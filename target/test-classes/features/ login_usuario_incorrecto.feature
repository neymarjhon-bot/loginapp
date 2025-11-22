Característica: Login incorrecto
  Escenario: Login fallido con credenciales incorrectas
    Dado que abro el navegador y accedo a la página de login para credenciales incorrectas
    Cuando ingreso el nombre de usuario incorrecto "usuarioIncorrecto"
    Y ingreso la contraseña incorrecta "passwordIncorrecto"
    Y presiono el botón de ingresar con credenciales incorrectas
    Entonces debo ver un mensaje de error
