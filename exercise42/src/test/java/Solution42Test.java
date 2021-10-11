import Solution42.Solution42;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

class Solution42Test {

    @Test
    void readingData() throws IOException {
        List<String> data = Solution42.readData();
        assertEquals("Ling", data.get(0));
    }



}
