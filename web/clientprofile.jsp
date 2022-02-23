
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.upper.entity.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPPER ELECTRONICS SHOP</title>
    <%@include file = "/vendor/head.jsp"%>
</head>
<body>

<%@include file = "/vendor/navbar.jsp"%>



<div class="container">

    <div class="row mt-5">
        <div class="col-sm-12">
            <h2>
                This is profile of <%=(ONLINE?currentClient.getfName(): "NO USER")%>
            </h2>
        </div>



        <div class="card">
            <div class="row">
                <div class="col-md-8 cart">
                    <div class="title">
                        <div class="row">
                            <div class="col">
                                <h4><b>Shopping Cart</b></h4>
                            </div>
                            <div class="col align-self-center text-right text-muted"><%=item.size()%> items</div>
                        </div>
                    </div>
                    <%
                        HttpSession cardSession = request.getSession();
                        ArrayList<Items> cardItems = (ArrayList<Items>) cardSession.getAttribute("cardList");
                        ArrayList<ArrayList<Items>> newList = new ArrayList<>();
                        if(cardItems!=null) {
                            newList.add(cardItems);
                        }
                        if(newList!=null){
                            for (ArrayList<Items> item:newList){
                                for(Items it:item){

                    %>
                            <div class="row border-top border-bottom">
                                <div class="row main align-items-center">
                                    <div class="col-2"><img class="img-fluid" src="https://i.imgur.com/1GrakTl.jpg"></div>
                                    <div class="col">
                                        <div class="row text-muted"><%=it.getName()%></div>
                                        <div class="row"><%=it.getDescription()%></div>
                                    </div>
                                    <div class="col"> <a href="#">-</a><a href="#" class="border">1</a><a href="#">+</a> </div>
                                    <div class="col">&Tenge <%=it.getPrice()%><span class="close">&#10005;</span></div>
                                </div>
                            </div>
                    <%
                                }
                            }
                        }
                    %>

                    <div class="back-to-shop"><a href="#">&leftarrow;</a><span class="text-muted">Back to shop</span></div>
                </div>
                <div class="col-md-4 summary">
                    <div>
                        <h5><b>Summary</b></h5>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col" style="padding-left:0;">ITEMS 3</div>
                        <div class="col text-right">&euro; 132.00</div>
                    </div>
                    <form>
                        <p>SHIPPING</p> <select>
                        <option class="text-muted">Standard-Delivery- &euro;5.00</option>
                    </select>
                        <p>GIVE CODE</p> <input id="code" placeholder="Enter your code">
                    </form>
                    <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                        <div class="col">TOTAL PRICE</div>
                        <div class="col text-right">&euro; 137.00</div>
                    </div> <button class="btn">CHECKOUT</button>
                </div>
            </div>
        </div>


    </div>

</div>
</body>
</html>