package com.seok.home.pay;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Test;

import com.seok.home.MyAbstractTest;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.PagedDataList;
import com.siot.IamportRestClient.response.Payment;

public class PayImportTest extends MyAbstractTest{

	IamportClient client = new IamportClient("6833265443546261", "SiEfYqnG3G0yBBQRFMvspUyp9l0UAJ0ytmsMxyHJBQftWtJHoRKQvJvB59QljGoZBNLS6wXZSGJ5p5Mg");
	
//	@Test
	 public void testGetToken() {
        try {
            IamportResponse<AccessToken> auth_response = client.getAuth();
            System.out.println(auth_response.getResponse().getToken());

        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            //서버 연결 실패
            e.printStackTrace();
        }
    }
	 
//	    @Test
	    public void testPaymentsByStatusAll() {
	        try {
	            IamportResponse<PagedDataList<Payment>> r_response = client.paymentsByStatus("ready");
	            IamportResponse<PagedDataList<Payment>> p_response = client.paymentsByStatus("paid");
	            IamportResponse<PagedDataList<Payment>> f_response = client.paymentsByStatus("failed");
	            IamportResponse<PagedDataList<Payment>> c_response = client.paymentsByStatus("cancelled");
	            IamportResponse<PagedDataList<Payment>> all_response = client.paymentsByStatus("all");

	            System.out.println(all_response.getResponse().getTotal());
	            System.out.println(r_response.getResponse().getTotal());
	            assertNotNull(p_response.getResponse());
	            assertNotNull(f_response.getResponse());
	            assertNotNull(c_response.getResponse());

	            assertTrue(all_response.getResponse().getTotal() ==
	                    r_response.getResponse().getTotal() + p_response.getResponse().getTotal() + f_response.getResponse().getTotal() + c_response.getResponse().getTotal());
	        } catch (IamportResponseException e) {
	            System.out.println(e.getMessage());

	            switch (e.getHttpStatusCode()) {
	                case 401:
	                    //TODO
	                    break;
	                case 500:
	                    //TODO
	                    break;
	            }
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	    @Test
	    public void testPartialCancelPaymentAlreadyCancelledMerchantUid() {
	        String test_already_cancelled_merchant_uid = "1seok2jo-1663731094101";
	        CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false, BigDecimal.valueOf(1500)); //merchant_uid를 통한 500원 부분취소

	        try {
	            IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);

	            
	            System.out.println(payment_response.getResponse().getCancelAmount());
	            assertNotNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
	            System.out.println(payment_response.getMessage());
	        } catch (IamportResponseException e) {
	            System.out.println(e.getMessage());

	            switch (e.getHttpStatusCode()) {
	                case 401:
	                    //TODO
	                    break;
	                case 500:
	                    //TODO
	                    break;
	            }
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	    }
	 
	 
//	    @Test
	    public void testCancelPaymentChecksumByImpUid() {
	        String test_already_cancelled_imp_uid = "imp_875574619822";
	        CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true); //imp_uid를 통한 전액취소
//	        cancel_data.setChecksum(BigDecimal.valueOf(500)); // checksum 으로 검증 추가

	        try {
	            IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
	            
	            System.out.println(payment_response.getResponse().getApplyNum());
	            assertNotNull(payment_response.getResponse());
	        } catch (IamportResponseException e) {
	            System.out.println(e.getMessage());

	            switch (e.getHttpStatusCode()) {
	                case 401:
	                    //TODO
	                    break;
	                case 500:
	                    //TODO
	                    break;
	            }
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }


}
