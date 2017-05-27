package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;
/*
 * Ajax ��ͼƬ��֤�������֤���������򷵻�true
 * ����ȷ���false��
 */
public class CheckVerifyCodeAction extends BaseAction{
	private String VerifyCode;
	private boolean ok = false;
	public String execute(){
		String code = (String) session.get("code");
		if(code.equalsIgnoreCase(VerifyCode)){
			ok=true;
		}
		return "success";
		
	}
	public String getVerifyCode() {
		return VerifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		VerifyCode = verifyCode;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	

}
