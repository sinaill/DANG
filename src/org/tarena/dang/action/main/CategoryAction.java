package org.tarena.dang.action.main;
import java.util.List;
import org.tarena.dang.dao.CategoryDAO;
import org.tarena.dang.entity.Category;

public class CategoryAction {
	private List<Category> cats;
	private CategoryDAO categoryDAO;
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public String execute() throws Exception{
		cats = categoryDAO.findAll(1);
		return "success";
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	
}
