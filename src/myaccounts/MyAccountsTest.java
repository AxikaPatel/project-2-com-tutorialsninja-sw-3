package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility
{
    String baseURL = "http://tutorialsninja.com/demo/index.php";
    @Before
    public void setUp()
    {
        openBrowser(baseURL);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException
    {
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOption("Register");

        //1.3 Verify the text “Register Account”.
        String expectedMessage = "Register";
        String actualMessage = getTextFromElement(By.xpath("//a[contains(text(),'Register')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void  verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException
    {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOption("Login");


        //2.3 Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void  verifyThatUserRegisterAccountSuccessfully() throws InterruptedException
    {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOption("Register");

       //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"),"Axika");

        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"),"Patel");

        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"),"axika120@gmail.com");

        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"),"07526542130");

        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"Axika12342");

        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"),"Axika12342");

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));


        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@class='btn btn-primary']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedMessage2 = "Your Account Has Been Created!";
        String actualMessage2 = getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage2, actualMessage2);

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));


        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOption("Logout");

        //3.16 Verify the text “Account Logout”
        String expectedMessage3 = "Account Logout";
        String actualMessage3 = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage3, actualMessage3);

        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    @Test
    public void  verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException
    {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter Login”
        selectMyAccountOption("Login");

        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"),"axika4387@gmail.com");

        //4.4 Enter Last Name
        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"Axika1234");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));

        //4.7 Verify text “My Account”
        String expectedMessage5 = "My Account";
        String actualMessage5 = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
        Assert.assertEquals(expectedMessage5, actualMessage5);


        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOption("Logout");

        //4.10 Verify the text “Account Logout”
        String expectedMessage4 = "Account Logout";
        String actualMessage4 = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage4, actualMessage4);

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }






    @After
    public void tearDown()
    {
        closeBrowser();
    }


}
