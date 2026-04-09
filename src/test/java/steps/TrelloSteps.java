package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.pt.*;
import maps.TrelloMap;
import org.junit.Assert;
import utils.RestUtils;

import static org.junit.Assert.*;

public class TrelloSteps {

    TrelloMap trelloMap = new TrelloMap();

    @Dado("que tenha um payload valido da API do Trello")
    public void queTenhaUmPayloadValidoDaAPIDoTrello() {
        trelloMap.initJson();
    }

    @Quando("envio uma requisicao do tipo POST para criar card")
    public void criarCard() {
        RestUtils.post(trelloMap.getJson(), "/cards");

        if (RestUtils.getResponse().statusCode()==200){TrelloMap.idCard = RestUtils.getResponse().jsonPath().getString("id");};
    }

    @Quando("envio uma requisicao do tipo PUT para editar card")
    public void editarCard() {

        String endpoint = "/cards/" + TrelloMap.idCard + "?name=Card Automacao Editado" + "&key=" + trelloMap.getJson().get("key") + "&token=" + trelloMap.getJson().get("token");

        RestUtils.put(endpoint);
    }

    @Quando("envio uma requisicao do tipo DELETE para excluir card")
    public void excluirCard() {

        String endpoint = "/cards/" + TrelloMap.idCard + "?key=" + trelloMap.getJson().get("key") + "&token=" + trelloMap.getJson().get("token");

        RestUtils.delete(endpoint);
    }

    @Entao("valido que recebo status {int}")
    public void validarStatus(int status) {
        assertEquals(status, RestUtils.getResponse().getStatusCode());
    }

    @E("valido que o campo {string} seja {string}")
    public void validoQueOCampoSeja(String key, String value) {
        trelloMap.getJson().put(key, value);
    }

    @E("valido que o campo {string} nao seja nulo")
    public void validoQueOCampoNaoSejaNulo(String campo) {
        Object valor = RestUtils.getResponse().jsonPath().get(campo);

        assertNotNull(valor);
    }

    @Dado("que tenha um payload com campo {string} com o valor {string}")
    public void queTenhaUmPayloadInvalido(String key,  String value) {
        trelloMap = new TrelloMap();
        trelloMap.getJson().put(key,value);
    }

    @Dado("que tenha um payload com campo {string} excluido")
    public void queTenhaUmPayloadComCampoExluido(String key) {
        trelloMap = new TrelloMap();
        trelloMap.getJson().remove(key);
    }
}