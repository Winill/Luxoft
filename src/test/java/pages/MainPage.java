package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static appmanager.TestBase.app;

/**
 * Created by Oлег on 20.07.2017.
 */
public class MainPage {

    private By searchBox = By.xpath("//input[contains(@class, 'c-autocomplete__input sb-searchbox__input sb-destination__input')]");
    private By submitSearch = By.xpath("//button[@data-component= 'search/searchbox/submit-button']");
    private By checkInDay = By.xpath("//input[@name='checkin_monthday']");
    private By checkInMonth = By.xpath("//input[@name='checkin_month']");
    private By checkInYear = By.xpath("//input[@name='checkin_year']");
    private By checkOutDay = By.xpath("//input[@name='checkout_monthday']");
    private By checkOutMonth = By.xpath("//input[@name='checkout_month']");
    private By checkOutYear = By.xpath("//input[@name='checkout_year']");


    public void enterSearchWord(String searchWord) {
        WebElement searchBoxElem = app.wd.findElement(searchBox);
        searchBoxElem.clear();
        searchBoxElem.sendKeys(searchWord);
    }

    public void setCheckInDate() {
        WebElement checkInDayElem = app.wd.findElement(checkInDay);
        checkInDayElem.sendKeys("20");
        WebElement checkInMonthElem = app.wd.findElement(checkInMonth);
        checkInMonthElem.sendKeys("9");
        WebElement checkInYearElem = app.wd.findElement(checkInYear);
        checkInYearElem.sendKeys("2017");
    }

    public void setCheckOutDate() {
        WebElement checkOutDayElem = app.wd.findElement(checkOutDay);
        checkOutDayElem.clear();
        checkOutDayElem.sendKeys("25");
        WebElement checkOutMonthElem = app.wd.findElement(checkOutMonth);
        checkOutMonthElem.clear();
        checkOutMonthElem.sendKeys("9");
        WebElement checkOutYearElem = app.wd.findElement(checkOutYear);
        checkOutYearElem.clear();
        checkOutYearElem.sendKeys("2017");
    }

    public void submit() {
        WebElement submitSearchElem = app.wd.findElement(submitSearch);
        submitSearchElem.click();
    }
}
