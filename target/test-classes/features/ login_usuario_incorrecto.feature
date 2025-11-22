Feature: Login con credenciales inválidas
  Como usuario del sistema
  Quiero ingresar con datos incorrectos
  Para verificar que el sistema muestre mensaje de error

  Scenario: Ingreso con usuario o password incorrecto
    Dado que el usuario abre el navegador
    Y ingresa a la pagina de login
    Cuando ingresa usuario o password incorrecto
    Entonces el sistema muestra mensaje de error
