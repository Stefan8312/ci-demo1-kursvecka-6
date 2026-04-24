package systementor.cidemo1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystementorSeleniumTest2 {

    Logger logger = Logger.getLogger(SystementorSeleniumTest2.class.getName());

    @Test
    void testNavigateToOmOss(){

        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://systementor.se/");
        logger.info("Navigated to Systementor");

        WebElement omossKlick =
                driver.findElement(By.linkText("Om oss"));

        omossKlick.click();
        logger.info("clicked Om oss");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();

        assertTrue(
                currentUrl.contains("om-oss") ||
                        title.contains("Om oss")
        );

        logger.info("After clicking it lands on the om oss page");

        driver.quit();
    }
}