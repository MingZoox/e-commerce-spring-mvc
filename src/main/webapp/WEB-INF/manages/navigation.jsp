<%-- 
    Document   : navigation
    Created on : 28-Nov-2018, 2:39:20 PM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>navigation</title>
    </head>
    <body>

        <div class="sidebar-menu">
            <div class="logo"> <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> <a href="#"> <span id="logo" ></span> 
                    <!--<img id="logo" src="" alt="Logo"/>--> 
                </a> </div>
            <div class="menu">
                <ul id="menu" >
                    <li><a href="${pageContext.request.contextPath}/manages/home"><i class="fa fa-home"></i><span>Home</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/manages/category"><i class="fa fa-tags"></i><span>Category</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/manages/product/list/1"><i class="fa fa-copy"></i><span>Product</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/manages/report/receipt"><i class="fa fa-bar-chart"></i><span>Report</span></a></li>
                    <li><a href="#"><i class="fa fa-envelope"></i><span>Mailbox</span><span class="fa fa-angle-right" style="float: right"></span></a>
                        <ul id="menu-academico-sub" >
                            <li id="menu-academico-avaliacoes" ><a href="inbox.html">Inbox</a></li>
                            <li id="menu-academico-boletim" ><a href="inbox-details.html">Compose email</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="fa fa-cogs"></i><span>System</span><span class="fa fa-angle-right" style="float: right"></span></a>
                        <ul id="menu-academico-sub" >
                            <li id="menu-academico-avaliacoes" ><a href="404.html">404</a></li>
                            <li id="menu-academico-boletim" ><a href="blank.html">Blank</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="clearfix"> </div>

        <!--slide bar menu end here-->
        <script>
            var toggle = true;

            $(".sidebar-icon").click(function () {
                if (toggle)
                {
                    $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
                    $("#menu span").css({"position": "absolute"});
                } else
                {
                    $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
                    setTimeout(function () {
                        $("#menu span").css({"position": "relative"});
                    }, 400);
                }
                toggle = !toggle;
            });
        </script>

    </body>
</html>
