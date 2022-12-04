package library;

public class Megye {
    public Megye(int countyid, String countyName) {
        countyId = countyid;
        this.countyName = countyName;
    }

    private int countyId;
    private String countyName;

    public int getCountyId() {
        return countyId;
    }

    public String getCountyName() {
        return countyName;
    }
}
