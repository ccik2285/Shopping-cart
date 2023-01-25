package com.example.pion.product.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pion.product.dao.ProductTempDao;
import com.example.pion.product.dto.ProductRequest;

@Service
public class ProductTempService {
	
	@Autowired
	private ProductTempDao productTempDao;
	
	public void save(ProductRequest request) {
		
		productTempDao.save(request.toEntity());
	}
}
