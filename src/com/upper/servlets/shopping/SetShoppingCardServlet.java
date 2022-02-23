package com.upper.servlets.shopping;

import com.upper.database.ItemDBManager;
import com.upper.entity.Items;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SetShoppingCardServlet", value = "/items/setshoppingcard")
public class SetShoppingCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long itemId = 0L;
        try {
            itemId = Long.parseLong(request.getParameter("id"));
        } catch (Exception e) {
        }
        Items item = ItemDBManager.getItem(itemId);
        List<Items> cardList = new ArrayList<>();
        HttpSession cardSession = request.getSession();

        if (item != null) {
            System.out.println(item.getId());

            cardList.add(item);
            cardSession.setAttribute("cardList", cardList);

        }
        System.out.println(cardList);
        System.out.println(cardList.size());

        ArrayList<Items> cardItems = (ArrayList<Items>) cardSession.getAttribute("cardList");

        for (Items it : cardItems) {
            System.out.println("Session items is: "+it.getName());
        }


    }
}
