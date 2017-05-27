package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Book;
import org.tarena.dang.entity.Item;
import org.tarena.dang.entity.Product;

public interface ProductDAO {
	public List<Product> findHotNewBook(int size);
	public List<Book> findRecommendBook();
	public List<Book> findBooksByCatId(int cid,int page,int pageSize);
	public List<Book> findBooksByCatId(int cid);
	public int findNumByCat_id(int cat_id,int pageSize);
	public Product findById(int id);
	public List<Product> findHotBook(int size);
	public List<Item> find(final int size);
}
