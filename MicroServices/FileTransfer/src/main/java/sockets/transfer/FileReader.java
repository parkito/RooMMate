package sockets.transfer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Artem Karnov @date 25.05.2017.
 *         artem.karnov@t-systems.com
 */

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class);

    public byte[] read(String fileName) throws FileNotFoundException {
        Utils.isFileExists(fileName);
        byte[] buffer = null;

        try (FileInputStream fin = new FileInputStream(fileName)) {
            buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return buffer;

    }
}
