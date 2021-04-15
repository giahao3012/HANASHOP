<%-- 
    Document   : Left
    Created on : Jan 6, 2021, 2:52:41 PM
    Author     : Admin
--%>




<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach var="c" items="${cate}">
                <li class="list-group-item text-white"><a href="ProductManagerServlet?action=getPbyCid&cid=${c.id}">${c.cname}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="card bg-light mb-3">
        
            <form action="searchByPriceServlet" method="POST">
                <div class="card-header bg-primary text-white text-uppercase">Select Price</div>
                <ul class="list-group bg-light" style="list-style-type: none; margin: 10px;">
                    <li><p style="margin-bottom: 0px;">From</p><span><input style="height:30px;" type="text" name="min" value="${min}" required/></span></li>
                    <li><p style="margin-bottom: 0px;">To</p><span><input style="height: 30px;" type="text" name="max" value="${max}" required/></span></li>
                    <li><input type="submit" class="list-group-item" value="Submit" style="margin-left: 68px;margin-top: 10px; border-radius: 20px;"></li>
                </ul>
            </form>
    </div>
</div>