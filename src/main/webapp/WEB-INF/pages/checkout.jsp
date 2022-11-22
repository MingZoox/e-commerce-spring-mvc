<%-- 
    Document   : cart
    Created on : 25-Nov-2018, 11:56:43 AM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <br/><br/>

            <div class="container">
                <div class="content">
                    <div class="shopping_cart">
                    <c:forEach var="map" items="${sessionScope.myCartItems}">
                        <div class="cart_box">
                            <div class="message">
                                <div class="list_img"><img src="${pageContext.request.contextPath}/resources/pages/images/${map.value.product.productImage}" class="img-responsive" alt=""></div>
                                <div class="list_close"><a href="${pageContext.request.contextPath}/cart/remove/${map.value.product.productId}">Remove item</a></div> 
                                <div class="list_desc"><h4><a href="#"><c:out value="${map.value.product.productName}"/></a></h4><c:out value="${map.value.quantity}"/> x
                                    $<c:out value="${map.value.product.productPrice}"/> = <span class="actual"> $<c:out value="${map.value.quantity * map.value.product.productPrice}"/></span></div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="total">
                    <div class="total_right">Free Shipping</div>
                    <div class="clearfix"> </div>
                    <div class="total_right">Total: $<c:out value="${sessionScope.myCartTotal}"/></div>
                    <div class="clearfix"> </div>
                    <div class="total_right">VAT (10%): <c:out value="${sessionScope.myCartTotal * 0.1}"/></div>
                    <div class="clearfix"> </div>
                    <div class="total_right">Pay: $<c:out value="${sessionScope.myCartTotal + (sessionScope.myCartTotal * 0.1)}"/></div>
                    <div class="clearfix"> </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>

            <div class="contact">
                <h2 class=" contact-in">CHECKOUT </h2>

                <div class="col-md-6 contact-top">
                    <h3>Info</h3>
                    <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas </p>
                    <p>Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id </p>				
                    <ul class="social ">
                        <li><span><i > </i>124 Avenue Street, Los angeles,California </span></li>
                        <li><span><i class="down"> </i>+ 00 123 456 7890</span></li>
                        <li><a href="mailto:info@example.com"><i class="mes"> </i>info@example.com</a></li>
                    </ul>
                </div>
                <div class="col-md-6 contact-top">
                    <form:form method="POST" action="${pageContext.request.contextPath}/cart/checkout" modelAttribute="receipt">
                        <h3>Want to work with me?</h3>
                        <div>
                            <span>Your Name</span>
                            <form:input path="receiptName"  />
							  <form:errors path="receiptName"></form:errors>
                        </div>
                        <div>
                            <span>Your Email</span>	
                            <form:input path="receiptMail"  />
                        </div>
                        <div>
                            <span>Your Address</span>	
                            <form:input path="receiptAddress"  />
                        </div>
                        <input type="submit" value="SEND" >	
                    </form:form>
                </div>
                <div class="clearfix"> </div>
            </div>

        </div>

        <br/><br/>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
