package com.dogapi.tests.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;
import com.dogapi.tests.utils.ConfigUtils;

public class CommonSteps {

    private static Response response;
    private static String baseUrl;

    public static void setResponse(Response res) {
        response = res;
    }

    public static Response getResponse() {
        return response;
    }

    @Dado("que eu tenha Uma url válida da dogAPI")
    public void queEuTenhaUmaUrlValidaDaDogAPI() {
        baseUrl = ConfigUtils.getBaseUrl(); // A URL válida padrão
    }

    @Dado("que eu tenha Uma url inválida da dogAPI")
    public void queEuTenhaUmaUrlInvalidaDaDogAPI() {
        baseUrl = ConfigUtils.getBaseUrl() + "/invalido"; // Uma URL inválida propositalmente
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    @Entao("o código de status da resposta deve ser {int}")
    public void o_codigo_de_status_da_resposta_deve_ser(Integer statusCode) {
        assertNotNull(response, "A resposta não deve ser nula.");
        assertEquals(statusCode.intValue(), response.statusCode(), "O código de status não corresponde ao esperado.");
    }

    @Entao("a resposta deve ter a chave status como {string}")
    public void a_resposta_deve_ter_a_chave_status_como(String statusEsperado) {
        assertNotNull(response, "A resposta não deve ser nula.");

        String contentType = response.getContentType();
        assertTrue(contentType != null && contentType.contains("application/json"),
                   "A resposta não está no formato JSON. Tipo de conteúdo recebido: " + contentType);
        
        try {
            String status = response.jsonPath().getString("status");
            assertEquals(statusEsperado, status, "O valor da chave 'status' na resposta não corresponde ao esperado.");
        } catch (Exception e) {
            fail("Erro ao obter o valor da chave 'status' como JSON. Verifique o formato da resposta.", e);
        }
    }
}
