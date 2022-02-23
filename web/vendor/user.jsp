<%@ page import="com.upper.entity.Client" %>
<%
    Client currentClient = (Client)request.getSession().getAttribute("CURRENT_CLIENT");
    boolean ONLINE=false;
    if(currentClient!=null){
        ONLINE=true;
    }
%>
