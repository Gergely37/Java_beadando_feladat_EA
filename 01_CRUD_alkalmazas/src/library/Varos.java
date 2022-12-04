package library;

public class Varos {
    public Varos(int cityId, String cityName, int countyId, boolean countySeat, boolean countyCouncil) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.countyId = countyId;
        this.countySeat = countySeat;
        this.countyCouncil = countyCouncil;
    }

    private int cityId;
    private String cityName;
    private int countyId;
    private boolean countySeat;
    private boolean countyCouncil;

    public int getId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCountyId() {
        return countyId;
    }

    public boolean getCountySeat() {
        return countySeat;
    }

    public boolean getCountyCouncil() {
        return countyCouncil;
    }
}
