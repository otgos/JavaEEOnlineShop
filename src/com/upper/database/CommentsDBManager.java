package com.upper.database;



import com.upper.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class CommentsDBManager {

    static Connection connection = MySQLConnection.ConnectDB();

    public static ArrayList<Comment> getComments(Long id){
        ArrayList<Comment> comments = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT cmt.id, cmt.client_id, c.fname, c.lname, c.phone, c.gender, c.address, c.email, c.password, cmt.comment, cmt.commentdate, i.id  " +
                    " FROM comments cmt INNER JOIN client c ON cmt.client_id = c.id" +
                    " INNER JOIN items i ON cmt.item_id = i.id" +
                    " WHERE i.id  = ?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                comments.add(new Comment(
                        resultSet.getLong("id"),
                        new Client(
                                resultSet.getLong("id"),
                                resultSet.getString("fname"),
                                resultSet.getString("lname"),
                                resultSet.getString("phone"),
                                resultSet.getString("gender"),
                                resultSet.getString("address"),
                                resultSet.getString("email"),
                                resultSet.getString("password")
                        ),
                        resultSet.getString("comment"),
                        resultSet.getTimestamp("commentdate"),
                        new Items (
                                resultSet.getLong("id")
                )));

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return comments;
    }

    public static boolean addComment(Comment comment){
        int rows = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO comments (id, client_id, comment, commentdate, item_id )"+
                    "VALUES (null, ?,?, ?, ?)"+
                    "");
            statement.setLong(1, comment.getClient().getId());
            statement.setString(2, comment.getComments());
            statement.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
            statement.setLong(4, comment.getItem().getId());


            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }


}
