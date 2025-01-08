package pages;

import core.BasePage;
import org.junit.Assert;

public class buscarProdutoPage extends BasePage {

    public void preencherCampo(String texto) {
        escreverPeloId("twotabsearchtextbox", texto);
    }

    public void clicarBuscar() {
        clicarBotaoPeloId("nav-search-submit-button");
    }

    public void clicarBotaoOrdenacaoCrescenteDeValor() {
        clicarBotaoPeloId("a-autoid-0-announce");
        clicarBotaoPeloId("s-result-sort-select_1");
    }

    public void clicarBotaoOrdenacaoDecrescenteDeValor() {
        clicarBotaoPeloId("a-autoid-0-announce");
        clicarBotaoPeloId("s-result-sort-select_2");
    }

    public String confirmarProduto(String xpath) {
        return obterTextoPeloXpath(xpath);
    }

    public String confirmarProdutoPeloId(String id) {
        return obterTextoPeloXpath(id);
    }

    public void clicarNoMenu() {
        clicarBotaoPeloId("nav-hamburger-menu");
    }

    public void clicarNaCategoriaMaisVendidos() throws InterruptedException {
        Thread.sleep(3000);
        clicarBotaoPeloXpath("/html/body/div[3]/div[2]/div[2]/ul[1]/li[2]/a");
        Assert.assertEquals("Mais vendidos", confirmarProduto("//*[@id=\"zg_banner_text\"]"));
    }

    public void clicarNaCategoriaEletronicos() {
        clicarBotaoPeloXpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[16]/a");
        Assert.assertEquals("Mais Vendidos em Eletrônicos", confirmarProduto("/html/body/div[1]/div[2]/div/div/div[1]/div/div/div[1]/h1"));
    }

    public void clicarNaCategoriaCelularesComunicacao() {
        clicarBotaoPeloXpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div[4]/a");
        Assert.assertEquals("Mais Vendidos em Celulares e Comunicação", confirmarProduto("/html/body/div[1]/div[2]/div/div/div[1]/div/div/div[1]/h1"));
    }

    public void clicarNaCategoriaCelularesSmartphones() {
        clicarBotaoPeloXpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div[2]/div[3]");
        Assert.assertEquals("Mais Vendidos em Celulares e Smartphones", confirmarProduto("/html/body/div[1]/div[2]/div/div/div[1]/div/div/div[1]/h1"));
    }

    public void aplicarFiltros() {
        clicarBotaoPeloXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[4]/ul/li[1]/span/a/div/label/i");
        clicarBotaoPeloXpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[6]/div[22]/ul/span/span[4]/li/span/a/div/label/i");
    }
}