package LoginFunctionality;

import LoginFunctionality.com.utility.excelData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class WorksjoyExcelTest {

    WebDriver driver;
    @Test(priority = 1)

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:/Study/chrome/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://testing.worksjoy.in/#/");

    }

    @DataProvider(name= "ExcelData")
    public Iterator<Object[]> getTestData(){

        ArrayList<Object []> testData = excelData.getDataFromExcel();
        return testData.iterator();
    }


    @Test(dataProvider = "ExcelData")
    public void loginPage(String username, String password){
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("myInput")).sendKeys(password);

        driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/button")).click();

        Assert.assertTrue(driver.getTitle().contains("Worksjoy"),"Login Failed");
        System.out.println("Login Successfil");
    }
}
