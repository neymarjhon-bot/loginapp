package com.platinum.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginIncorrectoSteps {

    WebDriver driver;

    @Given("que abro el navegador y accedo a la página de login")
    public void abrirLogin() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/CtaCorriente/login.jsp");
    }

    @When("ingreso el nombre de usuario incorrecto {string}")
    public void usuarioIncorrecto(String usuario) {
        driver.findElement(By.id("usuario")).sendKeys(usuario);
    }

    @When("ingreso la contraseña incorrecta {string}")
    public void passIncorrecto(String pass) {
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @When("presiono el botón de ingresar")
    public void presionarLogin() {
        driver.findElement(By.id("btnLogin")).click();
    }

    @Then("debo ver un mensaje de error")
    public void verMensajeError() {
        driver.getPageSource().contains("Error");
        driver.quit();
    }
}
