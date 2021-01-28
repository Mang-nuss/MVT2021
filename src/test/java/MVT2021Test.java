package MVT2021;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MVT2021Test {

    private Product product;
    private Catalog catalog = new Catalog();
    private String compartmentName;
    private Compartment compartment;
    private ArrayList<Compartment> compartments = new ArrayList<>();
    private int id;
    private int sum;
    private String modelNr;
    private String expected;
    private String actual;

    /**
     * When product is created, a catalog compartment is created
     */
    @Test
    void catalogCompartmentIsCreated() {
        product = new Product("Berner Sennen Shampoo",
                "A1",
                99,
                "B1",
                1,
                "Shampoo.",
                catalog
        );
        compartment = new Compartment(product,catalog);
        //compartment = catalog.getCompartmentName(product.getProductId());
        assertEquals(compartment.getId(),"A1");
    }

    /**
     * Catalog can check for compartments by compartment id
     */
    @Test
    void compartmentCanBeFoundById() {
        product = new Product("Berner Sennen Shampoo",
                "A1",
                99,
                "B1",
                1,
                "Shampoo.",
                catalog
        );

        expected = "A1";
        actual = null;
        modelNr = product.getModelNr();
        compartments = catalog.getCompartments();
        for(Compartment c : compartments) {
            if(c.getId() == modelNr) {
                actual = c.getId();
                break;
            }
        }
        assertEquals(actual,expected);
    }

    /**
     * When compartment is created, it enters the catalog. The above refactored.
     */
    @Test
    void compartmentIsInCatalog() {
        product = new Product("Berner Sennen Shampoo",
                "A1",
                99,
                "B1",
                1,
                "Shampoo.",
                catalog
        );
        product = new Product("St Bernhard Shampoo",
                "A2",
                89,
                "B2",
                1,
                "More shampoo.",
                catalog
        );
        expected = "A1";
        actual = catalog.getCompartmentByCompartmentId("A1").getId();
        assertEquals(actual,expected);
    }

    /**
     * When product is created, a catalog compartment is created automatically
     */
    @Test
    void catalogCompartmentIsCreatedAutomatically() {
        //compartment = new Compartment(product);
        product = new Product("Berner Sennen Shampoo",
                "A1",
                99,
                "B1",
                1,
                "Shampoo.",
                catalog
        );
        //product.createCompartment();
        compartment = catalog.getCompartmentByProduct(product);

        assertEquals(compartment.getId(),"A1");
    }

    /**
     * When product is created, compartment is stored in catalog
     */
    @Test
    void catalogCompartmentIsStored() {
        product = new Product("St Bernhard Shampoo",
                "A2",
                89,
                "B2",
                1,
                "More shampoo.",
                catalog
        );
        compartmentName = catalog.getCompartmentByProduct(product).getId();
        assertEquals(compartmentName,"A2");
    }

    /**
     * Price is saved in private var
     */
    @Test
    void priceIsSaved() {
        product = new Product("Leonberger Shampoo",
                "A3",
                79,
                "B3",
                1,
                "Even more shampoo.",
                catalog
                );
        assertTrue(product.getPrice() == 79);
    }

    /**
     * When product is created, catalog total size is increased
     */
    @Test
    void productIsSavedInCatalog() {
        //product.enterCatalog(catalog);
        product = new Product("St Bernhard Shampoo",
                "A2",
                89,
                "B2",
                1,
                "More shampoo.",
                catalog
        );
        assertEquals(catalog.getTotalSize(),1);
    }

    /**
     * There should be only one compartment per model nr
     */
    @Test
    void onlyOneCompartmentPerModelNr() {
        product = new Product("St Bernhard Shampoo",
                "A2",
                89,
                "B2",
                1,
                "More shampoo.",
                catalog
        );
        product = new Product("St Bernhard Shampoo",
                "A2",
                89,
                "B2",
                1,
                "More shampoo.",
                catalog
        );
        sum = 0;
        for(Compartment c : catalog.getCompartments()) {
            System.out.println(c.getId());
            if(c.getId() == "A2") {
                System.out.println("match!");
                sum += 1;
            }
        }
        System.out.println("sum: " + sum);

        assertEquals(sum,1);
    }

    /**
     * multiple products are entered and compartments are created accordingly
     */
    @Test
    void nrOfCompartmentsAreCorrectAfterProductsAreCreated() {
        enterProducts();
        for(Compartment c : catalog.getCompartments()) {
            System.out.println("title:" + c.getId());
        }
        assertEquals(catalog.getTotalSize(),3);
    }

    /**
     * multiple products are entered and compartment sizes are correct
     */
    @Test
    void compartmentSizesAreCorrect() {
        enterProducts();
        for(Compartment c : catalog.getCompartments()) {
            System.out.println("title:" + c.getId());
            for(Product product : c.getItems()) {
                System.out.println("id: " + product.getProductId());
            }
        }
        assertEquals(catalog.getCompartmentByCompartmentId("A2").getItems().size(),3);
    }

    //------------------------------------------------------------//

    void enterProducts() {
        for(int i=0; i<2; i++) { //2 products are created
            product = new Product("Berner Sennen Shampoo",
                    "A1",
                    99,
                    "B1",
                    1,
                    "Shampoo.",
                    catalog
            );
        }

        for(int i=0; i<3; i++) { //3
            product = new Product("St Bernhard Shampoo",
                    "A2",
                    89,
                    "B2",
                    1,
                    "More shampoo.",
                    catalog
            );
        }

        for(int i=0; i<4; i++) { //4
            product = new Product("Leonberger Shampoo",
                    "A3",
                    79,
                    "B3",
                    1,
                    "Even more shampoo.",
                    catalog
            );
        }
    }


}
