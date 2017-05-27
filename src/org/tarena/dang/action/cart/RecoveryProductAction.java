package org.tarena.dang.action.cart;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.CookieUtil;

public class RecoveryProductAction extends BaseAction{
	private ProductDAO productDAO;
   private int id;
   public String execute() throws Throwable{
	   CartService cart = CartFactory.getInstance(session,productDAO);
	   cart.recovery(id);
	   CookieUtil.addCookie(Constant.CART, cart.store(), response);
	   return "success";
   }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public void setProductDAO(ProductDAO productDAO) {
	this.productDAO = productDAO;
}
   
}
