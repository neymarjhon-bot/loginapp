package com.platinum.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginIncorrectoSteps {

    WebDriver driver;

    @Given("que abro el navegador y accedo a la página de login con credenciales incorrectas")
    public void abrirLoginIncorrecto() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/CtaCorriente/login.jsp");
    }

    @When("ingreso un nombre de usuario incorrecto {string}")
    public void ingresoUsuarioIncorrecto(String usuario) {
        driver.findElement(By.id("usuario")).sendKeys(usuario);
    }

    @When("ingreso una contraseña incorrecta {string}")
    public void ingresoPasswordIncorrecto(String pass) {
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @When("presiono el botón de ingresar con credenciales incorrectas")
    public void presionarLoginIncorrecto() {
        driver.findElement(By.id("btnLogin")).click();
    }

    @Then("debo ver un mensaje de error de credenciales")
    public void verMensajeError() {
        driver.getPageSource().contains("Error");
        driver.quit();
    }
}
