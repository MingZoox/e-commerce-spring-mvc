<%-- 
    Document   : success
    Created on : 26-Nov-2018, 7:54:30 PM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>success</title>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="check-out">
                    <h4 class="title">Shopping cart is empty</h4>
                    <p class="cart">You have no items in your shopping cart.<br>Click<a href="${pageContext.request.contextPath}/home"> here</a> to continue shopping</p>
                </div>

            </div>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
