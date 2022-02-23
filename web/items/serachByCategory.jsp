
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
                    <th>AMOUNT</th>
                    <th>BRAND</th>
                    <th>CATEGORY</th>
                    <th>DETAILS</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Items> items =(ArrayList<Items>) request.getAttribute("searchByCategory");
                    int number = 1;
                    if(items!=null){
                        for(Items it:items){
                %>
                <tr>
                    <td>
                        <%
                            out.print(number);
                        %>
                    </td>
                    <%--                  ID column disabled--%>
                    <%--                  <td>--%>
                    <%--                    <%--%>
                    <%--                      out.print(it.getId());--%>
                    <%--                    %>--%>
                    <%--                  </td>--%>

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
                        <%=it.getAmount()%>
                    </td>

                    <td>
                        <%=it.getManufacturer().getName()+" / "+it.getManufacturer().getShortName()%>
                    </td>

                    <td>
                        <%=it.getCategory().getName()%>
                    </td>

                    <td>
                        <a href="/items/itemdetail?id=<%=it.getId()%>" class ="btn btn-info btn-sm">DETAILS</a>
                    </td>
                </tr>

                <%
                            number++;
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>