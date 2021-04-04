package model;

public class BidContainer {

    private Bid bid;

    public BidContainer(Bid bid) {
        this.bid = bid;
    }

    public Bid getBid() {
        return bid;
    }

    @Override
    public String toString() {
        return "BidContainer{" +
                "bid=" + bid +
                '}';
    }
}
