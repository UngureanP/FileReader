import model.BidContainer;

import model.Bid;
import util.JsonReader;
import util.FileManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) {
        String filePath = "src/main/resources/model/bids.json";

        while (true) {
            execute(filePath);
        }
    }

    private static void execute(String filePath) {
        BidContainer[] bidContainers = JsonReader.getContent(filePath, BidContainer[].class);
        List<BidContainer> bidContainerList = Arrays.asList(bidContainers);

        List<Bid> bidDetails = bidContainerList.stream()
                .map(BidContainer::getBid)
                .collect(Collectors.toList());

        FileManager.logBidList(bidDetails);
        FileManager.waitFileUpdate();
    }
}
