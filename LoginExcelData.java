package LoginFunctionality;

import LoginFunctionality.com.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class LoginExcelData {
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

    @Test(dependsOnMethods = "setup"/*,dataProvider = "ExcelSheetData"*/)

    public void loginPage(String username, String password){
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("myInput")).sendKeys(password);

        driver.findElement(By.xpath("//*[@id=\"formContent\"]/form/button")).click();

        Assert.assertTrue(driver.getTitle().contains("Worksjoy"),"Login Failed");
        System.out.println("Login Successfil");
    }
/*
    @DataProvider (name = "ExcelSheetData")
    public static void excelData(){

        Xls_Reader reader = new Xls_Reader("C:/Users/Admin.DESKTOP-6CD7RG7/IdeaProjects/Worksjoy Project/src/LoginFunctionality/WorksjoyLoginData.xls");
        int rowCount = reader.getRowCount("LoginData");

        for (int i=2 ; i<rowCount; i++){

            String username = reader.getCellData("LoginData","username",i);
            System.out.println(username);

            String password = reader.getCellData("LoginData","password",i);
            System.out.println(password);

        }

    } */

}
