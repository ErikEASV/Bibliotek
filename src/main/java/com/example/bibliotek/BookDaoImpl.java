package com.example.bibliotek;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private Connection con; // forbindelsen til databasen
    public BookDaoImpl()  {
        try{
            // Bemærk: selve connection-strengen skal tilpasses Jeres connection settings..
            /// jdbc:sqlserver://server.database.windows.net:1433   U6u7U8u5yY
            // jdbc:sqlserver://localhost:1433;database=LibDB
            // jdbc:sqlserver://localhost:1433;database=LibDB;userName=sa;password=U6u7U8u5yY
            con = DriverManager.getConnection("jdbc:sqlserver://10.176.111.34:1433;database=CSe2023t_t_11_LibDB;userName=CSe2023t_t_11;password=CSe2023tT11#23;encrypt=true;trustServerCertificate=true");
            //con = DriverManager.getConnection("jdbc:sqlserver://EASV-THA-Q418\\TH:1433;database=LibDB;integratedSecurity=true");
        } catch (SQLException e){
            System.err.println("Kan ikke skabe forbindelse:" + e.getErrorCode() + e.getMessage());
        }
        System.out.println("Forbundet til databasen... ");
    }

    public void saveBook(Book book) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO BOOK VALUES(?,?,?);");
            ps.setString(1, book.getIsbn());
            ps.setString(2,book.getTitle());
            ps.setString(3,book.getCategory());
            ps.executeUpdate();

        } catch (SQLException e){
            System.err.println("Kan ikke indsætte record");
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books= new ArrayList();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Book;");
            ResultSet rs = ps.executeQuery();

            Book book;
            while(rs.next()){
                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String category = rs.getString(3);

                book = new Book(isbn,title,category);
                books.add(book);
            }

        } catch (SQLException e){
            System.err.println("Kan ikke læse records");
        }
        return books;
    }
}