package domain.entities.memoryList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MemoryList {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int Id;
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
