package org.tarena.dang.service;
import java.util.Map;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.CookieUtil;
public class CartFactory extends BaseAction{
	public static CartService getInstance(
			         Map<String,Object> session,ProductDAO productDAO) throws Exception{
		CartService cart = 
			  (CartService) session.get(Constant.CART);     
		if(cart==null){
			cart = new CartServiceImpl();
			cart.load(CookieUtil.findCookie(Constant.CART,httpReq),productDAO);
			session.put(Constant.CART, cart);
		}
		return cart;
	}

}
