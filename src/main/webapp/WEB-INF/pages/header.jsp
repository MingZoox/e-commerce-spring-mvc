<%-- 
    Document   : header
    Created on : 24-Nov-2018, 10:53:53 AM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>

<!-- css -->
<link href="<c:url value="/resources/pages/css/bootstrap.css"/>"
	rel='stylesheet' type='text/css' />
<link href="<c:url value="/resources/pages/css/etalage.css"/>"
	rel='stylesheet' type='text/css' />
<link href="<c:url value="/resources/pages/css/style.css"/>"
	rel='stylesheet' type='text/css' />

<!--js-->
<script
	src="<c:url value="/resources/pages/js/jquery.etalage.min.js" />"></script>
<script src="<c:url value="/resources/pages/js/jquery.flexisel.js" />"></script>
<script src="<c:url value="/resources/pages/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/pages/js/nav.js" />"></script>
<script
	src="<c:url value="/resources/pages/js/responsiveslides.min.js" />"></script>
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>

<!--fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>

<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!--slider-script-->
<script>
	$(function() {
		$("#slider1").responsiveSlides({
			auto : true,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>
<script>
	$(document).ready(function(c) {
		$('.alert-close1').on('click', function(c) {
			$('.message1').fadeOut('slow', function(c) {
				$('.message1').remove();
			});
		});
	});
</script>

</head>
<body>

	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="header-top-in">
					<div class="logo">
						<a href="${pageContext.request.contextPath}/home"><img
							src="${pageContext.request.contextPath}/resources/pages/images/logo.png"
							alt=" "></a>
					</div>
					<div class="header-in">
						<ul class="icon1 sub-icon1">

							<c:if test="${sessionScope.myLogin==null}">
								<li><a href="${pageContext.request.contextPath}/login">LOGIN</a></li>
							</c:if>
							<c:if test="${sessionScope.myLogin!=null}">
								<li><a href="${pageContext.request.contextPath}/logout">LOGOUT</a></li>
								<li><a href="${pageContext.request.contextPath}/cart/add/-1">
									SHOPPING CART</a></li>
							<li><div class="cart">
									<a href="${pageContext.request.contextPath}/cart/add/-1" class="cart-in"> </a> <span> <c:out
											value="${sessionScope.myCartNum}" /></span>
								</div>
								<ul class="sub-icon1 list">
									<h3>
										Recently added items (<c:out value="${sessionScope.myCartNum}" />)
									</h3>
									<div class="shopping_cart">
										<c:forEach var="map" items="${sessionScope.myCartItems}">
											<div class="cart_box">
												<div class="message">
													<div class="alert-close"><a href="${pageContext.request.contextPath}/cart/remove/${map.value.product.productId}" ></a></div>
													<div class="list_img">
														<img
															src="${pageContext.request.contextPath}/resources/pages/images/${map.value.product.productImage}"
															class="img-responsive" alt="">
													</div>
													<div class="list_desc">
														<h4>
															<a href="${pageContext.request.contextPath}/product/${map.value.product.productId}"><c:out value="${map.value.product.productName}" /></a>
														</h4>
														<c:out value="${map.value.quantity}" /> x $
														<c:out value="${map.value.product.productPrice}" />
														= <span class="actual"> $<c:out value="${map.value.quantity * map.value.product.productPrice}" /></span>
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
										</c:forEach>
									</div>
									<div class="total">
										<div class="total_left">Total:</div>
										<div class="total_right">
											$
											<c:out value="${sessionScope.myCartTotal}" />
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="login_buttons">
										<div class="check_button">
											<a href="${pageContext.request.contextPath}/cart/checkout">Check out</a>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="clearfix"></div>
								</ul>
								</li>
							</c:if>
							
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<div class="header-bottom">
			<div class="container">
				<div class="h_menu4">
					<a class="toggleMenu" href="#">Menu</a>
					<ul class="nav">
						<li class="active"><a
							href="${pageContext.request.contextPath}/home"><i> </i>Home</a></li>
						<li><a href="about">About</a></li>
						<li><a href="news">News</a></li>
						<li>Shop
							<ul class="drop">
								<c:forEach var="item" items="${listCategory}">
									<li><a
										href="${pageContext.request.contextPath}/category/${item.categoryId}">${item.categoryName}</a></li>
								</c:forEach>
							</ul></li>
						<li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="header-bottom-in">
			<div class="container">
				<div class="header-bottom-on">
					<p class="wel">
						<a href="#">Welcome visitor you can login or create an
							account.</a>
					</p>
					<div class="header-can">
						<ul class="social-in">
							<li><a href="#"><i> </i></a></li>
							<li><a href="#"><i class="facebook"> </i></a></li>
							<li><a href="#"><i class="twitter"> </i></a></li>
							<li><a href="#"><i class="skype"> </i></a></li>
						</ul>
						<div class="down-top">
							<select class="in-drop">
								<option value="Dollars" class="in-of">Dollars</option>
								<option value="Euro" class="in-of">Euro</option>
								<option value="Yen" class="in-of">Yen</option>
							</select>
						</div>
						<div class="search">
							<form>
								<input type="text" value="Search" onfocus="this.value = '';"
									onblur="if (this.value == '') {
                                                this.value = '';
                                            }">
								<input type="submit" value="">
							</form>
						</div>

						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
