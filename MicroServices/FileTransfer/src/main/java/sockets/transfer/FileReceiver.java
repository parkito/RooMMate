package sockets.transfer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Artem Karnov @date 25.05.2017.
 *         artem.karnov@t-systems.com
 */

public class FileReceiver {
    private static final Logger logger = LogManager.getLogger(FileReceiver.class);

    private final static int PORT = 4444;

    public void run() throws IOException {
        logger.info("Wait for messages");

        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            logger.error("Couldn't listen to port 4444");
        }

        try {
            client = server.accept();
        } catch (IOException e) {
            logger.error("Can't accept");
        }

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        File file = new File("/home/parkito/Downloads/result.pdf");
        file.createNewFile();
        DataInputStream dis = new DataInputStream(client.getInputStream());
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = new byte[4096];

        int filesize = 151230000; // Send file size in separate msg
        int read = 0;
        int totalRead = 0;
        int remaining = filesize;
        while ((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            totalRead += read;
            remaining -= read;
            System.out.println("read " + totalRead + " bytes.");
            fos.write(buffer, 0, read);
        }

        fos.close();
        dis.close();
        client.close();
        server.close();
    }


}
