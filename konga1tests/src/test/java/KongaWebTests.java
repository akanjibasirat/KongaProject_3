import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebTests {

    // import  webdriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // Open chrome driver
        driver = new ChromeDriver();
        //1, Imput konga page url (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        Thread.sleep(10000);
        // maximize window
        driver.manage().window().maximize();
        Thread.sleep(15000);
    }

    @Test (priority = 1)
    public void signin() throws InterruptedException {
        //2, sign in to Konga successfully
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        //2a, input the phone number
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("09076990746");
        Thread.sleep(3000);
        //2b, impute the password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("aminatuaudu1");
        Thread.sleep(3000);
        //2c click on the login button
        driver.findElement(By.xpath(" //*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(8000);
    }

    @Test (priority = 2)
    void clicklaptopcateory() throws InterruptedException {
        //3 from the categories,click on computer and accessories
        //3a click on all categories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[1]")).click();
        //3b click on computer and accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(15000);
        //4 click on laptop sub category
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(15000);
    }

    @Test (priority = 3)
    void clickapplemacbook() throws InterruptedException {
        //5, Click on the Apple Macbook
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(20000);
    }

    @Test (priority = 4)
    void itemtocart () throws InterruptedException {
        //6, Add an item to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[2]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(10000);
        //6b click on the cart button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]")).click();
        Thread.sleep(10000);

    }

    @Test (priority = 5)
    void selectaddress () throws InterruptedException {
        //7a click on the checkout button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(15000);
        // 7, select an address
        // click on change
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        //7b, click on "add delivery address"
        Thread.sleep(15000);
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(5000);
        //7c select address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(8000);
        //7d click on use this address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(10000);
    }


    @Test (priority = 6)
    public void makepayment() throws InterruptedException {
        //8 continue to make payment
        // 8a click on pay now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(13000);
        //8b click on continue to make payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(15000);
    }
    @Test (priority = 7)
    public void selectcardmethod () throws InterruptedException {
        //9 select a card payment method
        //9a change from default to iframe
        WebElement paymethod = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(7000);
        //9b select card payment method
        WebElement cardpayment = driver.findElement(By.className("Card"));
        cardpayment.click();
        Thread.sleep(5000);
    }

    @Test (priority = 8)
    public void inputcarddetails () throws InterruptedException {
        //10. input individual card details
        //10a input card number in its field
        WebElement carddigit = driver.findElement(By.id("card-number"));
        carddigit.sendKeys("123456789000");
        Thread.sleep(3000);

        //10b input date in its field
        WebElement datedigit = driver.findElement(By.id("expiry"));
        datedigit.sendKeys("1124");
        Thread.sleep(3000);

        //10c input CVV in its field
        WebElement cvvdigit = driver.findElement(By.id("cvv"));
        cvvdigit.sendKeys("456");
        Thread.sleep(5000);
    }
    @Test (priority = 9)
    public void errormessage () throws InterruptedException {

        //11 print out the error message
        WebElement error = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(error.getText());
        Thread.sleep(5000);
    }
    @Test (priority = 10)
    public void closeframe () throws InterruptedException {
        //12 close the Iframe that displays input card details
        WebElement exitframe = driver.findElement(By.className("data-card__close"));
        exitframe.click();
        Thread.sleep(5000);
    }
    @Test (priority = 11)
    public void exitiframe () throws InterruptedException {
        // Exit ifame web
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }



    @AfterTest
    public void closeBrowser() {
        //12. Quit your browser
        driver.quit();
    }



    }
