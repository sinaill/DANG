package org.tarena.dang.action.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
	String userName=null;
	String password=null;

	public MyAuthenticator(){
	}
	public MyAuthenticator(String username, String password) {
		this.userName = username;
		this.password = password;
	}
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(userName, password);
	}
	/**
	 * 发送邮件
	 * @param mail
	 * @param content
	 */
	public void sendMail(String mail,String content){
		  MailSenderInfo mailInfo = new MailSenderInfo();
	      mailInfo.setMailServerHost("smtp.qq.com");
	      mailInfo.setMailServerPort("25");
	      mailInfo.setValidate(true);
	      mailInfo.setUserName("345849402@qq.com");//设置你的邮箱
	      mailInfo.setPassword("123456");//您的邮箱密码
	      mailInfo.setFromAddress("345849402@qq.com");//设置你的邮箱
	      mailInfo.setToAddress(mail);
	      mailInfo.setSubject("验证码");
	      mailInfo.setContent(" 感谢您使用当当网您的验证码为"+content);
	         //这个类主要来发送邮件
	      SimpleMailSender sms = new SimpleMailSender();
	          sms.sendTextMail(mailInfo);//发送文体格式
	          //sms.sendHtmlMail(mailInfo);//发送html格式
	    }  

public static void main(String[] args){
         //这个类主要是设置邮件
      MailSenderInfo mailInfo = new MailSenderInfo();
      mailInfo.setMailServerHost("smtp.exmail.qq.com");
      mailInfo.setMailServerPort("25");
      mailInfo.setValidate(true);
      mailInfo.setUserName("123456@qq.com");//设置你的
      mailInfo.setPassword("123456");//您的邮箱密码
      mailInfo.setFromAddress("123456@qq.com");
      mailInfo.setToAddress("2806289796@qq.com");
      mailInfo.setSubject("测试邮件");
      mailInfo.setContent("测试邮件的内容");
         //这个类主要来发送邮件
      SimpleMailSender sms = new SimpleMailSender();
          sms.sendTextMail(mailInfo);//发送文体格式
          //sms.sendHtmlMail(mailInfo);//发送html格式
    }  
}
