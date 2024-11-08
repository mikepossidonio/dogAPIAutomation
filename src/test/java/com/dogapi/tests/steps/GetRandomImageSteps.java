package com.dogapi.tests.steps;

import com.dogapi.tests.utils.ConfigUtils;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.lessThan;

public class GetRandomImageSteps {

    @Quando("envio uma solicitação para obter uma imagem aleatória de um cão")
    public void envioUmaSolicitacaoParaObterUmaImagemAleatoriaDeUmCao() {
        String baseUrl = ConfigUtils.getBaseUrl();
        Response response = given()
                .baseUri(baseUrl)
                .header("Accept", "application/json")
                .get("/breeds/image/random");
        CommonSteps.setResponse(response);
    }

    @Quando("envio uma solicitação PUT para obter uma imagem aleatória de um cão")
    public void envioUmaSolicitacaoPutParaObterUmaImagemAleatoriaDeUmCao() {
        String baseUrl = ConfigUtils.getBaseUrl();
        Response response = given()
                .baseUri(baseUrl)
                .header("Accept", "application/json")
                .put("/breeds/image/random");
        CommonSteps.setResponse(response);
    }

    @Entao("a resposta deve conter uma URL de imagem")
    public void aRespostaDeveConterUmaUrlDeImagem() {
        String imageUrl = CommonSteps.getResponse().jsonPath().getString("message");
        assertNotNull(imageUrl, "A URL da imagem está nula");
        assertTrue(imageUrl.length() > 0, "A URL da imagem está vazia");
    }

    @Entao("a URL de imagem deve começar com {string}")
    public void aUrlDeImagemDeveComecarCom(String prefix) {
        String imageUrl = CommonSteps.getResponse().jsonPath().getString("message");
        assertTrue(imageUrl.startsWith(prefix), "URL da imagem inválida: " + imageUrl);
    }

    @Entao("o tempo de resposta deve ser menor que {int} segundo")
    public void oTempoDeRespostaDeveSerMenorQue(int segundos) {
        CommonSteps.getResponse().then().time(lessThan((long) segundos * 1000));
    }
}
