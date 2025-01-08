package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import static core.DriverPage.getDriver;
import static core.DriverPage.stopDriver;

public class BaseTest {

    @Before
    public void iniciar() {
        getDriver().manage().window().maximize();
        getDriver().get("https://www.amazon.com.br/");
        Assert.assertEquals("Amazon.com.br | Tudo pra você, de A a Z.", getDriver().getTitle());
    }

    @After
    public void finalizar() {
        stopDriver();
    }
}