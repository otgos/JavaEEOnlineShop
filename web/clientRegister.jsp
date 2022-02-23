
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPPER SHOP</title>
    <%@include file = "/vendor/head.jsp"%>
</head>
<body>

<%@include file = "/vendor/navbar.jsp"%>

<div class="container">

    <div class="row mt-5">
        <h3 class="mb-4">Fill the requested fields to continue your purchase.</h3>
        <div class="col-sm-6 offset-3">

            <%
                String success = request.getParameter("success");
                if(success!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>You have registered successfully!</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>

            </div>
            <%
                }
            %>

            <%
                String passerror = request.getParameter("passworderror");
                if(passerror!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Incorrect Password!</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>

            </div>
            <%
                }
            %>

            <%
                String emailError = request.getParameter("emailerror");
                if(emailError!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Incorrect Email!</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
            </div>
            <%
                }
            %>


            <form action="/clientRegister" method="post">
                <div class="form-group">
                    <label>FIRST NAME: </label>
                    <input type="text" required placeholder="Enter your FirstName" name="fName" class="form-control">
                </div>

                <div class="form-group">
                    <label>LAST NAME: </label>
                    <input type="text" required placeholder="Enter your LastName" name="lName" class="form-control">
                </div>
                <div class="form-group">
                    <label>PHONE NUMBER: </label>
                    <input type="text" required placeholder="Enter your phone number" name="phoneNumber" class="form-control">
                </div>
                <div class="form-group">
                    <label>GENDER: </label>
                    <select class="form-control" name="gender">
                            <option value="none" selected>Gender</option>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="other">other</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>HOME ADDRESS: </label>
                    <input type="text" required placeholder="Enter your delivery address" name="address" class="form-control">
                </div>

                <div class="form-group">
                    <label>EMAIL: </label>
                    <input type="email" required placeholder="Enter your email" name="email" class="form-control">
                </div>
                <div class="form-group">
                    <label>PASSWORD: </label>
                    <input type="password" required placeholder="Enter your email" name="password" class="form-control">
                </div>

                <div class="form-group">
                    <label>RETYPE PASSWORD: </label>
                    <input type="password" required placeholder="Enter your email" name="rePassword" class="form-control">
                </div>

<%--                <div class="form-group">--%>
<%--                    <label>REGISTER DATE: </label><br>--%>
<%--                    <input type="date" value="<?php echo date('Y-m-d');?>">--%>
<%--                </div>--%>


                <button class="btn btn-success">SUBMIT</button>
            </form>
        </div>
    </div>

</div>
</body>
</html>
