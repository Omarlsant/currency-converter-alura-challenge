# Challenge ONE | Conversor de Monedas

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Maven](https://img.shields.io/badge/Maven-4.0.0-blue.svg)
![Gson](https://img.shields.io/badge/Gson-2.10.1-green.svg)

## 📝 Descripción del Proyecto

Este es un conversor de monedas desarrollado en Java como parte de un challenge de programación. La aplicación funciona a través de la consola y permite a los usuarios convertir valores entre diferentes monedas, consumiendo los datos de tasas de cambio en tiempo real desde la API de [ExchangeRate-API](https://www.exchangerate-api.com/).

## ✨ Características Principales

-   **Interfaz de Consola:** Menú interactivo para una fácil navegación por parte del usuario.
-   **Consumo de API:** Se conecta a una API externa para obtener las tasas de cambio más recientes.
-   **Conversiones Bidireccionales:** Permite conversiones de las siguientes monedas internacionales:
    -   Dólar estadounidense (USD)
    -   Sol Peruano (PEN)
    -   Peso Argentino (ARS)
    -   Real Brasileño (BRL)
    -   Peso Colombiano (COP)
    -   Boliviano boliviano (BOB)
    -   Peso chileno (CLP)

-   **Código Modular:** El proyecto está estructurado en clases con responsabilidades únicas (cliente API, lógica principal), siguiendo buenas prácticas de programación.

## 🛠️ Tecnologías Utilizadas

-   **Java 21:** Lenguaje de programación principal.
-   **Java `HttpClient`:** Para realizar las solicitudes HTTP a la API.
-   **Gson:** Biblioteca de Google para parsear (convertir) las respuestas JSON de la API a objetos Java.
-   **Maven:** Herramienta para la gestión de dependencias y la construcción del proyecto.

## 🚀 Cómo Ejecutar el Proyecto

### Prerrequisitos

-   Tener instalado Java JDK 11 o una versión superior.
-   Tener instalado [Apache Maven](https://maven.apache.org/download.cgi).
-   Obtener una API Key gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/signup).

### Pasos

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/Omarlsant/alura-challenge-currency-converter
    cd alura-challenge-currency-converter
    ```

2.  **Configurar la API Key:**
    -   Abre el archivo `src/main/java/com/challenge/conversor/ApiCliente.java`.
    -   Busca la línea `String apiKey = "TU_API_KEY";` y reemplaza `"TU_API_KEY"` con tu clave personal.

3.  **Compilar y Ejecutar con Maven:**
    -   Abre una terminal en la raíz del proyecto.
    -   Compila el proyecto:
        ```bash
        mvn compile
        ```
    -   Ejecuta la aplicación:
        ```bash
        mvn exec:java -Dexec.mainClass="com.challenge.conversor.Principal"
        ```

¡Y listo! La aplicación se iniciará en tu consola.

## 👨‍💻 Autor

-   **Omar Lengua** - [Perfil de GitHub](https://github.com/Omarlsant).