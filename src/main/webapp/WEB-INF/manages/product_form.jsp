<%-- 
    Document   : product_form
    Created on : 28-Nov-2018, 8:34:38 PM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>product form</title>
    </head>
    <body>

        <div class="page-container">	

            <div class="left-content">

                <div class="mother-grid-inner">

                    <jsp:include page="header.jsp"></jsp:include>

                        <div class="inner-block">
                            <div class="inbox">
                                <h2>Product Details</h2>
                                <div class="col-md-12 compose-right">
                                    <div class="inbox-details-default">
                                        <div class="inbox-details-heading">
                                        ${product.productName}
                                    </div>
                                    <div class="inbox-details-body">
                                        <div class="alert alert-info">
                                            Please fill details to send a new message
                                        </div>
                                        <form:form method="POST" modelAttribute="product" class="com-mail"
                                                   action="${pageContext.request.contextPath}/manages/product/save" >
                                            <label>Category ${product.category.categoryId}</label>
                                            <form:select path="category.categoryId">    
                                                <option value="-1">Select a type</option>
                                                <c:forEach var="c" items="${listCategory}">
                                                    <option value="${c.categoryId}" ${product.category.categoryId == c.categoryId ? 'selected=""' : ''}>${c.categoryName}</option>
                                                </c:forEach>
                                            </form:select><br />
                                            <label>Name</label>
                                            <form:input path="productName"  />
                                            <label>Price</label>
                                            <form:input path="productPrice"  />
                                            <label>Sale</label>
                                            <form:input path="productSale" />
                                            <label>Description</label>
                                            <form:textarea path="productDescription"  />
                                               <c:if test="${product.productImage!=null}">
												<img src="${pageContext.request.contextPath}/resources/pages/images/${product.productImage}" alt="">
											</c:if>
                                            <div class="form-group">
                                                <div class="btn btn-default btn-file">
                                                    <i class="fa fa-paperclip"> </i> Attachment
                                                    <input type="file" name="attachment">
                                                </div>
                                            </div>
                                            <input type="submit" value="Save"> 
                                        </form:form>
                                    </div>
                                </div>
                            </div>

                            <div class="clearfix"> </div>     
                        </div>
                    </div>

                    <jsp:include page="footer.jsp"></jsp:include>

                    </div>

                </div>

            <jsp:include page="navigation.jsp"></jsp:include>

        </div>

    </body>
</html>
