package ute.application.baemax;

public class MainModel {

    String name, price, describe,star, surl;

    MainModel(){



    }

    public MainModel(String name, String price, String describe, String star, String surl) {
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.star = star;
        this.surl = surl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}
