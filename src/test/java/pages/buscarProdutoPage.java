package pages;

import core.BasePage;

public class buscarProdutoPage extends BasePage {

    public void preencherCampo(String texto) {
        escreverPeloId("twotabsearchtextbox", texto);
    }

    public void clicarBuscar() {
        clicarBotaoPeloId("nav-search-submit-button");
    }

    public String confirmarProduto(String xpath) {
        return obterTextoPeloXpath(xpath);
    }
}