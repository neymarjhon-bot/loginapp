package com.platinum.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidoSteps {

    WebDriver driver;

    @Given("que abro el navegador y accedo a la página de login para credenciales válidas")
    public void abrirLoginValido() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/CtaCorriente/login.jsp");
    }

    @When("ingreso el nombre de usuario {string}")
    public void ingresoUsuario(String usuario) {
        driver.findElement(By.id("usuario")).sendKeys(usuario);
    }

    @When("ingreso la contraseña {string}")
    public void ingresoPassword(String pass) {
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @When("presiono el botón de ingresar con credenciales válidas")
    public void presionarLoginValido() {
        driver.findElement(By.id("btnLogin")).click();
    }

    @Then("debo ver la página del menú principal")
    public void verMenuPrincipal() {
        driver.getPageSource().contains("Bienvenido");
        driver.quit();
    }
}
