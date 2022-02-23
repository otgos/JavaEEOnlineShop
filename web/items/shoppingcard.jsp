<%@ page import="java.util.ArrayList" %>
<%@ page import="com.upper.entity.Manufacturer" %>
<%@ page import="com.upper.entity.Category" %>
<%@ page import="com.upper.entity.Items" %>
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
        <div class="col-sm-6 offset-3">

            <%
                Items item = (Items)request.getAttribute("item");
                if(item!=null){
            %>
            <form action="/items/setshoppingcard" method="post">
                <div class="form-group">
                    <label>NAME: </label>
                    <input type="text" name="name" class="form-control" value="<%=item.getName()%>">
                </div>

                <div class="form-group">
                    <label>DESCRIPTION: </label>

                    <input type="text" name="name" class="form-control" value="<%=item.getDescription()%>">
                </div>


                <div class="form-group">
                    <label>MANUFACTURER: </label>

                    <input type="text"  name="manufacturer" value = "<%=item.getManufacturer().getName()%>">

                </div>

                <div class="form-group">
                    <label>CATEGORY: </label>

                    <input type="text"  name="category" value = "<%=item.getCategory().getName()%>">

                </div>

                <div class="form-group">
                    <button class="btn btn-primary"  name="action" value="additem">Continue Purchase </button>
                </div>

            </form>

            <form action="/deleteCookie" method="post">

                <div class="form-group">

                    <button class="btn btn-danger"  name="action" value="setform">DELETE COOKIE</button>
                </div>



            </form>
            <%
                }
            %>

        </div>
    </div>

</div>
</body>
</html>
