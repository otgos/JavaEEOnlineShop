package com.upper.database;



import com.upper.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryDBManager {

    static Connection connection = MySQLConnection.ConnectDB();

    public static ArrayList<Category> getCategories(){
        ArrayList<Category> categories = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(""+"" +
                    "SELECT id, name FROM category");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                categories.add(new Category(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                ));

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }

    public static Category getCategory(Long id){
        Category category = null;
        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    " SELECT * FROM category WHERE id = ? ");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                category = (new Category(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                ));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }


}
