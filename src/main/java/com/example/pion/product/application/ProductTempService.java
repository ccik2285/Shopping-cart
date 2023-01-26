package com.example.pion.product.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pion.product.dao.ProductTempDao;
import com.example.pion.product.domain.Product;
import com.example.pion.product.dto.ProductRequest;
import com.example.pion.product.dto.ProductResponse;

@Service
public class ProductTempService {
	
	@Autowired
	private ProductTempDao productTempDao;
	
	public void save(ProductRequest request) {
		
		productTempDao.save(request.toEntity());
	}

	public List<ProductResponse> findAllProduct() {
		// TODO Auto-generated method stub
//		List<Product> products = productTempDao.findAllProduct();
//		List<ProductResponse> resultList = new ArrayList<>();
//		
//		for(Product product: products) {
//			resultList.add(new ProductResponse(
//					product.getId(),product.getName(),product.getPrice()
//					));
//		
//		}
//		return resultList;
		
		return productTempDao.findAllProduct().stream()
				.map(ProductResponse::convert)
				.collect(Collectors.toList());
	}

	public ProductResponse findProductById(String id) {
		return ProductResponse.convert(productTempDao.findProductById(id));
	}
}
