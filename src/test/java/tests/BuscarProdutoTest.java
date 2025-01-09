package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.BuscarProdutoPage;

public class BuscarProdutoTest extends BaseTest {

    BuscarProdutoPage produto = new BuscarProdutoPage();

    @Test
    public void ID01_buscarProdutoExistente() throws InterruptedException {
        produto.preencherCampo("iPhone 16");
        produto.clicarBuscar();
        Assert.assertEquals("\"iPhone 16\"", produto.confirmarProduto("/html/body/div[1]/div[1]/span/div/h1/div/div[1]/div/h2/span[3]"));
        produto.selecionarProduto("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[1]/div/div/div/div/div[1]/div/div[2]/div[2]/div/div/div/a[2]/div/div[1]");
        Assert.assertEquals("Apple iPhone 16 Pro (1 TB) – Titânio-deserto", produto.confirmarProduto("//*[@id=\"productTitle\"]"));
    }

    @Test
    public void ID02_buscarProdutoInexistente() {
        produto.preencherCampo("shaushaus");
        produto.clicarBuscar();
        Assert.assertEquals("Nenhum resultado para", produto.confirmarProduto("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[1]/div/div/div/div[1]/span[1]"));
    }

    @Test
    public void ID03_buscarProdutoComErroDeDigitacao() throws InterruptedException {
        produto.preencherCampo("iPhxne 16");
        produto.clicarBuscar();
        Assert.assertEquals("\"iphone 16\"", produto.confirmarProduto("/html/body/div[1]/div[1]/span/div/h1/div/div[1]/div/h2/span[3]"));
        produto.selecionarProduto("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[1]/div/div/div/div/div[1]/div/div[2]/div[2]/div/div/div/a[2]/div/div[1]");
        Assert.assertEquals("Apple iPhone 16 Pro (1 TB) – Titânio-deserto", produto.confirmarProduto("//*[@id=\"productTitle\"]"));
    }

    @Test
    public void ID04_buscarProdutoNaOrdemCrescenteDeValor() throws InterruptedException {
        produto.preencherCampo("iPhone 16");
        produto.clicarBuscar();
        produto.clicarBotaoOrdenacaoCrescenteDeValor();
        Assert.assertEquals("Preço: Do menor para o maior", produto.confirmarProduto("/html/body/div[1]/div[1]/span/div/h1/div/div[4]/div/div/form/span/span/span/span/span[2]"));
        produto.selecionarProduto("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div[1]/span/a/div/img");
        Assert.assertEquals("Mamarmot Capa de celular anime para iPhone 16, desenho animado Satoru Goj Suguru Geto figura capa de telefone macia para iPhone 16 vem com chaveiro (Goj, para iPhone 16)", produto.confirmarProduto("//*[@id=\"productTitle\"]"));
    }

    @Test
    public void ID05_buscarProdutoNaOrdemDecrescenteDeValor() throws InterruptedException {
        produto.preencherCampo("iPhone 16");
        produto.clicarBuscar();
        produto.clicarBotaoOrdenacaoDecrescenteDeValor();
        Assert.assertEquals("Preço: Do maior para o menor", produto.confirmarProduto("/html/body/div[1]/div[1]/span/div/h1/div/div[4]/div/div/form/span/span/span/span/span[2]"));
        produto.selecionarProduto("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[27]/div/div");
        Assert.assertEquals("Apple iPhone 16 (512 GB) – Rosa", produto.confirmarProduto("//*[@id=\"productTitle\"]"));
    }

    @Test
    public void ID06_navegarParaCategoriaCelularesSmartphones() throws InterruptedException {
        produto.clicarNoMenu();
        produto.clicarNaCategoriaMaisVendidos();
        produto.clicarNaCategoriaEletronicos();
        produto.clicarNaCategoriaCelularesComunicacao();
        produto.clicarNaCategoriaCelularesSmartphones();
        produto.selecionarProduto("/html/body/div[1]/div[2]/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div[2]/span/div/a/div");
        Assert.assertEquals("Smartphone Xiaomi Redmi Note 13 8+256G Powerful Snapdragon® performance 120Hz FHD+ AMOLED display 33W fast charging with 5000mAh battery No NFC (Black)", produto.confirmarProduto("//*[@id=\"productTitle\"]"));
    }
}
