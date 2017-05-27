package org.tarena.dang.action.user;

import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.entity.User;

/*
 *   Ajax 对email进行验证，如果存在则返回false
 * 不存在返回true可以进行注册。
 */
public class CheckEmailAction {
	public String email;
	public boolean ok = false;
	public UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public String execute() {
		try {
			User user = userDAO.findByEmail(email);
			if (user==null) {
				ok=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
