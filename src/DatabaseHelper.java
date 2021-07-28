import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DatabaseHelper {

    Connection connection;

    public  DatabaseHelper(){
        try{
            createConnection();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void createConnection () throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/Library";
        String username = "root";
        String password = "Password123!";

        connection = DriverManager.getConnection(jdbcURL, username, password);
    }

    public void SaveRegistration(String fName, String lname, String email, String address, String phone, String cardID, String password){
        try{
            String sql = "INSERT INTO USER (fName, lName, email, address, phoneNumber, cardId, password)" +
                    "VALUES('"+fName+"', '"+lname+"', '"+email+"', '"+address+"', "+phone+", '"+cardID+"', '"+password+"')";
            Statement query = connection.createStatement();
            query.executeUpdate(sql);
            query.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean VerifyUserCreds(String email, String password){
        boolean valid = false;
        try{
            String sql = "SELECT password FROM User WHERE email = '"+email+"'";
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(sql);
            rs.next();
            if(password.equals(rs.getString("password")))
              valid = true;
            query.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return valid;
    }

    public ArrayList<Books> SearchBookByKeyword(String keyword)
    {
        ArrayList<Books> booksList = new ArrayList<Books>();
        try{
            String sql = "SELECT * FROM Book WHERE Title like '%"+keyword+"%' OR Author='%"+keyword+"%'";
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(sql);

            while (rs.next())
            {
                Books books = new Books(rs.getString("ISBN"), rs.getString("title"), rs.getString("author"),
                        rs.getString("genre"), rs.getBoolean("isAvailable"));
                booksList.add(books);
            }
            query.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return  booksList;
    }

    public ArrayList<Books> SearchBookByGenre(String genre)
    {
        ArrayList<Books> booksList = new ArrayList<Books>();
        try{
            String sql = "SELECT * FROM Book WHERE genre = '"+genre+"'";
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(sql);

            while (rs.next())
            {
                Books books = new Books(rs.getString("ISBN"), rs.getString("title"), rs.getString("author"),
                        rs.getString("genre"), rs.getBoolean("isAvailable"));
                booksList.add(books);
            }
            query.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return  booksList;
    }

    public void UpdateBookAvailability(String isbn){
        try{
            String sql = "UPDATE Book SET ISAVAILABLE = 0 WHERE ISBN = '"+isbn+"'";
            Statement query = connection.createStatement();
            query.executeUpdate(sql);
            query.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
