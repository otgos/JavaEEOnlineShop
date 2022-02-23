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
                        <a class="btn btn-dark btn-lg" href="/users/homeClient" role="button">BACK</a>
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

            </div>
            <div class="col-lg-4 col-md-5 col-sm-4 offset-md-1 offset-sm-1 col-12 mt-4">

                <form id="algin-form" action= "/items/addcomment?id=<%=item.getId()%>"  method="post">

                    <div class="form-group">
                        <h4>Leave a comment</h4> <label>Comment</label> <textarea name="comment" id="" msg cols="30" rows="5" class="form-control" style="background-color: gray;"></textarea>
                    </div>

                    <div class="form-inline"> <input type="checkbox" name="check" id="checkbx" class="mr-1"> <label>Subscribe me to the newlettter</label> </div>
                    <div>
                            <button class="btn btn-success" >Post Comment</button>
                    </div>

                </form>
            </div>

        </div>


    </div>
</section>

</div>
</body>
</html>
