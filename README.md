
Desarrollo del Videojuego de Batalla Pokémon: Trabajo en equipo entre Jualex y Mairin

Como parte del proyecto final de programación orientada a objetos, mi compañero Jualex y yo, Mairin, desarrollamos un videojuego de batalla por turnos inspirado en Pokémon. El juego fue desarrollado en Java usando conceptos fundamentales de la POO como clases, objetos, herencia, encapsulamiento y modularización del código. El objetivo fue simular una batalla entre entrenadores Pokémon, donde el jugador escoge su equipo y combate contra un oponente controlado por la máquina. A continuación, explico cómo nos dividimos las tareas y lo que hizo cada uno.

Aportes de Mairin: Diseño Base del Juego y la Estructura de los Pokémon
Mi trabajo se centró principalmente en diseñar las clases base del sistema, encargándome de la estructura orientada a objetos. Implementé las siguientes partes:

Clase Ataque: Define el nombre y el daño que hace cada ataque. Se utiliza para asociar ataques con los Pokémon.

Clase abstracta Pokemon: Sirve como plantilla base para todos los Pokémon del juego. Incluye atributos como nombre, vida y ataques, así como métodos para recibir daño, verificar si el Pokémon sigue vivo y acceder a sus datos.

Subclases de Pokémon por tipo: Implementé diferentes clases que heredan de Pokemon, como PokemonFuego, PokemonAgua, PokemonHada, PokemonRoca, y PokemonElectrico. Cada una se inicializa con dos ataques propios.

Clase Entrenador: Representa al jugador o al oponente. Contiene un nombre y un equipo de tres Pokémon. Incluye métodos para saber si le quedan Pokémon vivos y cuál es el próximo que luchará.

Mi enfoque fue asegurar una buena reutilización del código y facilitar la organización de los Pokémon en equipos distintos para cada entrenador.

Aportes de Jualex: Lógica del Combate y Experiencia del Jugador
Jualex se encargó principalmente de la lógica del combate, de la interacción con el jugador y del flujo principal del programa. Lo que él desarrolló incluye:

Clase Combate: Esta clase gestiona el sistema de batalla por turnos. Implementó un bucle que se repite mientras ambos entrenadores tengan Pokémon vivos. En cada turno, el jugador elige el ataque, y el oponente responde con uno aleatorio. La clase controla la aplicación del daño, muestra mensajes en pantalla e informa cuando un Pokémon es derrotado.

Método elegirAtaque(): Permite al jugador elegir entre los ataques disponibles de su Pokémon, con validación de entrada para evitar errores.

Flujo del juego en la clase Main: Jualex implementó todo lo relacionado con el menú inicial. El jugador selecciona su entrenador (Ash, Serena, Misty o Brock), y el sistema elige aleatoriamente un oponente diferente. Luego se inicia la batalla llamando al método iniciar() de la clase Combate.

Su enfoque fue crear una experiencia dinámica y fácil de usar para el jugador, además de controlar la lógica del combate de forma clara.

Conclusión: Trabajo en Equipo 
El desarrollo del proyecto se realizó dividiendo claramente las responsabilidades: Mairin se encargó del diseño de las clases base y la estructura OOP, y Jualex se enfocó en la interacción, el flujo del juego y la lógica de combate. Gracias a esta organización, logramos crear un sistema modular, fácil de mantener y ampliable en futuras versiones (por ejemplo, agregando más tipos de Pokémon o habilidades especiales).
# Examen-Final
