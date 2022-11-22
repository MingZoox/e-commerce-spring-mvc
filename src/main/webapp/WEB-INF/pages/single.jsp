<%-- 
    Document   : single
    Created on : 24-Nov-2018, 11:27:07 AM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Single</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="single">
			<div class="col-md-9 top-in-single">
				<div class="col-md-5 single-top">
					<img class="img-responsive fashion"
						src="${pageContext.request.contextPath}/resources/pages/images/${product.productImage}"
						alt="">
				</div>
				<div class="col-md-7 single-top-in">
					<div class="single-para">
						<h4>${product.productName}</h4>
						<h5>${product.productStatus}</h5>
						<div class="available">
							<h6>Available Options :</h6>
							<ul>
								<li>Quality:<select>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
								</select></li>
							</ul>
						</div>
						<div class="para-grid">
							<span class="add-to">$${product.productPrice}</span> <a href="${pageContext.request.contextPath}/cart/add/${product.productId}"
								class="hvr-shutter-in-vertical cart-to">Add to Cart</a>
							<div class="clearfix"></div>
						</div>
						<p>${product.productDescription}</p>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="content-top-in">
					<c:forEach var="item" items="${listProductFeatured}">
						<div class="col-md-4 top-single">
							<div class="col-md">
								<a
									href="${pageContext.request.contextPath}/product/${item.productId}"><img
									src="${pageContext.request.contextPath}/resources/pages/images/${item.productImage}"
									alt="" /> </a>
								<div class="top-content">
									<a
										href="${pageContext.request.contextPath}/product/${item.productId}"><h5>${item.productName}</h5>
									</a>
									<div class="white">
										<a href="${pageContext.request.contextPath}/cart/add/${item.productId}"
											class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD
											TO CART</a>
										<p class="dollar">
											<span class="in-dollar">$${item.productPrice} 
										</p>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>


					<div class="clearfix"></div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="single-bottom">
					<h4>Categories</h4>
					<ul>
						<c:forEach var="item" items="${listCategory}">
							<li><a href="${pageContext.request.contextPath}/category/${item.categoryId}"><i> </i>${item.categoryName}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="single-bottom">
					<h4>Product SALE</h4>
					<c:forEach var="item" items="${listProductSale}">
						<div class="product">
							<a
								href="${pageContext.request.contextPath}/product/${item.productId}">
								<img class="img-responsive fashion"
								src="${pageContext.request.contextPath}/resources/pages/images/${item.productImage}"
								alt="">
							</a>
							<div class="grid-product">
								<a
									href="${pageContext.request.contextPath}/product/${item.productId}"
									class="elit">${item.productName}</a> <span
									class="price price-in"><small>$${item.productPrice}</small>
									$${item.productPrice-item.productSale}</span>
							</div>
							<div class="clearfix"></div>
						</div>
					</c:forEach>

				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
