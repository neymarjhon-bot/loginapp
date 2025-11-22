Feature: Registro de hora médica veterinaria
  Como cliente del sistema
  Quiero registrar mis datos y los de mi mascota
  Para agendar una hora médica veterinaria

  Scenario: Registrar una hora médica veterinaria
    Dado que el usuario abre el navegador
    Y ingresa a la pagina de registro
    Cuando completa el formulario de registro de persona y mascota
    Entonces el sistema confirma el registro exitoso
