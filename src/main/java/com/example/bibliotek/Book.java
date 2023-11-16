package com.example.bibliotek;

public class Book {
    private String isbn;
    private String title;
    private String category;

    public Book (String isbn,String title,String category){
        this.isbn=isbn;
        this.title=title;
        this.category=category;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public String getTitle(){
        return this.title;
    }

    public String getCategory(){
        return this.category;
    }

    public String toString() {
        return isbn + " " + title + " " + category;
    }


}