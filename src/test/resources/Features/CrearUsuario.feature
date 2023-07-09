Feature: Creacion Usuarios

  @Api
  Scenario: Crear Usuarios
    Given crear usuario con data random
    When Crear usuario
    Then verifico que se cree
    Then Se verifica codigo 201