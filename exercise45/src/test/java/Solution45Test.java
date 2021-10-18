import Solution45.Solution45;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class Solution45Test {
    List<String> data;

    @BeforeEach @Test
    void testReadingInDataFromFile() throws IOException {
        data = Solution45.readData("utilize", "use");
        assertEquals("One should never use the word \"use\" in writing. Use \"use\" instead.", data.get(0));

    }

    @Test
    void testWritingDataToFile() throws IOException {
        Solution45.writeData(data, "output");

        File file = new File("data//output.txt");
        Scanner reader = new Scanner(file);

        assertEquals("One should never use the word \"use\" in writing. Use \"use\" instead.", reader.nextLine());
        reader.close();
    }
}
