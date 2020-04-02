package be.ucm.jds.controllers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import be.ucm.jds.BL.Entity.UtilisateurLogin;
import be.ucm.jds.BL.Entity.UtilisateurRegister;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.time.LocalDate;

public class AuthControllerTest {

    @Before
    public void createUtilisateur() throws JSONException {
        UtilisateurRegister utilisateurRegister = new UtilisateurRegister();
        utilisateurRegister.setEmail("a@a");
        utilisateurRegister.setPassword("Test1234");
        utilisateurRegister.setConfirmpassword("Test1234");
        utilisateurRegister.setPseudo("Test");
        utilisateurRegister.setDateNaissance(LocalDate.now().minusYears(18).minusDays(1));

        given()
                .contentType(ContentType.JSON)
                .body(utilisateurRegister)
                .when()
                .post("http://localhost:8080/inscription");
    }

    @Test
    public void seConnecter_avecUnEmailExistantEtLeBonMotDePasse_200() {
        UtilisateurLogin utilisateur = new UtilisateurLogin();
        utilisateur.setEmail("a@a");
        utilisateur.setPassword("Test1234");

        given()
                .contentType(ContentType.JSON)
                .body(utilisateur)
                .when()
                .post("http://localhost:8080/seConnecter")
                .then()
                .assertThat()
                .statusCode(200)
                .body("email", equalTo("a@a"));
    }

    @Test
    public void seConnecter_avecUnEmailExistantEtMotDePasseManqueChiffre_404() {
        UtilisateurLogin utilisateur = new UtilisateurLogin();
        utilisateur.setEmail("a@a");
        utilisateur.setPassword("Testteset");

        given()
                .contentType(ContentType.JSON)
                .body(utilisateur)
                .when()
                .post("http://localhost:8080/seConnecter")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void seConnecter_avecUnEmailExistantEtMotDePasseManqueMajuscule_404() {
        UtilisateurLogin utilisateur = new UtilisateurLogin();
        utilisateur.setEmail("a@a");
        utilisateur.setPassword("est1234");

        given()
                .contentType(ContentType.JSON)
                .body(utilisateur)
                .when()
                .post("http://localhost:8080/seConnecter")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void seConnecter_avecUnEmailExistantEtMotDePasseTropCourt_404() {
        UtilisateurLogin utilisateur = new UtilisateurLogin();
        utilisateur.setEmail("a@a");
        utilisateur.setPassword("Test123");

        given()
                .contentType(ContentType.JSON)
                .body(utilisateur)
                .when()
                .post("http://localhost:8080/seConnecter")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void seConnecter_avecUnEmailInexistant_404() {
        UtilisateurLogin utilisateur = new UtilisateurLogin();
        utilisateur.setEmail("a@b");
        utilisateur.setPassword("Test1234");

        given()
                .contentType(ContentType.JSON)
                .body(utilisateur)
                .when()
                .post("http://localhost:8080/seConnecter")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void inscription_emailDisponibleEtMotDepasseValideEtIdentiqueEtPlusDe18Ans_200() {
        UtilisateurRegister utilisateurRegister = new UtilisateurRegister();
        utilisateurRegister.setEmail("a@h");
        utilisateurRegister.setPassword("Test1234");
        utilisateurRegister.setConfirmpassword("Test1234");
        utilisateurRegister.setPseudo("Test");
        utilisateurRegister.setDateNaissance(LocalDate.now().minusYears(18).minusDays(1));

        given()
                .contentType(ContentType.JSON)
                .body(utilisateurRegister)
                .when()
                .post("http://localhost:8080/inscription")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void inscription_emailDisponibleEtMotDepasseValideEtIdentiqueEtMoinsDe18Ans_404() {
        UtilisateurRegister utilisateurRegister = new UtilisateurRegister();
        utilisateurRegister.setEmail("a@g");
        utilisateurRegister.setPassword("Test1234");
        utilisateurRegister.setConfirmpassword("Test1234");
        utilisateurRegister.setPseudo("Test");
        utilisateurRegister.setDateNaissance(LocalDate.now().minusYears(17));

        given()
                .contentType(ContentType.JSON)
                .body(utilisateurRegister)
                .when()
                .post("http://localhost:8080/inscription")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void inscription_emailDisponibleEtMotDepasseValideEtDifferentEtPlusDe18Ans_404() {
        UtilisateurRegister utilisateurRegister = new UtilisateurRegister();
        utilisateurRegister.setEmail("a@f");
        utilisateurRegister.setPassword("Test1234");
        utilisateurRegister.setConfirmpassword("Test123");
        utilisateurRegister.setPseudo("Test");
        utilisateurRegister.setDateNaissance(LocalDate.now().minusYears(18).minusDays(1));

        given()
                .contentType(ContentType.JSON)
                .body(utilisateurRegister)
                .when()
                .post("http://localhost:8080/inscription")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void inscription_emailDisponibleEtMotDepasseInvalideEtIdentiqueEtPlusDe18Ans_404() {
        UtilisateurRegister utilisateurRegister = new UtilisateurRegister();
        utilisateurRegister.setEmail("a@e");
        utilisateurRegister.setPassword("Test123");
        utilisateurRegister.setConfirmpassword("Test123");
        utilisateurRegister.setPseudo("Test");
        utilisateurRegister.setDateNaissance(LocalDate.now().minusYears(18).minusDays(1));

        given()
                .contentType(ContentType.JSON)
                .body(utilisateurRegister)
                .when()
                .post("http://localhost:8080/inscription")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void inscription_emailIndisponibleEtMotDepasseValideEtIdentiqueEtPlusDe18Ans_404() {
        UtilisateurRegister utilisateurRegister = new UtilisateurRegister();
        utilisateurRegister.setEmail("a@a");
        utilisateurRegister.setPassword("Test1234");
        utilisateurRegister.setConfirmpassword("Test1234");
        utilisateurRegister.setPseudo("Test");
        utilisateurRegister.setDateNaissance(LocalDate.now().minusYears(18).minusDays(1));

        given()
                .contentType(ContentType.JSON)
                .body(utilisateurRegister)
                .when()
                .post("http://localhost:8080/inscription")
                .then()
                .assertThat()
                .statusCode(404);
    }

}