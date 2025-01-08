package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.buscarProdutoPage;

public class buscarProdutoTest extends BaseTest {

    buscarProdutoPage produto = new buscarProdutoPage();

    @Test
    public void buscarProdutoExistente() {
        produto.preencherCampo("iPhone 16");
        produto.clicarBuscar();
        Assert.assertEquals("\"iPhone 16\"", produto.confirmarProduto("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/h2/span[3]"));
    }

    @Test
    public void buscarProdutoInexistente() {
        produto.preencherCampo("shaushaus");
        produto.clicarBuscar();
        Assert.assertEquals("Nenhum resultado para", produto.confirmarProduto("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[1]/div/div/div/div[1]/span[1]"));
    }

    @Test
    public void buscarProdutoComErroDeDigitacao() {
        produto.preencherCampo("iPhxne 16");
        produto.clicarBuscar();
        Assert.assertEquals("\"iphone 16\"", produto.confirmarProduto("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/h2/span[3]"));
    }

    @Test
    public void buscarProdutoNaOrdemCrescenteDeValor() {
        produto.preencherCampo("iPhone 16");
        produto.clicarBuscar();
        produto.clicarBotaoOrdenacaoCrescenteDeValor();
    }
}