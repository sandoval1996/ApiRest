Feature: Listar Usuarios

  @Api
  Scenario: LISTAR USUARIOS EXITOSAMENTE
    Given Quiero listar los usuarios registrados en la api
    Then Verifico el codigo 200
    And  Verifico que se listen