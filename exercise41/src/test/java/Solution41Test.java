import org.junit.jupiter.api.Test;
import Solution41.Solution41;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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

    @Test
    void TestingOutputFileCreation() throws IOException {
        List<String> names = Solution41.readData();
        Solution41.writeData(names);

        File tempFile = new File("data//exercise41_output.txt");
        boolean exists = tempFile.exists();
        assertTrue(exists);
    }

    @Test
    void testingWritingData() throws IOException {
        List<String> names = Solution41.readData();
        Solution41.writeData(names);

        File tempFile = new File("data//exercise41_output.txt");
        Scanner reader = new Scanner(tempFile);

        assertEquals("Total of 7 names", reader.nextLine());
        reader.close();
    }

}
