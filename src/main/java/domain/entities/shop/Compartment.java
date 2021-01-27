package domain.entities.shop;

import MVT2021.Catalog;
import MVT2021.Product;

import java.util.ArrayList;

public class Compartment {

    private String id;
    private ArrayList<MVT2021.Product> items = new ArrayList<MVT2021.Product>();

    public Compartment(MVT2021.Product product, Catalog catalog) {
        String modelNr = product.getModelNr();
        id = modelNr;

        catalog.addCompartment(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<MVT2021.Product> getItems() {
        return items;
    }

    public void setItems(ArrayList<MVT2021.Product> items) {
        this.items = items;
    }

    public void addItem(Product product) {
        this.items.add(product);
    }
}
