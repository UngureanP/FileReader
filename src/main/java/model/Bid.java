package model;

public class Bid {

    private String id;
    private String ts;
    private String ty;
    private String pl;

    public Bid(String id, String ts, String ty, String pl) {
        this.id = id;
        this.ts = ts;
        this.ty = ty;
        this.pl = pl;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    @Override
    public String toString() {
        return "Bid Details:"
                + "  id = " + id
                + "  timestamp = " + ts
                + "  name = " + ty
                + "  payload = " + pl;
    }
}
