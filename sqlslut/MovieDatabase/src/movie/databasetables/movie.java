package movie.databasetables;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

public class movie {
	
	
	
    public void insert(Connection conn) {
        int status = 0;

        try {
            
                PreparedStatement pstmt = null;
                PreparedStatement pstmt1 = null;
                pstmt1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
                pstmt1.executeUpdate();
                pstmt = conn.prepareStatement("insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating)"
                        + "values "
                        + "('The Shawshank Redemption', 'Two imprisoned men bond over a number of years', 'Frank Darabont', 'Stephen King', 'Tim Robbins', '1994-10-14', '4.5'),"
                        + "('The Godfather', 'The aging patriarch of an organized crime dynasty transfers control to his son','Francis Ford Coppola','Mario Puzo', 'Marlon Brando', '1972-3-24', '4.2'),"
                        + "('The Dark Knight','The menace known as the joker wreaks havoc on Gotham City', 'Christopher Nolan','Jonathan Nolan','Christian Bale','2008-7-18', '4.5'),"
                        + "('12 Angry Men', 'The jury in a New York City murder trial is frustrated by a single member whose skeptical caution forces them to more carefully consider the evidence.', 'Sidney Lumet', 'Reginald Rose', 'Henry Fonda', '1957-4-10', '3.5'),"
                        + "('Schindlers List', 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce.','Steven Spielberg', 'Thomas Keneally', 'Liam Neeson', '1994-10-14', 4),"
                        + "('The Lord of the Rings', 'Gandalf and Aragorn lead the World of Men against Sauron\\'s army to draw his gaze from Frodo and Sam', 'Peter Jackson', 'J.R.R Tolkien','Elijah Wood',  '2003-12-17', 3.5),"
                        + "('Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', 'Quentin Tarantino','Roger Avary','John Travolta','1994-10-14', 5),"
                        + "(' The Good, the Bad and the Ugly', 'A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.','Sergio Leone', 'Luciano Vincezoni','Clint Eastwood', '1967-12-29', 5),"
                        + "('Forrest Gump', 'the Vietnam War and other historical events unfold from the perspective with an IQ of 75, whose desire is to be reunited with his sweetheart.', 'Robert Zemeckis', 'Winston Groom','Tom Hanks','1994-7-6', '3.5'),"
                        + "('Fight Club', 'An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.', 'David Fincher', 'Chunk Palahniuk', 'Brad Pitt', '1999-10-15', 2.5),"
                        + "('Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the task of planting an idea', 'Christopher Nolan','Christopher Nolan','Leonardo DiCaprio','2010-8-16', 4)");

                status = pstmt.executeUpdate();
                if (status > 0) {
                    System.out.println("11 rows inserted into movie table successfully1");
                } else {
                    System.out.println("Couldn't insert values into the table, some error occured!");
                }

                pstmt.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    public void update(Connection conn,int movie_id, String movie_title, String movie_desc, String movie_director, String movie_writer, String movie_hero, String movie_release_date, int movie_rating) throws ParseException {
        int status = 0;
        java.util.Date utilDate;
        utilDate = new SimpleDateFormat("dd-MM-yyyy").parse(movie_release_date);

        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        try {
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0"); //performing update query on table having foreign key
            pstmt1.executeUpdate();
            pstmt = conn.prepareStatement("update movie set movie_title=?, movie_desc=?, movie_director=?,movie_writer=?, movie_hero=?, movie_release_date=?,movie_rating=? where movie_id=?"); //update query
            pstmt.setString(1, movie_title);
            pstmt.setString(2, movie_desc);
            pstmt.setString(3, movie_director);
            pstmt.setString(4, movie_writer);
            pstmt.setString(5, movie_hero);
            pstmt.setDate(6, sqlDate);
            pstmt.setInt(7, movie_rating);
            pstmt.setInt(8, movie_id);
            status = pstmt.executeUpdate(); //executing the query
            pstmt.close();

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

    public void delete(Connection conn, int id) {
        int status = 0;
        try {
            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;
            pstmt1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            pstmt1.executeUpdate();
            pstmt = conn.prepareStatement("delete from movie where movie_id=?"); //delete query
            pstmt.setInt(1, id);
            status = pstmt.executeUpdate();

            pstmt.close();

            if (status > 0) { //checking if record has been deleted or not
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("Couldn't delete record, some error occured!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(actor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void read(Connection conn) {

        JSONObject record = new JSONObject();
        
            try  {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("select * from movie");

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    record.put("movie_id", rs.getString("movie_id"));
                    record.put("movie_title", rs.getString("movie_title"));
                    record.put("Mmovie_desc", rs.getString("movie_desc"));
                    record.put("movie_director", rs.getString("movie_director"));
                    record.put("movie_writer", rs.getString("movie_writer"));
                    record.put("movie_hero", rs.getString("movie_hero"));
                    record.put("movie_release_date", rs.getString("movie_release_date"));
                    record.put("movie_rating", rs.getString("movie_rating"));
                    System.out.println(record);
                }

                pstmt.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
