package sockets.transfer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sockets.tcp.Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        File file = new File("C:\\Users\\akarnov\\Downloads\\result.pdf");
        file.createNewFile();
        PrintWriter outputWriter = new PrintWriter(file);


        int data;

        while ((data = inputReader.read()) != -1) {
            logger.info(data);
            outputWriter.write(data);
        }

        outputWriter.close();
        inputReader.close();
        client.close();
        server.close();

    }
}
