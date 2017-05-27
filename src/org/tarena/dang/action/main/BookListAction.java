package org.tarena.dang.action.main;

import java.util.List;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.CategoryDAO;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.Book;
import org.tarena.dang.entity.Category;
public class BookListAction extends BaseAction {
	//input
	private int pid;
	private int cid;
	private int page = 1;
	//output
	private List<Category> cats;
	private int totalNum;
	private List<Book> books;
	//injection
	private int pageSize = 3;
	private int totalPage;
	private CategoryDAO categoryDAO;
	private ProductDAO productDAO;
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		
		this.categoryDAO = categoryDAO;
	}

	public String execute() throws Exception{
		cats = categoryDAO.findByParentId(pid);//二级分类
		for(Category c:cats){
			totalNum += c.getPnum();//二级分类书的数量
		}
		books = productDAO.findBooksByCatId(cid, page, pageSize);
		totalPage  = productDAO.findNumByCat_id(cid, pageSize);
		return "success";
	}
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public int getTotalNum() {
		return totalNum;
	}


	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
	public List<Category> getCats() {
		return cats;
	}
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
