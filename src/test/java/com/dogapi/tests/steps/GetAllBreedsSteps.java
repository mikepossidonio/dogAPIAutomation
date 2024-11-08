package com.dogapi.tests.steps;

import com.dogapi.tests.utils.ConfigUtils;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.lessThan;

import java.util.Map;

public class GetAllBreedsSteps {

    @Quando("envio uma solicitação para listar todas as raças")
    public void envioUmaSolicitacaoParaListarTodasAsRacas() {
        String baseUrl = ConfigUtils.getBaseUrl();
        Response response = given()
                .baseUri(baseUrl)
                .header("Accept", "application/json")
                .get("/breeds/list/all");
        CommonSteps.setResponse(response);
    }

    @Quando("envio uma solicitação para um endpoint incorreto")
    public void envioUmaSolicitacaoParaUmEndpointIncorreto() {
        String baseUrl = ConfigUtils.getBaseUrl();
        Response response = given()
                .baseUri(baseUrl)
                .header("Accept", "application/json")
                .get("/breeds/lista");
        CommonSteps.setResponse(response);
    }

    @Quando("envio uma solicitação POST para listar todas as raças")
    public void envioUmaSolicitacaoPostParaListarTodasAsRacas() {
        String baseUrl = ConfigUtils.getBaseUrl();
        Response response = given()
                .baseUri(baseUrl)
                .header("Accept", "application/json")
                .post("/breeds/list/all");
        CommonSteps.setResponse(response);
    }

    @Entao("a resposta deve conter uma lista de raças")
    public void aRespostaDeveConterUmaListaDeRacas() {
        Map<String, Object> breeds = CommonSteps.getResponse().jsonPath().getMap("message");
        assertNotNull(breeds, "A lista de raças está vazia");
        assertFalse(breeds.isEmpty(), "A lista de raças está vazia");
    }

    @Entao("o tempo de resposta deve ser menor que {int} segundos")
    public void oTempoDeRespostaDeveSerMenorQue(int segundos) {
        CommonSteps.getResponse().then().time(lessThan((long) segundos * 1000));
    }
}
