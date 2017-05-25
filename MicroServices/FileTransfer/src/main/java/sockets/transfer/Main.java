package sockets.transfer;

import java.io.IOException;

/**
 * @author Artem Karnov @date 25.05.2017.
 *         artem.karnov@t-systems.com
 */

public class Main {
    public static void main(String[] args) throws IOException {
        FileReceiver fileReceiver = new FileReceiver();
        fileReceiver.run();

    }
}
