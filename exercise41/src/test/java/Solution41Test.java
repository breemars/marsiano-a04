import org.junit.jupiter.api.Test;
import Solution41.Solution41;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;

class Solution41Test {

    @Test
    void readingData() throws FileNotFoundException {
        List<String> names = Solution41.readData();

        assertEquals("Ling, Mai", names.get(0));
    }

    @Test
    void TestingDataLength() throws FileNotFoundException {
        List<String> names = Solution41.readData();

        assertEquals(7, names.size());
    }


}
