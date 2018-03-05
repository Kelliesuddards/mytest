package tests;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import static java.util.concurrent.TimeUnit.SECONDS;


public class facebookTest {

    public static void main (String[] args) {


        // 1. OPEN CHROME BROWSER.
        WebDriver driver = new ChromeDriver();

        // 2.  NAVIGATE TO “HTTP://WWW.FB.COM”
        driver.get("http://www.fb.com/");

        //  2.  VERIFY THAT PAGE IS REDIRECTED TO “HTTP://WWW.FACEBOOK.COM”, BY GETTING THE CURRENT URL.
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.facebook.com/" );
        System.out.println("URL Correct");

        // 4. VERIFY THAT THERE IS A “CREATE AN ACCOUNT” SECTION ON THE PAGE.

        WebDriverWait wait = new WebDriverWait(driver, 30);
        if (driver.findElement(By.xpath("//*[@id=\"u_0_t\"]")).isDisplayed()){
            System.out.println("Create An Account is Present");
        }else{
            System.out.println("Create An Account is Absent");
        }

        //5. FILL IN THE TEXT BOXES: FIRST NAME, SURNAME, MOBILE NUMBER OR EMAIL ADDRESS, “RE-ENTER MOBILE NUMBER”, NEW PASSWORD.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"u_0_e\"]")));
        driver.manage().timeouts().implicitlyWait(2, SECONDS);
        driver.findElement(By.xpath("//*[@id=\"u_0_e\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_0_e\"]")).sendKeys("James");
        driver.findElement(By.xpath("//*[@id=\"u_0_g\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_0_g\"]")).sendKeys("Smith");
        driver.findElement(By.xpath("//*[@id=\"u_0_j\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_0_j\"]")).sendKeys("james1234@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"u_0_q\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_0_q\"]")).sendKeys("jamespassword");
        driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_0_m\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_0_m\"]")).sendKeys("james1234@gmail.com");

        //6. UPDATE THE DATE OF BIRTH IN THE DROPDOWN.

        Select month = new Select(driver.findElement(By.xpath("//*[@id=\"month\"]")));
        month.selectByVisibleText("Feb");
        Select day = new Select(driver.findElement(By.xpath("//*[@id=\"day\"]")));
        month.selectByValue("1");

        //7. SELECT THE GENDER.
        driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();

        //8. CLICK ON “CREATE AN ACCOUNT”.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"u_0_t\"]")));
        driver.findElement(By.xpath("//*[@id=\"u_0_t\"]")).click();

        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);

        //driver.switchTo().window(parentWindow);




    }
}


