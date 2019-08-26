package by.Isachenko.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage {
    public void clickAddNewProduct(WebDriver driver){
        driver.findElement(By.cssSelector("[href*=category_id] .fa-plus-circle")).click();
        System.out.println("Info: " + "Click -- add new product.");
    }

    //public List<WebElement> get
}
