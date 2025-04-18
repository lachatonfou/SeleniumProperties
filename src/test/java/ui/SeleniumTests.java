package ui;

import configs.TestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTests {

    WebDriver driver;
    TestConfig config = new TestConfig();

    String baseUrl = config.getBaseUrl();


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void proverkaTextInput() throws InterruptedException {

        WebElement textInput = driver.findElement(By.id("my-text-id"));
        textInput.sendKeys("Halo");
        String enteredValue = textInput.getAttribute("value");
        Thread.sleep(1000);
        assertEquals("Halo", enteredValue);
    }

    @Test
    void proverkaPassword() throws InterruptedException {

        WebElement password = driver.findElement(By.name("my-password"));
        password.sendKeys("ololo");
        String enteredValue = password.getAttribute("value");
        Thread.sleep(1000);
        assertEquals("ololo", enteredValue);
    }

    @Test
    void proverkaTextArea() throws InterruptedException {

        WebElement textArea = driver.findElement(By.cssSelector("[name='my-textarea']"));
        textArea.sendKeys("uwuwu");
        String enteredValue = textArea.getAttribute("value");
        Thread.sleep(1000);
        assertEquals("uwuwu", enteredValue);
    }
}

