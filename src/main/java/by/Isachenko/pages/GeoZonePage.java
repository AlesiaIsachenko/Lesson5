package by.Isachenko.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class GeoZonePage {
    public List<WebElement> getListZones(WebDriver driver){
        return driver.findElements(By.cssSelector("[name*=zone_code]"));
    }
    public String getGeoZoneName(WebElement element){
        return element.findElement(By.cssSelector("[selected]")).getAttribute("text");
    }
}
