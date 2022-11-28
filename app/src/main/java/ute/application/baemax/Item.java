package ute.application.baemax;

public class Item {
    String name;
    String star;
    String price;
    String describe;
    int image;

    public Item(String name,String describe, String star, String price, int image) {
        this.image = image;
        this.name = name;
        this.star = star;
        this.price = price;
        this.describe = describe;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}