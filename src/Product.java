import java.io.*;
import java.util.*;

class Product implements Serializable {
    private String name;
    private String unit;
    private int quantity;
    private int price;
    private Date arrivalDate;
    private String description;

    public Product(String name, String unit, int quantity, int price, Date arrivalDate, String description) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", arrivalDate=" + arrivalDate +
                ", description='" + description + '\'' +
                '}';
    }
}