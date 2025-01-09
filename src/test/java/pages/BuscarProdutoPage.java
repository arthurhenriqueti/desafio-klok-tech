package pages;

import core.BasePage;
import org.junit.Assert;

public class BuscarProdutoPage extends BasePage {

    public void preencherCampo(String texto) {
        escreverId("twotabsearchtextbox", texto);
    }

    public void clicarBuscar() {
        clicarBotaoId("nav-search-submit-button");
    }

    public void clicarBotaoOrdenacaoCrescenteDeValor() {
        clicarBotaoId("a-autoid-0-announce");
        clicarBotaoId("s-result-sort-select_1");
    }

    public void clicarBotaoOrdenacaoDecrescenteDeValor() {
        clicarBotaoId("a-autoid-0-announce");
        clicarBotaoId("s-result-sort-select_2");
    }

    public String confirmarProduto(String xpath) {
        return obterTextoXpath(xpath);
    }

    public String confirmarProdutoPeloId(String id) {
        return obterTextoXpath(id);
    }

    public void clicarNoMenu() {
        clicarBotaoId("nav-hamburger-menu");
    }

    public void clicarNaCategoriaMaisVendidos() throws InterruptedException {
        Thread.sleep(3000);
        clicarBotaoXpath("/html/body/div[3]/div[2]/div[2]/ul[1]/li[2]/a");
        Assert.assertEquals("Mais vendidos", confirmarProduto("//*[@id=\"zg_banner_text\"]"));
    }

    public void clicarNaCategoriaEletronicos() {
        clicarBotaoXpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[16]/a");
        Assert.assertEquals("Mais Vendidos em Eletrônicos", confirmarProduto("/html/body/div[1]/div[2]/div/div/div[1]/div/div/div[1]/h1"));
    }

    public void clicarNaCategoriaCelularesComunicacao() {
        clicarBotaoXpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div[4]/a");
        Assert.assertEquals("Mais Vendidos em Celulares e Comunicação", confirmarProduto("/html/body/div[1]/div[2]/div/div/div[1]/div/div/div[1]/h1"));
    }

    public void clicarNaCategoriaCelularesSmartphones() {
        clicarBotaoXpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div[2]/div[3]");
        Assert.assertEquals("Mais Vendidos em Celulares e Smartphones", confirmarProduto("/html/body/div[1]/div[2]/div/div/div[1]/div/div/div[1]/h1"));
    }

    public void aplicarFiltros() {
        clicarBotaoXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[4]/ul/li[1]/span/a/div/label/i");
        clicarBotaoXpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[6]/div[22]/ul/span/span[4]/li/span/a/div/label/i");
    }

    public void selecionarProduto(String xpath) throws InterruptedException {
        Thread.sleep(3000);
        clicarBotaoXpath(xpath);
    }
}
