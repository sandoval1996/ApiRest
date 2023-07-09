Feature: Eliminar Usuario
  @Api
  Scenario Outline: Eliminar Usuario
    Given Quiero eliminar usuario con ID
    |Id  |
    |<idsUsers>|
    Then Verifico el codigo 204
    Examples:
      | idsUsers |
      | 1  |
      | 2  |
      | 3  |