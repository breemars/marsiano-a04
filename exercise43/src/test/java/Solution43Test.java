import Solution43.Solution43;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

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

}
