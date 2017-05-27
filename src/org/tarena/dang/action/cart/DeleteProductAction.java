package org.tarena.dang.action.cart;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.CookieUtil;

public class DeleteProductAction extends BaseAction{
	private ProductDAO productDAO;
	private int pid;
	public String execute() throws Exception{
		CartService cart = CartFactory.getInstance(session,productDAO);
		cart.delete(pid);
		CookieUtil.addCookie(Constant.CART, cart.store(), response);
		return "success";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
    
}
