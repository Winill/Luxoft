package models;

import java.util.Comparator;

/**
 * Created by Oлег on 20.07.2017.
 */
public class Offers {

    private String city;
    private String hotelName;
    private Integer rating;

    public Integer getRating() {
        return rating;
    }

    public Offers withRating(Integer rating) {
        this.rating = rating;
        return this;

    }

    public String getCity() {
        return city;
    }

    public Offers withCity(String city) {
        this.city = city;
        return this;

    }

    public String getHotelName() {
        return hotelName;
    }

    public Offers withHotelName(String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    public static Comparator<Offers> byRating = (o1, o2) -> o1.getRating() - o2.getRating();

    @Override
    public String toString() {
        return "Offers{" +
                "city='" + city + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offers offers = (Offers) o;

        if (city != null ? !city.equals(offers.city) : offers.city != null) return false;
        if (hotelName != null ? !hotelName.equals(offers.hotelName) : offers.hotelName != null) return false;
        return rating != null ? rating.equals(offers.rating) : offers.rating == null;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

}
