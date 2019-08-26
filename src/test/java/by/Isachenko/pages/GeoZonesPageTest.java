package by.Isachenko.pages;

import by.Isachenko.TestBase;
import by.Isachenko.model.Menu;
import com.google.common.collect.Ordering;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class GeoZonesPageTest  extends TestBase {
    @Test
    //тест: заходим в каждую из геозон и проверяем, что зоны расположены в алфавитном порядке
    public void testSortGeoZone() {
        super.logAsAdmin();
        Menu menu = new Menu();
        menu.menuclick(driver, menu.geoZones);
        GeoZonesPage geoZonesPage = new GeoZonesPage();
        GeoZonePage geoZonePage = new GeoZonePage();
        List<WebElement> listGeoZone = geoZonesPage.getListGeoZones(driver);
        int numberGeoZone = listGeoZone.size();
        for (int i =0; i < numberGeoZone; i++){
            WebElement element = listGeoZone.get(i);
            geoZonesPage.findHref(element).click();
            System.out.println("Info : " + "Open page Geo Zone: " + driver.findElement(By.cssSelector("[name=name]")).getAttribute("value"));
            List<WebElement> listZones = geoZonePage.getListZones(driver);
            ArrayList<String> arrayNameZone = new ArrayList<String>();
            for (int n = 0; n < listZones.size(); n++) {
                WebElement elementZone = listZones.get(n);
                String nameZone = geoZonePage.getGeoZoneName(elementZone);
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
            menu.menuclick(driver, menu.geoZones);
            listGeoZone  = geoZonesPage.getListGeoZones(driver);
        }
        System.out.println("Test is over.");
    }
}
