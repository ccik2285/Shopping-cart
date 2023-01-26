<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<script src="/js/jquery-3.6.3.min.js"></script>
<script>

$( document ).ready( function() {

	


});
</script>
<body>
	<div class="container">
		<form action="/main" method="post">
	    <div class="py-5 text-center">
	        <h2>상품 등록 폼</h2>
	    </div>
	    <h4 class="mb-3">상품 입력</h4>
        <div>
            <label for="name">상품명</label>
            <input type="text" id="name" name="name" class="formcontrol" placeholder="상품명을 입력하세요">
        </div>
        <div>
            <label for="price">가격</label>
            <input type="text" id="price" name="price" class="form-control" placeholder="가격을 입력하세요">
        </div>
        <hr class="my-4">
        <div class="row">
            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" id="addProductBtn" type="submit">상품
                    등록
                </button>
            </div>
            <div class="col">
                <button class="w-100 btn btn-secondary btn-lg"
                        onclick="location.href='/product'" type="button">취소
                </button>
            </div>
        </div>
        </form>
	</div>
</body>
</html>