# 🎮 Videojuego de Batalla por Turnos - Inspirado en Pokémon

Este videojuego fue desarrollado como parte del examen final del curso de **Programación Orientada a Objetos**. Está inspirado en el sistema de combate por turnos de Pokémon y construido totalmente en Java, utilizando conceptos clave como:

* Clases
* Herencia
* Encapsulamiento
* Modularización
* Manejo de errores

---

# 💡 Propuesta de Valor

* Videojuego educativo y entretenido que refuerza los fundamentos de la Programación Orientada a Objetos.
* Simulación de combates estratégicos con ataques, tipos y efectividad.
* Código modular y reutilizable, ideal como base para proyectos más grandes o ejercicios académicos.

# 👥 Segmento de Usuarios

* Estudiantes de programación en Java (nivel intermedio).
* Profesores que desean enseñar POO con ejemplos prácticos.
* Comunidad de desarrollo open source interesada en videojuegos educativos.

# 🔗 Relación con los Usuarios

* Documentación clara del código y del flujo del juego.
* Manual de uso incluido en este repositorio.
* Soporte básico a través de issues en GitHub.
* Posibilidad de expandir el juego con nuevas funciones, personajes o interfaz gráfica.

# 🧰 Recursos Clave

* Lenguaje Java y conocimientos en programación orientada a objetos.
* Clases diseñadas: `Pokemon`, `Ataque`, `Entrenador`, `Combate`, entre otras.

# 👨‍💻 Equipo de desarrollo:

* **Jualex**: flujo del juego, selección de personajes y lógica de entrada.

* **Mairin**: estructura de clases, lógica del combate y sistema de daño.

* Uso de paquetes como `Scanner` y `Random`.

# 🛠️ Clave de Actividades

* Desarrollo de clases Java y su estructura jerárquica.
* Implementación del sistema de combate por turnos.
* Validación de entradas, manejo de errores y aleatoriedad en oponentes.
* Planeación modular para futuras expansiones (por ejemplo, GUI).

# ✅ Conclusión

Este proyecto demuestra cómo aplicar los conceptos de la Programación Orientada a Objetos a un sistema real y funcional. Además de ser un videojuego entretenido, sirve como una herramienta educativa versátil para quienes deseen aprender Java de forma práctica y divertida.

---

# 👦 Trabajo de Jualex – Lógica de flujo principal y selección del jugador

Fui el encargado de diseñar y codificar todo el flujo principal del juego, desde que el programa arranca hasta que comienza el combate. Esto incluye:

# Bienvenida y entrada de datos:

* Pedí el nombre del jugador por consola usando `Scanner`.
* Mostré un mensaje introductorio claro para el usuario.

# Selección personalizada de equipo Pokémon:

* Mostré una lista de Pokémon disponibles, con su número y tipo.
* Validé que el jugador solo pudiera elegir 3 Pokémon distintos.
* Utilicé un arreglo booleano `elegido[]` para evitar elecciones repetidas.
* Maneje errores con `try-catch` para evitar fallos si el jugador ingresaba letras u opciones inválidas.

# Creación del rival aleatorio:

* Definimos los equipos de Ash, Misty, Brock y Serena.
* Se selecciona un rival al azar usando la clase `Random`.
* Se muestra al jugador qué entrenador fue elegido y qué Pokémon usará ese rival.

# Instancia de combate:

Una vez configurados los entrenadores, llamé al método `iniciar()` del objeto `Combate` para comenzar la pelea.

 En resumen, construí toda la parte donde el jugador interactúa con el juego antes del combate, permitiendo personalizar su equipo y enfrentarse a un rival diferente cada vez.

---

# 🛡️ Trabajo de Mairin – Sistema de combate y clases del juego

Fui responsable de toda la lógica del combate y la estructura interna del juego. Mis aportes son fundamentales para que la batalla funcione correctamente y tenga sentido en términos de estrategia. Esto incluye:

# Clases de Pokémon:

* Creé una clase base llamada `Pokemon`, con atributos como nombre, tipo, salud y lista de ataques.
* Implementé subclases como `PokemonAgua`, `PokemonFuego`, `PokemonRoca`, `PokemonHada` y `PokemonElectrico`.

# Sistema de ataque y efectividad:

* Programé la clase `Ataque`, con nombre y daño base.
* Añadí un sistema que calcula si un ataque es más o menos efectivo según el tipo del Pokémon rival.

# Clase de Entrenador:

* Creé la clase `Entrenador`, que contiene el nombre y su equipo Pokémon.
* Usada tanto para el jugador como para el rival.

# Combate por turnos:

* Implementé la clase `Combate`, con la siguiente lógica:

  * El jugador elige su Pokémon activo y el ataque a usar.
  * El rival selecciona Pokémon y ataques aleatoriamente.
  * Se muestran mensajes del combate paso a paso.
  * Se verifica si un Pokémon fue derrotado.
  * El combate termina cuando un equipo pierde todos sus Pokémon.

En resumen, construí todo lo que pasa dentro del combate, haciendo posible que los ataques, los efectos y la estrategia existan.

---

# 🔄 SDLC - Ciclo de Vida del Desarrollo de Software

# Proyecto Final: Videojuego de Pelea tipo Pokémon (Java OOP)

1. **Recolección de Requisitos**

   * Lenguaje: Java
   * POO: herencia, encapsulamiento, modularización
   * Flujo funcional y documentado

2. **Análisis**

   * Elección de entrenador
   * 3 Pokémon por entrenador
   * Ataques por turnos
   * Efectividad de tipos

3. **Diseño**

   * Clases: Ataque, Pokemon, subclases
   * Entrenador, Combate, Main

4. **Implementación**

   * Mairin: lógica OOP
   * Jualex: flujo y entradas

5. **Pruebas**

   * Daño, ataques, validaciones

6. **Despliegue**

   * Ejecutado en consola
   * Repositorio GitHub

7. **Mantenimiento**

   * Código escalable y documentado

---

# 📊 UML (Modelo de Clases)

```plaintext
+----------------+
|    Ataque      |
+----------------+
| - nombre: String
| - danio: int
+----------------+
| +getNombre(): String
| +getDanio(): int
+----------------+
       ▲
       |
       |
+----------------------------+
|      <<abstract>> Pokémon |
+----------------------------+
| #nombre: String            |
| #vida: int                 |
| #ataques: Ataque[]         |
+----------------------------+
| +getNombre(): String       |
| +getVida(): int            |
| +recibirDanio(int): void   |
| +atacar(Pokemon): int      |
| +getAtaques(): Ataque[]    |
+----------------------------+
   ▲        ▲        ▲
   |        |        |
+-------+ +-------+ +--------+
| Agua  | | Fuego | | Planta |
+-------+ +-------+ +--------+

+----------------------------+
|        Entrenador          |
+----------------------------+
| - nombre: String           |
| - equipo: Pokemon[]        |
| - pokemonActivo: int       |
+----------------------------+
| +getNombre(): String       |
| +getEquipo(): Pokemon[]    |
| +elegirPokemon(): void     |
| +mostrarEquipo(): void     |
| +getPokemonActivo(): Pokemon |
| +cambiarPokemon(int): void |
+----------------------------+

+----------------------------+
|           Main             |
+----------------------------+
| +main(String[]): void      |
+----------------------------+
| - Scanner input            |
| - Random random            |
| - flujo del juego          |
| - menú de acciones         |
| - IA del oponente          |
| - turnos de combate        |
| - impresión de estado      |
+----------------------------+
```
