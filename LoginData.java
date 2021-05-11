package LoginFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginData {
    WebDriver driver;

    @Test
    public void userLogin()
    {
        System.setProperty("webdriver.chrome.driver","C:/Study/chrome/chromedriver_win32/chromedriver.exe");
        driver =new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("http://testing.worksjoy.in/");

    }

    @Test(dataProvider = "Login Details" , dependsOnMethods = "userLogin")
    public void data(String username, String Password) throws InterruptedException
    {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("myInput")).sendKeys(Password);

        driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/button")).click();

        Thread.sleep(3000);

        Assert.assertTrue(driver.getTitle().contains("Worksjoy"),"Invalid username");
        System.out.println("login successfull");

        driver.quit();
    }

    @DataProvider(name ="Login Details")
    public Object[][] loginData()
    {
        Object [][] data = new Object[2][2];

        data [0][0] ="170779";
        data [0][1] = "123@dsspl";

        data [1][0] ="70779";
        data [1][1] = "123@dsspl";

        return data;

    }
/*
    @Test(dependsOnMethods = "data")
    public void logOut(){


        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.className("dropdown-menu userdropdwnmenu animated flipInY show"))).release().build().perform();


        Select select = new Select(driver.findElement(By.className("dropdown-menu userdropdwnmenu animated flipInY show")));
        select.selectByVisibleText("Logout");



        Select select = new Select(driver.findElement(By.cssSelector("body > app-root > app-layout > header > nav > div.loggedusername.dropdown-toggoggle-top > span")));
        select.selectByVisibleText("Logout");

 */
    }
