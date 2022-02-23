package com.upper.servlets.items;




import com.upper.database.CategoryDBManager;
import com.upper.database.ItemDBManager;
import com.upper.database.ManufacturerDBManager;
import com.upper.entity.Category;
import com.upper.entity.Items;
import com.upper.entity.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdditemServlet", value = "/items/additem")
public class AdditemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Manufacturer> manufacturers = ManufacturerDBManager.getManufacturers();
        request.setAttribute("manufacturers", manufacturers);
        ArrayList<Category> categories = CategoryDBManager.getCategories();
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/items/additem.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String image = request.getParameter("image");
        Long brandId = Long.parseLong(request.getParameter("brand_id"));
        Long categoryId = Long.parseLong(request.getParameter("category_id"));

        Manufacturer mn=ManufacturerDBManager.getManufacturer(brandId);
        Category ct = CategoryDBManager.getCategory(categoryId);

        ArrayList<Manufacturer> manufacturers = ManufacturerDBManager.getManufacturers();



        if(mn!=null && ct!=null){

            Items itm = new Items(null, name, description, price, amount, image, mn, ct);
            ItemDBManager.addItem(itm);
            response.sendRedirect("/items/additem?success");
        }else{
            response.sendRedirect("/items/additem?error");
            System.out.println("oh my gosh");
        }

    }
}
