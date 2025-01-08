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
        clicarBotaoPeloXpath("//*[@id=\"a-autoid-0-announce\"]");
        clicarBotaoPeloXpath("//*[@id=\"s-result-sort-select_1\"]");
    }

    public void clicarBotaoOrdenacaoDecrescenteDeValor() {
        clicarBotaoPeloXpath("//*[@id=\"a-autoid-0-announce\"]");
        clicarBotaoPeloXpath("//*[@id=\"s-result-sort-select_2\"]");
    }

    public String confirmarProduto(String xpath) {
        return obterTextoPeloXpath(xpath);
    }

    public void clicarNoMenu() {
        clicarBotaoPeloId("nav-hamburger-menu");
    }

    public void clicarNaCategoriaCelularesSmartphones() {
        clicarBotaoPeloXpath("/html/body/div[3]/div[2]/div[2]/ul[1]/li[20]/a[1]/div");
        clicarBotaoPeloXpath("//*[@id=\"hmenu-content\"]/ul[1]/ul[1]/li[5]/a");
        clicarBotaoPeloXpath("//*[@id=\"hmenu-content\"]/ul[16]/li[4]/a");
        Assert.assertEquals("Celulares e Smartphones", confirmarProduto("//*[@id=\"a-page\"]/div[1]/div[2]/div[1]/div/div/h1/b"));
    }

    public void aplicarFiltros() {
        clicarBotaoPeloXpath("//*[@id=\"s-refinements\"]/div[4]/ul/li[1]/span/a/div/label/i");
        clicarBotaoPeloXpath("//*[@id=\"p_n_feature_thirty_browse-bin/120222012011\"]/span/a/div/label/i");
    }
}