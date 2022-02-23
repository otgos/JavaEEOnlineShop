package com.upper.database;


import com.upper.entity.Category;
import com.upper.entity.Items;
import com.upper.entity.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDBManager {


    static Connection connection = MySQLConnection.ConnectDB();

    public static ArrayList<Items> getItems(){
        ArrayList<Items> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT i.id, i.name AS item_name, i.description, i.price, i.amount, i.image, i.brand_id, m.name AS manufacturer,m.country, m.shortname, i.category_id, c.name AS category  "+
                    "FROM items i INNER JOIN manufacturer m ON i.brand_id=m.id "+
                    " INNER JOIN category c ON i.category_id = c.id");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                items.add(new Items(
                        resultSet.getLong("id"),
                        resultSet.getString("item_name"),
                        resultSet.getString("description"),
                        resultSet.getInt("price"),
                        resultSet.getInt("amount"),
                        resultSet.getString("image"),
                        new Manufacturer(
                                resultSet.getLong("id"),
                                resultSet.getString("manufacturer"),
                                resultSet.getString("country"),
                                resultSet.getString("shortname")
                        ),
                        new Category(
                                resultSet.getLong("id"),
                                resultSet.getString("category")
                        )
                ));

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public static boolean addItem(Items item){
        int rows = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO items (id, name, description, price, amount, image, brand_id, category_id )"+
                    "VALUES (null, ?,?,?, ?, ?, ?, ?)"+
                    "");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setInt(3, item.getPrice());
            statement.setInt(4, item.getAmount());
            statement.setString(5, item.getImage());
            statement.setLong(6, item.getManufacturer().getId());
            statement.setLong(7, item.getCategory().getId());

            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }


    public static Items getItem(Long id){

        Items item = null;
        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT i.id, i.name AS item_name, i.description, i.price, i.amount, i.image, m.name AS manufacturer, m.country, m.shortname, c.name AS category_name" +
                    " FROM items i INNER JOIN manufacturer m ON i.brand_id=m.id " +
                    "INNER JOIN category c ON i.category_id = c.id " +
                    "WHERE i.id=?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            item = (new Items(
                    resultSet.getLong("id"),
                    resultSet.getString("item_name"),
                    resultSet.getString("description"),
                    resultSet.getInt("price"),
                    resultSet.getInt("amount"),
                    resultSet.getString("image"),
                    new Manufacturer(
                            resultSet.getLong("id"),
                            resultSet.getString("manufacturer"),
                            resultSet.getString("country"),
                            resultSet.getString("shortname")

                    ),
                    new Category(
                            resultSet.getLong("id"),
                            resultSet.getString("category_name")
                    )
            ));
            statement.close();
        }

        }catch (Exception e){
            e.printStackTrace();
        }

        return item;

    }

    public static boolean editItem(Items item){

        int rows=0;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    " UPDATE items SET name = ?, description=?, price=?, amount=?, image=?, brand_id=?, category_id=? "+
                    "WHERE id=?");


            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setInt(3, item.getPrice());
            statement.setInt(4, item.getAmount());
            statement.setString(5, item.getImage());
            statement.setLong(6, item.getManufacturer().getId());
            statement.setLong(7, item.getCategory().getId());
            statement.setLong(8, item.getId());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static List<Items> getCardItems(ArrayList<Items> cardList){
        List<Items> items = new ArrayList<>();
        try {
            if(cardList.size()>0){
                for(Items it:items) {
                    PreparedStatement statement = connection.prepareStatement("" +
                            "SELECT * FROM items WHERE id = ?");
                    statement.setLong(1, it.getId());
                   ResultSet resultSet= statement.executeQuery();
                    while (resultSet.next()){
                        Items itm = new Items();
                        itm.setId(resultSet.getLong("id"));
                        itm.setName(resultSet.getString("name"));
                        itm.setDescription(resultSet.getString("description"));
                        itm.setPrice(resultSet.getInt("price"));
                        items.add(itm);
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();

        }
        return items;
    }

    public static ArrayList<Items> searchByCategory(Long id){
        ArrayList<Items> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT i.id, i.name AS item_name, i.description, i.price, i.amount, i.image, i.brand_id, m.name AS manufacturer,m.country, m.shortname, i.category_id, c.name AS category  "+
                    "FROM items i INNER JOIN manufacturer m ON i.brand_id=m.id "+
                    " INNER JOIN category c ON i.category_id = c.id"+
                    " WHERE c.name = ? ");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                items.add(new Items(
                        resultSet.getLong("id"),
                        resultSet.getString("item_name"),
                        resultSet.getString("description"),
                        resultSet.getInt("price"),
                        resultSet.getInt("amount"),
                        resultSet.getString("image"),
                        new Manufacturer(
                                resultSet.getLong("id"),
                                resultSet.getString("manufacturer"),
                                resultSet.getString("country"),
                                resultSet.getString("shortname")
                        ),
                        new Category(
                                resultSet.getLong("id"),
                                resultSet.getString("category")
                        )
                ));

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

}
