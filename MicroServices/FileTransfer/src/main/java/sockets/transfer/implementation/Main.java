package sockets.transfer.implementation;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Artem Karnov @date 25.05.2017.
 *         artem.karnov@t-systems.com
 */

public class Main {
    public static void main(String[] args) throws IOException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ServiceStarter(new FileReceiver(), 4444));
        exec.execute(new ServiceStarter(new FileSender(), "/home/parkito/Downloads/source.pdf"));
        exec.shutdown();
    }
}
