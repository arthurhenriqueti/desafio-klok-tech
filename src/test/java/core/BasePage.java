package core;

import org.openqa.selenium.By;

import static core.DriverPage.getDriver;

public class BasePage {

    public void escreverId(String idCampo, String texto) {
        getDriver().findElement(By.id(idCampo)).sendKeys(texto);
    }

    public void clicarBotaoId(String idBotao) {
        getDriver().findElement(By.id(idBotao)).click();
    }

    public void clicarBotaoXpath(String xpathBotao) {
        getDriver().findElement(By.xpath(xpathBotao)).click();
    }

    public String obterTextoXpath(String xpathTexto) {
        String element;
        element = getDriver().findElement(By.xpath(xpathTexto)).getText();
        return element;
    }
}
