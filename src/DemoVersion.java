import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DemoVersion {
    public static void main(String[] args) throws AWTException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", MyConstants.DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 15);

        //////////////////////////////  Input New Address Page ////////////////////////////////
        String firstNameTesting = "Fernando";
        String lastNameTesting = "Torres";
        String address1Testing = "Anfield Rd";
        String address2Testing = "Anfield";
        String cityInputTesting = "Liverpool";
        String zipCodeInputElementTesting = "L4 0TH";
        String dayOfBird = "03/20/1984";
        String EnteringAge = "36";
        String webSite = "https://www.google.com/";
        String phoneNumber = "8625747878";
        String NoteBookText = "Never Back Down";
        String changingNameTo = "Peter";
        String changingLastNameTo = "Crouch";


        //////////////////////////////  Checking Login functionality ////////////////////////////////

        driver.findElement(By.id("session_email")).sendKeys("  ");
        driver.findElement(By.id("session_password")).sendKeys(" ");
        driver.findElement(By.cssSelector(".btn")).click();


        //////////////////////////////  Checking inside Website ////////////////////////////////

        WebElement addresses = driver.findElement(By.cssSelector("div[class= \"navbar-nav mr-auto\"] >a:nth-child(2)"));
        addresses.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class = container] > a")));
        WebElement newAddress = driver.findElement(By.cssSelector("div[class = container] > a"));
//        WebElement newAddress = driver.findElement(By.xpath("//a[text()='New Address']"));
        newAddress.click();


        //////////////////////////////  Creating a New  Address////////////////////////////////

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("address_first_name")));
        WebElement firstNameInput = driver.findElement(By.id("address_first_name"));
        firstNameInput.sendKeys(firstNameTesting);

        WebElement lastNameInputElement = driver.findElement(By.id("address_last_name"));
        // driver.findElement(By.xpath("//*[contains(@type, 'text')]"));
        lastNameInputElement.sendKeys(lastNameTesting);

        WebElement address1InputElement = driver.findElement(By.id("address_street_address"));
        address1InputElement.sendKeys(address1Testing);

        WebElement address2InputElement = driver.findElement(By.id("address_secondary_address"));
        address2InputElement.sendKeys(address2Testing);

        WebElement cityInputElement = driver.findElement(By.id("address_city"));
        cityInputElement.sendKeys(cityInputTesting);

        //////////////////////////////  Choosing a RANDOM option from the state dropdown  ////////////////////////////////

        List<WebElement> options = driver.findElements(By.cssSelector("#address_state>option"));
        Random random = new Random();
        int num = random.nextInt(options.size()+1);
        for (int i = 0; i < options.size(); i++) {
            options.get(num).click();
        }

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#address_state>option")));
//        List<WebElement> options2 = driver.findElements(By.cssSelector("#address_state>option"));
//        for (WebElement list: options2) {
//            list.getText();
//            System.out.println(list);
//        }

        //////////////////////////////          Zip Code                   ////////////////////////////////

        WebElement zipCodeInputElement = driver.findElement(By.id("address_zip_code"));
        zipCodeInputElement.sendKeys(zipCodeInputElementTesting);

        //////////////////////////////        Radio Button             ////////////////////////////////////
        WebElement radioButtonElement = driver.findElement(By.cssSelector("[value='us']"));
        radioButtonElement.click();

        //////////////////////////////  Entering the birthday "03/20/1984" ////////////////////////////////

        driver.findElement(By.id("address_birthday")).sendKeys(dayOfBird);

        //////////////////////////////    Entering  age                   ////////////////////////////////
        driver.findElement(By.id("address_age")).sendKeys(EnteringAge);

        //////////////////////////////    Entering  WebSite               ////////////////////////////////
        driver.findElement(By.id("address_website")).sendKeys(webSite);

        //////////////////////////////    Entering Phone Number         c ////////////////////////////////
        driver.findElement(By.id("address_phone")).sendKeys(phoneNumber);

        //////////////////////////////    Selecting Climbing and Dancing  ////////////////////////////////

        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_interest_dance")).click();


        driver.findElement(By.id("address_note")).sendKeys(NoteBookText);

        //////////////////////////////                Submit              ////////////////////////////////
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        //////////////////////////////           Verifying First Name     ////////////////////////////////

        boolean firstName = false;
        try {
            driver.findElement(By.xpath("//*[contains(text(),' Fernando')]"));
            firstName = true;
        } catch (Exception e){
           firstName = false;
        }
        System.out.println(firstName);


        boolean lastName = false;
        try {
            driver.findElement(By.xpath("//*[contains(text(),' Torres')]"));
            lastName = true;
        } catch (Exception e){
           lastName = false;
        }
        System.out.println(lastName);

        driver.findElement(By.xpath("//a[text()='Addresses']")).click();
        driver.findElement(By.xpath("//a[text()='Edit']")).click();

        //////////////////////////////           Changing First And Last Name      ////////////////////////////////

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.form-group > input.form-control#address_first_name")));
        WebElement firstNameAdding = driver.findElement(By.cssSelector("div.form-group > input.form-control#address_first_name"));
        firstNameAdding.clear();
        firstNameAdding.sendKeys(changingNameTo);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.form-group > input.form-control#address_last_name")));
        WebElement lastNameAdding = driver.findElement(By.cssSelector("div.form-group > input.form-control#address_last_name"));
        lastNameAdding.clear();
        lastNameAdding.sendKeys(changingLastNameTo);

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //////////////////////////////       Checking if the First And Last Name were changed     ////////////////////////////////

        boolean nameChanged = false;
        try {
            driver.findElement(By.xpath("//*[contains(text(),' Peter')]"));
            nameChanged = true;
        } catch (Exception e){
            nameChanged = false;
        }
        System.out.println(nameChanged);


        boolean lastNameChanged = false;
        try {
            driver.findElement(By.xpath("//*[contains(text(),' Crouch')]"));
            lastNameChanged = true;
        } catch (Exception e){
            lastNameChanged = false;
        }
        System.out.println(lastNameChanged);

        driver.findElement(By.xpath("//a[text()='Addresses']")).click();
        driver.findElement(By.xpath("//a[text()='Addresses']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-confirm='Are you sure?']")));
        driver.findElement(By.xpath("//a[@data-confirm='Are you sure?']")).click();

        //////////////////////////////       Pop-up deleting     ////////////////////////////////
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);



//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Address was successfully destroyed.']")));
//        String alertNotice = driver.findElement(By.xpath("//div[text()='Address was successfully destroyed.']")).getText();
//        System.out.println(alertNotice);
        driver.quit();
    }
}
