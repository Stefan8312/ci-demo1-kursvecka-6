package systementor.cidemo1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystementorSeleniumTest {

    Logger logger = Logger.getLogger(SystementorSeleniumTest.class.getName());

    @Test
    void testNavigateToOmOss() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--headless=new",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--window-size=1920,1080"
        );

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://systementor.se/");
        logger.info("Navigated to Systementor");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement omOss = wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Om oss"))
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);",
                omOss
        );

        omOss.click();

        logger.info("Clicked on Om oss");

        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();

        assertTrue(
                currentUrl.contains("om-oss") ||
                        title.contains("Om oss")
        );

        logger.info("After click it lands on the Om oss page");

        driver.quit();
    }
}