package com.upper.servlets.items;


import com.upper.database.CommentsDBManager;
import com.upper.database.ItemDBManager;
import com.upper.database.UserDBManager;
import com.upper.entity.Client;
import com.upper.entity.Comment;
import com.upper.entity.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet(value = "/items/addcomment")
public class ItemDetailAddCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id =0L;
        try {
            id = Long.parseLong(request.getParameter("id"));
            request.getSession().setAttribute("item_id", id);
        }catch (Exception e){
        }
        Items item = ItemDBManager.getItem(id);


        ArrayList<Comment> comments  = CommentsDBManager.getComments(id);
        request.setAttribute("comments", comments);

        if(item!=null){
            request.setAttribute("item", item);
            request.getRequestDispatcher("/user/addcomment.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client = (Client)request.getSession().getAttribute("CURRENT_CLIENT");
        Long clientId = client.getId();
        System.out.println("You have got the "+client);
        Client clntId = UserDBManager.getClient(clientId);
        System.out.println(clntId);

        String comment = request.getParameter("comment");

        Timestamp date = Timestamp.valueOf(LocalDateTime.now());


        Long itm = (Long) request.getSession().getAttribute("item_id");

        Items item = ItemDBManager.getItem(itm);


        if(clntId!=null && item!=null){

            Comment cmnt = new Comment(null, clntId, comment, date, item);

            CommentsDBManager.addComment(cmnt);
            response.sendRedirect("/items/addcomment");
        }else{
            response.sendRedirect("/items/addcomment?error");
            System.out.println("oh my gosh");
        }


    }
}
