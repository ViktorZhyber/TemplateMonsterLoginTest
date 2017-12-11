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
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static WebDriverWait wait;
    public static UserPage userPage;
    public static LoginPageFacebook loginPageFacebook;
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
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        loginPageFacebook = new LoginPageFacebook(driver);
        wait =  new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }
    @Test(priority = 1)
    public void loginTestEmail() {
        driver.get("https://account.templatemonster.com/auth/");
        wait.until(ExpectedConditions.visibilityOf(loginPage.userEmail));
        loginPage.loginTest(EMAIL,PASSWORD);
        wait.until(ExpectedConditions.visibilityOf((userPage.email)));
        email = userPage.getEmailText();
        Assert.assertEquals(EMAIL,email);
        driver.manage().deleteAllCookies();
    }
    @Test(priority = 2)
    public void loginTestFacebook() {
        driver.get("https://account.templatemonster.com/auth/");
        wait.until(ExpectedConditions.visibilityOf(loginPageFacebook.clickFacebookButton));
        loginPageFacebook.clickFacebookButton();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        wait.until(ExpectedConditions.visibilityOf(loginPageFacebook.enterEmailFacebook));
        loginPageFacebook.loginTestFaceBook(EMAIL_FB,PASSWORD_FB);
        driver.switchTo().window(newTab.get(0));
        userName = userPage.getEmailText();
        Assert.assertEquals(USERNAME,userName);
    }
    @AfterTest
    public void tearDown(){
           if (driver!=null)
             driver.quit();
    }
}
