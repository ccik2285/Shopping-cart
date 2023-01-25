package com.example.pion.product;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.pion.product.application.ProductService;
import com.example.pion.product.dto.ProductRequest;
import com.example.pion.product.dto.ProductResponse;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String productList() {
		return "/product/productList";
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String addProduct(@RequestBody ProductRequest request) {
		System.out.println("!!!!!!!!!!!!!");
		System.out.println(request.getName() + "   " + request.getPrice());
		productService.save(request);
		return "product/productList";
		
	}
	
	@GetMapping("/all")
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody List<ProductResponse> getProducts() {
		return productService.findAll();
	}
	
	@GetMapping("/detail/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ModelAndView getProductDetailById(@PathVariable("id") int id) throws NotFoundException {
		ModelAndView mv = new ModelAndView("/product/productDetail");
		mv.addObject("product", new ProductResponse(1, "상품 A", 2000));
		return mv;
	}
	
	@GetMapping("/addProductForm")
	public String printProductForm() {
		return "/product/addProductForm";
	}
	
	@GetMapping("/find/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody ProductResponse getProductById(@PathVariable("id") int id) throws NotFoundException {
		return productService.findBydId(id);
	}
}
