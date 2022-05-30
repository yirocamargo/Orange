   @Regresion
   Feature: infreso a la pagina

     @Login
     Scenario Outline: login credenciales exitosas
       Given open browser
       And diligenciar user <user> and contraseña <pass>
       Examples:
         | user  | pass     |
         | Admin | admin123 |

     @AddEmployee
     Scenario Outline: crear un empleado nuevo
       Given open browser
       And diligenciar user <user> and contraseña <pass>
       And llegar a la opcion agregar empleados
       When diligencie name <name> middl<middleName> y apellido <lastName>
       Examples:
         | user  | pass     | name | middleName | lastName |
         | Admin | admin123 | Emma | Valentina  | Cammargo |
