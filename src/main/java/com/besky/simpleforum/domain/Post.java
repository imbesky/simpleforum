package com.besky.simpleforum.domain;

import jakarta.persistence.*;

@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Title")
    private String title;
    @Column(name = "Author")
    private String author;
    private String content;
    @Id @Column(name = "Number")
    private int number;
    private String writtenDate;
    private String passWord;
    @Id
    private Long id;

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", number=" + number +
                ", writtenDate='" + writtenDate + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getWrittenDate() {
        return writtenDate;
    }

    public void setWrittenDate(String writtenDate) {
        this.writtenDate = writtenDate;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
