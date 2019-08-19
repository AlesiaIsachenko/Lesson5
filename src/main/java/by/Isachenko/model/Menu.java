package by.Isachenko.model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu {
    public String countries = "#app- [href*=countries]";
    public String geoZones  = "#app- [href*=geo_zones]";

    public void countriesMenuclick(WebDriver driver, String menu){
        driver.findElement(By.cssSelector(menu)).click();
    }
}
