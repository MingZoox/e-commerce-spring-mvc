<%-- 
    Document   : content
    Created on : 24-Nov-2018, 10:58:42 AM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>content</title>
    </head>
    <body>

        <div class="container">
            <div class="content">
                <div class="content-top">
                    <h3 class="future">FEATURED </h3>
                    <div class="content-top-in">
                        <c:forEach var="item" items="${listProductFeatured}">
                            <div class="col-md-3 md-col">
                                <div class="col-md">
                                    <a href="${pageContext.request.contextPath}/product/${item.productId}"><img  src="${pageContext.request.contextPath}/resources/pages/images/${item.productImage}" alt="" /></a>	
                                    <div class="top-content">
                                        <h5><a href="${pageContext.request.contextPath}/product/${item.productId}">${item.productName}</a></h5>
                                        <div class="white">
                                            <a href="${pageContext.request.contextPath}/cart/add/${item.productId}" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD TO CART</a>
                                            <p class="dollar"><span class="in-dollar">$</span><span>${item.productPrice}</span></p>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>							
                                </div>
                            </div>
                        </c:forEach>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <!---->
                <div class="content-top">
                    <h3 class="future">SALE </h3>
                    <div class="content-top-in">
                        <c:forEach var="item" items="${listProductSale}">
                        <div class="col-md-3 md-col">
                            <div class="col-md">
                                <a href="${pageContext.request.contextPath}/product/${item.productId}"><img src="${pageContext.request.contextPath}/resources/pages/images/${item.productImage}" alt="" /></a>	
                                <div class="top-content">
                                    <h5><a href="${pageContext.request.contextPath}/product/${item.productId}">${item.productName}</a></h5>
                                    <div class="white">
                                        <a href="${pageContext.request.contextPath}/cart/add/${item.productId}" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD TO CART</a>
                                        <p class="dollar"><span class="in-dollar">$</span><span>${item.productPrice}</span></p>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>							
                            </div>
                        </div>
                        </c:forEach>
                        <div class="clearfix"></div>
                    </div>
                </div>

            </div>
        </div>

    </body>
</html>
