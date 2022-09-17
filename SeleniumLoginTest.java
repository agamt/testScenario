import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLoginTest {

    @Test
     public void loginTest() {
        WebDriver driver = new ChromeDriver();
        //open and maximize browser
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://dev.projectswithaheart.pconnect.biz/Sitefinity/");
        //fill login data
        driver.findElement(By.id("username")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("pasword");
        driver.findElement(By.id("loginButton")).click();
        // logic if not direct to dashboard page:
        //verify title page
        if (driver.getTitle().contains("User Already Logged In") ) {
            // in case user will direct to configuration page > clcik button confirmation to visit the page
            driver.findElement(By.className("sfLinkBtnIn")).click();
            //click ok javascript confirmation popup
            driver.switchTo().alert().accept();
            //switch link to go dashboard page
            driver.get("https://dev.projectswithaheart.pconnect.biz/");
            //click profile manu
            driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/ul/li[5]/div[1]/div/span")).click();
            }
            //if user direct to dashboard page
            else {
            driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/ul/li[5]/div[1]/div/span")).click();
        }
        driver.quit();
    }
}
