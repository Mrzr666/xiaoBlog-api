package com.shimh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shimh.entity.Category;
import com.shimh.dao.wrapper.CategoryWrapper;

/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
public interface CategoryMapper extends JpaRepository<Category, Integer>, CategoryWrapper {

	/*@Query(value="select c.*, count(a.category_id) as articles from me_category c "
			+ "left join me_article a on a.category_id = c.id group by a.category_id",nativeQuery=true)
	List<Category> findAllDetail();*/

}
