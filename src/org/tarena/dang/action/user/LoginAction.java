package org.tarena.dang.action.user;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.dao.impl.UserDAOImPl;
import org.tarena.dang.entity.CartItem;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;
import org.tarena.dang.util.EncryptUtil;

/*
 * �û���¼
 */
public class LoginAction extends BaseAction {
	private User user;
	private String nameMsg = "";
	public UserDAO userDAO;
	private ProductDAO productDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public String execute() {
		String password = user.getPassword();
		try {
			user = userDAO.findByEmail(user.getEmail());
			session.put("user", user);
			if (user != null && password.equals(user.getPassword())) {
				if (user.getIsEmailVerify().equals("Y")) {
					user.setLastLoginTime(System.currentTimeMillis());
					user.setLastLoginIp(httpReq.getRemoteAddr());
                    userDAO.save(user);
					CartService cart = CartFactory.getInstance(session,productDAO);
					List<CartItem> items = cart.getBuyPros();
					if (items.isEmpty()) {
						nameMsg = "success";
					} else {
						nameMsg = "order";
					}
				} else {
					nameMsg = "is_email";
				}
			} else {
				request.put("login_error", "用户名或密码错误");
				nameMsg = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nameMsg;

	}

	public String getNameMsg() {
		return nameMsg;
	}

	public void setNameMsg(String nameMsg) {
		this.nameMsg = nameMsg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

}
