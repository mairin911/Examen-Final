import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
// =======================
// === JUALEX & MAIRIN: FLUJO PRINCIPAL DEL JUEGO, EQUIPO PERSONALIZADO Y COMBATE ===
// =======================
public class Main { // Clase principal que contiene el método main y gestiona el flujo del juego
    static Scanner scanner = new Scanner(System.in); // Scanner para leer entradas del usuario desde la consola
    static Random random = new Random();             // Random para decisiones aleatorias (como el oponente)

    public static void main(String[] args) { // Método principal que inicia el juego
        System.out.println("\n🎮 BIENVENIDO AL GRAN TORNEO DE BATALLA POKÉMON 🎮\n");  

        // === NUEVO: EL USUARIO CREA SU EQUIPO PERSONALIZADO ===
        // Lista de Pokémon disponibles para elegir
        Pokemon[] disponibles = { // Lista de Pokémon disponibles para que el jugador elija
            new PokemonElectrico("Pikachu"),  
            new PokemonFuego("Charizard"),
            new PokemonAgua("Squirtle"),
            new PokemonHada("Sylveon"),
            new PokemonFuego("Braixen"),
            new PokemonAgua("Piplup"),
            new PokemonAgua("Staryu"),
            new PokemonAgua("Psyduck"),
            new PokemonHada("Togepi"),
            new PokemonRoca("Onix"),
            new PokemonRoca("Geodude"),
            new PokemonFuego("Vulpix")
        };

        // El usuario ingresa su nombre
        System.out.print("¿Cuál es tu nombre de entrenador? "); // Pide al usuario que ingrese su nombre
        String nombreJugador = scanner.nextLine(); // Lee el nombre ingresado por el usuario

        // El usuario elige 3 Pokémon
        Pokemon[] equipoJugador = new Pokemon[3]; // Crea un arreglo para el equipo del jugador con espacio para 3 Pokémon
        boolean[] elegido = new boolean[disponibles.length]; // Crea un arreglo para llevar el control de qué Pokémon ya han sido elegidos (inicialmente todos son false)
        for (int i = 0; i < 3; i++) { // Bucle para que el jugador elija 3 Pokémon
            System.out.println("\nElige tu Pokémon #" + (i + 1) + ":"); // Muestra el número del Pokémon que el jugador está eligiendo
            for (int j = 0; j < disponibles.length; j++) { // Recorre la lista de Pokémon disponibles
                if (!elegido[j]) { // Si el Pokémon no ha sido elegido aún
                    System.out.println((j + 1) + ". " + disponibles[j].getNombre() + " (" + disponibles[j].getTipo() + ")"); // Muestra el número del Pokémon, su nombre y tipo
                }
            }
            int eleccion = -1; // Variable para almacenar la elección del jugador, inicializada en -1 para indicar que aún no se ha hecho una elección
            while (eleccion < 1 || eleccion > disponibles.length || elegido[eleccion - 1]) { // Bucle para validar la elección del jugador
                try {
                    System.out.print("Ingresa el número de tu elección: "); // Pide al jugador que ingrese el número del Pokémon que desea elegir
                    eleccion = Integer.parseInt(scanner.nextLine()); // Lee la entrada del jugador y la convierte a un número entero
                    if (eleccion < 1 || eleccion > disponibles.length || elegido[eleccion - 1]) { // Verifica si la elección es válida: debe estar dentro del rango de Pokémon disponibles y no haber sido elegido aún
                        System.out.println("Opción inválida o ya elegida. Intenta de nuevo."); // Mensaje que indica que la opción elegida no es válida o ya ha sido elegida
                    }
                } catch (Exception e) {  // Captura cualquier excepción (como entrada no numérica)
                    System.out.println("Entrada inválida. Intenta de nuevo."); // Mensaje que indica que la entrada del jugador no es válida (por ejemplo, si ingresa un texto en lugar de un número)
                }
            }
            equipoJugador[i] = disponibles[eleccion - 1]; // Asigna el Pokémon elegido al equipo del jugador en la posición correspondiente
            elegido[eleccion - 1] = true; // Marca el Pokémon como elegido para que no pueda ser seleccionado de nuevo
            System.out.println("¡Has elegido a " + equipoJugador[i].getNombre() + "!"); // Mensaje que indica que el jugador ha elegido un Pokémon
        }

        // Equipos predefinidos para el rival
        Pokemon[] equipoAsh = { // Equipo de Ash Ketchum
            new PokemonElectrico("Pikachu"), 
            new PokemonFuego("Charizard"),
            new PokemonAgua("Squirtle")
        };
        Pokemon[] equipoSerena = { // Equipo de Serena
            new PokemonHada("Sylveon"),
            new PokemonFuego("Braixen"),
            new PokemonAgua("Piplup")
        };
        Pokemon[] equipoMisty = { // Equipo de Misty
            new PokemonAgua("Staryu"),
            new PokemonAgua("Psyduck"),
            new PokemonHada("Togepi")
        };
        Pokemon[] equipoBrock = { // Equipo de Brock
            new PokemonRoca("Onix"),
            new PokemonRoca("Geodude"),
            new PokemonFuego("Vulpix")
        };

        // Lista de posibles rivales (sin repetir el equipo del jugador)
        List<Entrenador> posibles = new ArrayList<>(); // Crea una lista para almacenar los entrenadores rivales disponibles
        posibles.add(new Entrenador("Ash", equipoAsh)); // Añade a Ash Ketchum con su equipo a la lista de posibles rivales
        posibles.add(new Entrenador("Serena", equipoSerena)); // Añade a Serena con su equipo a la lista de posibles rivales
        posibles.add(new Entrenador("Misty", equipoMisty)); // Añade a Misty con su equipo a la lista de posibles rivales
        posibles.add(new Entrenador("Brock", equipoBrock)); // Añade a Brock con su equipo a la lista de posibles rivales

        // Selecciona rival al azar
        Entrenador enemigo = posibles.get(random.nextInt(posibles.size())); // Selecciona un rival al azar de la lista de posibles rivales

        // Crea el entrenador jugador con su equipo personalizado
        Entrenador jugador = new Entrenador(nombreJugador, equipoJugador); // Crea un nuevo entrenador con el nombre del jugador y su equipo personalizado

        // Muestra el equipo del rival antes de iniciar el combate
        System.out.println("\nTu rival será: " + enemigo.getNombre()); // Mensaje que indica quién es el rival del jugador
        System.out.println("Equipo rival:"); // Muestra el equipo del rival
        for (Pokemon p : enemigo.getEquipo()) { // Recorre el equipo del rival y muestra los nombres y tipos de sus Pokémon
            System.out.println("- " + p.getNombre() + " (" + p.getTipo() + ")"); // Muestra el nombre y tipo de cada Pokémon del equipo del rival
        }

        // Inicia el combate
        Combate batalla = new Combate(jugador, enemigo); // Crea una nueva instancia de la clase Combate con el jugador y el enemigo
        batalla.iniciar(); // Llama al método iniciar del combate para comenzar la batalla
    }
}