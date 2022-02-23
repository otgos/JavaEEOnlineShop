<%@ page import="com.upper.entity.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.upper.database.ItemDBManager" %>
<%@ page import="static com.upper.database.ItemDBManager.getCardItems" %>
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

        <H1>In your card : </H1>


        <div class="container">

            <div class="row mt-5">
                <div class="col-sm-12">
                    <%--            <h4>--%>
                    <%--                CONTENTS OF <%=siteName%>--%>
                    <%--            </h4>--%>

                    <table class="table">
                        <thead>
                        <tr>
                            <th>No:</th>
                            <%--              <th>ID</th>--%>
                            <th>NAME</th>
                            <th>DESCRIPTION</th>
                            <th>PRICE</th>

                        </tr>
                        </thead>
                        <tbody>



                        <tr>
                            <td>
<%--                                <%--%>
<%--                                    out.print(number);--%>
<%--                                %>--%>
                            </td>

                            <%
                                ArrayList<Items> itemName = (ArrayList<Items>)session.getAttribute("cardList");
                                if(itemName!=null){
                                    for(Items it: itemName){
                            %>
                            <td>
                                <%=it.getName()%>
                            </td>

                            <td>
                                <%=it.getDescription()%>
                            </td>

                            <td>
                                <%=it.getPrice()%>
                            </td>

                            <td>
                                <a href="/items/itemdetail?id=<%=it.getId()%>" class ="btn btn-info btn-sm">DETAILS</a>
                            </td>
                        </tr>

                        <%
                                }
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>




        </div>
    </div>

</div>
</body>
</html>
