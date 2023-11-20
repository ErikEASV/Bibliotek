package com.example.bibliotek;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private Connection con; // forbindelsen til databasen
    public BookDaoImpl()  {
        try{
            con = DriverManager.getConnection("jdbc:sqlserver://10.176.111.34:1433;database=CSe2023t_t_11_LibDB;userName=CSe2023t_t_11;password=CSe2023tT11#23;encrypt=true;trustServerCertificate=true");
        } catch (SQLException e) {
            System.err.println("Kan ikke skabe forbindelse:" + e.getErrorCode() + e.getMessage());
        }
        System.out.println("Forbundet til databasen... ");
    }

    public void saveBook(Book book) {
        try{
            // med alm. db-kald:
            Statement database = con.createStatement();
            String sql = "INSERT INTO BOOK (isbn, title, type) VALUES "
                    + "('"+book.getIsbn()
                    +"','"+book.getTitle()
                    +"','"+book.getCategory()
                    +"')";
            System.out.println("SQL: " + sql);
            database.executeUpdate(sql);

        /* eller med preparedstatement:
            PreparedStatement ps = con.prepareStatement("INSERT INTO BOOK VALUES(?,?,?);");
            ps.setString(1, book.getIsbn());
            ps.setString(2,book.getTitle());
            ps.setString(3,book.getCategory());
            ps.executeUpdate();*/

        } catch (SQLException e){
            System.err.println("Kan ikke indsætte record: " + e.getMessage());
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books= new ArrayList();
        try{
            // med alm. db-kald:
            Statement database = con.createStatement();
            String sql = "SELECT * FROM Book";
            ResultSet rs = database.executeQuery(sql);
            while (rs.next()) {
                String isbn     = rs.getString("isbn");
                String title    = rs.getString("title");
                String type     = rs.getString("type");

                Book book = new Book(isbn, title, type);
                books.add(book);
            }
            /* eller med preparedStatement:
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Book;");
            ResultSet rs = ps.executeQuery();

            Book book;
            while(rs.next()){
                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String category = rs.getString(3);

                book = new Book(isbn,title,category);
                books.add(book);
            }*/

        } catch (SQLException e){
            System.err.println("Kan ikke læse records");
        }
        return books;
    }
}