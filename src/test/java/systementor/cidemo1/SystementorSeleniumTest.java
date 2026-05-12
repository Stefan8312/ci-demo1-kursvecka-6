package systementor.cidemo1;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

        try {

            driver.get("https://systementor.se/");
            logger.info("Navigated to Systementor");

            WebDriverWait wait = new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10)
            );

            WebElement omOss = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.linkText("Om oss")
                    )
            );

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    omOss
            );

            Thread.sleep(1000);

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    omOss
            );

            logger.info("Clicked on Om oss");

            wait.until(ExpectedConditions.urlContains("om"));

            String currentUrl = driver.getCurrentUrl();
            String title = driver.getTitle();

            logger.info("Current URL: " + currentUrl);
            logger.info("Page title: " + title);

            assertTrue(
                    currentUrl.toLowerCase().contains("om") ||
                            title.toLowerCase().contains("om"),
                    "Did not navigate to Om oss page"
            );

            logger.info("Successfully landed on Om oss page");

        } catch (Exception e) {

            logger.severe("Test failed: " + e.getMessage());
            throw new RuntimeException(e);

        } finally {

            driver.quit();
        }
    }
}