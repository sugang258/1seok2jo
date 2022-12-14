package com.seok.home.pay;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.admin.AdminPager;
import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.teacher.TeacherPager;
import com.seok.home.member.MemberDTO;
import com.seok.home.util.ChartDTO;

@Repository
public class PayDAO {
	
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.seok.home.pay.PayDAO.";
	
	public List<ChartDTO> getChartAdminDashBoard() throws Exception{
		return session.selectList(NAMESPACE+"getChartAdminDashBoard");
	}
	
	public Long getOamountTotal(TeacherPager pager) throws Exception{
		return session.selectOne(NAMESPACE+"getOamountTotal", pager);
	}
	
	public Long getteacherListTotal(TeacherPager pager) throws Exception{
		return session.selectOne(NAMESPACE+"getteacherListTotal", pager);
	}
	
	public List<OrderDTO> getteacherList(TeacherPager pager) throws Exception{
		return session.selectList(NAMESPACE+"getteacherList", pager);
	}
	
	public Long getPayAdminTotal(AdminPager pager) throws Exception{
		return session.selectOne(NAMESPACE+"getPayAdminTotal", pager);
	}
	
	public List<PaymentDTO> getPayAdminList(AdminPager pager) throws Exception{
		return session.selectList(NAMESPACE+"getPayAdminList", pager);
	}
	
	public int updatePaymentRemains(PaymentDTO paymentDTO) throws Exception{
		return session.update(NAMESPACE+"updatePaymentRemains", paymentDTO);
	}
	
	public Long getPaymentRemains(PaymentDTO paymentDTO) throws Exception{
		return session.selectOne(NAMESPACE+"getPaymentRemains", paymentDTO);
	}
	
	public int saveRefund(RefundDTO refundDTO) throws Exception{
		return session.insert(NAMESPACE+"saveRefund", refundDTO);
	}
	
	public PaymentDTO getPayDetail(PaymentDTO dto)throws Exception{
		return session.selectOne(NAMESPACE+"getPayDetail", dto);
	}
	
	public int savePayment(PaymentDTO dto)throws Exception{
		return session.insert(NAMESPACE+"savePayment", dto);
	}
	
	public int saveOrder(OrderDTO orderDTO) throws Exception{
		return session.insert(NAMESPACE+"saveOrder", orderDTO);
	}
	
	public List<PaymentDTO> getPaymentList(PaymentDTO dto) throws Exception{
		return session.selectList(NAMESPACE+"getPaymentList", dto);
	}
	
	public OrderDTO getOrder(OrderDTO orderDTO) throws Exception{
		return session.selectOne(NAMESPACE+"getOrder", orderDTO);
	}

}
