<%-- 
    Document   : slideshow
    Created on : 24-Nov-2018, 10:57:47 AM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>slideshow</title>
    </head>
    <body>

        <div class="banner-mat">
            <div class="container">
                <div class="banner">

                    <!-- Slideshow 4 -->
                    <div class="slider">
                        <ul class="rslides" id="slider1">
                            <li><img src="${pageContext.request.contextPath}/resources/pages/images/banner.jpg" alt="">
                            </li>
                            <li><img src="${pageContext.request.contextPath}/resources/pages/images/banner1.jpg" alt="">
                            </li>
                            <li><img src="${pageContext.request.contextPath}/resources/pages/images/banner.jpg" alt="">
                            </li>
                            <li><img src="${pageContext.request.contextPath}/resources/pages/images/banner2.jpg" alt="">
                            </li>
                        </ul>
                    </div>

                    <div class="banner-bottom">
                        <div class="banner-matter">
                            <p>Childish Gambino - Camp Now Available for just $9.99</p> 
                            <a href="single.html" class="hvr-shutter-in-vertical ">Purchase</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>				
                <!-- //slider-->
            </div>
        </div>

    </body>
</html>
