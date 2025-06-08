import java.util.*; // Importa todas las clases del paquete java.util, necesarias para Scanner (leer datos del usuario) y Random (números aleatorios)

// =======================
// === MAIRIN: CLASES BASE, TIPOS DE POKÉMON, ATAQUES, ESTRUCTURA OOP ===
// =======================

// -----------------------------
// Clase que representa un ataque de un Pokémon
// -----------------------------
class Ataque {
    private String nombre; // Guarda el nombre del ataque (ejemplo: "Lanzallamas")
    private int dano;      // Guarda el daño que causa el ataque

    // Constructor: recibe el nombre y el daño del ataque y los asigna a los atributos
    public Ataque(String nombre, int dano) {
        this.nombre = nombre; // Asigna el nombre recibido al atributo nombre
        this.dano = dano;     // Asigna el daño recibido al atributo dano
    }

    // Devuelve el nombre del ataque
    public String getNombre() {
        return nombre;
    }

    // Devuelve el daño del ataque
    public int getDano() {
        return dano;
    }
}

// -----------------------------
// Clase abstracta base para todos los Pokémon
// -----------------------------
abstract class Pokemon {
    protected String nombre;      // Nombre del Pokémon (ejemplo: "Pikachu")
    protected int vida;           // Vida actual del Pokémon (ejemplo: 100)
    protected Ataque[] ataques;   // Arreglo de ataques disponibles para el Pokémon

    // Constructor: inicializa nombre, vida y ataques
    public Pokemon(String nombre, int vida, Ataque[] ataques) {
        this.nombre = nombre;     // Asigna el nombre recibido
        this.vida = vida;         // Asigna la vida recibida
        this.ataques = ataques;   // Asigna el arreglo de ataques recibido
    }

    // Resta daño a la vida del Pokémon
    public void recibirDano(int dano) {
        this.vida -= dano; // Resta el daño recibido a la vida actual
        if (this.vida < 0) this.vida = 0; // Si la vida es menor a 0, la ajusta a 0 (no hay vida negativa)
    }

    // Devuelve true si el Pokémon sigue vivo (vida mayor a 0)
    public boolean estaVivo() {
        return this.vida > 0;
    }

    // Devuelve el nombre del Pokémon
    public String getNombre() {
        return nombre;
    }

    // Devuelve la vida actual del Pokémon
    public int getVida() {
        return vida;
    }

    // Devuelve el arreglo de ataques del Pokémon
    public Ataque[] getAtaques() {
        return ataques;
    }
}

// -----------------------------
// Subclases para cada tipo de Pokémon, cada una define sus ataques
// -----------------------------

// Pokémon tipo Fuego
class PokemonFuego extends Pokemon {
    // Constructor: inicializa el Pokémon con ataques de tipo Fuego
    public PokemonFuego(String nombre) {
        super(nombre, 100, new Ataque[]{
            new Ataque("Lanzallamas", 30), // Ataque fuerte
            new Ataque("Ascuas", 20)       // Ataque más débil
        });
    }
}

// Pokémon tipo Agua
class PokemonAgua extends Pokemon {
    public PokemonAgua(String nombre) {
        super(nombre, 100, new Ataque[]{
            new Ataque("Hidrobomba", 28), // Ataque fuerte de agua
            new Ataque("Burbuja", 18)     // Ataque débil de agua
        });
    }
}

// Pokémon tipo Eléctrico
class PokemonElectrico extends Pokemon {
    public PokemonElectrico(String nombre) {
        super(nombre, 100, new Ataque[]{
            new Ataque("Impactrueno", 25), // Ataque fuerte eléctrico
            new Ataque("Rayo", 22)         // Ataque débil eléctrico
        });
    }
}

// Pokémon tipo Hada
class PokemonHada extends Pokemon {
    public PokemonHada(String nombre) {
        super(nombre, 100, new Ataque[]{
            new Ataque("Brillo Mágico", 26), // Ataque fuerte de hada
            new Ataque("Encanto", 19)        // Ataque débil de hada
        });
    }
}

