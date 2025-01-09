package core;

import org.openqa.selenium.By;

import static core.DriverPage.getDriver;

public class BasePage {

    public void escreverId(String idCampo, String texto) {
        getDriver().findElement(By.id(idCampo)).sendKeys(texto);
    }

    public void escreverXpath(String xpathCampo, String texto) {
        getDriver().findElement(By.xpath(xpathCampo)).sendKeys(texto);
    }

    public void clicarBotaoId(String idBotao) {
        getDriver().findElement(By.id(idBotao)).click();
    }

    public void clicarBotaoXpath(String xpathBotao) {
        getDriver().findElement(By.xpath(xpathBotao)).click();
    }

    public void clicarBotaoCss(String cssBotao) {
        getDriver().findElement(By.cssSelector(cssBotao)).click();
    }

    public void clicarBotaoClassName(String className) {
        getDriver().findElement(By.className(className)).click();
    }

    public String obterTextoXpath(String xpathTexto) {
        String element;
        element = getDriver().findElement(By.xpath(xpathTexto)).getText();
        return element;
    }

    public String obterTextoId(String idTexto) {
        String element;
        element = getDriver().findElement(By.id(idTexto)).getText();
        return element;
    }
}
