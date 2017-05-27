package org.tarena.dang.action.cart;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;

import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.CookieUtil;
public class AddCartAction extends BaseAction{
	private int pid;
	private boolean buy = false;
	private CartService cartService;
	private ProductDAO productDAO;
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	public String execute() throws Exception{
		cartService = CartFactory.getInstance(session,productDAO);
		buy = cartService.buy(pid,productDAO);
		CookieUtil.addCookie(Constant.CART, cartService.store(), response);
		return "success";
	}
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public boolean isBuy() {
		return buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	

}
