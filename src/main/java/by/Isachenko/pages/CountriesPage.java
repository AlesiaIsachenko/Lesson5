package by.Isachenko.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CountriesPage {
    public List<WebElement> getListCountries(WebDriver driver){
        return driver.findElements(By.cssSelector(".row"));
    }

    public String getCountryName(WebElement element){
        return element.findElement(By.cssSelector("a")).getAttribute("innerText");
    }

    public WebElement findHref(WebElement element){
        return element.findElement(By.cssSelector("a"));
    }
}