// Pokémon tipo Roca
class PokemonRoca extends Pokemon {
    public PokemonRoca(String nombre) {
        super(nombre, 100, new Ataque[]{
            new Ataque("Avalancha", 27),     // Ataque fuerte de roca
            new Ataque("Lanzarrocas", 19)    // Ataque débil de roca
        });
    }
}

// -----------------------------
// Clase que representa a un entrenador Pokémon
// -----------------------------
class Entrenador {
    private String nombre;      // Nombre del entrenador (ejemplo: "Ash")
    private Pokemon[] equipo;   // Arreglo de Pokémon que forman el equipo del entrenador

    // Constructor: inicializa el nombre y el equipo del entrenador
    public Entrenador(String nombre, Pokemon[] equipo) {
        this.nombre = nombre;   // Asigna el nombre recibido
        this.equipo = equipo;   // Asigna el equipo recibido
    }

    // Devuelve el nombre del entrenador
    public String getNombre() {
        return nombre;
    }

    // Devuelve el primer Pokémon vivo del equipo (el que luchará)
    public Pokemon obtenerPokemonVivo() {
        for (Pokemon p : equipo) {        // Recorre el equipo de Pokémon
            if (p.estaVivo()) return p;   // Si encuentra uno vivo, lo retorna
        }
        return null; // Si ninguno está vivo, retorna null
    }

    // Devuelve true si el entrenador tiene al menos un Pokémon vivo
    public boolean tienePokemonVivos() {
        return obtenerPokemonVivo() != null;
    }

    // Devuelve el equipo completo de Pokémon
    public Pokemon[] getEquipo() {
        return equipo;
    }
}

// =======================
// === JUALEX: LÓGICA DE COMBATE, ENTRADA DEL JUGADOR, COMBATE POR TURNOS ===
// =======================

// -----------------------------
// Clase que representa el combate entre dos entrenadores Pokémon
// -----------------------------
class Combate {
    private Entrenador jugador; // Entrenador controlado por el usuario
    private Entrenador enemigo; // Entrenador rival (controlado por la máquina)
    private Scanner scanner = new Scanner(System.in); // Scanner para leer entradas del usuario
    private Random random = new Random();             // Random para decisiones aleatorias

    // Constructor: recibe los dos entrenadores que participarán en el combate
    public Combate(Entrenador jugador, Entrenador enemigo) {
        this.jugador = jugador; // Asigna el entrenador jugador
        this.enemigo = enemigo; // Asigna el entrenador enemigo
    }

