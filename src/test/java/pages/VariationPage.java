package pages;

import models.Offers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static appmanager.TestBase.app;
import static java.lang.Double.parseDouble;
import static models.Offers.byRating;

/**
 * Created by Oлег on 20.07.2017.
 */
public class VariationPage {

    private String allOffers = "//div[contains(@class, 'sr_item sr_item_new')]";
    private String name = "//span[contains(@class, 'sr-hotel__name')]";
    private String address = "//div[contains(@class, 'address')]";
    private String rating = "//span[contains(@class, 'review-score-badge')]";
    public String highestRatingHotel;


    public List<Offers> offersByParameters() {
        List<Offers> offers = new ArrayList<Offers>();
        List<WebElement> elements = app.wd.findElements(By.xpath(allOffers));
        for (int i = 1; i < elements.size(); i++) {
            String hotelName = app.wd.findElement(By.xpath(allOffers + "[" + i + "]" + name)).getText();
            String addressOfHotel = app.wd.findElement(By.xpath(allOffers + "[" + i + "]" + address)).getText();
            Integer ratingOfHotel = (int) parseDouble(app.wd.findElement(By.xpath(allOffers + "[" + i +"]" + rating)).getText())*10;
            Offers item = new Offers().withCity(addressOfHotel).withHotelName(hotelName).withRating(ratingOfHotel);
            offers.add(item);
        }
        return offers;
    }

    public void sortByRating(List<Offers> offers) {
        offers.sort(byRating);
    }

    public void getHighestRatingHotel(List<Offers> offers) {
        highestRatingHotel = offers.get(offers.size()-1).getHotelName();
    }

    public void goToHighestRatingHotel() {
        WebElement goToHotel = app.wd.findElement(By.xpath(allOffers + "//span[contains (text(), '" + highestRatingHotel + "')]"));
        goToHotel.click();
    }


}

