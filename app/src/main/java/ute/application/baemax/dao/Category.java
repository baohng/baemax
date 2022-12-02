package ute.application.baemax.dao;
import java.util.List;

public class Category {
    private String nameCategory;
    private List<Card> cards;
    public Category(String nameCategory, List<Card> cards) {
        this.nameCategory = nameCategory;
        this.cards = cards;
    }
    public String getNameCategory() {
        return nameCategory;
    }
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
    public List<Card> getBooks() {
        return cards;
    }
    public void setBooks(List<Card> books) {
        this.cards = books;
    }
}