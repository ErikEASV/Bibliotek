package com.example.bibliotek;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class BibliotekController {
    @FXML
    private TextField isbnText,titleText,categoryText;

    @FXML
    private TextArea booksText;

    @FXML
    private Button insertBook, getAllBooks;

    private BookDao bdi = new BookDaoImpl();


    @FXML
    protected void insertBookHandler(Event e) {
        Book book = new Book(isbnText.getText(),titleText.getText(),categoryText.getText());
        bdi.saveBook(book);
    }

    @FXML
    protected void getAllBooksHandler(Event e) {
        List<Book> books = bdi.getAllBooks();
        booksText.clear();
        for(Book book : books){
            booksText.appendText(book.toString()+"\n");
        }
    }
}