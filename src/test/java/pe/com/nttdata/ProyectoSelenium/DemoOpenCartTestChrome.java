package pe.com.nttdata.ProyectoSelenium;// Generated by Selenium IDE

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DemoOpenCartTestChrome {
  private static WebDriver driver;
  private static Map<String, Object> vars;
  private static JavascriptExecutor js;
  @BeforeAll
  public static void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterAll
  public static void tearDown() {
    driver.quit();
  }
  @Test
  public void registroUsuario() {
    driver.get("https://demo.opencart.com/");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.xpath("//nav[@id=\'top\']/div[2]/div[2]/ul/li[2]/div/a/span")).click();
    driver.findElement(By.linkText("Register")).click();
    driver.findElement(By.id("input-firstname")).click();
    driver.findElement(By.id("input-firstname")).sendKeys("henry");
    driver.findElement(By.id("input-lastname")).click();
    driver.findElement(By.id("input-lastname")).sendKeys("ilizarbe");
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).sendKeys("christophermen@gmail.com");
    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).sendKeys("1234");
    driver.findElement(By.id("input-newsletter-yes")).click();
    driver.findElement(By.cssSelector(".float-end > .form-check")).click();
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.cssSelector(".btn-primary")).click();

    String text = driver.findElement(By.xpath("//div[contains(@id,'content')]/h1")).getText();
    System.out.println("El valor es: " + text);
    Assertions.assertEquals(text, "Register Account");
  }

  @Test
  public void compra() {
    driver.get("https://demo.opencart.com/");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.cssSelector(".col:nth-child(1) > form .img-fluid")).click();
    driver.findElement(By.id("input-quantity")).click();
    driver.findElement(By.id("input-quantity")).sendKeys(Keys.BACK_SPACE);
    driver.findElement(By.id("input-quantity")).sendKeys("2");
    driver.findElement(By.id("button-cart")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("shopping cart")));
    driver.findElement(By.linkText("shopping cart")).click();
    driver.findElement(By.linkText("Continue")).click();

    boolean objeto = driver.findElement(By.xpath("//div[contains(@id,'logo')]")).isDisplayed();
    Assertions.assertTrue(objeto);
  }
}
