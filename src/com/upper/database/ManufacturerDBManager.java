package com.upper.database;



import com.upper.entity.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManufacturerDBManager {

    static Connection connection = MySQLConnection.ConnectDB();

    public static ArrayList<Manufacturer> getManufacturers(){
        ArrayList<Manufacturer> manufacturers = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(""+"" +
                    "SELECT id, name, country, shortname FROM manufacturer");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                manufacturers.add(new Manufacturer(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getString("shortname")
                ));

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return manufacturers;
    }

    public static Manufacturer getManufacturer(Long id){
        Manufacturer manufacturer = null;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    ""+" SELECT * FROM manufacturer where id=? LIMIT 1 "
            );
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                manufacturer = (new Manufacturer(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getString("shortname")
                ));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return manufacturer;
    }

}
