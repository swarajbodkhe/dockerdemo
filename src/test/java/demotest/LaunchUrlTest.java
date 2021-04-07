package demotest;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.testng.annotations.*;


import java.net.MalformedURLException;
import java.net.URL;

public class LaunchUrlTest {
    ThreadLocal<RemoteWebDriver> rc;
    @BeforeMethod
    public void a() throws MalformedURLException {
        rc=new ThreadLocal<>();
        DesiredCapabilities capabilities= DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.LINUX);
        capabilities.setBrowserName("chrome");
        rc.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities));
    }
    public WebDriver getdriver(){
        return rc.get();
    }
    @Test
    public void T1(){
        getdriver().get("https://www.google.com");
    }

    @Test
    public void T2(){
        getdriver().get("https://www.facebook.com");
    }

    @Test
    public void T3(){
        getdriver().get("https://www.wordpress.com");
    }

    @Test
    public void T4(){
        getdriver().get("https://www.amazon.com");
    }
    @AfterMethod
    public void endT(){
        getdriver().close();
        getdriver().quit();
    }
}
