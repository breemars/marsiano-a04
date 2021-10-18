import Solution43.Solution43;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Solution43Test {

    @Test
    void createHTMLTest() throws IOException {
        Solution43.createHTML("TestName", "TestAuthor");
        File tempFile = new File("data//website//TestName//index.html");
        boolean exists = tempFile.exists();
        assertTrue(exists);
    }

    @Test
    void createDirectoryTest() {
        Solution43.createDirectory("TestName", "FolderName");
        File tempFile = new File("data//website//TestName//FolderName");
        boolean exists = tempFile.exists();
        assertTrue(exists);
    }

    @Test
    void testingHTMLFileOutput() throws IOException {
        Solution43.createHTML("TestName", "TestAuthor");
        File tempFile = new File("data//website//TestName//index.html");

        Scanner reader = new Scanner(tempFile);

        assertEquals("<title>TestName</title>", reader.nextLine());
        reader.close();
    }

}
