<%-- 
    Document   : product_list
    Created on : 28-Nov-2018, 8:34:28 PM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product list</title>
    </head>
    <body>

        <div class="page-container">	

            <div class="left-content">

                <div class="mother-grid-inner">

                    <jsp:include page="header.jsp"></jsp:include>

                        <div class="inner-block">
                            <div class="inbox">
                                <h2>Product Manage</h2>
                                <div class="col-md-12 mailbox-content  tab-content tab-content-in">
                                    <div class="tab-pane active text-style" id="tab1">
                                        <div class="mailbox-border">
                                            <div class="mail-toolbar clearfix">
                                                <div class="float-left">
                                                <a href="${pageContext.request.contextPath}/manages/product/add">
                                                    <div class="btn btn_1 btn-default mrg5R">
                                                        <i class="fa fa-plus"> </i>
                                                    </div>
                                                 </a>
                                                    <div class="clearfix"> </div>
                                                </div>
                                                <div class="float-right">
                                                    <span class="text-muted m-r-sm">Pages </span>
                                                    <div class="btn-group">
                                                        <a href="${pageContext.request.contextPath}/manages/product/list/${curIndex-1}" class="btn btn-default ${curIndex==1?"disabled":""}"><i class="fa fa-angle-left"></i></a>
                                                        <c:forEach var="i" begin="0" end="${totalItem}">    
                                                            <a class="btn btn-default" href="${pageContext.request.contextPath}/manages/product/list/${i+1}"><c:out value="${i+1}"/></a>
                                                        </c:forEach>
                                                    	<a href="${pageContext.request.contextPath}/manages/product/list/${curIndex+1}" class="btn btn-default ${curIndex==totalItem+1?"disabled":""}"><i class="fa fa-angle-right"></i></a>
                                                </div>	
                                                <div class="clearfix"> </div>		        
                                            </div>
                                        </div>
                                        <table class="table tab-border">
                                            <tbody>
                                                <tr>
                                                    <td class="hidden-xs">
                                                        <b>Product</b>
                                                    </td>
                                                     <td class="hidden-xs" style="width: 200px;">
                                                        <b>Category</b>
                                                    </td>
                                                    <td style="text-align: right; width: 150px;">
                                                        <b>Price</b>
                                                    </td>
                                                    <td style="text-align: right; width: 150px;">
                                                        <b>Sale</b>
                                                    </td>
                                                    <td style="text-align: center; width: 150px;">
                                                        <b>Option</b>
                                                    </td>
                                                </tr>
                                                <c:forEach var="item" items="${listProduct}">
                                                    <tr class="unread checked">
                                                        <td class="hidden-xs">
                                                            ${item.productName}
                                                        </td>
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            ${item.category.categoryName}
                                                        </td>
                                                        <td style="text-align: right; width: 150px;">
                                                            $${item.productPrice}
                                                        </td>
                                                        <td style="text-align: right; width: 150px;">
                                                            ${item.productSale}
                                                        </td>
                                                        <td style="text-align: center; width: 150px;">
                                                            <a class="btn btn-default" href="${pageContext.request.contextPath}/manages/product/edit/${item.productId}"><i class="fa fa-edit"></i></a>
                                                            <a class="btn btn-default" href="${pageContext.request.contextPath}/manages/product/remove/${item.productId}"><i class="fa fa-remove"></i></a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
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
