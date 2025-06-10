
Desarrollo del Videojuego de Batalla Pokémon: Trabajo en equipo entre Jualex y Mairin

Como parte del proyecto final de programación orientada a objetos, mi compañero Jualex y yo, Mairin, desarrollamos un videojuego de batalla por turnos inspirado en Pokémon. El juego fue desarrollado en Java usando conceptos fundamentales de la POO como clases, objetos, herencia, encapsulamiento y modularización del código. El objetivo fue simular una batalla contra entrenadores Pokémon, donde el jugador crea su equipo y combate contra un oponente controlado por la máquina. A continuación, explico cómo nos dividimos las tareas y lo que hizo cada uno.

🧠 Trabajo de Jualex – Lógica de flujo principal y selección del jugador
fui el encargado de diseñar y codificar todo el flujo principal del juego, es decir, lo que ocurre desde que el programa arranca hasta que comienza el combate. Esto incluye:

Bienvenida y entrada de datos:

1. Pidi el nombre del jugador por consola usando Scanner.
2. Mostre un mensaje introductorio claro para el usuario.

Selección personalizada de equipo Pokémon:

1. Mostre una lista de Pokémon disponibles, con su número y tipo.
2. Valide que el jugador solo pudiera elegir 3 Pokémon distintos.
3. Use un arreglo booleano elegido[] para evitar elecciones repetidas.
4. Maneje errores con try-catch para evitar fallos si el jugador ingresaba letras u opciones inválidas.

Creación del rival aleatorio:

1. Defini los equipos de Ash, Misty, Brock y Serena.
2. Seleccione un rival al azar usando la clase Random.
3. Mostre al jugador qué entrenador fue elegido y qué Pokémon usará ese rival.

Instancia de combate:
Una vez configurados los entrenadores, llamé al método iniciar() del objeto Combate para comenzar la pelea.

En resumen, construí toda la parte donde el jugador interactúa con el juego antes del combate, Donde el jugador puede personalizar su equipo y enfrentarse a un rival diferente cada vez.

⚔️ Trabajo de Mairin – Sistema de combate y clases del juego
fui responsable de toda la lógica del combate y la estructura interna del juego. Mis aportes son fundamentales para que la batalla funcione correctamente y tenga sentido en términos de estrategia. Esto incluye:

Clases de Pokémon:

1. Cree una clase base llamada Pokemon, que contiene atributos como nombre, tipo, salud (vida) y una lista de ataques.
2. Implemente subclases como PokemonAgua, PokemonFuego, PokemonRoca, PokemonHada y PokemonElectrico, que heredan de Pokemon y tienen ataques diferentes según su tipo.

Sistema de ataque y efectividad:

1. Programe la clase Ataque, que contiene el nombre y el daño base.
2. Añadi un sistema que calcula si un ataque es más o menos efectivo dependiendo del tipo del Pokémon rival (por ejemplo, el agua es fuerte contra fuego).
Esta lógica de efectividad está implementada dentro del combate, afectando el daño final de cada ataque.

Clase Entrenador:

1. Cree la clase Entrenador, que contiene el nombre del entrenador y su equipo Pokémon.
Esta clase se usa tanto para el jugador como para el rival.

Combate por turnos:

1. Implemente la clase Combate, donde programó toda la pelea:
2. El jugador elige su Pokémon activo y el ataque a usar.
3. El rival selecciona Pokémon y ataques aleatoriamente.
4. Se muestran mensajes del combate paso a paso (quién ataca, cuánto daño hace, si es efectivo, etc.).
5. Se verifica si un Pokémon fue derrotado, y se pide al jugador elegir otro si es necesario.
6. El combate termina cuando todos los Pokémon de un equipo pierden su vida.

En resumen, construí todo lo que pasa dentro del combate, haciendo posible que los ataques, los efectos y la estrategia existan.
