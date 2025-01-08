package pages;

import core.BasePage;

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

    public String confirmarProduto(String xpath) {
        return obterTextoPeloXpath(xpath);
    }
}