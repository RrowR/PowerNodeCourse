package day19;


import java.util.Date;
import java.util.Objects;


public class Trunk{
    private String band;
    private Double price;
    private Date birDate;
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trunk trunk = (Trunk) o;
        return Objects.equals(band, trunk.band) &&
                Objects.equals(price, trunk.price) &&
                Objects.equals(birDate, trunk.birDate) &&
                Objects.equals(type, trunk.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(band, price, birDate, type);
    }

    @Override
    public String toString() {
        return "Trunk{" +
                "band='" + band + '\'' +
                ", price=" + price +
                ", birDate=" + birDate +
                ", type='" + type + '\'' +
                '}';
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getBirDate() {
        return birDate;
    }

    public void setBirDate(Date birDate) {
        this.birDate = birDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Trunk() {
    }

    public Trunk(String band, Double price, Date birDate, String type) {
        this.band = band;
        this.price = price;
        this.birDate = birDate;
        this.type = type;
    }
}
