package com.platinum.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static org.junit.Assert.assertTrue;

public class StepsDefinitions {

    WebDriver driver;

    @Dado("que el usuario abre el navegador")
    public void abrirNavegador() {
        driver = new ChromeDriver();
    }

    @Cuando("ingresa a la pagina de login")
    public void irLogin() {
        driver.get("http://localhost:8080/CtaCorriente/login.jsp");
    }

    @Cuando("ingresa el usuario valido")
    public void ingresarUsuarioValido() {
        driver.findElement(By.name("rut")).sendKeys("12345678-9");
        driver.findElement(By.name("btnLogin")).click();
    }

    @Entonces("accede al menu principal")
    public void validarMenu() {
        assertTrue(driver.getPageSource().contains("Bienvenido"));
        driver.quit();
    }

    @Cuando("ingresa usuario o password incorrecto")
    public void ingresarUsuarioIncorrecto() {
        driver.findElement(By.name("rut")).sendKeys("00000000-0");
        driver.findElement(By.name("btnLogin")).click();
    }

    @Entonces("el sistema muestra mensaje de error")
    public void validarMensajeError() {
        assertTrue(driver.getPageSource().contains("Ejecutivo no encontrado"));
        driver.quit();
    }
}
