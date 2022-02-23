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

@WebServlet(name = "EditItemServlet", value = "/items/edititem")
public class EditItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id =0L;
        try {
            id = Long.parseLong(request.getParameter("id"));
        }catch (Exception e){
        }
        Items item = ItemDBManager.getItem(id);
        if(item!=null){
            request.setAttribute("item", item);
            ArrayList<Manufacturer> manufacturers = ManufacturerDBManager.getManufacturers();
            request.setAttribute("manufacturers", manufacturers);
            ArrayList<Category> categories = CategoryDBManager.getCategories();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/items/edititem.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        Long brandId = Long.parseLong(request.getParameter("brand_id"));
        Long categoryId = Long.parseLong(request.getParameter("category_id"));

        Manufacturer mn=ManufacturerDBManager.getManufacturer(brandId);
        Category ct = CategoryDBManager.getCategory(categoryId);

        String redirect = "/";
        if(mn!=null && ct!=null){
            Items item = ItemDBManager.getItem(id);

            if(item!=null){
                item.setId(id);
                item.setName(name);
                item.setDescription(description);
                item.setPrice(price);
                item.setAmount(amount);
                item.setManufacturer(mn);
                item.setCategory(ct);

                if(ItemDBManager.editItem(item)){
                    redirect = "/items/edititem"+id+"success";
                }else {
                    redirect = "/items/edititem"+id+"error";
                }
            }
        }
        response.sendRedirect(redirect);
    }
}
