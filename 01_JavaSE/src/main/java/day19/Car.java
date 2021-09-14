package day19;

import java.util.Date;
import java.util.Objects;

public class Car implements Comparable<Car>{
    private String band;
    private Double price;
    private Date birDate;
    private String type;

    public Car() {
    }

    public Car(String band, Double price, Date birDate, String type) {
        this.band = band;
        this.price = price;
        this.birDate = birDate;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(band, car.band) &&
                Objects.equals(price, car.price) &&
                Objects.equals(birDate, car.birDate) &&
                Objects.equals(type, car.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(band, price, birDate, type);
    }

/*    @Override
    public int compareTo(Object o) {
        if (this.price < ((Car) o).price){
            return -1;
        }else if (this.price > ((Car) o).price){
            return 1;
        }else {
            return 0;
        }
    }*/

    @Override
    public int compareTo(Car o) {
        if (this.price < o.price){
            return -1;
        }else if (this.price > o.price){
            return 1;
        }else {
            return 0;
        }
    }
}
