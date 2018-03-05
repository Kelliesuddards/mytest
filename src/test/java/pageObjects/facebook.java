package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class facebook {

    public WebElement createAccount = null;

    public WebElement createAccountButton (WebDriver driver){

        createAccount = driver.findElement(By.xpath("//*[@id=\"u_0_t\"]"));

        return createAccount;

    }
}