    // Método que inicia y gestiona todo el combate entre los dos entrenadores
    public void iniciar() {
        // Imprime mensaje de inicio de combate mostrando los nombres de los entrenadores
        System.out.println("\n⚔️ " + jugador.getNombre() + " entra en batalla contra " + enemigo.getNombre() + "!\n");

        // Bucle principal del combate: se repite mientras ambos tengan al menos un Pokémon vivo
        while (jugador.tienePokemonVivos() && enemigo.tienePokemonVivos()) {
            // Obtiene el primer Pokémon vivo del jugador (el que luchará este turno)
            Pokemon pokeJugador = jugador.obtenerPokemonVivo();
            // Obtiene el primer Pokémon vivo del enemigo (el que luchará este turno)
            Pokemon pokeEnemigo = enemigo.obtenerPokemonVivo();

            // Muestra en pantalla el nombre y la vida actual de ambos Pokémon que están luchando
            System.out.println("🔥 " + pokeJugador.getNombre() + " (Vida: " + pokeJugador.getVida() + ") VS " +
                    pokeEnemigo.getNombre() + " (Vida: " + pokeEnemigo.getVida() + ")");

            // El jugador elige un ataque para su Pokémon (se llama a un método que muestra las opciones y lee la elección)
            int ataqueJugador = elegirAtaque(pokeJugador);
            // Obtiene el daño que causará el ataque elegido por el jugador
            int danoJugador = pokeJugador.getAtaques()[ataqueJugador].getDano();
            // Aplica el daño al Pokémon enemigo (resta la vida)
            pokeEnemigo.recibirDano(danoJugador);
            // Muestra en pantalla qué ataque usó el jugador y cuánto daño causó
            System.out.println("⚡ " + pokeJugador.getNombre() + " usa " +
                    pokeJugador.getAtaques()[ataqueJugador].getNombre() + " y causa " + danoJugador + " de daño!");

            // Si el Pokémon enemigo quedó sin vida después del ataque del jugador
            if (!pokeEnemigo.estaVivo()) {
                // Muestra mensaje de que el Pokémon enemigo ha caído
                System.out.println("💀 " + pokeEnemigo.getNombre() + " ha caído!");
                // Salta el turno del enemigo (el bucle vuelve a empezar con el siguiente Pokémon enemigo)
                continue;
            }

            // El enemigo elige un ataque de forma aleatoria (elige un índice válido del arreglo de ataques)
            int ataqueEnemigo = random.nextInt(pokeEnemigo.getAtaques().length);
            // Obtiene el daño que causará el ataque elegido por el enemigo
            int danoEnemigo = pokeEnemigo.getAtaques()[ataqueEnemigo].getDano();
            // Aplica el daño al Pokémon del jugador (resta la vida)
            pokeJugador.recibirDano(danoEnemigo);
            // Muestra en pantalla qué ataque usó el enemigo y cuánto daño causó
            System.out.println("🔥 " + pokeEnemigo.getNombre() + " contraataca con " +
                    pokeEnemigo.getAtaques()[ataqueEnemigo].getNombre() + " causando " + danoEnemigo + " de daño!");

            // Si el Pokémon del jugador quedó sin vida después del ataque enemigo
            if (!pokeJugador.estaVivo()) {
                // Muestra mensaje de que el Pokémon del jugador ha sido derrotado
                System.out.println("💥 " + pokeJugador.getNombre() + " ha sido derrotado!");
            }
        }

        // Cuando termina el bucle, se verifica quién ganó el combate
        if (jugador.tienePokemonVivos()) {
            // Si el jugador aún tiene Pokémon vivos, muestra mensaje de victoria
            System.out.println("\n🏆 ¡" + jugador.getNombre() + " ha ganado el combate con valentía!");
        } else {
            // Si el enemigo tiene Pokémon vivos y el jugador no, muestra mensaje de derrota
            System.out.println("\n❌ " + enemigo.getNombre() + " ha ganado la batalla.");
        }
    }

    // Método privado que permite al jugador elegir el ataque de su Pokémon
    private int elegirAtaque(Pokemon poke) {
        int opcion = -1; // Inicializa la variable opción con un valor inválido
        // Bucle que se repite hasta que el jugador elija una opción válida
        while (opcion < 0 || opcion >= poke.getAtaques().length) {
            try {
                // Muestra el mensaje para elegir ataque
                System.out.println("Elige un ataque:");
                // Recorre el arreglo de ataques del Pokémon y los muestra con su número y daño
                for (int i = 0; i < poke.getAtaques().length; i++) {
                    System.out.println((i + 1) + ". " + poke.getAtaques()[i].getNombre() +
                            " (Daño: " + poke.getAtaques()[i].getDano() + ")");
                }
                // Lee la opción del usuario, la convierte a entero y la ajusta a índice de arreglo (resta 1)
                opcion = Integer.parseInt(scanner.nextLine()) - 1;
            } catch (Exception e) {
                // Si el usuario ingresa algo inválido (no es número o está fuera de rango), muestra mensaje de error
                System.out.println("⚠️ Entrada inválida, intenta de nuevo.");
            }
        }
        // Devuelve el índice del ataque elegido por el jugador
        return opcion;
    }
}

// =======================
// === JUALEX & MAIRIN: FLUJO PRINCIPAL DEL JUEGO, SELECCIÓN DE EQUIPOS Y COMBATE ===
// =======================
public class Main {
    static Scanner scanner = new Scanner(System.in); // Scanner para leer entradas del usuario desde la consola
    static Random random = new Random();             // Random para decisiones aleatorias (como el oponente)

