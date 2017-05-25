package sockets.transfer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        byte[] fileForSent = fileReader.read("C:\\Users\\akarnov\\Downloads\\File.pdf");

        logger.info("Welcome to Client side");
        logger.info("Connecting to " + ADDRESS + ":" + PORT);

        Socket socket = new Socket(ADDRESS, PORT);
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));

        logger.info(fileForSent.length);
        outputWriter.println(fileForSent);
//        String output = inputReader.readLine();
        logger.info("done");

        outputWriter.close();
        inputReader.close();
        lineReader.close();
        socket.close();

        return true;
    }
}
