package com.example.pion.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.pion.product.domain.Product;

@Mapper
public interface ProductTempDao {
	
	@Insert("""
			<script>
				INSERT INTO product(name,price)
				VALUES(
					#{name},
					#{price}
				)
			</script>
			""")
//	public void save(String name,int price);
	public void save(Product product);
	
	@Select("""
			<script>
				SELECT id,name,price
					   FROM product
			</script>
			""")
	public List<Product> findAllProduct();

	@Select("""
			<script>
				SELECT id,name,price
					   FROM product
					   WHERE #{id} = id
			</script>
			""")
	public Product findProductById(String id);
	
}
