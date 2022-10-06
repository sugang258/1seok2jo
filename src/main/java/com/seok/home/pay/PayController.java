package com.seok.home.pay;

import java.math.BigDecimal;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.lecture.LectureDTO;
import com.seok.home.member.MemberDTO;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
@RequestMapping(value="/pay/*")
public class PayController {
	
	@Autowired
	private PayService payService;

	private IamportClient client = new IamportClient("6833265443546261", "SiEfYqnG3G0yBBQRFMvspUyp9l0UAJ0ytmsMxyHJBQftWtJHoRKQvJvB59QljGoZBNLS6wXZSGJ5p5Mg");
	
	@GetMapping(value="status")
	public ModelAndView getPayDetail(PaymentDTO paymentDTO, ModelAndView mv) throws Exception{

		paymentDTO = payService.getPayDetail(paymentDTO);
		
		mv.addObject("paymentDTO", paymentDTO);
		mv.setViewName("pay/status");
		
		return mv;
	}
	
	@PostMapping(value="cancel")
	@ResponseBody
	public ModelAndView requestCancle(RefundDTO refundDTO, Long cancelOnum,Long cancelLnum, String cancelPuid, String pr_amount, ModelAndView mv,HttpServletRequest request) throws Exception{
		refundDTO.setP_uid(cancelPuid);
		refundDTO.setO_num(cancelOnum);	
		Long l_num = cancelLnum;
		String message = "환불 실패";
		int result = 0;

		//전액 포인트 환불이면 환불요청을 하지 않음
		if(refundDTO.getPr_amount()==0) {
			//바로 저장
			refundDTO.setPr_num(cancelOnum*10+1);
			result = payService.cancelSuccess(refundDTO, l_num, request);
		}else {
			//아임페이로 환불 요청
			String cancelled_merchant_uid = cancelPuid;
			BigDecimal cancelAmount = BigDecimal.valueOf(refundDTO.getPr_amount());
			
			CancelData cancel_data = new CancelData(cancelled_merchant_uid, false, cancelAmount);
			
			IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);

			//환불요청 실패한 경우 null값이 돌아옴
			if(payment_response.getResponse()==null) {
				message = "요청금액이 환불가능 금액보다 많습니다.";

			}else {//취소 성공하면
				refundDTO.setPr_num(Long.parseLong(payment_response.getResponse().getApplyNum()));
				
				result = payService.cancelSuccess(refundDTO, l_num, request);
			}
		}
		
		if(result==1) {
			message="환불요청이 완료되었습니다";
		}
		mv.addObject("message", message);
		mv.addObject("url", "/pay/status?p_uid="+cancelPuid);
		mv.setViewName("common/result");

		return mv;
	}
	
	//‘강의 상세’  ‘장바구니’ 페이지에서 결제하기 버튼을 눌러 주문페이지로 이동
	@GetMapping(value="order")
	public ModelAndView showOrder(String l_num, HttpServletRequest request) throws Exception{
		//구매하려는 강의정보를 받아와 (강의상세에서 바로 넘어오는 경우 강의번호로, 장바구니에서 넘어오는 경우 아이디로 장바구니를 가져와 넘겨준다.)
		
		ModelAndView mv = new ModelAndView();
		
		ArrayList<LectureDTO> lectureDTOs = new ArrayList<LectureDTO>();
		
		if(l_num!=null) {
			lectureDTOs = payService.getCartLectures(l_num);			
		}else {
			MemberDTO member = (MemberDTO)request.getSession().getAttribute("member");
			lectureDTOs = payService.getCartLectures(member);
		}
		
		
		mv.addObject("lectures", lectureDTOs);
		mv.setViewName("pay/order");
		
		return mv;
	}
	
	//결제성공시
	@PostMapping(value="success")
	@ResponseBody
	public int receiveSuccess(@RequestBody HashMap<String, String> res, HttpServletRequest request) throws Exception {
		//주문상세내역과 결제내역 저장
		PaymentDTO paymentDTO = new PaymentDTO();
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
		
		//받아온 파라미터 값 매칭
		String l_num = res.get("l_num");

		paymentDTO.setId(mem.getId());
		paymentDTO.setP_uid(res.get("merchant_uid"));
		paymentDTO.setP_point(Long.parseLong(res.get("point")));
		paymentDTO.setP_amount(Long.parseLong(res.get("amount")));
		paymentDTO.setP_realamount(Long.parseLong(res.get("paid_amount")));
		paymentDTO.setP_method(res.get("pay_method"));
		paymentDTO.setP_remains(Long.parseLong(res.get("paid_amount")));
		paymentDTO.setP_c_name(res.get("card_name"));
		paymentDTO.setP_c_apply(Long.parseLong(res.get("apply_num")));
		paymentDTO.setP_c_num(Long.parseLong(res.get("card_number")));
		paymentDTO.setP_c_quota(Long.parseLong(res.get("card_quota")));
		paymentDTO.setP_at(Long.parseLong(res.get("paid_amount")));
		paymentDTO.setP_receipt(res.get("receipt_url"));
		
		int result = payService.paySuccess(paymentDTO, l_num);
		
		//포인트 계산
		

		return result;
	}
	
	@GetMapping(value="complete")
	public ModelAndView showComplete(PaymentDTO paymentDTO) throws Exception {
		//주문정보, 강의정보 DB에서 가져와서 화면에 뿌려준다.
		HashMap<String, Object> result = payService.showComplete(paymentDTO);
		
		paymentDTO = (PaymentDTO)result.get("paymentDTO");
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("result",result);
		mv.setViewName("pay/complete");
		return mv;
	}
	
	//아임포트 관련/ 현재 필요없음
	@PostMapping(value="getTk")
	@ResponseBody
	public ModelAndView getTk(ModelAndView mv) throws Exception{
		IamportResponse<AccessToken> auth_response = client.getAuth();
		String token = auth_response.getResponse().getToken();
		
		mv.addObject("result", token);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}

}
