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

	IamportClient client = new IamportClient("6833265443546261", "SiEfYqnG3G0yBBQRFMvspUyp9l0UAJ0ytmsMxyHJBQftWtJHoRKQvJvB59QljGoZBNLS6wXZSGJ5p5Mg");
	
	@GetMapping(value="status")
	public String getDetail() throws Exception{
		
		return "pay/status";
	}
	
	@PostMapping(value="getTk")
	@ResponseBody
	public ModelAndView getTk(ModelAndView mv) throws Exception{
		IamportResponse<AccessToken> auth_response = client.getAuth();
		String token = auth_response.getResponse().getToken();
		
		mv.addObject("result", token);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}

	//추후 주문 상세 등으로 바꿀것...
	@GetMapping(value="cancel")
	public String cancle(PaymentDTO paymentDTO, Model model) throws Exception{
		
		paymentDTO.setP_uid("1seok2jo-1663727564296");
		System.out.println("cancleGet"+paymentDTO.getP_uid());
		
		paymentDTO = payService.cancel(paymentDTO);
		
		model.addAttribute("payment", paymentDTO);
		return "pay/cancel";
	}
	
	@PostMapping(value="cancel")
	@ResponseBody
	public String cancle(RefundDTO refundDTO) throws Exception{
		System.out.println("hi");
		
		String test_already_cancelled_merchant_uid = "1seok2jo-1663728830588";
        CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false, BigDecimal.valueOf(1500)); //merchant_uid를 통한 500원 부분취소

        IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);

        System.out.println(payment_response.getResponse().getCancelAmount());
        System.out.println(payment_response.getResponse().getApplyNum());//환불번호
        System.out.println(payment_response.getResponse().getCancelReason());
        System.out.println(payment_response.getResponse().getFailReason());

        System.out.println(payment_response.getResponse().getCancelAmount());
		return "hi";
	}
	
	//‘강의 상세’  ‘장바구니’ 페이지에서 결제하기 버튼을 눌러 주문페이지로 이동
	@GetMapping(value="order")
	public ModelAndView showOrder(String l_num, HttpServletRequest request) throws Exception{
		//구매하려는 강의정보를 받아와 (강의상세에서 바로 넘어오는 경우 강의번호로, 장바구니에서 넘어오는 경우 장바구니 표시로 넘겨준다.)
		
		ModelAndView mv = new ModelAndView();
		
		ArrayList<LectureDTO> lectureDTOs = new ArrayList<LectureDTO>();
		
		if(l_num!=null) {
			lectureDTOs = payService.getOrder(l_num);			
		}else {
			MemberDTO member = (MemberDTO)request.getSession().getAttribute("member");
			lectureDTOs = payService.getOrder(member);
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
		//paymenDTO에 받아온 변수 값 매칭
		PaymentDTO paymentDTO = new PaymentDTO();
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
		
		System.out.println(res.keySet());
		System.out.println(res.get("point"));
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
		
		int result = payService.receiveSuccess(paymentDTO);
		
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

}
