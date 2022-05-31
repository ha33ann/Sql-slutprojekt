
package movie.databasetables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import movie.DatabaseConnection.getConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class actor {
	getConnection gc=new getConnection();

    public void insert() {
        int status = 0;

        try (Connection con = gc.getConnection()) {
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("insert into actor values (0001, 'Leonardo', 'DiCaprio', 'USA', 'https://twitter.com/LeoDiCaprio?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor', 'https://www.instagram.com/leonardodicaprio/', 'https://www.facebook.com/LeonardoDiCaprio'),\n"
                    + "(0002, 'Tim', 'Robbins', 'American', 'https://twitter.com/timrobbins1', 'https://www.instagram.com/timrobbinshere/?hl=en', 'https://www.facebook.com/public/Tim-Robbins'),\n"
                    + "(0003, 'Henry', 'Fonda', 'American', 'https://twitter.com/iamfonda?lang=en', 'https://www.instagram.com/henryfonda_/?hl=en', 'https://www.facebook.com/HenryFonda/'),\n"
                    + "(0004, 'Christian' , 'Bale' , 'UK', 'https://twitter.com/theofficialbale?lang=en', 'https://www.instagram.com/christianbale_/?hl=en', 'https://www.facebook.com/ChristianBaleBook/' ),\n"
                    + "(0005, 'Liam', 'Neeson', 'UK', 'https://twitter.com/the_liamneeson?lang=en', 'https://www.instagram.com/neeson_liam/?hl=en','https://www.facebook.com/LiamNeesonUSA/'),\n"
                    + "(0006, 'Elijah', 'Wood', 'American', 'https://twitter.com/elijahwood', 'https://www.instagram.com/elijahwoodswe/?hl=en', 'https://www.facebook.com/officialelijahwood'),\n"
                    + "(0007, 'John', 'Travolta', 'America', 'https://twitter.com/johntravoltahot?lang=en', 'https://www.instagram.com/johntravolta/?hl=en', 'https://www.facebook.com/johntravolta'),\n"
                    + "(0008, 'Clint', 'Eastwood' , 'American', 'https://twitter.com/clintforever?lang=en', 'https://www.instagram.com/clinteastwoodfans01/?hl=en', 'https://www.facebook.com/ClintEastwoodMovieDirector'),\n"
                    + "(0009, 'Tom', 'Hanks', null, 'https://twitter.com/tomhanks?lang=en', 'https://www.instagram.com/tomhanks/', 'https://www.facebook.com/TomHanks'),\n"
                    + "(0010, 'Brad', 'Pitt', 'American', 'https://twitter.com/pittofficial?lang=en', 'https://www.instagram.com/bradpittofflcial/?hl=en', null),\n"
                    + "(0011, 'Marlon', 'Brando', 'American', 'https://twitter.com/marlonbrando?lang=en','https://www.instagram.com/marlonbrando/?hl=en','https://www.facebook.com/marlonbrandoestate'),\n"
                    + "(0012, 'Frank', 'Darabont', 'France', 'https://twitter.com/frankdarabont?lang=en','https://www.instagram.com/rabontfrank5c70/?hl=en','https://www.facebook.com/public/Frank-Darabont'),\n"
                    + "(0013, 'Stephen', 'King', 'American', 'https://twitter.com/StephenKing','https://www.instagram.com/stephenkingofficialpage/?hl=en','https://www.facebook.com/stephenkingwriter/'),\n"
                    + "(0014, 'Francio', 'Ford Coppola', 'American', 'https://twitter.com/coppolaford?lang=en','https://www.instagram.com/francisfordcoppola_/?hl=en','https://www.facebook.com/pages/category/Artist/Francis-Ford-Coppola-9661134092/'),\n"
                    + "(0015, 'Jonathan', 'Nolan', 'UK', 'https://twitter.com/jonathannolan','https://www.instagram.com/jonathannolan/?hl=en','https://www.facebook.com/public/Jonathan-Nolan'),\n"
                    + "(0016, 'Christopher', 'Nolan', 'UK', 'https://twitter.com/chris_nolann?lang=en','https://www.instagram.com/christophernolann/?hl=en','https://www.facebook.com/ChristopherNolan.info/'),\n"
                    + "(0017, 'Sidney', 'Lumet', null, 'https://twitter.com/bysidneylumet','https://www.instagram.com/sidneylumet/?hl=en','https://www.facebook.com/FilmmakerSidneyLumet/')");
            status = pstmt.executeUpdate();
            if (status > 0) {
                System.out.println("17 rows inserted into actor table successfully1");
            } else {
                System.out.println("Couldn't insert values into the table, some error occured!");
            }

            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(actor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public void update(int actor_id, String actor_first_name, String actor_last_name, String actor_nationality, String actor_twitter_url, String actor_insta_url, String actor_fb_url) {
        int status = 0;
        try {
            Connection con = gc.getConnection(); //establishing the database connection
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("update actor set actor_first_name=?, actor_last_name=?, actor_nationality=?,actor_twitter_url=?, actor_insta_url=?, actor_fb_url=? where actor_id=?"); //update query
            pstmt.setString(1, actor_first_name);
            pstmt.setString(2, actor_last_name);
            pstmt.setString(3, actor_nationality);
            pstmt.setString(4, actor_twitter_url);
            pstmt.setString(5, actor_insta_url);
            pstmt.setString(6, actor_fb_url);
            pstmt.setInt(7, actor_id);
            status = pstmt.executeUpdate(); //executing the query
            pstmt.close();
            con.close();

            if (status > 0) { //checking if record has been updated or not
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("Couldn't update record, some error occured!");

            }

        } catch (SQLException ex) { //catching the exception
            Logger.getLogger(actor.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(int id) {
        int status = 0;
        try {
            Connection con = gc.getConnection(); //establishing the database connection 
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            pstmt1.executeUpdate();
            pstmt = con.prepareStatement("delete from actor where actor_id=?"); //delete query
            pstmt.setInt(1, id);
            status = pstmt.executeUpdate();

            pstmt.close();
            con.close();

            if (status > 0) { //checking if record has been deleted or not
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("Couldn't delete record, some error occured!");

            }

        } catch (SQLException ex) {
            Logger.getLogger(actor.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void read() {

        JSONObject record = new JSONObject(); //creating the JSONObject

        try {
            Connection con = gc.getConnection();
            PreparedStatement pstmt = null;
            pstmt = con.prepareStatement("select * from actor");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                record.put("actor_id", rs.getString(1));       //display records in JSON format
                record.put("actor_first_name", rs.getString(2));
                record.put("actor_last_name", rs.getString(3));
                record.put("actor_nationality", rs.getString(4));
                record.put("actor_twitter_url", rs.getString(5));
                record.put("actor_insta_url", rs.getString(6));
                record.put("actor_fb_url", rs.getString(7));
                System.out.println(record);
            }

            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(actor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
