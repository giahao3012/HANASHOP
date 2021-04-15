<%-- 
    Document   : History
    Created on : Jan 19, 2021, 6:25:29 PM
    Author     : Admin
--%>
<%@page import="java.util.List"%>
<%@page import="dto.CartDTO"%>
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
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
           <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="ProductManagerServlet">WELCOME ${sessionScope.acc.username}</a></li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
       
        <form action="SearchHistoryByNameServlet" method="POST" style="display: flex; justify-content: center; width: 550px; margin-left: 29%;">
            <input type="hidden" name="username" value="${sessionScope.acc.username}"/>
            <p class="nameSelect">Input Product Name: </p> <input type="text" name="pname" style="height: 30px; width: 200px;" value="${requestScope.pname}" required/>
            <input type="submit" class="submitI" value="Search">
        </form>
        <form action="SearchHistoryByDateServlet" method="POST" style="display: flex; justify-content: center; width: 550px; margin-left: 30%;">
            <input type="hidden" name="username" value="${sessionScope.acc.username}"/>
            <p class="nameSelect">Input Date Order: </p> <input type="date" name="date" style="height: 30px; width: 200px;" value="${requestScope.date}" required/>
            <input type="submit" class="submitI" value="Search">
        </form>
        <div class="container-fluid" style="margin-top: 70px;text-align: center;">
            <div class="row">
                <div class="col-sm-2">
                    <p></p>

                </div>
                
                <div class="shopping-cart">
                <div class="px-4 px-lg-0">
                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <c:if test="${not empty requestScope.LIST}">
                                            <table class="table">
                                                 <thead>
                                                    <tr>
                                                    <th>No</th>
                                                    <th>Product Name</th>
                                                    <th>Price</th>
                                                    <th>Quantity</th>
                                                    <th>Amount</th>
                                                    <th>Date Order</th>
                                                </tr>
                                             </thead>
                                            <c:forEach var="dto" items="${requestScope.LIST}" varStatus="counter">
                                            <tbody>
                                            <tr>
                                                <td style="padding: 20px 20px;">${counter.count}</td>
                                                <td style="padding: 20px 20px;">${dto.name} </td>
                                                <td style="padding: 20px 20px;">${dto.price}</td>
                                                <td style="padding: 20px 20px;">${dto.quantity}</td>
                                                <td style="padding: 20px 20px;">${dto.price * dto.quantity}</td>
                                                <td style="padding: 20px 20px;">${dto.date}</td>
                                            </tr>
                                            </tbody>
                                            </c:forEach>
                                            </table>
                                        </c:if>
                                         <c:if test="${not empty requestScope.LISTHISTORY}">
                    <table class="table">
                        <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Amount</th>
                                    <th>Date Order</th>
                                </tr>
                            </thead>
                            <c:forEach var="dto" varStatus="counter" items="${requestScope.LISTHISTORY}">

                                <tbody>
                                    <tr>
                                        <td style="padding: 20px 20px;">${counter.count}</td>
                                        <td style="padding: 20px 20px;">${dto.name}</td>
                                        <td style="padding: 20px 20px;">${dto.price}</td>
                                        <td style="padding: 20px 20px;">${dto.quantity}</td>
                                        <td style="padding: 20px 20px;">${dto.price * dto.quantity}</td>
                                        <td style="padding: 20px 20px;">${dto.date}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                    </table>
                </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
                                   
            </div>
        </div>

    </body>
</html>