package com.example.bibliotek;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    public void saveBook(Book book); // Create a record

    public List<Book> getAllBooks(); // Read all books

    // TODO the other CRUD methods are placed here
}