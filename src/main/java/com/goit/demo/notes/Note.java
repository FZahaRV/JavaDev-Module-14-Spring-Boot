package com.goit.demo.notes;

import java.util.Random;

public class Note {
    private Random random = new Random();

    private long id;

    private String title;

    private String content;

    void setId() {
        id = random.nextLong(999);
    }

    public long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ID " + id + "\nTitle " + title + "\nContent " + content + "\n";
    }
}