package google;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import setup.setup;

public class TestGoogle extends setup {

    String SEARCH_FIELD = "input[type=text]";
    String SEARCH_BUTTON = "#tsf > div:nth-child(2) > div.A8SBwf > div.FPdoLc.tfB0Bf > center > input.gNO89b";
    String SEARCH_TEXT = "github";

    @Test(priority = 1)
    public void validateTitleOfPage() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }

    @Test(priority = 2)
    public void validateInputFieldValue(){
        WebElement searchFiled = driver.findElement(By.cssSelector(SEARCH_FIELD));
        searchFiled.sendKeys(SEARCH_TEXT);
        Assert.assertEquals(searchFiled.getAttribute("value"),SEARCH_TEXT);
    }

    @Test(priority = 3)
    public void validateSearch(){
        WebElement searchFiled = driver.findElement(By.cssSelector(SEARCH_FIELD));
        searchFiled.sendKeys("github");
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        Assert.assertTrue(driver.getTitle().startsWith(SEARCH_TEXT));
    }
}
