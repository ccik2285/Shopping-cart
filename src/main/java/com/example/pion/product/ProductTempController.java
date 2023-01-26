package com.example.pion.product;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.pion.product.application.ProductTempService;
import com.example.pion.product.dto.ProductRequest;
import com.example.pion.product.dto.ProductResponse;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/main")
public class ProductTempController {
		
		@Autowired
		private ProductTempService ProductTempService;
	
		//@GetMapping("/index")
		@GetMapping()
		public String temp(Model md) {
			//md.addAttribute("name","상품 A");
			System.out.println(md.getAttribute("name"));
			md.addAttribute("name",md.getAttribute("name"));
			return  "product/productTemp";
		} 
		
		@GetMapping("/create")
		public void getInfo(HttpServletRequest request){
		    System.out.println("get parameter" + request.getParameter("name"));
		    
		}
		@GetMapping("/find/all")
		@ResponseStatus(code =HttpStatus.OK)
		@ResponseBody
		public List<ProductResponse> findAllProduct() {
			return ProductTempService.findAllProduct();
		}
		
		
		@GetMapping("/detail/{id}")
		@ResponseStatus(code = HttpStatus.OK)
		public ModelAndView getAndViewProductDetailById(@PathVariable String id) {
			ModelAndView mv = new ModelAndView("product/productDetail");
			
			ProductResponse result = ProductTempService.findProductById(id);
			mv.addObject("product",result);
			
			return mv;
		}
		
		
		@GetMapping("/find/{id}")
		public String getProductById(@PathVariable String id) {
			return "/product/productList";
		}
		
		@GetMapping("/params")
		public String getProductByParams(@RequestParam("id") String id) {
			System.out.println("params : " + id);
			return "/product/productList";
		}
		
		@GetMapping("/mv")
		public ModelAndView getMainModel() {
			ModelAndView mv = new ModelAndView("/main/modelA");
			mv.addObject("name","modelA");
			return mv;
		}
		
		@GetMapping("/string")
		public String getMainString() {
			return "index";
		}
	
		@GetMapping("/responseBody")
		@ResponseBody
		public RestJson getResponseBody() {
			
			RestJson result = new RestJson("상품 A",3000);
			return result;
			
		}
		
		@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
		@ResponseStatus(code = HttpStatus.CREATED)
		public String saveProduct(ProductRequest request) {
			ProductTempService.save(request);
			return "main";
		}
		
	/*	@GetMapping("/exception")
		public void throwError() {
			throw new RuntimeException();
		}
		
		@ExceptionHandler(value = RuntimeException.class) 
		public String getErrorPage() {
			return "error";
		}  */
		
		
	// /main/index   main이 붙은거에만 작동
}
