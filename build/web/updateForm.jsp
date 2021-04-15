<%-- 
    Document   : updateForm
    Created on : Jan 11, 2021, 2:54:26 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Update Form</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Update Form</h2>
                </div>
                <div class="card-body">
                    <form method="POST" action="ProductManagerServlet">
                      <div class="form-row">
                            <div class="name">Product ID</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="id" value="${p.id}" required/>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Product Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="name" value="${p.name}" required/>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Image</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="type" name="img" value="${p.img}" required/>
                                    <img src="${p.img}" width="260" height="260"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Description</div>
                            <div class="value">
                                <div class="input-group">
                                    <textarea class="input--style-5" type="type" name="description" required>${p.descritption}</textarea>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Price</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="number" name="price" value="${p.price}" min="1">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Quantity</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="number" name="quantity" value="${p.quantity}" min="10">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Publish Company</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="type" name="publishingCompany" value="${p.publishingCompany}" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Create Date</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="createDate" value="${p.createDate}">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Category</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="category">
                                            <c:forEach items="${cate}" var="c">
                                                <option value="${c.id}">${c.cname}</option>
                                            </c:forEach>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Are a product is release?</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Release
                                    <input type="radio" checked="checked" name="isDisable">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">Disable
                                    <input type="radio" name="isDisable">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div>
                            <input type="submit" class="btn btn--radius-2 btn--red" value="Update" name="action">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->