<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/jquery-3.6.3.min.js"></script>
<script>

$( document ).ready( function() {

		$.ajax({
			url: "/main/find/all",
			type: "get",
			dataType: "json",	
			success: function(data) {
				
				if(data){
					for(let i=0; i < data.length; i++){
						let product = data[i];
						$('#productList > tbody:last').append(
								`
								<tr>
								<td>
									\${product['id']}
								</td>
								
								
								<td>
									<a href="/main/detail/\${product['id']}">\${product['name']}</a>
								</td>
								
								
								<td>
									\${product['price']}
								</td>
								</tr>
								`		
								)
					}	
				}
			} 
		}); 
	

});
</script>
</head>
<body>
<div class="container" style="max-width: 600px">
    <div class="py-5 text-center">
        <h2>상품 목록</h2>
    </div>
    <div class="row">
        <div class="col">
            <button class="btn btn-primary float-end"
            	onclick="location.href='/product/addProductForm'" 
	             type="button">
                상품 등록
            </button>
        </div>
    </div>
    <hr class="my-4">
    <div>
        <table class="table" id="productList">
            <thead>
            <tr>
                <th>ID</th>
                <th>상품명</th>
                <th>가격</th>
            </tr>
            </thead>
            <tbody>
            	
		      
            </tbody>
        </table>
    </div>
</div> 
</body>
</html>
   