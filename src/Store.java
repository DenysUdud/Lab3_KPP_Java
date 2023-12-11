import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Store implements Serializable {
    private List<Product> products;
    private String store_name;

    public Store(String store_name) {
        this.store_name = store_name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getProductsList() {
        String productsstring = "";
        for (int i = 0; i < products.size(); i++) {
            productsstring += " " + products.get(i);
        }

        return productsstring;

    }

    @Override
    public String toString() {
        return "Store{" + store_name +
                "products=" + getProductsList() +
                '}';
    }
}
