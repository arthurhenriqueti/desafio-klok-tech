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
        Assert.assertEquals("\"iPhone 16\"", produto.confirmarProduto("/html/body/div[1]/div[1]/span/div/h1/div/div[1]/div/h2/span[3]"));
    }

    @Test
    public void buscarProdutoInexistente() {
        produto.preencherCampo("shaushaus");
        produto.clicarBuscar();
        Assert.assertEquals("Nenhum resultado para", produto.confirmarProduto("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[1]/div/div/div/div[1]/span[1]"));
    }

    @Test
    public void buscarProdutoComErroDeDigitacao() {
        produto.preencherCampo("iPhxne 16");
        produto.clicarBuscar();
        Assert.assertEquals("\"iphone 16\"", produto.confirmarProduto("/html/body/div[1]/div[1]/span/div/h1/div/div[1]/div/h2/span[3]"));
    }

    @Test
    public void buscarProdutoNaOrdemCrescenteDeValor() {
        produto.preencherCampo("iPhone 16");
        produto.clicarBuscar();
        produto.clicarBotaoOrdenacaoCrescenteDeValor();
        Assert.assertEquals("Preço: Do menor para o maior", produto.confirmarProduto("/html/body/div[1]/div[1]/span/div/h1/div/div[4]/div/div/form/span/span/span/span/span[2]"));
    }

    @Test
    public void buscarProdutoNaOrdemDecrescenteDeValor() {
        produto.preencherCampo("iPhone 16");
        produto.clicarBuscar();
        produto.clicarBotaoOrdenacaoDecrescenteDeValor();
        Assert.assertEquals("Preço: Do maior para o menor", produto.confirmarProduto("/html/body/div[1]/div[1]/span/div/h1/div/div[4]/div/div/form/span/span/span/span/span[2]"));
    }

    @Test
    public void navegarParaCategoriaCelularesSmartphones() throws InterruptedException {
        produto.clicarNoMenu();
        produto.clicarNaCategoriaMaisVendidos();
        produto.clicarNaCategoriaEletronicos();
        produto.clicarNaCategoriaCelularesComunicacao();
        produto.clicarNaCategoriaCelularesSmartphones();
    }
}