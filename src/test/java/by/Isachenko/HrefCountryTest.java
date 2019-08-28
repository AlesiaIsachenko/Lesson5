package by.Isachenko;

import by.Isachenko.model.Menu;
import by.Isachenko.pages.CountriesPage;
import by.Isachenko.pages.CountryPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class HrefCountryTest extends TestBase{
    @Test
    public void HrefCountriesTest() {
        super.logAsAdmin();
        Menu menu = new Menu();
        menu.menuclick(driver, menu.countries);
        List<String> titleList= Arrays.asList("ISO 3166-1 alpha-2 - Wikipedia", "ISO 3166-1 alpha-3 - Wikipedia", "Regular expression - Wikipedia",
                "International Address Format Validator: Verify Mailing Formats | Informatica", "Regular expression - Wikipedia",
                "List of countries and capitals with currency and language - Wikipedia", "List of country calling codes - Wikipedia");
        CountriesPage countriesPage = new CountriesPage();
        List<WebElement> countriesList = countriesPage.getListCountries(driver);
        countriesPage.findHref(countriesList.get(0)).click();
        CountryPage countryPage = new CountryPage();
        String originalWindow = driver.getWindowHandle();
        Set<String> existingWindows = driver.getWindowHandles();
        List<WebElement> hrefList = countryPage.getHref(driver);
        for (int i = 0; i< hrefList.size(); i++){
            System.out.println("Info: " + "Click href.");
            hrefList.get(i).click();
            String newWindow = wait.until(anyWindowOtherThan(existingWindows));
            driver.switchTo().window(newWindow);
            //неявное ожидание загрузки страницы
            List<WebElement> list = driver.findElements(By.cssSelector("a"));
            if (driver.getTitle().equals(titleList.get(i))){
                System.out.println("Info: " + "New window title -- " + driver.getTitle() + ".");
            }else{
                System.out.println("Warn: " + "New window  has another title! " + driver.getTitle());
            }
            driver.close();
            System.out.println("Info: " + "Close new window.");
            driver.switchTo().window(originalWindow);
            hrefList = countryPage.getHref(driver);
        }
        System.out.println("Test is over.");
    }
}
