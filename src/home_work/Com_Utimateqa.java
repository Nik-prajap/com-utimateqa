package home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project - 5.
 * BaseUrl = https://courses.ultimateqa.com/users/sign_in
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on "Sign In" link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */
public class Com_Utimateqa {

    // Static variables assign to call direct to main method
    static String browser = "Chrome";   //launch the Chrome browser as requested.
    static String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println(driver.getTitle());                      // Print the title
        System.out.println(driver.getCurrentUrl());                 // Print Current Url
        System.out.println(driver.getPageSource());                 // Print Page Source

        WebElement signIn = driver.findElement(By.linkText("Sign In"));
        signIn.click();
        Thread.sleep(2500);

        System.out.println(driver.getCurrentUrl());

        WebElement eMail = driver.findElement(By.id("user[email]"));
        eMail.sendKeys("Prime123@gmail.com");
        Thread.sleep(2500);

        WebElement passWord = driver.findElement(By.id("user[password]"));
        passWord.sendKeys("123Prime");
        Thread.sleep(2500);

        WebElement login = driver.findElement(By.xpath("(//button[@type='submit'])"));
        login.click();
        Thread.sleep(5000);

        driver.navigate().to("https://courses.ultimateqa.com/");
        Thread.sleep(5000);

        driver.navigate().forward();
        Thread.sleep(2500);

        driver.navigate().back();
        Thread.sleep(2500);

        driver.navigate().refresh();
        Thread.sleep(2500);

        driver.quit();
    }
}
