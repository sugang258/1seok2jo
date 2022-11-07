package com.seok.home.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class EmailManager {
	
	// 1. 발신자의 메일 계정과 비밀번호 설정
	final String user = "1s_2j@naver.com";
	final String password = "1seok2jo!!";
	
	private Session session;
	
    public EmailManager() {
    	
        // 2. Property에 SMTP 서버 정보 설정
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.naver.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("defaultEncoding","utf-8");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.naver.com");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
//        prop.put("mail.smtp.starttls.required", "true");



        // 3. SMTP 서버정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성
        session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
        
    }
    
    public void sendHTML(String recipient, String subject, String contents) {
        // 4. Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다.
        // 5. Transport 클래스를 사용하여 작성한 메세지를 전달한다.

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(user));

            // 수신자 메일 주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Subject
            message.setSubject(subject);

            // Text
            message.setContent(contents ,"text/html;charset=utf-8");

            Transport.send(message);    // send message

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    
    
    public String getcsAnswerHtml(String title, String contents, String answer){
    		
    	StringBuffer mailMsg = new StringBuffer();
    	mailMsg.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
    	mailMsg.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">");
    	mailMsg.append("<head>");
    	mailMsg.append("<!--[if gte mso 9]>");
    	mailMsg.append("<xml>");
    	mailMsg.append("  <o:OfficeDocumentSettings>");
    	mailMsg.append("    <o:AllowPNG/>");
    	mailMsg.append("    <o:PixelsPerInch>96</o:PixelsPerInch>");
    	mailMsg.append("  </o:OfficeDocumentSettings>");
    	mailMsg.append("</xml>");
    	mailMsg.append("<![endif]-->");
    	mailMsg.append("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
    	mailMsg.append("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
    	mailMsg.append("  <meta name=\"x-apple-disable-message-reformatting\">");
    	mailMsg.append("  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->");
    	mailMsg.append("  <title></title>");
    	
    	mailMsg.append("    <style type=\"text/css\">");
    	mailMsg.append("      @media only screen and (min-width: 620px) {");
    	mailMsg.append("  .u-row {");
    	mailMsg.append("    width: 600px !important;");
    	mailMsg.append("  }");
    	mailMsg.append("  .u-row .u-col {");
    	mailMsg.append("    vertical-align: top;");
    	mailMsg.append("  }");

    	mailMsg.append("  .u-row .u-col-100 {");
    	mailMsg.append("    width: 600px !important;");
    	mailMsg.append("  }");

    	mailMsg.append("}");

    	mailMsg.append("@media (max-width: 620px) {");
    	mailMsg.append("  .u-row-container {");
    	mailMsg.append("    max-width: 100% !important;");
    	mailMsg.append("    padding-left: 0px !important;");
    	mailMsg.append("    padding-right: 0px !important;");
    	mailMsg.append("  }");
    	mailMsg.append("  .u-row .u-col {");
    	mailMsg.append("    min-width: 320px !important;");
    	mailMsg.append("    max-width: 100% !important;");
    	mailMsg.append("    display: block !important;");
    	mailMsg.append("  }");
    	mailMsg.append("  .u-row {");
    	mailMsg.append("    width: calc(100% - 40px) !important;");
    	mailMsg.append("  }");
    	mailMsg.append("  .u-col {");
    	mailMsg.append("    width: 100% !important;");
    	mailMsg.append("  }");
    	mailMsg.append("  .u-col > div {");
    	mailMsg.append("    margin: 0 auto;");
    	mailMsg.append("  }");
    	mailMsg.append("}");
    	mailMsg.append("body {");
    	mailMsg.append("  margin: 0;");
    	mailMsg.append("  padding: 0;");
    	mailMsg.append("}");

    	mailMsg.append("table,");
    	mailMsg.append("tr,");
    	mailMsg.append("td {");
    	mailMsg.append("  vertical-align: top;");
    	mailMsg.append("  border-collapse: collapse;");
    	mailMsg.append("}");

    	mailMsg.append("p {");
    	mailMsg.append("  margin: 0;");
    	mailMsg.append("}");

    	mailMsg.append(".ie-container table,");
    	mailMsg.append(".mso-container table {");
    	mailMsg.append("  table-layout: fixed;");
    	mailMsg.append("}");

    	mailMsg.append("* {");
    	mailMsg.append("  line-height: inherit;");
    	mailMsg.append("}");

    	mailMsg.append("a[x-apple-data-detectors='true'] {");
    	mailMsg.append("  color: inherit !important;");
    	mailMsg.append("  text-decoration: none !important;");
    	mailMsg.append("}");

    	mailMsg.append("table, td { color: #000000; } @media (max-width: 480px) { #u_content_heading_1 .v-font-size { font-size: 30px !important; } #u_content_heading_2 .v-font-size { font-size: 24px !important; } #u_content_text_2 .v-container-padding-padding { padding: 10px !important; } #u_content_text_3 .v-container-padding-padding { padding: 10px !important; } #u_content_text_4 .v-container-padding-padding { padding: 10px 10px 30px !important; } }");
    	mailMsg.append("    </style>");
    	
    	

    	mailMsg.append("<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->");

    	mailMsg.append("</head>");

    	mailMsg.append("<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #eeeeee;color: #000000\">");
    	mailMsg.append("  <!--[if IE]><div class=\"ie-container\"><![endif]-->");
    	mailMsg.append("  <!--[if mso]><div class=\"mso-container\"><![endif]-->");
    	mailMsg.append("  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #eeeeee;width:100%\" cellpadding=\"0\" cellspacing=\"0\">");
    	mailMsg.append("  <tbody>");
    	mailMsg.append("  <tr style=\"vertical-align: top\">");
    	mailMsg.append("    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">");
    	mailMsg.append("    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #eeeeee;\"><![endif]-->");


    	mailMsg.append("<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">");
    	mailMsg.append("  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">");
    	mailMsg.append("    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">");
    	mailMsg.append("      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->");
    	
    	mailMsg.append("<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #ffffff;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->");
    	mailMsg.append("<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">");
    	mailMsg.append("  <div style=\"background-color: #ffffff;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">");
    	mailMsg.append("  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->");
    	mailMsg.append("  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->");
    	mailMsg.append("  </div>");
    	mailMsg.append("</div>");
    	mailMsg.append("<!--[if (mso)|(IE)]></td><![endif]-->");
    	mailMsg.append("      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->");
    	mailMsg.append("    </div>");
    	mailMsg.append("  </div>");
    	mailMsg.append("</div>");



    	mailMsg.append("<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">");
    	mailMsg.append("  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">");
    	mailMsg.append("    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">");
    	mailMsg.append("      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->");
    	
    	mailMsg.append("<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #ffffff;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->");
    	mailMsg.append("<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">");
    	mailMsg.append("  <div style=\"background-color: #ffffff;height: 100%;width: 100% !important;\">");
    	mailMsg.append("  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->");
    	
    	mailMsg.append("<table id=\"u_content_heading_1\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">");
    	mailMsg.append("  <tbody>");
    	mailMsg.append("    <tr>");
    	mailMsg.append("      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 10px 10px;font-family:'Montserrat',sans-serif;\" align=\"left\">");

    	mailMsg.append("  <h1 class=\"v-font-size\" style=\"margin: 0px; color: #58c22d; line-height: 120%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: helvetica,sans-serif; font-size: 35px;\">");
    	mailMsg.append("    <strong>문의 답변이 완료되었습니다</strong>");
    	mailMsg.append("  </h1>");

    	mailMsg.append("      </td>");
    	mailMsg.append("    </tr>");
    	mailMsg.append("  </tbody>");
    	mailMsg.append("</table>");

    	mailMsg.append("<table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">");
    	mailMsg.append("  <tbody>");
    	mailMsg.append("    <tr>");
    	mailMsg.append("      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 0px;font-family:'Montserrat',sans-serif;\" align=\"left\">");

    	mailMsg.append("  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">");
    	mailMsg.append("    <tbody>");
    	mailMsg.append("      <tr style=\"vertical-align: top\">");
    	mailMsg.append("        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">");
    	mailMsg.append("          <span>&#160;</span>");
    	mailMsg.append("        </td>");
    	mailMsg.append("      </tr>");
    	mailMsg.append("    </tbody>");
    	mailMsg.append("  </table>");

    	mailMsg.append("      </td>");
    	mailMsg.append("    </tr>");
    	mailMsg.append("  </tbody>");
    	mailMsg.append("</table>");

    	mailMsg.append("<table id=\"u_content_heading_2\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">");
    	mailMsg.append("  <tbody>");
    	mailMsg.append("    <tr>");
    	mailMsg.append("      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 10px 10px;font-family:'Montserrat',sans-serif;\" align=\"left\">");

    	mailMsg.append("  <h2 class=\"v-font-size\" style=\"margin: 0px; color: #000000; line-height: 110%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: helvetica,sans-serif; font-size: 20px;\">");
    	mailMsg.append("    <div>");
    	mailMsg.append("<div>");
    	mailMsg.append("<div>");
    	mailMsg.append("<div>");
    	mailMsg.append("<div><strong>");
    	mailMsg.append(title);
    	mailMsg.append("</strong></div>");
    	mailMsg.append("</div>");
    	mailMsg.append("</div>");
    	mailMsg.append("</div>");
    	mailMsg.append("</div>");
    	mailMsg.append("  </h2>");
    	mailMsg.append("      </td>");
    	mailMsg.append("    </tr>");
    	mailMsg.append("  </tbody>");
    	mailMsg.append("</table>");

    	mailMsg.append("<table id=\"u_content_text_2\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">");
    	mailMsg.append("  <tbody>");
    	mailMsg.append("    <tr>");
    	mailMsg.append("      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 100px;font-family:'Montserrat',sans-serif;\" align=\"left\">");
    	mailMsg.append("  <div style=\"line-height: 140%; text-align: center; word-wrap: break-word;\">");
    	mailMsg.append(contents);
    	mailMsg.append("  </div>");

    	mailMsg.append("      </td>");
    	mailMsg.append("    </tr>");
    	mailMsg.append("  </tbody>");
    	mailMsg.append("</table>");
    	mailMsg.append("<table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">");
    	mailMsg.append("  <tbody>");
    	mailMsg.append("    <tr>");
    	mailMsg.append("      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 0px;font-family:'Montserrat',sans-serif;\" align=\"left\">");

    	mailMsg.append("  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #bfedd2;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">");
    	mailMsg.append("    <tbody>");
    	mailMsg.append("      <tr style=\"vertical-align: top\">");
    	mailMsg.append("        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">");
    	mailMsg.append("          <span>&#160;</span>");
    	mailMsg.append("        </td>");
    	mailMsg.append("      </tr>");
    	mailMsg.append("    </tbody>");
    	mailMsg.append("  </table>");

    	mailMsg.append("      </td>");
    	mailMsg.append("    </tr>");
    	mailMsg.append("  </tbody>");
    	mailMsg.append("</table>");
    	
    	mailMsg.append("<table id=\"u_content_heading_2\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">");
    	mailMsg.append("  <tbody>");
    	mailMsg.append("    <tr>");
    	mailMsg.append("      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 10px 10px;font-family:'Montserrat',sans-serif;\" align=\"left\">");

    	mailMsg.append("  <h2 class=\"v-font-size\" style=\"margin: 0px; color: #000000; line-height: 110%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: helvetica,sans-serif; font-size: 20px;\">");
    	mailMsg.append("    <div>");
    	mailMsg.append("<div>");
    	mailMsg.append("<div>");
    	mailMsg.append("<div>");
    	mailMsg.append("<div><strong>");
    	mailMsg.append("답변");
    	mailMsg.append("</strong></div>");
    	mailMsg.append("</div>");
    	mailMsg.append("</div>");
    	mailMsg.append("</div>");
    	mailMsg.append("</div>");
    	mailMsg.append("  </h2>");
    	mailMsg.append("      </td>");
    	mailMsg.append("    </tr>");
    	mailMsg.append("  </tbody>");
    	mailMsg.append("</table>");
    	
    	mailMsg.append("<table id=\"u_content_text_3\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">");
    	mailMsg.append("  <tbody>");
    	mailMsg.append("    <tr>");
    	mailMsg.append("      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 100px;font-family:'Montserrat',sans-serif;\" align=\"left\">");

    	mailMsg.append("  <div style=\"line-height: 140%; text-align: center; word-wrap: break-word;\">");
    	mailMsg.append(answer);
    	mailMsg.append("</div>");

		mailMsg.append("      </td>");
		mailMsg.append("    </tr>");
		mailMsg.append("  </tbody>");
		mailMsg.append("</table>");
		
		mailMsg.append("  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->");
		mailMsg.append("  </div>");
		mailMsg.append("</div>");
		mailMsg.append("<!--[if (mso)|(IE)]></td><![endif]-->");
		mailMsg.append("      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->");
		mailMsg.append("    </div>");
		mailMsg.append("  </div>");
		mailMsg.append("</div>");
		
		
		
		mailMsg.append("<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">");
		mailMsg.append("  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">");
		mailMsg.append("    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">");
		mailMsg.append("      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->");
		
		mailMsg.append("<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #bfedd2;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->");
		mailMsg.append("<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">");
		mailMsg.append("  <div style=\"background-color: #bfedd2;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">");
		mailMsg.append("  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->");
		
		mailMsg.append("<table id=\"u_content_text_4\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">");
		mailMsg.append("  <tbody>");
		mailMsg.append("    <tr>");
		mailMsg.append("      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 60px;font-family:'Montserrat',sans-serif;\" align=\"left\">");
		mailMsg.append("        ");
		mailMsg.append("  <div style=\"line-height: 140%; text-align: center; word-wrap: break-word;\">");
		mailMsg.append("    <p style=\"font-size: 14px; line-height: 140%;\">Contact us | 1seok2jo</p>");
		mailMsg.append("  </div>");
		
		mailMsg.append("      </td>");
		mailMsg.append("    </tr>");
		mailMsg.append("  </tbody>");
		mailMsg.append("</table>");
		
		mailMsg.append("  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->");
		mailMsg.append("  </div>");
		mailMsg.append("</div>");
		mailMsg.append("<!--[if (mso)|(IE)]></td><![endif]-->");
		mailMsg.append("      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->");
		mailMsg.append("    </div>");
		mailMsg.append("  </div>");
		mailMsg.append("</div>");
		
		
		mailMsg.append("    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->");
		mailMsg.append("    </td>");
		mailMsg.append("  </tr>");
		mailMsg.append("  </tbody>");
		mailMsg.append("  </table>");
		mailMsg.append("  <!--[if mso]></div><![endif]-->");
		mailMsg.append("  <!--[if IE]></div><![endif]-->");
		mailMsg.append("</body>");
		
		mailMsg.append("</html>");
    	
    	return mailMsg.toString();
    }


}
