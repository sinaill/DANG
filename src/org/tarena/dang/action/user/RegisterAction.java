package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.action.mail.MyAuthenticator;
import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.dao.impl.UserDAOImPl;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.EncryptUtil;
import org.tarena.dang.util.VerifyUtil;
/*
 * �û�ע��
 */
public class RegisterAction extends BaseAction{
	//input
	public User user;
	public UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	/**
	 * �û�ע��
	 * @return
	 */
	public String execute(){

		user.setPassword(EncryptUtil.md5Encrypt(user.getPassword()));
		MyAuthenticator myAuthenticator = new MyAuthenticator();
		String EmailVerifyCode = VerifyUtil.createCode();
		myAuthenticator.sendMail(user.getEmail(), EmailVerifyCode);
		user.setUserIntegral(Constant.NORMAL);
		user.setIsEmailVerify(Constant.NO);
		user.setEmailVerifyCode(EmailVerifyCode);
		user.setLastLoginTime(System.currentTimeMillis());
		user.setLastLoginIp(httpReq.getRemoteAddr());
		session.put("user", user);
		try {
			userDAO.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "verify";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
