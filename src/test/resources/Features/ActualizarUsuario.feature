Feature: Actualizar Usuario

  @Api
  Scenario Outline: Actualizacion de Usuario
    Given crear usuario con data random
    When I quiero actualizar usuario
    | IdUser  |
    | <id>|
    Then validar codigo de respuesta 200
    Then Validar que se actualizo el nombre usuario
    Examples:
      | id  |
      | 1   |
      | 2   |
      | 3   |