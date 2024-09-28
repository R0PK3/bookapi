package com.bonustask.bookapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publish_year")
    private int publishYear;
    @Column(name = "rating")
    private int rating;

    public Book(String title, String author, int publishYear, int rating) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.rating = rating;
    }

    public Book(){}

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}

    public String getAuthor(){return author;}

    public void setAuthor(String author){this.author = author;}

    public int getPublishYear() {return publishYear;}

    public void setPublishYear(int publishYear) {this.publishYear = publishYear;}

    public int getRating(){return rating;}

    public void setRating(int rating){this.rating = rating;}
}
