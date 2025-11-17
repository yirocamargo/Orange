   @Regresion
   Feature: ingreso a la pagina

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
       And diligencie name <name> y apellido <lastName> rutaFoto <rutaFoto>
       And llegar a la opcion directory
       And busqueda name <name> y apellido <lastName>
       When validar info name <name> y apellido <lastName>
       Examples:
         | user  | pass     | name    | lastName  | rutaFoto |
         | Admin | admin123 | Yiro2    | Camargo1  | C:\Proyectos Automatizacion\OrangeHrm\src\test\java\Orange\Fhoto\Foto.jpg |

