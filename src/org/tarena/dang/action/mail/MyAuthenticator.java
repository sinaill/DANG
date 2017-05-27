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
	 * �����ʼ�
	 * @param mail
	 * @param content
	 */
	public void sendMail(String mail,String content){
		  MailSenderInfo mailInfo = new MailSenderInfo();
	      mailInfo.setMailServerHost("smtp.qq.com");
	      mailInfo.setMailServerPort("25");
	      mailInfo.setValidate(true);
	      mailInfo.setUserName("345849402@qq.com");//�����������
	      mailInfo.setPassword("123456");//������������
	      mailInfo.setFromAddress("345849402@qq.com");//�����������
	      mailInfo.setToAddress(mail);
	      mailInfo.setSubject("��֤��");
	      mailInfo.setContent(" ��л��ʹ�õ�����������֤��Ϊ"+content);
	         //�������Ҫ�������ʼ�
	      SimpleMailSender sms = new SimpleMailSender();
	          sms.sendTextMail(mailInfo);//���������ʽ
	          //sms.sendHtmlMail(mailInfo);//����html��ʽ
	    }  

public static void main(String[] args){
         //�������Ҫ�������ʼ�
      MailSenderInfo mailInfo = new MailSenderInfo();
      mailInfo.setMailServerHost("smtp.exmail.qq.com");
      mailInfo.setMailServerPort("25");
      mailInfo.setValidate(true);
      mailInfo.setUserName("123456@qq.com");//�������
      mailInfo.setPassword("123456");//������������
      mailInfo.setFromAddress("123456@qq.com");
      mailInfo.setToAddress("2806289796@qq.com");
      mailInfo.setSubject("�����ʼ�");
      mailInfo.setContent("�����ʼ�������");
         //�������Ҫ�������ʼ�
      SimpleMailSender sms = new SimpleMailSender();
          sms.sendTextMail(mailInfo);//���������ʽ
          //sms.sendHtmlMail(mailInfo);//����html��ʽ
    }  
}
