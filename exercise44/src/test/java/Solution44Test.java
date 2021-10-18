import Solution44.Solution44;
import Solution44.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

class Solution44Test {
    List<String> data;
    List<Products> products;

    @BeforeEach @Test
    void testReadingInData() throws IOException {
        data = Solution44.readData();
        assertEquals("    {\"name\": \"Widget\", \"price\": 25.00, \"quantity\": 5 }", data.get(0));

    }

    @BeforeEach @Test
    void testCreateObjectList() {
       products = Solution44.objectList(data);
       assertEquals("Widget", products.get(0).getName());
    }

    @Test
    void testSearchingForProduct() {
        assertTrue(Solution44.searchProduct(products, "Doodad"));
    }

}
