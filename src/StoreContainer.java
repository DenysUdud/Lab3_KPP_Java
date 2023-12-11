import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class StoreContainer implements Iterable<Store>, Serializable {
    private List<Store> stores;

    public StoreContainer() {
        this.stores = new ArrayList<>();
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public void removeStore(int index) {
        if (index >= 0 && index < stores.size()) {
            stores.remove(index);
        }
    }

    @Override
    public Iterator<Store> iterator() {
        return stores.iterator();
    }

    @Override
    public String toString() {
        return "StoreContainer{" +
                "stores=" + stores +
                '}';
    }
}