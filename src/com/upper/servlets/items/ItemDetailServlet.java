package com.upper.servlets.items;


import com.upper.database.CommentsDBManager;
import com.upper.database.ItemDBManager;
import com.upper.entity.Comment;
import com.upper.entity.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ItemDetailServlet", value = "/items/itemdetail")
public class ItemDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id =0L;
        try {
            id = Long.parseLong(request.getParameter("id"));
        }catch (Exception e){
        }
        Items item = ItemDBManager.getItem(id);

        ArrayList<Comment> comments  = CommentsDBManager.getComments(id);
        request.setAttribute("comments", comments);

        if(item!=null){
            request.setAttribute("item", item);
            request.getRequestDispatcher("/items/itemdetail.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
