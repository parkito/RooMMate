package sockets.transfer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Artem Karnov @date 25.05.2017.
 *         artem.karnov@t-systems.com
 */

public class FileSender {
    private static final Logger logger = LogManager.getLogger(FileReader.class);

    private final static int PORT = 4444;
    private final static String ADDRESS = "localhost";
    private FileReader fileReader;

    public FileSender() {
        fileReader = new FileReader();
    }

    public boolean sentFile() throws IOException {
        File file = new File("/home/parkito/Downloads/source.pdf");

        logger.info("Welcome to Client side");
        logger.info("Connecting to " + ADDRESS + ":" + PORT);

        Socket socket = new Socket(ADDRESS, PORT);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[4096];

        while (fis.read(buffer) > 0) {
            dos.write(buffer);
        }

        fis.close();
        dos.close();

        socket.close();

        return true;
    }
}
