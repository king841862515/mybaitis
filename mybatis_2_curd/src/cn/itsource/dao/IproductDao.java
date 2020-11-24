package cn.itsource.dao;

import java.util.List;

import cn.itsource.domain.Product;

public interface IproductDao {


		
		void save(Product p);
		
		void update(Product p);
		
		void delete(Long id);
		
		Product getOne(Long id);
		
		List<Product> getAll();
	
	
}
