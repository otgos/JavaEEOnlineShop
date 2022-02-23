
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entity.Manufacturer" %>
<%@ page import="com.entity.Category" %>
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
                String success = request.getParameter("success");
                if(success!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Welldone!</strong> Item added successfully!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <form action="/items/edititem" method="post">
                <div class="form-group">
                    <label>NAME: </label>
                    <input type="text" placeholder="Item Name" name="name" class="form-control">
                </div>
                <div class="form-group">
                    <label>DESCRIPTION: </label>
                    <input type="text" placeholder="Item Description" name="description" class="form-control">
                </div>
                <div class="form-group">
                    <label>PRICE: </label>
                    <input type="number" placeholder="Item Price" name="price" class="form-control">
                </div>
                <div class="form-group">
                    <label>AMOUNT: </label>
                    <input type="mumber" placeholder="Item amount" name="amount" class="form-control">
                </div>

                <div class="form-group">
                    <label>MANUFACTURER: </label>
                    <select class="form-control" name="brand_id">
                        <%
                            ArrayList<Manufacturer> manufacturers = (ArrayList<Manufacturer>) request.getAttribute("manufacturers");
                            if(manufacturers!=null){
                                for(Manufacturer c:manufacturers){
                        %>

                        <option value="<%=c.getId()%>">

                            <%=c.getName()+" / "+c.getShortName()%>

                        </option>

                        <%
                                }
                            }
                        %>
                    </select>
                </div>

                <div class="form-group">
                    <label>CATEGORY: </label>
                    <select class="form-control" name="category_id">
                        <%
                            ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
                            if(categories!=null){
                                for(Category c:categories){
                        %>

                        <option value="<%=c.getId()%>">

                            <%=c.getName()%>

                        </option>

                        <%
                                }
                            }
                        %>
                    </select>
                </div>

                <div class="form-group">
                    <button class="btn btn-success">UPDATE ITEM</button>
                </div>



            </form>
        </div>
    </div>

</div>
</body>
</html>
