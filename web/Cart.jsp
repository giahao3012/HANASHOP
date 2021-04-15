<%-- 
    Document   : Cart
    Created on : Jan 16, 2021, 11:09:17 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>

    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>${requestScope.ERROR}</h1><h1>${requestScope.SUCCESS}</h1>
        <c:set var="shop" value="${sessionScope.CART}"/>
        <c:if test="${not empty shop}">
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">
                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Product</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Price</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Quantity</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Delete</div>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${shop.cart.values()}" var="dto">
                                                <tr>
                                                    <th scope="row">
                                                        <div class="p-2">
                                                            <img src="${dto.image}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                            <div class="ml-3 d-inline-block align-middle">
                                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block"></a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                            </div>
                                                        </div>
                                                    </th>
                                                    <td class="align-middle"><strong>${dto.price}</strong></td>
                                                    <td class="align-middle">
                                                        <a href="updateCartServlet?action=sub&pid=${dto.id}&pq=${dto.quantityCart}"><button class="btnSub">-</button></a> 
                                                        <strong>${dto.quantityCart}</strong>
                                                        <a href="updateCartServlet?action=add&pid=${dto.id}&pq=${dto.quantityCart}"><button class="btnAdd">+</button></a>
                                                    </td>
                                                    <td class="align-middle"><a href="ProductManagerServlet?action=deleteCart&pid=${dto.id}" class="text-dark">
                                                            <button type="button" class="btn btn-danger" onclick="return confirm('Do you want to delete?')">Delete</button>
                                                        </a>
                                                    </td>
                                                </tr> 
                                                </c:forEach>
                                            </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>
                         <form action="OrderServlet" method="POST">   
                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Delivery Info</div>
                                <div class="p-4">
                                    <div class="input-group mb-4 border rounded-pill p-2">
                                        <input type="text" placeholder="Enter Ship Address" name="shipAddr" aria-describedby="button-addon3" class="form-control border-0" required>
                                    </div>
                                    <div class="input-group mb-4 border rounded-pill p-2">
                                        <input type="text" placeholder="Enter Payment Method" name="payment" aria-describedby="button-addon3" class="form-control border-0" required>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Total</div>
                                <div class="p-4">
                                    <ul class="list-unstyled mb-4">
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total Product's Price</strong><strong>${shop.getTotal()} $</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>10 $</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total Price</strong>
                                            <h5 class="font-weight-bold">${shop.getTotal()+10} $</h5>
                                        </li>
                                    </ul>
                                        <c:if test="${shop.getTotal()!=0}">
                                            
                                            <input type="hidden" name="username" value="${sessionScope.acc.username}"/>
                                            <input type="hidden" name="Tprice" value="${shop.getTotal()+10}"/>
                                            <input type="submit" value="Buy Now" class="btn btn-dark rounded-pill py-2 btn-block">
                                           
                                        </c:if>
                                </div>
                            </div>
                        </div>
                       </form>
                    </div>
                </div>
            </div>
        </div>
        
    </c:if>
        <c:if test="${!not empty shop}">
            <h2 color="red">CART IS EMPTY!!!</h2>
        </c:if>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>
</html>

