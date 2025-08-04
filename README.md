# 💣 Buscaminas en Consola 💣

## Descripción del Proyecto

Este proyecto es una implementación del clásico juego de Buscaminas, desarrollado en Java para ejecutarse en la consola. El objetivo es que el jugador descubra todas las casillas seguras en un tablero de 10x10 con 10 minas ocultas, evitando detonar alguna de ellas.

El proyecto ha sido desarrollado como un examen final para la asignatura de Programación Orientada a Objetos (POO), aplicando conceptos como:
* Patrón de diseño **Modelo-Vista-Controlador (MVC)**.
* Uso de **herencia y polimorfismo**.
* **Encapsulamiento** y relaciones de clase.
* Manejo de **excepciones personalizadas** y estándar.
* **Persistencia de datos** para guardar y cargar partidas.
* Principios de **código limpio**.

---

## 🚀 Instalación y Ejecución

Para compilar y ejecutar este proyecto, necesitas tener instalado el **Java Development Kit (JDK)** versión 11 o superior.

### Desde un IDE (IntelliJ IDEA, Eclipse, VS Code)

1.  Clona este repositorio en tu máquina local:
    ```bash
    git clone https://github.com/PastFlex1/Examen-POO.git
    ```
2.  Abre el proyecto en tu IDE preferido.
3.  Asegúrate de que la estructura de directorios del proyecto coincida con la siguiente:
    ```
    src/
    ├── controller/
    ├── exceptions/
    ├── model/
    └── view/
    ```
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

---

## 🕹️ Uso del Juego

El juego se ejecuta en la consola y te pedirá que ingreses comandos para interactuar con el tablero.

### Comandos Disponibles

* **Coordenada (`A5`)**: Descubre la casilla en la fila A, columna 5. Si la casilla está vacía, el juego revelará automáticamente las casillas adyacentes hasta encontrar números. Si es una mina, pierdes el juego.
* **Marcar (`MA5`)**: Marca la casilla en la fila A, columna 5, con una bandera ('F'). Esto sirve para recordar dónde crees que hay una mina y evitar seleccionarla. Si la casilla ya está marcada, este comando la desmarcará.
* **Guardar (`G`)**: Guarda el estado actual del juego en un archivo llamado `juego_guardado.ser`.
* **Cargar (`L`)**: Carga un juego previamente guardado desde el archivo `juego_guardado.ser`.


## 🤝 Colaboración y Repositorio

El desarrollo de este proyecto se gestionó utilizando un repositorio de GitHub, demostrando la colaboración del equipo a través de *commits* significativos y claros.

### Historial de Commits

A continuación se muestra una parte del historial de commits, que refleja las etapas del desarrollo:

* **`Solucion de error en Tablero.java`**: Corrección de un `NullPointerException` en la inicialización de la matriz de casillas.
* **`¡El juego tiene memoria! Implementación de la función guardar/cargar.`**: Adición de la persistencia de datos mediante serialización para guardar y cargar partidas.
* **`Implementacion de cada seccion del buscaminas`**: *Commit* inicial que establece la estructura del proyecto y las clases principales del modelo, vista y controlador.

---

## 👨‍💻 Equipo de Desarrollo

* **[Alex Palma]**
