package by.Isachenko.pages;

import by.Isachenko.TestBase;
import by.Isachenko.model.Menu;
import com.google.common.collect.Ordering;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class CountriesPageTest extends TestBase {
    @Test
    // тест: страны на странице расположены в алфавитном порядке
    public void testSortCountry() {
        super.logAsAdmin();
        CountriesPage page = new CountriesPage();
        Menu menu = new Menu();
        menu.menuclick(driver, menu.countries);
        List<WebElement> listCountries = page.getListCountries(driver);

        int numberCountries = listCountries.size();
        ArrayList<String> arrayNameCountry = new ArrayList<String>();
        for (int n = 0; n < numberCountries; n++) {
            WebElement elementCountry = listCountries.get(n);
            String nameCountry = page.getCountryName(elementCountry);
            arrayNameCountry.add(nameCountry);
        }
        System.out.println(arrayNameCountry.toString());
        boolean f = Ordering.natural().isOrdered(arrayNameCountry);

        if (f){
            System.out.println("Info: " + "List of countries is sorted correctly.");
        }else{
            System.out.println("Warn:  " + "List of countries is not sorted correctly!");
        }
        System.out.println("Test is over.");
    }

    @Test
    //короткий тест: открыть страницу страны (Канада, США) и там проверить, что зоны расположены в алфавитном порядке
    public void testZone2() {
        super.logAsAdmin();
        String hrefCountry[] = {"http://localhost/litecart/admin/?app=countries&doc=edit_country&country_code=CA", "http://localhost/litecart/admin/?app=countries&doc=edit_country&country_code=US"};
        CountryPage countryPage = new CountryPage();
        for (int i = 0; i<hrefCountry.length; i++){
            driver.navigate().to(hrefCountry[i]);
            System.out.println("Info : " + "Open page: " + driver.findElement(By.cssSelector("[name=name]")).getAttribute("value"));
            if (areElementsPresent(driver, By.cssSelector(".fa-times-circle"))){
                List<WebElement> listZone = countryPage.getListZones(driver);
                ArrayList<String> arrayNameZone = new ArrayList<String>();
                for (int n = 0; n < listZone.size(); n++) {
                    WebElement elementZone = listZone.get(n);
                    String nameZone = countryPage.getZoneName(elementZone);
                    arrayNameZone.add(nameZone);
                }
                System.out.println("Info : " + "Zones list: " + arrayNameZone.toString());
                boolean f = Ordering.natural().isOrdered(arrayNameZone);
                if (f){
                    System.out.println("Info : " + "Zones list is sorted correctly.");
                    System.out.println();
                }else{
                    System.out.println("Warn : " + "Zones list is not sorted correctly!");
                    System.out.println();
                }
            }else{
                System.out.println("Info: It is not zones list on page.");
            }
        }
        System.out.println("Test is over.");
    }

    @Test
    //тест: открыть страницу страны (перебор всех стран) и там проверить, что зоны расположены в алфавитном порядке (если они есть)
    public void testZone() {
        super.logAsAdmin();
        CountriesPage countriesPage = new CountriesPage();
        CountryPage countryPage = new CountryPage();
        Menu menu = new Menu();
        menu.menuclick(driver, menu.countries);
        List<WebElement> listCountries = countriesPage.getListCountries(driver);
        int numberCountries = listCountries.size();
        for (int n = 0; n < numberCountries; n++) {
            WebElement elementCountry = listCountries.get(n);
            countriesPage.findHref(elementCountry).click();
            if (areElementsPresent(driver, By.cssSelector(".fa-times-circle"))) {
                List<WebElement> listZone = countryPage.getListZones(driver);
                ArrayList<String> arrayNameZone = new ArrayList<String>();
                for (int j = 0; j < listZone.size(); j++) {
                    WebElement elementZone = listZone.get(j);
                    String nameZone = countryPage.getZoneName(elementZone);
                    arrayNameZone.add(nameZone);
                }
                System.out.println(arrayNameZone.toString());
                boolean f = Ordering.natural().isOrdered(arrayNameZone);
                if (f) {
                    System.out.println("Info: " + "Zones list is sorted correctly.");
                } else {
                    System.out.println("Warn: " + "Zones list is not sorted correctly!");
                }
            } else {
                System.out.println("Info: " + "It is not zones list on page.");
            }
            menu.menuclick(driver, menu.countries);
            listCountries = countriesPage.getListCountries(driver);
        }
        System.out.println("Test is over.");
    }
}
