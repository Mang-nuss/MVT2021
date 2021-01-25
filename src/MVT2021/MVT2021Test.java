package MVT2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MVT2021Test {

    private Product product;

    @Test
    void priceIsSaved() {
        product = new Product("Berner Sennen Shampoo",
                "A1",
                99,
                "B1",
                1,
                "Shampoo."
                );
        assertTrue(product.getPrice() == 99);
    }

    //@Test

}
