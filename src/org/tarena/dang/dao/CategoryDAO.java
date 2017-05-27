package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Category;

public interface CategoryDAO {
	public List<Category> findAll(int id);
	public List<Category> findByParentId(int id);
	
}
