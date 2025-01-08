package core;

import org.openqa.selenium.By;

import static core.DriverPage.getDriver;

public class BasePage {

    public void escreverPeloId(String idCampo, String texto) {
        getDriver().findElement(By.id(idCampo)).sendKeys(texto);
    }

    public void escreverPeloXpath(String xpathCampo, String texto) {
        getDriver().findElement(By.xpath(xpathCampo)).sendKeys(texto);
    }

    public void clicarBotaoPeloId(String idBotao) {
        getDriver().findElement(By.id(idBotao)).click();
    }

    public void clicarBotaoPeloXpath(String xpathBotao) {
        getDriver().findElement(By.xpath(xpathBotao)).click();
    }

    public String obterTextoPeloXpath(String xpathTexto) {
        String element;
        element = getDriver().findElement(By.xpath(xpathTexto)).getText();
        return element;
    }
}