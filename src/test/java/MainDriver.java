import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MainDriver {
   static WebDriver driver = new ChromeDriver();
    @BeforeClass
    public  void before () {
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
    @AfterMethod
    public void afterMethod () {
        driver.quit();
    }

}
