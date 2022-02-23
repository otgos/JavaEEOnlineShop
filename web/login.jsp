
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
        <h3 class="mb-4">LOGIN TO SYSTEM</h3>
        <div class="col-sm-6 offset-3">
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


            <form action="/auth" method="post">
                <div class="form-group">
                    <label>EMAIL: </label>
                    <input type="email" required placeholder="Enter your email" name="email" class="form-control">
                </div>
                <div class="form-group">
                    <label>PASSWORD: </label>
                    <input type="password" required placeholder="Enter your password" name="password" class="form-control">
                </div>

                <div class="form-group">
                    <button class="btn btn-success">LOGIN</button>
                </div>

            </form>
        </div>
    </div>

</div>
</body>
</html>
