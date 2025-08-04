


# 💣 Buscaminas en Consola 💣

## Descripción del Proyecto

Este proyecto es una implementación del clásico juego de Buscaminas, desarrollado en Java para ejecutarse en la consola. El objetivo es que el jugador descubra todas las casillas seguras en un tablero de 10x10 con 10 minas ocultas, evitando detonar alguna de ellas.

El desarrollo del proyecto se ha realizado como un examen final para la asignatura de Programación Orientada a Objetos (POO), aplicando los principios y buenas prácticas más importantes de la ingeniería de software:
* **Patrón de diseño Modelo-Vista-Controlador (MVC)**.
* Uso de **herencia y polimorfismo** para modelar los elementos del juego.
* **Encapsulamiento** y relaciones de clase bien diseñadas.
* Manejo robusto de **excepciones personalizadas** y estándar.
* **Persistencia de datos** mediante serialización para guardar y cargar partidas.
* Implementación de **pruebas unitarias** con JUnit 5, siguiendo un enfoque de **Desarrollo Guiado por Pruebas (TDD)** en las etapas iniciales del modelo.

---

## 🚀 Instalación y Ejecución

Para compilar y ejecutar este proyecto, necesitas tener instalado el **Java Development Kit (JDK)** versión 11 o superior y un gestor de dependencias como Maven o Gradle, o configurar las librerías de JUnit 5 en tu IDE.

### Estructura de Archivos
El proyecto está organizado en una estructura de paquetes lógica, separando el modelo, la vista y el controlador, con una carpeta dedicada a las pruebas unitarias.

### Desde un IDE (IntelliJ IDEA, Eclipse, VS Code)

1.  Clona este repositorio en tu máquina local:
    ```bash
    git clone [https://github.com/PastFlex1/Examen-POO.git](https://github.com/PastFlex1/Examen-POO.git)
    ```
2.  Abre el proyecto en tu IDE preferido.
3.  Asegúrate de que la configuración del proyecto reconozca las carpetas `src` y `src/test` como "Source Roots" y "Test Source Roots", respectivamente.
4.  Localiza el archivo `Main.java` dentro del directorio `src`.
5.  Ejecuta la clase `Main` (normalmente, haciendo clic derecho y seleccionando "Run" o usando el botón de "play" en la barra de herramientas).

### Desde la Línea de Comandos

1.  Navega hasta la raíz del proyecto.
2.  Compila los archivos `.java`:
    ```bash
    javac -d bin src/**/*.java
    ```
3.  Ejecuta la aplicación:
    ```bash
    java -cp bin Main
    ```
### Ejecución de Pruebas Unitarias

Para ejecutar las pruebas unitarias, necesitarás las librerías de JUnit 5 en tu classpath. Desde tu IDE, puedes hacer clic derecho en la carpeta `src/test/model` o en un archivo de prueba individual y seleccionar "Run Tests".

---

## 🕹️ Uso del Juego

El juego se ejecuta en la consola y te pedirá que ingreses comandos para interactuar con el tablero.

### Comandos Disponibles

* **Coordenada (`A5`)**: Descubre la casilla en la fila A, columna 5. Si es una casilla con mina, pierdes. Si es segura, se revela su contenido.
* **Marcar (`MA5`)**: Marca la casilla en la fila A, columna 5, con una bandera ('F'). Esto sirve para recordar dónde crees que hay una mina.
* **Guardar (`G`)**: Guarda el estado actual del juego en un archivo llamado `juego_guardado.ser`.
* **Cargar (`L`)**: Carga un juego previamente guardado desde el archivo `juego_guardado.ser`.


## 🤝 Colaboración y Repositorio

El desarrollo de este proyecto se gestionó utilizando un repositorio de GitHub.El repositorio del proyecto es:

[https://github.com/PastFlex1/Examen-POO.git](https://github.com/PastFlex1/Examen-POO.git)

### Historial de Commits

* **`fix: Solucion de error en Tablero.java`**: Corrección de un `NullPointerException` en la inicialización de la matriz de casillas.
* **`feat: Implementacion de persistencia de datos (guardar/cargar)`**: Adición de la funcionalidad de serialización para guardar y cargar partidas.
* **`refactor: Introducción de herencia y polimorfismo en las clases Casilla`**: Se mejoró el diseño del modelo para usar herencia con las clases `Casilla`, `CasillaMina` y `CasillaNumero`.
* **`test: Creación de pruebas unitarias para el modelo con JUnit 5`**: Se implementaron pruebas exhaustivas para validar la lógica de las clases `Tablero`, `Casilla` y `JuegoBuscaminas`.


## 👨‍💻 Equipo de Desarrollo

* Alex Palma
