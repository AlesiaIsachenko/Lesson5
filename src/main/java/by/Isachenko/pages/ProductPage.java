package by.Isachenko.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class ProductPage {
    public void clickTabInformation(WebDriver driver){
        driver.findElement(By.cssSelector("[href*=information]")).click();
        System.out.println("Info: " + "Go to tab -- Information.");
    }

    public void clickTabData(WebDriver driver){
        driver.findElement(By.cssSelector("[href*=tab-data]")).click();
        System.out.println("Info: " + "Go to tab -- Data.");
    }

    public void clickTabPrices(WebDriver driver){
        driver.findElement(By.cssSelector("[href*=tab-prices]")).click();
        System.out.println("Info: " + "Go to tab -- Prices.");
    }

    public void clickSave(WebDriver driver){
        driver.findElement(By.cssSelector("[type=submit][name=save]")).click();
        System.out.println("Info: " + "Click Save.");
    }
    public void clickDelete(WebDriver driver){
        driver.findElement(By.cssSelector("[type=submit][name=delete]")).click();
        System.out.println("Info: " + "Click Delete.");
    }

    //Tab General
    public void setStatusEnabled(WebDriver driver){
        driver.findElement(By.cssSelector("[name=status][value='1']")).click();
        System.out.println("Info: " + "Set status -- Enabled.");
    }

    public void setName(WebDriver driver, String name){
        driver.findElement(By.cssSelector("[type=text][name*=name]")).sendKeys(name);
        System.out.println("Info: " + "Set name -- " + name + ".");
    }

    public void setCode(WebDriver driver, String code){
        driver.findElement(By.cssSelector("[type=text][name=code]")).sendKeys(code);
        System.out.println("Info: " + "Set code -- " + code + ".");
    }

    public void setCategories(WebDriver driver, String categories){
        if (categories.equals("Rubber Ducks")){
            driver.findElement(By.cssSelector("[type=checkbox][data-name='Rubber Ducks']")).click();
            System.out.println("Info: " + "Click categories -- Rubber Ducks.");
        }else if(categories.equals("Subcategory")){
            driver.findElement(By.cssSelector("[type=checkbox][data-name='Subcategory']")).click();
            System.out.println("Info: " + "Click categories -- Subcategory.");
        }else if (categories.equals("Root")){
            driver.findElement(By.cssSelector("[type=checkbox][data-name='Root']")).click();
            System.out.println("Info: " + "Click/unclick categories -- Root.");
        }
    }

    public void setProductGroup(WebDriver driver, String text){
        if (text.equals("Female")){
            driver.findElement(By.cssSelector("[name*=product][value='1-2']")).click();
            System.out.println("Info: " + "Set product group -- Female.");
        }else if (text.equals("Male")){
            driver.findElement(By.cssSelector("[name*=product][value='1-1']")).click();
            System.out.println("Info: " + "Set product group -- Male.");
        }else if (text.equals("Unisex")){
            driver.findElement(By.cssSelector("[name*=product][value='1-3']")).click();
            System.out.println("Info: " + "Set product group -- Unisex.");
        }
    }

    public void setQuantity(WebDriver driver, String quantity){
        WebElement element = driver.findElement(By.cssSelector("[name=quantity]"));
        element.clear();
        element.sendKeys(quantity);
        System.out.println("Info: " + "Set quantity -- " + quantity + ".");
    }

    public void uploadImages(WebDriver driver, String path){
        File f = new File(path);
        String absolute = f.getAbsolutePath();
        driver.findElement(By.cssSelector("[type=file]")).sendKeys(absolute);
        System.out.println("Info: " + "Upload images -- " + path + ".");
    }

    public void setDateValidFrom(WebDriver driver, String date1, String date2){
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        if (browserName.equals("internet explorer")||browserName.equals("microsoftedge")){
            driver.findElement(By.cssSelector("[name=date_valid_from]")).sendKeys(date1);
            System.out.println("Info: " + "set date valid from -- " + date1 + ".");
        }else{
            driver.findElement(By.cssSelector("[name=date_valid_from]")).sendKeys(date2);
            System.out.println("Info: " + "set date valid from -- " + date2 + ".");
        }
    }

    public void setDateValidTo(WebDriver driver, String date1, String date2){
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        if (browserName.equals("internet explorer")||browserName.equals("microsoftedge")){
            driver.findElement(By.cssSelector("[name=date_valid_to]")).sendKeys(date1);
            System.out.println("Info: " + "Set date valid to -- " + date1 + ".");
        }else{
            driver.findElement(By.cssSelector("[name=date_valid_to]")).sendKeys(date2);
            System.out.println("Info: " + "Set date valid to -- " + date2 + ".");
        }
    }

    //Tab Information
    public void setManufacturer(WebDriver driver, String text){
        Select dropdown = new Select(driver.findElement(By.cssSelector("[name=manufacturer_id]")));
        dropdown.selectByVisibleText(text);
        System.out.println("Info: " + "Set manufacturer -- " + text + ".");
    }

    public void setSupplier(WebDriver driver, String text){
        Select dropdown = new Select(driver.findElement(By.cssSelector("[name=supplier_id]")));
        dropdown.selectByVisibleText(text);
        System.out.println("Info: " + "Set supplier -- " + text + ".");
    }

    public void setKeywords(WebDriver driver, String keywords){
        driver.findElement(By.cssSelector("[name=keywords]")).sendKeys(keywords);
        System.out.println("Info: " + "Set keywords -- " + keywords + ".");
    }

    public void copyText(String text){
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void setShortDescription(WebDriver driver, String text){
        copyText(text);
        driver.findElement(By.cssSelector("[name*=short_description]")).sendKeys(Keys.LEFT_CONTROL + "v");
        System.out.println("Info: " + "Set short description.");
    }

    public void setDescription(WebDriver driver, String text){
        copyText(text);
        driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys(Keys.LEFT_CONTROL + "v");
        System.out.println("Info: " + "Set description.");
    }

    public void setHeadTitle(WebDriver driver, String headTitle){
        driver.findElement(By.cssSelector("[name*=head_title]")).sendKeys(headTitle);
        System.out.println("Info: " + "Set head title -- " + headTitle + ".");
    }

    public void setMetaDescription(WebDriver driver, String metaDescription){
        driver.findElement(By.cssSelector("[name*=meta_description]")).sendKeys(metaDescription);
        System.out.println("Info: " + "Set meta description -- " + metaDescription + ".");
    }

    // Tab Prices
    public void setPurchasePrice(WebDriver driver, String price){
        WebElement element = driver.findElement(By.cssSelector("[name=purchase_price]"));
        element.clear();
        element.sendKeys(price);
        System.out.println("Info: " + "Set purchase price -- " + price + ".");
    }

    public void setPurchasePriceVal(WebDriver driver, String text){
        Select dropdown = new Select(driver.findElement(By.cssSelector("[name=purchase_price_currency_code]")));
        dropdown.selectByVisibleText(text);
        System.out.println("Info: " + "Set purchase price currency coder -- " + text + ".");
    }

    public void setPriceUSD(WebDriver driver, String price){
        driver.findElement(By.cssSelector("[name='prices[USD]']")).sendKeys(price);
        System.out.println("Info: " + "Set price USD -- " + price + ".");
    }

    public void setPriceTaxUSD(WebDriver driver, String price){
        driver.findElement(By.cssSelector("[name='gross_prices[USD]']")).sendKeys(price);
        System.out.println("Info: " + "Set price tax USD -- " + price + ".");
    }

    public void setPriceEUR(WebDriver driver, String price){
        driver.findElement(By.cssSelector("[name='prices[EUR]']")).sendKeys(price);
        System.out.println("Info: " + "Set price EUR -- " + price + ".");
    }

    public void setPriceTaxEUR(WebDriver driver, String price){
        driver.findElement(By.cssSelector("[name='gross_prices[EUR]']")).sendKeys(price);
        System.out.println("Info: " + "Set price tax EUR -- " + price + ".");
    }
}
