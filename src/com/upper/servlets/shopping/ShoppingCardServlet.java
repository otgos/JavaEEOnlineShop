package com.upper.servlets.shopping;

import com.upper.database.CategoryDBManager;
import com.upper.database.ItemDBManager;
import com.upper.database.ManufacturerDBManager;
import com.upper.entity.Category;
import com.upper.entity.Items;
import com.upper.entity.Manufacturer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShoppingCardServlet", value = "/items/viewcard")
public class ShoppingCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession cardSession = request.getSession();
        ArrayList<Items> cardItems = (ArrayList<Items>) cardSession.getAttribute("cardList");

        request.getRequestDispatcher("/items/viewcard.jsp").forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