    public static void main(String[] args) { // Método principal, punto de entrada del programa
        System.out.println("\n🎮 BIENVENIDO AL GRAN TORNEO DE BATALLA POKÉMON 🎮\n"); // Mensaje de bienvenida

        // === MAIRIN: CREACIÓN DE EQUIPOS Y POKÉMON ===
        // Crea los equipos predefinidos de cada entrenador, cada uno con 3 Pokémon
        Pokemon[] equipoAsh = {
            new PokemonElectrico("Pikachu"),   // Primer Pokémon de Ash
            new PokemonFuego("Charizard"),     // Segundo Pokémon de Ash
            new PokemonAgua("Squirtle")        // Tercer Pokémon de Ash
        };
        Pokemon[] equipoSerena = {
            new PokemonHada("Sylveon"),        // Primer Pokémon de Serena
            new PokemonFuego("Braixen"),       // Segundo Pokémon de Serena
            new PokemonAgua("Piplup")          // Tercer Pokémon de Serena
        };
        Pokemon[] equipoMisty = {
            new PokemonAgua("Staryu"),         // Primer Pokémon de Misty
            new PokemonAgua("Psyduck"),        // Segundo Pokémon de Misty
            new PokemonHada("Togepi")          // Tercer Pokémon de Misty
        };
        Pokemon[] equipoBrock = {
            new PokemonRoca("Onix"),           // Primer Pokémon de Brock
            new PokemonRoca("Geodude"),        // Segundo Pokémon de Brock
            new PokemonFuego("Vulpix")         // Tercer Pokémon de Brock
        };

        // === JUALEX: MENÚ DE SELECCIÓN DE ENTRENADOR Y FLUJO DE JUEGO ===
        Entrenador jugador = null; // Inicializa el entrenador del jugador como null
        while (jugador == null) {  // Mientras no se haya seleccionado un entrenador válido
            try {
                System.out.println("Selecciona tu entrenador:");
                System.out.println("1. Ash\n2. Serena\n3. Misty\n4. Brock"); // Muestra las opciones
                int eleccion = Integer.parseInt(scanner.nextLine()); // Lee la opción del usuario como número
                switch (eleccion) { // Evalúa la opción elegida
                    case 1:
                        jugador = new Entrenador("Ash", equipoAsh); // Si elige 1, asigna Ash
                        break;
                    case 2:
                        jugador = new Entrenador("Serena", equipoSerena); // Si elige 2, asigna Serena
                        break;
                    case 3:
                        jugador = new Entrenador("Misty", equipoMisty); // Si elige 3, asigna Misty
                        break;
                    case 4:
                        jugador = new Entrenador("Brock", equipoBrock); // Si elige 4, asigna Brock
                        break;
                    default:
                        System.out.println("❗ Opción inválida."); // Si elige otra cosa, muestra error
                }
            } catch (Exception e) {
                System.out.println("⚠️ Entrada inválida, por favor ingresa un número."); // Si hay error, muestra mensaje
            }
        }

        // === JUALEX: SELECCIÓN ALEATORIA DE OPONENTE Y COMBATE ===
        // Selección aleatoria de oponente (no puede ser el mismo que el jugador)
        Entrenador[] posibles = {
            new Entrenador("Ash", equipoAsh),
            new Entrenador("Serena", equipoSerena),
            new Entrenador("Misty", equipoMisty),
            new Entrenador("Brock", equipoBrock)
        };
        Entrenador enemigo;
        do {
            enemigo = posibles[random.nextInt(posibles.length)]; // Selecciona un oponente aleatorio
        } while (enemigo.getNombre().equals(jugador.getNombre())); // Repite si es el mismo que el jugador

        // Inicia el combate entre el jugador y el oponente
        Combate batalla = new Combate(jugador, enemigo); // Crea el objeto Combate
        batalla.iniciar(); // Llama al método para iniciar el combate
    }
}