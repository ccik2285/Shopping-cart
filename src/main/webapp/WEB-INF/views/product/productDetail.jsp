<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.pion.product.dto.ProductResponse" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">

<%
	ProductResponse product = (ProductResponse)request.getAttribute("product");
	
%>

</head>
<body>
	<div class="container">
	    <div class="py-5 text-center">
	        <h2>상품 상세</h2>
	    </div>
	    <div>
	        <label for="itemId">상품 ID</label>
	        <input type="text" id="itemId" name="itemId" class="form-control" value="<%= product.getId() %>" readonly>
	    </div>
	    <div>
	        <label for="itemName">상품명</label>
	        <input type="text" id="itemName" name="itemName" class="form-control" value="<%= product.getName() %>" readonly>
	    </div>
	    <div>
	        <label for="price">가격</label>
	        <input type="text" id="price" name="price" class="form-control" value="<%= product.getPrice() %>">
	    </div>
	    <hr class="my-4">
	    <div class="row">
	        <div class="col">
	            <button class="w-100 btn btn-primary btn-lg" type="button">상품 수정</button>
	        </div>
	        <div class="col">
	            <button class="w-100 btn btn-secondary btn-lg" type="button">목록으로</button>
	        </div>
	    </div>
	</div>
</body>
</html>