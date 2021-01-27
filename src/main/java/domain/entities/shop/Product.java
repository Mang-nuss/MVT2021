package domain.entities.shop;

import MVT2021.Catalog;
import MVT2021.Compartment;

public class Product {

    private String productName;
    private static int id = 1; //id should be unique
    private int productId;
    private String modelNr;
    private int price;
    private String imgReference;
    private int category;
    private String description;
    private Compartment compartment;

    public Product(String name, String nr, int p, String imgRef, int cat, String descr, MVT2021.Catalog catalog) {

        productName = name;
        setProductId();
        modelNr = nr;
        price = p;
        imgReference = imgRef;
        category = cat;
        description = descr;

        createCompartment(catalog);
        enterCatalog(catalog);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId() {
        this.productId = id;
        id++; //the class variable is increased
    }

    public String getModelNr() {
        return modelNr;
    }

    public void setModelNr(String modelNr) {
        this.modelNr = modelNr;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgReference() {
        return imgReference;
    }

    public void setImgReference(String imgReference) {
        this.imgReference = imgReference;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void enterCatalog(MVT2021.Catalog catalog) {
        compartment = catalog.getCompartmentByCompartmentId(this.getModelNr());
        compartment.addItem(this);
    }

    public void createCompartment(Catalog catalog) {
        boolean duplicate = false;
        for(Compartment c : catalog.getCompartments()) {
            if(c.getId() == this.getModelNr()) {
                duplicate = true;
            }
        }

        if(!duplicate) { compartment = new Compartment(this,catalog); }
    }
}
