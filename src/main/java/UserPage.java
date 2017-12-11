import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

    public UserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(css = "[class*='user-account-info__name t1'")
    public WebElement email;

    public String getEmailText(){
       String emailInfo;
        emailInfo = email.getText();
        return(emailInfo);
    }


}
