package com.dogapi.tests.steps;

import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetBreedImagesSteps {

    @Quando("envio uma solicitação para obter imagens da raça {string}")
    public void envioUmaSolicitacaoParaObterImagensDaRaca(String raca) {
        String url = "https://dog.ceo/api/breed/" + raca + "/images";
        Response response = given()
                .when()
                .get(url)
                .then()
                .extract().response();
        CommonSteps.setResponse(response);
    }

    @Entao("a resposta deve conter uma lista de URLs de imagem")
    public void aRespostaDeveConterUmaListaDeUrlsDeImagem() {
        List<String> urls = CommonSteps.getResponse().jsonPath().getList("message");
        Assert.assertTrue("A resposta deve conter URLs de imagem", urls != null && !urls.isEmpty());
    }
}
