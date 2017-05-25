package sockets.transfer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Artem Karnov @date 25.05.2017.
 *         artem.karnov@t-systems.com
 */

public class FileSaver {
    public void saveFile(byte[] bytes) {
        File file = new File("SavedFile.pdf");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(bytes);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
