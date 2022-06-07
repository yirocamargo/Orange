#01/06/2022
@Regresion
Feature: Manejo de data por medio de excel

@Excel
Scenario Outline: agregar usuario administrador
Given open browser
  And diligenciar user <user> and contraseña <pass>
  And llegar a agregar un usuario
  When diligencie el nombre de la hoja <sheetName> y numero de columna <rowNumber>
  Examples:
    | user  | pass     | sheetName   | rowNumber |
    | Admin | admin123 | RegTestData | 0         |