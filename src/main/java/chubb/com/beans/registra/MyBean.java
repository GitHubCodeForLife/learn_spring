package chubb.com.beans.registra;

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