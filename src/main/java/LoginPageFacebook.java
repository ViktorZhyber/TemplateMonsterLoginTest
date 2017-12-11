
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFacebook {
    public LoginPageFacebook(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"id-general-facebook-button\"]/button")
    public WebElement clickFacebookButton;

    @FindBy(id = "email")
    public WebElement enterEmailFacebook;

    @FindBy(id = "pass")
    public WebElement enterPasswordFacebook;

    @FindBy(css = "[value*='Log In'")
    public WebElement clickLoginbuttonFacebook;

    public void clickFacebookButton() {
        clickFacebookButton.click();
    }

    public void enterEmailFacebook(String EMAIL_FB) {
        enterEmailFacebook.sendKeys(EMAIL_FB);
    }

    public void enterPasswordFacebook(String PASSWORD_FB) {
        enterPasswordFacebook.sendKeys(PASSWORD_FB);
    }

    public void clickLoginButtonFacebook() {
        clickLoginbuttonFacebook.click();
    }


    public void loginTestFaceBook(String EMAIL_FB, String PASSWORD_FB){
        this.enterEmailFacebook(EMAIL_FB);
        this.enterPasswordFacebook(PASSWORD_FB);
        this.clickLoginButtonFacebook();
    }
}
