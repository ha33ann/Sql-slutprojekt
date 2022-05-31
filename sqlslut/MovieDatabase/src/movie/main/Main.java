package movie.main;
import java.text.ParseException;
import java.util.Scanner;
import movie.databasetables.actor;
import movie.databasetables.artiste;
import movie.databasetables.artiste_band;
import movie.databasetables.band;
import movie.databasetables.genre;
import movie.databasetables.movie;
import movie.databasetables.movie_genre;
import movie.databasetables.movie_studio;
import movie.databasetables.poster;
import movie.databasetables.role;
import movie.databasetables.song;
import movie.databasetables.song_band;
import movie.databasetables.studio;
import movie.databasetables.trailer;

public class Main {


    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        System.out.println("Welcome!");
        System.out.println("Using movie database!");
        showTableNames();    //calling the CRUD methods
    }

    private static void showTableNames() throws ParseException {
        System.out.println("\n Please choose the table on which you want to perform CRUD operations:"
                + "\n1. movie"
                + "\n2. genre"
                + "\n3. movie_genre"
                + "\n4. poster"
                + "\n5. trailer"
                + "\n6. studio"
                + "\n7. movie_studio"
                + "\n8. actor"
                + "\n9. role"
                + "\n10. band"
                + "\n11. song"
                + "\n12. song_band"
                + "\n13. artiste"
                + "\n14. artiste_band"
                + "\n15. Exit");


     
      
        	int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                movieTable();
                break;
            case 2:
                genreTable();
                break;
            case 3:
                movie_genreTable();
                break;
            case 4:
                posterTable();
                break;
            case 5:
                trailerTable();
                break;
            case 6:
                studioTable();
                break;
            case 7:
                movie_studioTable();
                break;
            case 8:
                actorTable();
                break;
            case 9:
                roleTable();
                break;
            case 10:
                bandTable();
                break;
            case 11:
                songTable();
                break;
            case 12:
                song_bandTable();
                break;
            case 13:
                artisteTable();
                break;
            case 14:
                artiste_bandTable();
                break;
            default:
                break;
        }
        
        
    }
    

    private static void movieTable() throws ParseException {
    	System.out.println("\n movie table selected!");
        System.out.println("Which operation do you want to perform on movie table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        movie m=new movie();
        int movie_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
            	
                m.insert();  //inserting values into database
                movieTable();
                break;
            case 2:
                m.read();    //retrieving values from database
                movieTable();
                break;
            case 3:
                System.out.println("Enter movie_id of the record you want to update:");
                movie_id = sc.nextInt();
                System.out.println("Enter new movie_title:");
                String movie_title = sc.next();
                movie_title+=sc.nextLine();
                System.out.println("Enter new movie_desc:");
                String movie_desc = sc.nextLine();
                System.out.println("Enter new movie_director:");
                String movie_director = sc.nextLine();
                System.out.println("Enter new movie_writer:");
                String movie_writer = sc.nextLine();
                System.out.println("Enter new movie_hero:");
                String movie_hero = sc.nextLine();
                System.out.println("Enter new movie_release_date: (Format: dd-MM-yyyy)");
                String movie_release_date = sc.nextLine();
                System.out.println("Enter new movie_rating:");
                int movie_rating = sc.nextInt();
                m.update(movie_id, movie_title, movie_desc, movie_director, movie_writer, movie_hero, movie_release_date, movie_rating);   //updating records
                movieTable();
                break;
            case 4:
                System.out.println("Enter movie_id of the record you want to delete:");
                movie_id = sc.nextInt();
                m.delete(movie_id);     //deleting records
                movieTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void genreTable() throws ParseException {
        System.out.println("\n genre table selected!");
        System.out.println("Which operation do you want to perform on genre table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        genre g=new genre();
        int genre_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                g.insert();  //inserting values into database
                genreTable();
                break;
            case 2:
                g.read();   //retrieving values from database
                genreTable();
                break;
            case 3:
                System.out.println("Enter genre_id of the record you want to update:");
                genre_id = sc.nextInt();
                System.out.println("Enter new genre_type:");
                String genre_type = sc.next();
                genre_type+=sc.nextLine();
                System.out.println("Enter new genre_desc:");
                String genre_desc = sc.next();
                genre_desc+=sc.nextLine();
                g.update(genre_id, genre_type, genre_desc);   //updating records
                genreTable();
                break;
            case 4:
                System.out.println("Enter genre_id of the record you want to delete:");
                genre_id = sc.nextInt();
                g.delete(genre_id);       //deleting records
                genreTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void movie_genreTable() throws ParseException {
        System.out.println("\n movie_genre table selected!");
        System.out.println("Which operation do you want to perform on movie_genre table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        movie_genre mg=new movie_genre();
        
        		
        int movie_genre_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                mg.insert();   //inserting values into database
                movie_genreTable();
                break;
            case 2:
                mg.read();   //retrieving values from database
                movie_genreTable();
                break;
            case 3:
                System.out.println("Enter movie_genre_id of the record you want to update:");
                movie_genre_id = sc.nextInt();
                System.out.println("Enter new genre_movie_id:");
                int genre_movie_id = sc.nextInt();
                System.out.println("Enter new genre_genre_id:");
                int genre_genre_id = sc.nextInt();
                mg.update(movie_genre_id, genre_movie_id, genre_genre_id);   //updating records
                movie_genreTable();
                break;
            case 4:
                System.out.println("Enter movie_genre_id of the record you want to delete:");
                movie_genre_id = sc.nextInt();
                mg.delete(movie_genre_id);       //deleting records
                movie_genreTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void posterTable() throws ParseException {
        System.out.println("\n poster table selected!");
        System.out.println("Which operation do you want to perform on poster table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        poster p=new poster();
        int poster_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                p.insert();  //inserting values into database
                posterTable();
                break;
            case 2:
                p.read();   //retrieving values from database
                posterTable();
                break;
            case 3:
                System.out.println("Enter poster_id of the record you want to update:");
                poster_id = sc.nextInt();
                System.out.println("Enter new poster_title:");
                String poster_title = sc.next();
                poster_title+=sc.nextLine();
                System.out.println("Enter new poster_movie_id:");
                int poster_movie_id = sc.nextInt();
                p.update(poster_id, poster_title, poster_movie_id);   //updating records
                posterTable();
                break;
            case 4:
                System.out.println("Enter poster_id of the record you want to delete:");
                poster_id = sc.nextInt();
                p.delete(poster_id);       //deleting records
                posterTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void trailerTable() throws ParseException {
        System.out.println("\n trailer table selected!");
        System.out.println("Which operation do you want to perform on trailer table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        trailer t=new trailer();
        int trailer_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                t.insert();   //inserting values into database
                trailerTable();
                break;
            case 2:
                t.read();   //retrieving values from database
                trailerTable();
                break;
            case 3:
                System.out.println("Enter trailer_id of the record you want to update:");
                trailer_id = sc.nextInt();
                System.out.println("Enter new trailer_length:");
                int trailer_length = sc.nextInt();
                System.out.println("Enter new trailer_url:");
                String trailer_url = sc.next();
                trailer_url+=sc.nextLine();
                
                System.out.println("Enter new trailer_movie_id:");
                int trailer_movie_id = sc.nextInt();
                t.update(trailer_id, trailer_length, trailer_url, trailer_movie_id);   //updating records
                trailerTable();
                break;
            case 4:
                System.out.println("Enter trailer_id of the record you want to delete:");
                trailer_id = sc.nextInt();
                t.delete(trailer_id);       //deleting records
                trailerTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void studioTable() throws ParseException {
        System.out.println("\n studio table selected!");
        System.out.println("Which operation do you want to perform on studio table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        studio s=new studio();
        int studio_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                s.insert();   //inserting values into database
                studioTable();
                break;
            case 2:
                s.read();   //retrieving values from database
                studioTable();
                break;
            case 3:
                System.out.println("Enter studio_id of the record you want to update:");
                studio_id = sc.nextInt();
                System.out.println("Enter new studio_name:");
                String studio_name = sc.next();
                studio_name+=sc.nextLine();
                System.out.println("Enter new studio_location:");
                String studio_location = sc.nextLine();
                s.update(studio_id, studio_name, studio_location);   //updating records
                studioTable();
                break;
            case 4:
                System.out.println("Enter studio_id of the record you want to delete:");
                studio_id = sc.nextInt();
                s.delete(studio_id);       //deleting records
                studioTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void movie_studioTable() throws ParseException {
        System.out.println("\n movie_studio table selected!");
        System.out.println("Which operation do you want to perform on movie_studio table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        movie_studio ms=new movie_studio();
        int movie_studio_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                ms.insert();  //inserting values into database
                movie_studioTable();
                break;
            case 2:
                ms.read();   //retrieving values from database
                movie_studioTable();
                break;
            case 3:
                System.out.println("Enter movie_studio_id of the record you want to update:");
                movie_studio_id = sc.nextInt();
                System.out.println("Enter new studio_movie_id:");
                int studio_movie_id = sc.nextInt();
                System.out.println("Enter new studio_studio_id:");
                int studio_studio_id = sc.nextInt();
                ms.update(movie_studio_id, studio_movie_id, studio_studio_id);   //updating records
                movie_studioTable();
                break;
            case 4:
                System.out.println("Enter movie_studio_id of the record you want to delete:");
                movie_studio_id = sc.nextInt();
                ms.delete(movie_studio_id);
                movie_studioTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void actorTable() throws ParseException {
        System.out.println("\n actor table selected!");
        System.out.println("Which operation do you want to perform on actor table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        actor a=new actor();
        int actor_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                a.insert();  //inserting values into database
                actorTable();
                break;
            case 2:
                a.read();   //retrieving values from database
                actorTable();
                break;
            case 3:
                System.out.println("Enter actor_id of the record you want to update:");
                actor_id = sc.nextInt();
                System.out.println("Enter new actor_first_name:");
                String actor_first_name = sc.next();
                actor_first_name+=sc.nextLine();
                System.out.println("Enter new actor_last_name:");
                String actor_last_name = sc.nextLine();
                System.out.println("Enter new actor_nationality:");
                String actor_nationality = sc.nextLine();
                System.out.println("Enter new actor_twitter_url:");
                String actor_twitter_url = sc.nextLine();
                System.out.println("Enter new actor_insta_url:");
                String actor_insta_url = sc.nextLine();
                System.out.println("Enter new actor_fb_url:");
                String actor_fb_url = sc.nextLine();
                a.update(actor_id, actor_first_name, actor_last_name, actor_nationality, actor_twitter_url, actor_insta_url, actor_fb_url);   //updating records
                actorTable();
                break;
            case 4:
                System.out.println("Enter actor_id of the record you want to delete:");
                actor_id = sc.nextInt();
                a.delete(actor_id);       //deleting records
                actorTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void roleTable() throws ParseException {
        System.out.println("\n role table selected!");
        System.out.println("Which operation do you want to perform on role table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        role r=new role();
        int role_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                r.insert();  //inserting values into database
                roleTable();
                break;
            case 2:
                r.read();   //retrieving values from database
                roleTable();
                break;
            case 3:
                System.out.println("Enter role_id of the record you want to update:");
                role_id = sc.nextInt();
                System.out.println("Enter new role_desc:");
                String role_desc = sc.next();
                role_desc+=sc.nextLine();
                System.out.println("Enter new role_movie_id:");
                int role_movie_id = sc.nextInt();
                System.out.println("Enter new role_person_id:");
                int role_person_id = sc.nextInt();
                r.update(role_id, role_desc, role_movie_id, role_person_id);   //updating records
                roleTable();
                break;
            case 4:
                System.out.println("Enter role_id of the record you want to delete:");
                role_id = sc.nextInt();
                r.delete(role_id);       //deleting records
                roleTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void bandTable() throws ParseException {
        System.out.println("\n band table selected!");
        System.out.println("Which operation do you want to perform on band table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        band b=new band();
        int band_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                b.insert();  //inserting values into database
                bandTable();
                break;
            case 2:
                b.read();   //retrieving values from database
                bandTable();
                break;
            case 3:
                System.out.println("Enter band_id of the record you want to update:");
                band_id = sc.nextInt();
                System.out.println("Enter new band_name:");
                String band_name = sc.next();
                band_name+=sc.nextLine();
                System.out.println("Enter new band_total_members:");
                int band_total_members = sc.nextInt();
                b.update(band_id, band_name, band_total_members);   //updating records
                bandTable();
                break;
            case 4:
                System.out.println("Enter band_id of the record you want to delete:");
                band_id = sc.nextInt();
                b.delete(band_id);       //deleting records
                bandTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void songTable() throws ParseException {
        System.out.println("\n song table selected!");
        System.out.println("Which operation do you want to perform on song table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        song s=new song();
        int song_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                s.insert();  //inserting values into database
                songTable();
                break;
            case 2:
                s.read();   //retrieving values from database
                songTable();
                break;
            case 3:
                System.out.println("Enter song_id of the record you want to update:");
                song_id = sc.nextInt();
                System.out.println("Enter new song_name:");
                String song_name = sc.next();
                song_name+=sc.nextLine();
                System.out.println("Enter new song_length:");
                int song_length = sc.nextInt();
                System.out.println("Enter new song_url:");
                String song_url = sc.nextLine();
                song_url+=sc.nextLine();
                s.update(song_id, song_name, song_length, song_url);   //updating records
                songTable();
                break;
            case 4:
                System.out.println("Enter song_id of the record you want to delete:");
                song_id = sc.nextInt();
                s.delete(song_id);
                songTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void song_bandTable() throws ParseException {
        System.out.println("\n song_band table selected!");
        System.out.println("Which operation do you want to perform on song_band table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        song_band sb=new song_band();
        int song_band_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                sb.insert();  //inserting values into database
                song_bandTable();
                break;
            case 2:
                sb.read();   //retrieving values from database
                song_bandTable();
                break;
            case 3:
                System.out.println("Enter song_band_id of the record you want to update:");
                song_band_id = sc.nextInt();
                System.out.println("Enter new song_song_id:");
                int song_song_id = sc.nextInt();
                System.out.println("Enter new band_band_id:");
                int band_band_id = sc.nextInt();
                sb.update(song_band_id, song_song_id, band_band_id);   //updating records
                song_bandTable();
                break;
            case 4:
                System.out.println("Enter song_band_id of the record you want to delete:");
                song_band_id = sc.nextInt();
                sb.delete(song_band_id);       //deleting records
                song_bandTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void artisteTable() throws ParseException {
        System.out.println("\n artiste table selected!");
        System.out.println("Which operation do you want to perform on artiste table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        artiste a=new artiste();
        int artiste_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                a.insert();  //inserting values into database
                artisteTable();
                break;
            case 2:
                a.read();   //retrieving values from database
                artisteTable();
                break;
            case 3:
                System.out.println("Enter artiste_id of the record you want to update:");
                artiste_id = sc.nextInt();
                System.out.println("Enter new artiste_name:");
                String artiste_name = sc.next();
                artiste_name+=sc.nextLine();
                System.out.println("Enter new artiste_country:");
                String artiste_country = sc.nextLine();
                System.out.println("Enter new artiste_age:");
                int artiste_age = sc.nextInt();
                a.update(artiste_id, artiste_name, artiste_country,artiste_age);   //updating records
                artisteTable();
                break;
            case 4:
                System.out.println("Enter artiste_id of the record you want to delete:");
                artiste_id = sc.nextInt();
                a.delete(artiste_id);       //deleting records
                artisteTable();
                break;
            default:
                showTableNames();
                break;
        }

    }

    private static void artiste_bandTable() throws ParseException {
        System.out.println("\n artiste_band table selected!");
        System.out.println("Which operation do you want to perform on artiste_band table?"
                + "\n\t1. Create"
                + "\n\t2. Read"
                + "\n\t3. Update"
                + "\n\t4. Delete"
                + "\n\t5. Go back");

        artiste_band ab=new artiste_band();
        int artiste_band_id;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                ab.insert(); //inserting values into database
                artiste_bandTable();
                break;
            case 2:
                ab.read();   //retrieving values from database
                artiste_bandTable();
                break;
            case 3:
                System.out.println("Enter artiste_band_id of the record you want to update:");
                artiste_band_id = sc.nextInt();
                System.out.println("Enter new band_role:");
                String band_role = sc.next();
                band_role=sc.nextLine();
                System.out.println("Enter new artiste_artiste_id:");
                int artiste_artiste_id = sc.nextInt();
                System.out.println("Enter new band_band_id:");
                int band_band_id = sc.nextInt();
                ab.update(artiste_band_id, band_role, artiste_artiste_id,band_band_id);   //updating records
                artiste_bandTable();
                break;
            case 4:
                System.out.println("Enter artiste_band_id of the record you want to delete:");
                artiste_band_id = sc.nextInt();
                ab.delete(artiste_band_id);       //deleting records
                artiste_bandTable();
                break;
            default:
                showTableNames();
                break;
        }

    }
    


}
