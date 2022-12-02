package ute.application.baemax.dao;

import java.util.List;

public class ListFood {
    private String nameCategory;
    private List<Food> books;

    public ListFood(String nameCategory, List<Food> books) {
        this.nameCategory = nameCategory;
        this.books = books;
    }
    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Food> getBooks() {
        return books;
    }

    public void setBooks(List<Food> books) {
        this.books = books;
    }
}
