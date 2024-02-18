package chubb.com.beans.beans_factory_util;

public class MyBean {
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MyBean{" + "price=" + price + '}';
    }
}