package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static appmanager.TestBase.app;

/**
 * Created by Олег Калужин on 24.07.2017.
 */
public class HotelPage {
  WebElement hotelName = app.wd.findElement(By.xpath("//h2[@id='hp_hotel_name']"));

  public String getHotelName(){
    System.out.println(hotelName.getText());
    return hotelName.getText();
  }
}
