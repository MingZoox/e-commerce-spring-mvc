<%-- 
    Document   : shop
    Created on : 24-Nov-2018, 11:22:53 AM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shop</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="products">
			<h2 class=" products-in">PRODUCTS</h2>

			<c:set var="salary" scope="session" value="0" />
			<c:forEach var="item" items="${listProduct}">
				<%--                         <c:set var="salary" scope="session" value="${salary + 1}"/>
                        <c:if test = "${salary == 1}">
                            <div class=" top-products">
                        </c:if> --%>

				<div class="col-md-3 md-col">
					<div class="col-md">
						<a
							href="${pageContext.request.contextPath}/product/${item.productId}"
							class="compare-in"><img
							src="${pageContext.request.contextPath}/resources/pages/images/${item.productImage}"
							alt="" /> <!-- <div class="compare">
                                        <span>Add to Compare</span>
                                        <span>Add to Whislist</span>
                                    </div> --> </a>
						<div class="top-content">
							<h5>
								<a
									href="${pageContext.request.contextPath}/product/${item.productId}">${item.productName}</a>
							</h5>
							<div class="white">
								<a href="${pageContext.request.contextPath}/cart/add/${item.productId}"
									class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD
									TO CART</a>
								<p class="dollar">
									<span class="in-dollar">$</span><span>2</span><span>0</span>
								</p>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>

				<%--                         <c:if test = "${salary == 4}">
                            <c:set var="salary" scope="session" value="0"/>
                            <div class="clearfix"></div>
                            </div>
                        </c:if> --%>
			</c:forEach>

			<div class="clearfix"></div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
