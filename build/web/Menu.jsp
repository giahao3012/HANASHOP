<%-- 
    Document   : Menu
    Created on : Jan 6, 2021, 2:52:32 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="ProductManagerServlet">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Hello ${sessionScope.acc.username}</a>
                </li>
                <c:if test="${sessionScope.acc!=null}">
                     <c:if test="${sessionScope.acc.role=='admin'}">
                    <li class="nav-item">
                    <a class="nav-link" href="manageServlet">Manager Product</a>
                    </li>
                    </c:if>
                    <c:if test="${sessionScope.acc.role=='user'}">
                         <li class="nav-item">
                        <a class="nav-link" href="HistoryServlet?username=${sessionScope.acc.username}">View History</a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                    <a class="nav-link" href="LogoutServlet">Logout</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc==null}">
                    <li class="nav-item">
                    <a class="nav-link" href="Login.jsp">Login</a>
                    </li>
                </c:if>
            </ul>

            <form action="SearchServlet" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input name="txt" type="text" value="${s}" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="Cart.jsp">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light"></span>
                </a>
            </form>
        </div>
    </div>
</nav>
    <section class="jumbotron text-center" style="background-image:url(https://i.pinimg.com/originals/dd/26/89/dd2689332f56aa00c9fb9f41afd8e209.png);">
    <div class="container">
        <img src="data:image/png;base64,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">
    </div>
    </section>
<!--end of menu-->

