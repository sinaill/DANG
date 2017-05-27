package org.tarena.dang.dao.impl;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.tarena.dang.dao.BaseDAO;
import org.tarena.dang.dao.CategoryDAO;
import org.tarena.dang.entity.Category;
@Repository("categoryDAO")
public class HibernateCategoryDAO extends BaseDAO implements CategoryDAO{

	@SuppressWarnings("unchecked")
	public List<Category> findAll(int id) {
		String hql = "select distinct c " +
				"from Category c " +
				"join fetch c.listCates " +
				"where c.parentId=?";
		Object[] params = {id};
		List<Category> list = 
			this.getHibernateTemplate().find(hql,params);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Category> findByParentId( int id) {
		String hql = "from Category where parentId=?";
         Object[] params = {id};
           List<Category> list = 
	        this.getHibernateTemplate().find(hql,params);
          return list;
	}

}
