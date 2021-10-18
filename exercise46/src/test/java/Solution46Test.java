import Solution46.Solution46;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Map;

class Solution46Test {
    Map<String, Integer> map;

    @BeforeEach @Test
    void countingWordsTest() throws IOException {
        map = Solution46.countWords();
        assertEquals(7, map.get("badger"));
    }

    @Test
    void searchForWordInMap() {
        assertTrue(Solution46.wordInMap("snake", map));
    }
}
