package tests;

import appmanager.TestBase;
import models.Offers;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelPage;
import pages.MainPage;
import pages.VariationPage;

import java.util.List;

/**
 * Created by Oлег on 20.07.2017.
 */
public class BookingTests extends TestBase {

    private MainPage mainpage;
    private VariationPage variatiionPage;
    private HotelPage hotelPage;


    @Test(enabled = true)
    public void testCityContains() {
        app.wd.get("https://www.booking.com/");
        mainpage = new MainPage();
        mainpage.enterSearchWord("New York City");
        mainpage.setCheckInDate();
        mainpage.setCheckOutDate();
        mainpage.submit();
        variatiionPage = new VariationPage();
        List<Offers> offers = variatiionPage.offersByParameters();
        for (Offers offer : offers) {
            Assert.assertTrue(offer.getCity().contains("New York"));
        }
    }

    @Test(enabled = true)
    public void testOfBestRating() {
        app.wd.get("https://www.booking.com/");
        mainpage = new MainPage();
        mainpage.enterSearchWord("New York City");
        mainpage.setCheckInDate();
        mainpage.setCheckOutDate();
        mainpage.submit();
        variatiionPage = new VariationPage();
        List<Offers> offers = variatiionPage.offersByParameters();
        variatiionPage.sortByRating(offers);
        variatiionPage.getHighestRatingHotel(offers);
        variatiionPage.goToHighestRatingHotel();
        for (String winHandle : app.wd.getWindowHandles()) {
            app.wd.switchTo().window(winHandle);
        }
        hotelPage = new HotelPage();
        Assert.assertEquals(variatiionPage.highestRatingHotel, hotelPage.getHotelName());
    }
}
