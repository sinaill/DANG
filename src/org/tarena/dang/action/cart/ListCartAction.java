package org.tarena.dang.action.cart;
import java.util.List;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.CartItem;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;
public class ListCartAction extends BaseAction{
   private List<CartItem> items;
   private double total;
   private double save;
   private CartService cartService;
   private ProductDAO productDAO;
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
   public String execute() throws Exception{
	 cartService = CartFactory.getInstance(session,productDAO);
	 items = cartService.getBuyPros();
	 total = cartService.cost();
	 save = cartService.sale();
	 return "success";  
   }
public List<CartItem> getItems() {
	return items;
}
public void setItems(List<CartItem> items) {
	this.items = items;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public double getSave() {
	return save;
}
public void setSave(double save) {
	this.save = save;
}
public void setProductDAO(ProductDAO productDAO) {
	this.productDAO = productDAO;
}
    
   
   
}
