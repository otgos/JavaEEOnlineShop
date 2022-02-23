<%@ page import="com.upper.entity.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.upper.entity.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/vendor/head.jsp"%>
    <title>UPPER ELECTRONICS SHOP</title>
</head>
<body>
<%@include file = "/vendor/navbar.jsp"%>
<div class="container">

    <div class="row mt-3">
        <div class="col-sm-12">
            <%
                Items item = (Items)request.getAttribute("item");
                if(item!=null){
            %>

            <div class="card" style="width: 45rem;">
                <img src="<%=item.getImage()%>" class="card-img-top" alt="...">
                <div class="card-body">
                    <h2 class="card-title"><%=item.getName()%></h2>
                        <p class="lead">
                            DESCRIPTION: <%=item.getDescription()%>  <br>
                            PRICE: <%=item.getPrice()%> KZ Tenge <br>
                            MANUFACTURER : <%=item.getManufacturer().getName()+" / "+item.getManufacturer().getShortName()%> <br>
                            CATEGORY : <%=item.getCategory().getName()%><br
                            AMOUNT : <%=item.getAmount()%> AVAILABLE
                        </p>

                    <div class="mt-2 d-flex justify-content-between">
                        <a class="btn btn-dark btn-lg" href="/" role="button">BACK</a>
                        <a class="btn btn-primary btn-lg" type= "post" href="/items/setshoppingcard?id=<%=item.getId()%>" role="button">ADD TO BASKET</a>
                    </div>
                </div>
            </div>
            </div>
            </div>
            <%
                }
            %>
        </div>
    </div>

<section>
    <div class="container">


        <div class="row">
            <div class="col-sm-5 col-md-6 col-12 pb-4">

                <h1>Comments</h1>
                <%
                    ArrayList<Comment> comments = (ArrayList<Comment>)request.getAttribute("comments");
                    if(comments!=null){
                        for(Comment c:comments){

                %>

                <div class="comment mt-4 text-justify float-left"> <img src="https://i.imgur.com/yTFUilP.jpg" alt="" class="rounded-circle" width="40" height="40">
                    <h4><%=c.getClient().getfName()%></h4> <span><%=c.getDate()%></span> <br>
                    <p><%=c.getComments()%></p>
                </div>

                <%
                        }
                    }
                %>
                <div class="mt-2 d-flex justify-content-between">
                    <h4>In order to write a comment, please </h4>
                    <a class="btn btn-gray btn-lg" type= "post" href="/clientRegister" role="button">REGISTER</a>
                    <h4>or</h4>
                    <a class="btn btn-gray btn-lg" type= "post" href="/login" role="button">LOGIN</a>

                </div>
            </div>
        </div>
        </div>
</section>

</div>
</body>
</html>
