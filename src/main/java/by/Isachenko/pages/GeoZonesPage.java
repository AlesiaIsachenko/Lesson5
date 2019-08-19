package by.Isachenko.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GeoZonesPage {
    public List<WebElement> getListGeoZones(WebDriver driver){
        return driver.findElements(By.cssSelector(".row"));
    }

    public WebElement findHref(WebElement element){
        return element.findElement(By.cssSelector("a"));
    }
}
