import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class KurtosysTest {
    private static WebDriver Browser;

    public static void main(String[] args){
        System.setProperty("webdrive.chrome.driver","C:\\Users\\F5044790\\IdeaProjects\\Kurtosys Automation Assesment\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        String Url = "https://www.kurtosys.com/";

        //Navigate to the URL
        driver.get(Url);

        //  Maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        wait(10000);
        WebElement resourcesLnk = driver.findElement(By.xpath("/html/body/div[1]/div/div/section[1]/div/div/div/div/div/div/div/div/div/div/div/section/div/div/div[2]/div/div/div/div/div/div/div/ul/li[3]/a/div"));
        Actions action = new Actions(driver);
        action.moveToElement(resourcesLnk).perform();

        WebElement whitePapersEbookLnk = driver.findElement(By.xpath("//*[@id=\"kurtosys-menu-item-59810\"]/div/div/div/div/section/div/div/div[2]/div/div/div[2]/div/ul/li[4]/a/span[2]"));
        whitePapersEbookLnk.click();
        wait(2000);
        WebElement whitePapersLbl= driver.findElement(By.xpath("/html/body/div[2]/div/div/section[1]/div[2]/div/div/div/div/div[2]/div/h2"));
        if (whitePapersLbl.getText().equals("White Papers")){
            System.out.println("White papers is displayed");
        }else{
            System.out.println("White papers is not displayed");
        }
        wait(2000);
        WebElement whitePapersTile= driver.findElement(By.xpath("/html/body/div[2]/div/div/section[2]/div/div/div/div/div/div/div/div/article[3]"));
        whitePapersTile.click();
        wait(2000);
        WebElement fullnameEdt = driver.findElement(By.xpath("//*[@id='18882_231669pi_18882_231669']"));
        WebElement companyEdt = driver.findElement(By.xpath("//*[@id=\"18882_231675pi_18882_231675\"]"));
        WebElement industryEdt = driver.findElement(By.xpath("////*[@id=\"18882_231677pi_18882_231677\"]"));
        WebElement lastNameEdt = driver.findElement(By.xpath("//*[@id=\"18882_231671pi_18882_231671\"]"));
        WebElement sendMeAcopyBtn = driver.findElement(By.xpath("//*[@id=\"pardot-form\"]/p[2]/input"));
        fullnameEdt.sendKeys("Mdu");
        lastNameEdt.sendKeys("Ntuli");
        companyEdt.sendKeys("Kurtosys");
        industryEdt.sendKeys("Banking");
        sendMeAcopyBtn.click();

        captureScreenShot(driver);

    }
    public static void wait(int time){
        try {
            Thread.sleep(time);
        }catch (Exception error){
            System.out.println("Cant wait : "+ error.getMessage());
        }
    }

    public static void captureScreenShot(WebDriver driver){
        try {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
        }catch (Exception error){
            System.out.println("Unable to take screenshot : "+ error.getMessage());
        }

    }
}