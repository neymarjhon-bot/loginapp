package com.platinum.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistroVeterinariaSteps {

    WebDriver driver;

    @Given("que estoy en la página de registro veterinario")
    public void abrirRegistro() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/CtaCorriente/registro.jsp");
    }

    @When("ingreso el rut {string}")
    public void ingresoRut(String rut) {
        driver.findElement(By.id("rut")).sendKeys(rut);
    }

    @When("ingreso el nombre {string}")
    public void ingresoNombre(String nombre) {
        driver.findElement(By.id("nombre")).sendKeys(nombre);
    }

    @When("ingreso la mascota {string}")
    public void ingresoMascota(String mascota) {
        driver.findElement(By.id("mascota")).sendKeys(mascota);
    }

    @When("presiono registrar")
    public void presionoRegistrar() {
        driver.findElement(By.id("btnRegistrar")).click();
    }

    @Then("se debe mostrar el mensaje {string}")
    public void mensajeExito(String mensaje) {
        driver.getPageSource().contains(mensaje);
        driver.quit();
    }
}
