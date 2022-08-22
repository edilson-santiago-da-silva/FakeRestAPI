package modulos.activities;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import dataFactory.ActivitiesDataFactory;
import dataFactory.InvalidActivityDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Testes de API Rest do modulo de atividades")
public class ActivitiesTest {
    @BeforeEach
    public void beforeEach(){
        baseURI = "https://fakerestapi.azurewebsites.net";
    }

    @Test
    @DisplayName("Validar a busca de atividades")
    public void testConsultaAAtividades() {
        given()
            .when()
                .get("/api/v1/Activities/1")
            .then()
                .assertThat()
                    .body("id", equalTo(1))
                    .statusCode(200);
    }

    @Test
    @DisplayName("Cadastrar uma atividade com paramêtros valídos")
    public void testCadastrarUmaAtividadeComParametrosValidos() {
        given()
                .contentType(ContentType.JSON)
                .body(ActivitiesDataFactory.cadastrarAtividadeValida())
            .when()
                .post("/api/v1/Activities")
            .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Cadastar uma atividade com paramêtros invalídos")
    public void testCadastrarUmaAtividadeComParametrosInvalidos() {
        given()
                .contentType(ContentType.JSON)
                .body(InvalidActivityDataFactory.cadastrarAtividadeInvalida())
            .when()
                .post("/api/v1/Activities")
            .then()
                .assertThat()
                    .body("title", equalTo("One or more validation errors occurred."))
                    .statusCode(400);
    }

    @Test
    @DisplayName("Deletar uma atividade cadastrada")
    public void testDeletarUmaAtividade() {
        baseURI = "https://fakerestapi.azurewebsites.net";
        given()
                .when()
                    .delete("/api/v1/Activities/31")
                .then()
                    .statusCode(200);
    }
}
