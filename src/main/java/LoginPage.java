import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(css = "[type*='email'")
    public WebElement userEmail;

    @FindBy(css = "[type*='password'")
    public WebElement userPassword;

    public void enterUserName(String EMAIL) {
        userEmail.sendKeys(EMAIL);
    }

    public void enterPassword(String PASSWORD) {
        userPassword.sendKeys(PASSWORD);
    }

    public void submitLoginEmail() {
        userEmail.sendKeys(Keys.ENTER);
    }

    public void submitLoginPassword() {
        userPassword.sendKeys(Keys.ENTER);
    }
    public void loginTest(String EMAIL, String PASSWORD){
        this.enterUserName(EMAIL);
        this.submitLoginEmail();
        this.enterPassword(PASSWORD);
        this.submitLoginPassword();
    }


}
