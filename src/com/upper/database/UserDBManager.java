package com.upper.database;

import com.upper.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDBManager {
    static Connection connection = MySQLConnection.ConnectDB();
    public static ArrayList<Client> getClients(){
        ArrayList<Client> clients = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT id, fname, lname, gender, address, phone, email, password, startdate FROM client ");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                clients.add(new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("gender"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("password")

                ));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return clients;
    }
    public static Client getClient(String email){

        Client client = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM client where email  = ? " );

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                client = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("gender"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }


            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return client;
    }

    public static boolean addClient(Client client){
        int rows = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO client (id, fname, lname, phone, gender, address, email, password )"+
                    "VALUES (null, ?,?,?, ?, ?, ?, ?)"+
                    "");
            statement.setString(1, client.getfName());
            statement.setString(2, client.getlName());
            statement.setString(3, client.getPhoneNumber());
            statement.setString(4, client.getGender());
            statement.setString(5, client.getAddress());
            statement.setString(6, client.getEmail());
            statement.setString(7, client.getPassword());

            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static Client getClient(Long id){

        Client client = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM client where id  = ? LIMIT 1" );

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                client = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("gender"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }


            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return client;
    }
}
