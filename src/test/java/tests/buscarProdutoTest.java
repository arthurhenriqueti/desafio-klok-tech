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
        Assert.assertEquals("Preço: Do menor para o maior", produto.confirmarProduto("//*[@id=\"a-autoid-64-announce\"]/span[2]"));
    }

    @Test
    public void buscarProdutoNaOrdemDecrescenteDeValor() {
        produto.preencherCampo("iPhone 16");
        produto.clicarBuscar();
        produto.clicarBotaoOrdenacaoDecrescenteDeValor();
        Assert.assertEquals("Preço: Do maior para o menor", produto.confirmarProduto("//*[@id=\"a-autoid-64-announce\"]/span[2]"));
    }

    @Test
    public void buscarProdutoPorCategoriaCelularesSmartphones() {
        produto.clicarNoMenu();
        produto.clicarNaCategoriaCelularesSmartphones();
        produto.aplicarFiltros();
        Assert.assertEquals("Apple iPhone 16 Pro Max (512 GB) – Titânio natural", produto.confirmarProduto("//*[@id=\"da2f58de-75d3-4921-b287-b5ce3c4fc54f\"]/div/div/span/div/div/div[2]/div[1]/a/h2/span"));
    }
}