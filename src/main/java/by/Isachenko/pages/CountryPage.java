package by.Isachenko.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CountryPage {
    public List<WebElement> getListZones(WebDriver driver){
        return driver.findElements(By.cssSelector("[name*=name][name^=zones]"));
    }

    public String getZoneName(WebElement element){
        return element.getAttribute("value");
    }
}
