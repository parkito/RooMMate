package sockets.transfer;

import java.io.IOException;

/**
 * @author Artem Karnov @date 25.05.2017.
 *         artem.karnov@t-systems.com
 */

public class Main1 {
    public static void main(String[] args) throws IOException {
        FileSender fileSender = new FileSender();
        fileSender.sentFile();
    }
}
