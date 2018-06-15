

import POM.Enterandhomescreen;
import POM.Howtosendscreen;
import POM.Sendscreen;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Main {

    private static AndroidDriver<MobileElement> driver;
    public TestName name = new TestName();
    private static ExtentReports extent ;
    private static ExtentTest test ;

    @BeforeClass
    public static void setUp() throws IOException, ParserConfigurationException, SAXException {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter
                ("C:\\Users\\einat.v\\Documents\\Mobile Automation BuyMe\\reports\\report_mobile_tests.html");
        htmlReporter.setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Vaserman Mobile Automation Project", "Automating “BuyMe” App by mobile");
        extent.setSystemInfo("Project goal", "'BuyMe' App Sanity Test-mobile");
        extent.setSystemInfo("Tester", "VASERMAN");
        extent.setSystemInfo("App address", "https://play.google.com/store/apps/details?id=il.co.mintapp.buyme");
        extent.setSystemInfo("Third-Party", "Selenium web-driver, JUnit, Appium, Extent Report.");

        test.log(Status.INFO, "@Before class");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(getData("Package"), getData("Packageurl"));
        capabilities.setCapability(getData("Activity"), getData("Activitylink"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 150);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void test01_open_app_and_googleregistration () throws InterruptedException {
//        This method enter the app "buyme" and chooses google to register the application
        boolean enterandhomescreenok = false;
        try {
            WebDriverWait expwait = new WebDriverWait(driver, 10);
            expwait.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/googleButton")));
            test.pass("Register Screen", MediaEntityBuilder.createScreenCaptureFromPath
                    (takeScreenShot("C:\\Users\\einat.v\\Documents\\Mobile Automation BuyMe\\screenshots\\"
                            + "Register Screen")).build());
            Enterandhomescreen.googleButtontoreg (driver);
            enterandhomescreenok = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"App Could not Register" + e.getMessage());
            enterandhomescreenok = false;
        }finally {
            if (enterandhomescreenok){
                test.log(Status.PASS,"App Register Successfully");
            }
        }
    }
    @Test
    public void test02_Choosegiftvariables() throws InterruptedException, IOException {
//    This method will pick the gift variables by user selection such as business ,category ,gift  ect and move to send screen//

        boolean pickatt = false;
        try {

            WebDriverWait waittitle = new WebDriverWait(driver, 15);
            waittitle.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/t_title")));

            test.pass("Home Screen", MediaEntityBuilder.createScreenCaptureFromPath
                    (takeScreenShot("C:\\Users\\einat.v\\Documents\\Mobile Automation BuyMe\\screenshots\\"
                            + "Home Screen")).build());
        Enterandhomescreen.choosecategor (driver);

            WebDriverWait waitforbusiness = new WebDriverWait(driver, 15);
            waitforbusiness.until(ExpectedConditions.visibilityOfElementLocated(By.id("il.co.mintapp.buyme:id/businessName")));

        Enterandhomescreen.chooseabusiness (driver);

            test.pass("Picking Screen", MediaEntityBuilder.createScreenCaptureFromPath
                    (takeScreenShot("C:\\Users\\einat.v\\Documents\\Mobile Automation BuyMe\\screenshots\\"
                            + "Picking Screen")).build());

            WebDriverWait waitforprice = new WebDriverWait(driver, 30);
            waitforprice.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/priceEditText")));
        Enterandhomescreen.writesumofmoney (driver);
        Enterandhomescreen.submittonextpage(driver);


            pickatt = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"App Could not Pick Gift Attributes and gift from List" + e.getMessage());
            pickatt = false;
        }finally {
            if (pickatt){
                test.log(Status.PASS,"App Succeeded Picking Gift Attributes and gift from List");
            }
        }
    }

    @Test
    public void test03_fillsendscreen() throws IOException {
//        This method deals with the sending info such as to whom the gift for, which event, blessing ect. and move on  to the next screen:  how to send a gift
        boolean fillsend = false;
        try {
        Sendscreen.towhomthegift(driver);
            test.pass("Send Screen Form", MediaEntityBuilder.createScreenCaptureFromPath
                    (takeScreenShot("C:\\Users\\einat.v\\Documents\\Mobile Automation BuyMe\\screenshots\\"
                            + "Send Screen Form")).build());
        Sendscreen.watkindofevent(driver);
        Sendscreen.pickabless(driver);
        Sendscreen.blessEditText(driver);
        Sendscreen.scrolldown(driver);
        Sendscreen.whosendthegift(driver);
        Sendscreen.submit(driver);

            fillsend = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"App Could not Fill Sendscreen form" + e.getMessage());
            fillsend = false;
        }finally {
            if (fillsend){
                test.log(Status.PASS,"App Succeed Filling Sendscreen form");
            }
        }
    }

    @Test
    public void test04_fillhowtosend(){
//This method deals with filling when to send the gift,how to send the gift via sms-via mail-ect ,filling an e-mail and submit to payment page //
        boolean fillhowtosend = false;
        try {

        Howtosendscreen.nowRadioButton(driver);
            test.pass("How to Send Screen Form", MediaEntityBuilder.createScreenCaptureFromPath
                    (takeScreenShot("C:\\Users\\einat.v\\Documents\\Mobile Automation BuyMe\\screenshots\\"
                            + "How to Send Screen Form")).build());
        Howtosendscreen.optionCheckBox_email(driver);
        Howtosendscreen.swipetonextbutton (driver);

            WebDriverWait expwait4 = new WebDriverWait(driver, 10);
            expwait4.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/goNextButton")));
        Howtosendscreen.enteremail(driver);
        Howtosendscreen.submittopayment (driver);

            fillhowtosend = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"App Could not Fill How to Send form and Submit" + e.getMessage());
            fillhowtosend = false;
        }finally {
            if (fillhowtosend){
                test.log(Status.PASS,"App Succeed Filling How to Send form and Submit");
            }
        }
    }



    @AfterClass
    public static void after() {
        driver.quit();
        extent.flush();

    }



    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }


    private static String getData(String keyName) throws
            ParserConfigurationException, IOException, SAXException {
        File XML1 = new File("C:\\Users\\einat.v\\Documents\\Mobile Automation BuyMe\\XML1.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;
        assert dBuilder != null;
        doc = dBuilder.parse(XML1);
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();

    }

}