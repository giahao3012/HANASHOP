<%-- 
    Document   : index
    Created on : Oct 13, 2020, 11:24:45 PM
    Author     : 🌸방탄소년단🌸
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hana Shop</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="ProductManagerServlet">Home</a></li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            
            <div class="container">
                <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>

                    <div class="col-sm-9">
                        <div class="row">
                        <c:forEach items="${data}" var="p">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${p.img}" height="220" width="100" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="ProductManagerServlet?action=detail&pid=${p.id}" title="View Product">${p.name}</a></h4>
                                        <p class="card-text show_txt">${p.descritption}
                                        </p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${p.price} $</p>
                                            </div>
                                            <c:if test="${sessionScope.acc.role=='user'}">
                                                    <div class="col">
                                                    <form action="ProductManagerServlet" method="POST">
                                                    <input class="btn btn-success btn-block" type="submit" name="action" value="Add To Cart">
                                                    <input type="hidden" name="idC" value="${p.id}"/>
                                                    <input type="hidden" name="nameC" value="${p.name}"/>
                                                    <input type="hidden" name="imgC" value="${p.img}">
                                                    <input type="hidden" name="descriptionC" value="${p.descritption}"/>
                                                    <input type="hidden" name="cateC" value="${p.categoryID}"/>
                                                    <input type="hidden" name="quantityC" value="${p.quantity}"/>
                                                    <input type="hidden" name="priceC" value="${p.price}"/>
                                                    <input type="hidden" name="usernameC" value="${sessionScope.acc.username}"/>
                                                    </form>
                                                    </div>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
            <c:choose>
                    <c:when test="${act=='searchbyPrice'}">
                    <div class="clearfix">
                    <ul class="pagination" style="margin-left: 50%;">
                    <c:forEach begin="1" end="${numP}" var="i">
                        <c:url var="link" value="searchByPriceServlet">
                                <c:param name="index" value="${i}"/>
                                <c:param name="min" value="${requestScope.min}"/>
                                <c:param name="max" value="${requestScope.max}"/>
                        </c:url>
                        <li class="page-item"><a href="${link}" class="page-link">${i}</a></li>
                    </c:forEach>
                    </ul>
                    </div>
                    </c:when>
                    <c:when test="${act=='searchbyName'}">
                        <div class="clearfix">
                    <ul class="pagination" style="margin-left: 50%;">
                    <c:forEach begin="1" end="${numP}" var="i">
                        <c:url var="link" value="SearchServlet">
                                <c:param name="index" value="${i}"/>
                                <c:param name="txt" value="${requestScope.s}"/>
                        </c:url>
                        <li class="page-item"><a href="${link}" class="page-link">${i}</a></li>
                    </c:forEach>
                    </ul>
                    </div>
                    </c:when>
                    <c:when test="${act=='searchbyCateID'}">
                        <div class="clearfix">
                    <ul class="pagination" style="margin-left: 50%;">
                    <c:forEach begin="1" end="${numP}" var="i">
                        <c:url var="link" value="loadProductbyCid">
                                <c:param name="index" value="${i}"/>
                                <c:param name="cid" value="${requestScope.cId}"/>
                        </c:url>
                        <li class="page-item"><a href="${link}" class="page-link">${i}</a></li>
                    </c:forEach>
                    </ul>
                    </div>
                    </c:when>
                    <c:otherwise>
                    <div class="clearfix">
                    <ul class="pagination" style="margin-left: 50%;">
                    <c:forEach begin="1" end="${numP}" var="i">
                        <li class="page-item"><a href="loadProductServlet?index=${i}" class="page-link">${i}</a></li>
                    </c:forEach>
                    </ul>
                    </div>
                    </c:otherwise>
                </c:choose>
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>

