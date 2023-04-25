package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility
{
    String baseURL = "http://tutorialsninja.com/demo/index.php";
    @Before
    public void setUp()
    {
        openBrowser(baseURL);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException
    {
        //1.1 Mouse hover on Desktops Tab.and click
        WebElement desktop = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        desktop.click();

        //1.2 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");

        //1.3 Select Sort By position "Name: Z to A"

        List<WebElement> beforeFilterNameZtoAList = driver.findElements(By.xpath("//h4"));
        List<String> beforeFileNameZtoAList= new ArrayList<>();
        for(WebElement nameZtoA : beforeFilterNameZtoAList)
        {
            beforeFileNameZtoAList.add(nameZtoA.getText());
        }

        WebElement dropDown = dropDownMenu(By.id("input-sort"));
        Select select = new Select(dropDown);
        //Thread.sleep(2000);
        select.selectByVisibleText("Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order
        List<WebElement> afterFilterNameZtoAList = driver.findElements(By.xpath("//h4"));
        List<String> afterFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : afterFilterNameZtoAList) {
            afterFileNameZtoAList.add(nameZtoA.getText());
        }

        Collections.reverse(beforeFileNameZtoAList);
        System.out.println("Before :-"+beforeFileNameZtoAList);
        System.out.println("After :-"+ afterFileNameZtoAList);
        Thread.sleep(3000);
        Assert.assertEquals(beforeFileNameZtoAList, afterFileNameZtoAList);

    }

    @Test
    public void  verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException
    {
        //2.1 Mouse hover on Desktops Tab. and click
        WebElement desktop = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        desktop.click();

        //2.2 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");

        //2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown = dropDownMenu(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (A - Z)");

        //2.4 Select product “HP LP3065”
        selectMenu("HP LP3065");

        // 2.5 Verify the Text "HP LP3065"
        String expectedMessage1 = "HP LP3065";
        String actualTextMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        Assert.assertEquals(expectedMessage1,actualTextMessage1);

        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";

        clickOnElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]"));
        //clickOnElement(By.id("input-option225"));
        while (true) {
            String monthYear = driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
            //System.out.println(monthYear); // November 2022
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("/html/body/div[4]/div/div[1]/table/thead/tr[1]/th[3]")); // /html/body/div[4]/div/div[1]/table/thead/tr[1]/th[3]
            }
        }

        List<WebElement> allDates = driver.findElements(By.xpath("/html/body/div[4]/div/div[1]/table/tbody/tr[5]/td[3]"));
        for (WebElement dt : allDates){
            if (dt.getText().equalsIgnoreCase(date)){
                dt.click();
                break;
            }
        }

        //2.7.Enter Qty "1” using Select class.
        clearQty(By.xpath("//input[@id='input-quantity']"));
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedMessage2 = "Success: You have added HP LP3065 to your shopping cart!\n×";
        String actualTextMessage2 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage2,actualTextMessage2);

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.11 Verify the text "Shopping Cart"
        String expectedMessage3 = "Shopping Cart  (1.00kg)";
        String actualTextMessage3 = getTextFromElement(By.xpath("//*[@id=\"content\"]/h1"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage3,actualTextMessage3);

        //2.12 Verify the Product name "HP LP3065"
        String expectedMessage4 ="HP LP3065";
        String actualTextMessage4 = getTextFromElement(By.linkText("HP LP3065"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage4,actualTextMessage4);

        //2.13 Verify the Delivery Date "2022-11-30"
        String expectedMessage5 ="Delivery Date:2022-11-30";
        String actualTextMessage5 = getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage5,actualTextMessage5);

        //2.14 Verify the Model "Product21"
        String expectedMessage6 ="Product 21";
        String actualTextMessage6 = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage6,actualTextMessage6);

        //2.15 Verify the Todat "$122.00"
        String expectedMessage7 ="$122.00";
        String actualTextMessage7 = getTextFromElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage7,actualTextMessage7);
    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }


}
