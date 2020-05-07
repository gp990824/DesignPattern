package com.gp.creat.builder;

/**
 * @author gp
 * @create 2020/2/24 20:15
 */
public class House {
    private String color;
    private Integer price;

    @Override
    public String toString() {
        return "House{" +
                "color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    public House() {
    }

    public House(String color, Integer price) {
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
