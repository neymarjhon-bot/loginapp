Feature: Login de ejecutivo con credenciales válidas
  Como ejecutivo del sistema
  Quiero ingresar con un RUT válido
  Para acceder al menú principal del sistema

  Scenario: Ingreso con usuario válido registrado en la base de datos
    Dado que el usuario abre el navegador
    Y ingresa a la pagina de login
    Cuando ingresa el usuario valido
    Entonces accede al menu principal
