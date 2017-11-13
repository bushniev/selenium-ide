import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class WiniumTest {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void start() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability("app", "C:\\Windows\\System32\\calc.exe");
        cap.setCapability("app", "D:\\Calculator.exe");
        driver = new RemoteWebDriver(new URL("http://localhost:9999"), cap);
        wait = new WebDriverWait(driver,30);

    }

    @Test
    public void add() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("1")));

        driver.findElement(By.name("3")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("8")).click();
        driver.findElement(By.name("=")).click();

        Assert.assertEquals("363",driver.findElement(By.id("1000")).getText());

    }

    @Test
    public void sub() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("1")));

        driver.findElement(By.name("Clear")).click();
        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("7")).click();
        driver.findElement(By.name("3")).click();
        driver.findElement(By.name("-")).click();
        driver.findElement(By.name("8")).click();
        driver.findElement(By.name("3")).click();
        driver.findElement(By.name("=")).click();

        Assert.assertEquals("90",driver.findElement(By.id("1000")).getText());

    }

    @AfterClass
    public static void stop() {

        driver.quit();
    }


}
