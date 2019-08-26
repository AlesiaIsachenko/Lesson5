package by.Isachenko;

import by.Isachenko.model.Menu;
import by.Isachenko.pages.CatalogPage;
import by.Isachenko.pages.ProductPage;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AddNewProductTest extends TestBase{
    @Test
    public void testAddNewProduct() {
        super.logAsAdmin();
        Menu menu = new Menu();
        menu.menuclick(driver, menu.catalog);
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.clickAddNewProduct(driver);
        //добавляю новый продукт в каталог
        ProductPage productPage = new ProductPage();
        productPage.setStatusEnabled(driver);
        productPage.setName(driver, "Pink Duck");
        productPage.setCode(driver, "rd006");
        productPage.setCategories(driver, "Root");
        productPage.setCategories(driver, "Rubber Ducks");
        productPage.setProductGroup(driver, "Female");
        productPage.setQuantity(driver, "40");
        productPage.uploadImages(driver, "src\\test\\files\\pinkduck.png");
        productPage.setDateValidFrom(driver, "2019-08-20","20.08.2019");
        productPage.setDateValidTo(driver, "2019-08-30","30.08.2019");
        timeSleep(2);
        productPage.clickTabInformation(driver);
        wait.until(d->d.findElement(By.cssSelector("[name=keywords]")));
        productPage.setManufacturer(driver, "ACME Corp.");
        productPage.setKeywords(driver, "Keywords");
        String shortDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sollicitudin ante massa, eget ornare libero porta congue.";
        productPage.setShortDescription(driver, shortDescription);
        String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sollicitudin ante massa, eget ornare libero porta congue. Cras scelerisque dui non consequat sollicitudin. Sed pretium tortor ac auctor molestie. Nulla facilisi. Maecenas pulvinar nibh vitae lectus vehicula semper. Donec et aliquet velit. Curabitur non ullamcorper mauris. In hac habitasse platea dictumst. Phasellus ut pretium justo, sit amet bibendum urna. Maecenas sit amet arcu pulvinar, facilisis quam at, viverra nisi. Morbi sit amet adipiscing ante. Integer imperdiet volutpat ante, sed venenatis urna volutpat a. Proin justo massa, convallis vitae consectetur sit amet, facilisis id libero.";
        productPage.setDescription(driver, description);
        productPage.setHeadTitle(driver, "Head Title");
        productPage.setMetaDescription(driver, "Meta Description");
        productPage.clickTabPrices(driver);
        wait.until(d->d.findElement(By.cssSelector("[name=purchase_price]")));
        productPage.setPurchasePrice(driver, "25");
        productPage.setPurchasePriceVal(driver, "US Dollars");
        productPage.setPriceUSD(driver, "25");
        productPage.setPriceEUR(driver, "23");
        productPage.clickSave(driver);
        System.out.println("Info: " + "New product has  been created.");

        menu.menuclick(driver, menu.catalog);
        List<WebElement> list = driver.findElements(By.cssSelector(".row [href*='catalog&category'"));
        String name = "";
        for (int i =0; i<list.size(); i++){
            name = list.get(i).getAttribute("textContent");
            if (name.equals("Rubber Ducks")){
                list.get(i).click();
            }
            list = driver.findElements(By.cssSelector(".row [href*='catalog&category'"));
        }
        //проверяю, что новый продукт появился в списке
        list = driver.findElements(By.cssSelector("[href*='product&category']:not([title])"));
        for (int i =0; i<list.size(); i++){
            name = list.get(i).getAttribute("textContent");
            if (name.equals("Pink Duck")){
                System.out.println("Info: " + "New product has been added to the list.");
                //удаляю созданный продукт, чтобы после теста ничего не осталось
                list.get(i).click();
                productPage.clickDelete(driver);
                //закрываю всплывающее сообщение "Are you sure?"
                Alert alt = driver.switchTo().alert();
                alt.accept();
                break;
            }
        }
        wait.until(d->d.findElement(By.cssSelector(".row [href*='catalog&category'")));
        System.out.println("Test is over.");
    }
}
