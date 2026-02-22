Automation Framework - Selenium + TestNG + ExtentReports

Descripción
Este proyecto es un framework de automatización de pruebas para la aplicación [SauceDemo](https://www.saucedemo.com/).  
Está construido con Java 11, Maven, Selenium, TestNG y ExtentReports para generación de reportes.

Permite ejecutar pruebas en múltiples navegadores y captura screenshots automáticamente en caso de fallo o éxito de los tests.

Estructura del proyecto:
automation-framework/
├── src/
│ ├── main/java/pages/ # Páginas de la aplicación (Page Objects)
│ ├── test/java/base/ # BaseTest y DriverFactory
│ ├── test/java/listeners/ # Listener para ExtentReports
│ ├── test/java/tests/ # Casos de prueba
├── reports/ # Reportes de ExtentReports
├── screenshots/ # Capturas de pantalla de los tests
├── pom.xml # Dependencias y configuración de Maven
├── testng.xml # Suite de TestNG
└── README.md # Este archivo


Requisitos
- Java 11 o superior  
- Maven instalado  
- Git (opcional, para clonar el repositorio)  

--------------------

Instalación

1. Clonar el repositorio:

```bash

git clone https://github.com/TU_USUARIO/automation-framework.git

2.  Entrar en la carpeta del proyecto:

cd automation-framework

3.  Descargar dependencias con Maven:

mvn clean install

4.  Ejecutar tests

Para ejecutar todos los tests:

mvn test

5. Reportes y screenshots

Los reportes de ExtentReports se generan en:

reports/ExtentReport.html

6.  Los screenshots de los tests (fallidos o exitosos) se guardan en:

screenshots/

----------------------------------------

Casos de prueba incluidos
Test Case 1 – Login exitoso

Given usuario válido
When ingresa credenciales correctas
Then accede al inventario

Test Case 2 – Login inválido

Given usuario bloqueado
When ingresa contraseña incorrecta
Then se muestra mensaje de error

Test Case 3 – Login sin credenciales

Given campos vacíos
When intenta loguearse
Then se muestra validación