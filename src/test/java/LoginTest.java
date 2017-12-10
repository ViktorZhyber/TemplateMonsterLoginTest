import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String email;
    private String userName;
    private String PASSWORD_FB = "1!Qqqqqqqqq";
    private String PASSWORD = "1!Qqqqqqqq";
    private String EMAIL_FB = "testtemplatemonster8@gmail.com";
    private String EMAIL = "testtemplatemonster1@bigmir.net";
    private String USERNAME = "Сергей Петров";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/vzhyber/IdeaProjects/TemplateMonster/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);

    }
    @Test(priority = 1)
    public void loginTestEmail() {
        driver.get("https://account.templatemonster.com/auth/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type*='email'"))).sendKeys(EMAIL);
        driver.findElement(By.cssSelector("[type*='email'")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("[type*='password'")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("[type*='password'")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class*='user-account-info__name t1'")));
        email = driver.findElement(By.cssSelector("[class*='user-account-info__name t1'")).getText();
        Assert.assertEquals(EMAIL,email);
        driver.manage().deleteAllCookies();
    }
    @Test(priority = 2)
    public void loginTestFacebook() {
        driver.get("https://account.templatemonster.com/auth/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"id-general-facebook-button\"]/button")));
        driver.findElement(By.xpath("//*[@id=\"id-general-facebook-button\"]/button")).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys(EMAIL_FB);
        driver.findElement(By.id("pass")).sendKeys(PASSWORD_FB);
        driver.findElement(By.cssSelector("[value*='Log In'")).click();
        driver.switchTo().window(newTab.get(0));
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='user-account-info__name t1'")));
        userName = driver.findElement(By.cssSelector("[class*='user-account-info__name t1'")).getText();
        Assert.assertEquals(USERNAME,userName);
    }
    @AfterTest
    public void tearDown(){
           if (driver!=null)
               driver.quit();
    }
}
