package util;

import static util.Base64Decoder.decode;

import model.Bid;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class FileManager {

    private final static Logger logger = Logger.getLogger(FileManager.class);

    public static void logBidList(final List<Bid> bidList) {
        int listSize = bidList.size();
        ExecutorService service = null;

        try {
            service = Executors.newFixedThreadPool(listSize);
            for (Bid bid : bidList) {
                service.submit(logBidInfo(bid));
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    public static void waitFileUpdate() {
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Runnable logBidInfo(Bid bid) {
        bid.setPl(decode(bid.getPl()));
        return () -> logger.info(bid);
    }
}
