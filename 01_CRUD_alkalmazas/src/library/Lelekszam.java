package library;

public class Lelekszam {
    private int cityId;
    private int year;
    private int women;
    private int total;

    public Lelekszam(int cityId, int year, int women, int total) {
        this.cityId = cityId;
        this.year = year;
        this.women = women;
        this.total = total;
    }

    public int getId() {
        return cityId;
    }
    public int getYear() {
        return year;
    }

    public int getWomen() {
        return women;
    }

    public int getTotal() {
        return total;
    }

}
