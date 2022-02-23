package com.upper.servlets.items;

import com.upper.database.CategoryDBManager;
import com.upper.database.ItemDBManager;
import com.upper.entity.Category;
import com.upper.entity.Items;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SearchByCategoryServlet", value = "/items/searchByCategory")
public class SearchByCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Items> items = ItemDBManager.searchByCategory(Long.parseLong(request.getParameter("id")));
        System.out.println("got the " +items);
        request.setAttribute("searchByCategory", items);
        request.getRequestDispatcher("/items/serchByCategory.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
