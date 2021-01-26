package domain.entities.memoryList;

public class MemoryList {

    private int Id;
    private String SelectedProducts;

    private String CustomerNumber;
    private String ProductId;

    public void setSelectedProducts(String selectedProducts) {
        SelectedProducts = selectedProducts;
    }

    public String getSelectedProducts() {
        return SelectedProducts;
    }

    public void setCustomerNumber(String customerNumber) {
        CustomerNumber = customerNumber;
    }

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductId() {
        return ProductId;
    }
}
