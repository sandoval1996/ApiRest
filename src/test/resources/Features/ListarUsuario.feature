Feature: Listar Usuario
  @Api
  Scenario Outline: lISTAR UN USUARIO
    Given Yo quiero obtener un usuario con id
    |Id   |Firstname |
    |<id> |<firstname>|
    Then verifico que se genere codigo 200
    And  verifico que tenga ID
    And verfico que tenga nombre
    Examples:
      | id | firstname |
      | 1  | George    |
      | 2  | Janet     |
      | 3  | Emma      |
      | 4  | Eve       |