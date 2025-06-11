import java.util.*; // Importa todas las clases del paquete java.util, necesarias para Scanner (leer datos del usuario) y Random (números aleatorios)

// =======================
// === MAIRIN: CLASES BASE, TIPOS DE POKÉMON, ATAQUES, ESTRUCTURA OOP ===
// =======================

// -----------------------------
// Clase que representa un ataque de un Pokémon
// -----------------------------
class Ataque { // Clase que representa un ataque de un Pokémon
    private String nombre; // Guarda el nombre del ataque (ejemplo: "Lanzallamas")
    private int dano;      // Guarda el daño que causa el ataque

    // Constructor: recibe el nombre y el daño del ataque y los asigna a los atributos
    public Ataque(String nombre, int dano) { // Constructor que recibe el nombre y el daño del ataque
        this.nombre = nombre; // Asigna el nombre recibido al atributo nombre
        this.dano = dano;     // Asigna el daño recibido al atributo dano
    }

    // Devuelve el nombre del ataque
    public String getNombre() {  // Método para obtener el nombre del ataque
        return nombre;  // Retorna el nombre del ataque
    }

    // Devuelve el daño del ataque
    public int getDano() {  // Método para obtener el daño del ataque
        return dano;   // Retorna el daño del ataque
    }
}

// -----------------------------
// Clase abstracta base para todos los Pokémon
// -----------------------------
abstract class Pokemon {  // Clase abstracta que define la estructura básica de un Pokémon
    // Atributos comunes a todos los Pokémon
    protected String nombre;      // Nombre del Pokémon (ejemplo: "Pikachu")
    protected int vida;           // Vida actual del Pokémon (ejemplo: 100)
    protected Ataque[] ataques;   // Arreglo de ataques disponibles para el Pokémon

    // Constructor: inicializa nombre, vida y ataques
    public Pokemon(String nombre, int vida, Ataque[] ataques) {  // Constructor que recibe el nombre, vida y ataques del Pokémon
        this.nombre = nombre;     // Asigna el nombre recibido
        this.vida = vida;         // Asigna la vida recibida
        this.ataques = ataques;   // Asigna el arreglo de ataques recibido
    }

    // Resta daño a la vida del Pokémon
    public void recibirDano(int dano) {  // Método para recibir daño
        this.vida -= dano; // Resta el daño recibido a la vida actual
        if (this.vida < 0) this.vida = 0; // Si la vida es menor a 0, la ajusta a 0 (no hay vida negativa)
    }

    // Devuelve true si el Pokémon sigue vivo (vida mayor a 0)
    public boolean estaVivo() { // Método para verificar si el Pokémon está vivo
        return this.vida > 0; // Retorna true si la vida es mayor a 0, indicando que el Pokémon está vivo
    }

    // Devuelve el nombre del Pokémon
    public String getNombre() {     // Método para obtener el nombre del Pokémon
        return nombre;              // Retorna el nombre del Pokémon
    }

    // Devuelve la vida actual del Pokémon
    public int getVida() {          // Método para obtener la vida actual del Pokémon
        return vida;                // Retorna la vida actual del Pokémon
    }

    // Devuelve el arreglo de ataques del Pokémon
    public Ataque[] getAtaques() {  // Método para obtener los ataques del Pokémon
        return ataques;             // Retorna el arreglo de ataques disponibles para el Pokémon
    }

    // === AÑADIDO: EFECTIVIDAD DE TIPOS ===
    // MÉTODO ABSTRACTO PARA OBTENER EL TIPO DEL POKÉMON
    public abstract String getTipo(); // Método abstracto que debe ser implementado por las subclases para devolver el tipo del Pokémon
}

// -----------------------------
// Subclases para cada tipo de Pokémon, cada una define sus ataques
// -----------------------------

// Pokémon tipo Fuego
class PokemonFuego extends Pokemon {  // Clase que representa un Pokémon de tipo Fuego
    public PokemonFuego(String nombre) {  // Constructor que recibe el nombre del Pokémon
        super(nombre, 100, new Ataque[]{ // Llama al constructor de la clase base con nombre, vida y ataques
            new Ataque("Lanzallamas", 30), // Ataque de tipo Fuego con 30 de daño
            new Ataque("Ascuas", 20) // Ataque de tipo Fuego con 20 de daño
        });
    }
    @Override
    public String getTipo() { return "Fuego"; } // Implementa el método abstracto para devolver el tipo del Pokémon
}

// Pokémon tipo Agua
class PokemonAgua extends Pokemon { // Clase que representa un Pokémon de tipo Agua
    public PokemonAgua(String nombre) { // Constructor que recibe el nombre del Pokémon
        super(nombre, 100, new Ataque[]{    // Llama al constructor de la clase base con nombre, vida y ataques
            new Ataque("Hidrobomba", 28), // Ataque de tipo Agua con 28 de daño
            new Ataque("Burbuja", 18) // Ataque de tipo Agua con 18 de daño
        });
    }
    @Override // Anula el método abstracto de la clase base
    public String getTipo() { return "Agua"; } // Implementa el método abstracto para devolver el tipo del Pokémon
}

// Pokémon tipo Eléctrico
class PokemonElectrico extends Pokemon {  // Clase que representa un Pokémon de tipo Eléctrico
    public PokemonElectrico(String nombre) { // Constructor que recibe el nombre del Pokémon
        super(nombre, 100, new Ataque[]{ // Llama al constructor de la clase base con nombre, vida y ataques
            new Ataque("Impactrueno", 25), // Ataque de tipo Eléctrico con 25 de daño
            new Ataque("Rayo", 22) // Ataque de tipo Eléctrico con 22 de daño
        });
    }
    @Override // Anula el método abstracto de la clase base
    public String getTipo() { return "Electrico"; } // Implementa el método abstracto para devolver el tipo del Pokémon
}

// Pokémon tipo Hada
class PokemonHada extends Pokemon { // Clase que representa un Pokémon de tipo Hada
    public PokemonHada(String nombre) { // Constructor que recibe el nombre del Pokémon
        super(nombre, 100, new Ataque[]{ // Llama al constructor de la clase base con nombre, vida y ataques
            new Ataque("Brillo Mágico", 26), // Ataque de tipo Hada con 26 de daño
            new Ataque("Encanto", 19) // Ataque de tipo Hada con 19 de daño
        });
    }
    @Override // Anula el método abstracto de la clase base
    public String getTipo() { return "Hada"; } // Implementa el método abstracto para devolver el tipo del Pokémon
}

// Pokémon tipo Roca
class PokemonRoca extends Pokemon { // Clase que representa un Pokémon de tipo Roca
    public PokemonRoca(String nombre) { // Constructor que recibe el nombre del Pokémon
        super(nombre, 100, new Ataque[]{ // Llama al constructor de la clase base con nombre, vida y ataques
            new Ataque("Avalancha", 27), // Ataque de tipo Roca con 27 de daño
            new Ataque("Lanzarrocas", 19) // Ataque de tipo Roca con 19 de daño
        });
    }
    @Override // Anula el método abstracto de la clase base
    public String getTipo() { return "Roca"; } // Implementa el método abstracto para devolver el tipo del Pokémon
}

// -----------------------------
// Clase que representa a un entrenador Pokémon
// -----------------------------
class Entrenador { // Clase que representa a un entrenador Pokémon
    private String nombre;      // Nombre del entrenador (ejemplo: "Ash")
    private Pokemon[] equipo;   // Arreglo de Pokémon que forman el equipo del entrenador

    // Constructor: inicializa el nombre y el equipo del entrenador
    public Entrenador(String nombre, Pokemon[] equipo) { // Constructor que recibe el nombre y el equipo del entrenador
        this.nombre = nombre;   // Asigna el nombre recibido
        this.equipo = equipo;   // Asigna el equipo recibido
    }

    // Devuelve el nombre del entrenador
    public String getNombre() {     // Método para obtener el nombre del entrenador
        return nombre;             // Retorna el nombre del entrenador
    }

    // Devuelve el primer Pokémon vivo del equipo (el que luchará)
    public Pokemon obtenerPokemonVivo() { // Método para obtener el primer Pokémon vivo del equipo
        for (Pokemon p : equipo) {        // Recorre el equipo de Pokémon
            if (p.estaVivo()) return p;   // Si encuentra uno vivo, lo retorna
        }
        return null; // Si ninguno está vivo, retorna null
    }

    // Devuelve true si el entrenador tiene al menos un Pokémon vivo
    public boolean tienePokemonVivos() { // Método para verificar si el entrenador tiene Pokémon vivos
        return obtenerPokemonVivo() != null; // Retorna true si hay al menos un Pokémon vivo
    }

    // Devuelve el equipo completo de Pokémon
    public Pokemon[] getEquipo() { // Método para obtener el equipo completo del entrenador
        return equipo; // Retorna el arreglo de Pokémon que forman el equipo del entrenador
    }
}

// =======================
// === JUALEX: LÓGICA DE COMBATE, ENTRADA DEL JUGADOR, COMBATE POR TURNOS ===
// =======================

// -----------------------------
// Clase que representa el combate entre dos entrenadores Pokémon
// -----------------------------
class Combate { // Clase que representa el combate entre dos entrenadores Pokémon
    private Entrenador jugador; // Entrenador controlado por el usuario
    private Entrenador enemigo; // Entrenador rival (controlado por la máquina)
    private Scanner scanner = new Scanner(System.in); // Scanner para leer entradas del usuario
    private Random random = new Random();             // Random para decisiones aleatorias

    // Constructor: recibe los dos entrenadores que participarán en el combate
    public Combate(Entrenador jugador, Entrenador enemigo) { // Constructor que recibe los entrenadores
        this.jugador = jugador; // Asigna el entrenador jugador
        this.enemigo = enemigo; // Asigna el entrenador enemigo
    }

    // MÉTODO PARA CALCULAR EL MULTIPLICADOR DE DAÑO SEGÚN LOS TIPOS
    private double calcularMultiplicador(String tipoAtacante, String tipoDefensor) {   // Método que calcula el multiplicador de daño según los tipos de Pokémon
        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Hada")) return 2.0; // Fuego es fuerte contra Hada
        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Agua")) return 0.5; // Fuego es débil contra Agua
        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Roca")) return 0.5;   // Fuego es débil contra Roca
        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Fuego")) return 0.5; // Fuego es débil contra Fuego

        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Fuego")) return 2.0; // Agua es fuerte contra Fuego
        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Roca")) return 2.0; // Agua es fuerte contra Roca
        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Agua")) return 0.5; // Agua es débil contra Agua

        if (tipoAtacante.equals("Electrico") && tipoDefensor.equals("Agua")) return 2.0; // Eléctrico es fuerte contra Agua
        if (tipoAtacante.equals("Electrico") && tipoDefensor.equals("Roca")) return 0.5; // Eléctrico es débil contra Roca
        if (tipoAtacante.equals("Electrico") && tipoDefensor.equals("Electrico")) return 0.5; // Eléctrico es débil contra Eléctrico

        if (tipoAtacante.equals("Hada") && tipoDefensor.equals("Roca")) return 0.5; // Hada es débil contra Roca
        if (tipoAtacante.equals("Hada") && tipoDefensor.equals("Fuego")) return 0.5; // Hada es débil contra Fuego
        if (tipoAtacante.equals("Hada") && tipoDefensor.equals("Hada")) return 0.5; // Hada es débil contra Hada

        if (tipoAtacante.equals("Roca") && tipoDefensor.equals("Fuego")) return 2.0; // Roca es fuerte contra Fuego
        if (tipoAtacante.equals("Roca") && tipoDefensor.equals("Electrico")) return 2.0; // Roca es fuerte contra Eléctrico
        if (tipoAtacante.equals("Roca") && tipoDefensor.equals("Roca")) return 0.5; // Roca es débil contra Roca
        return 1.0; // Si no hay ninguna relación de tipo, el multiplicador es 1 (daño normal)
    }

    // Método que inicia y gestiona todo el combate entre los dos entrenadores
    public void iniciar() {
        // Imprime mensaje de inicio de combate mostrando los nombres de los entrenadores
        System.out.println("\n⚔️ " + jugador.getNombre() + " entra en batalla contra " + enemigo.getNombre() + "!\n"); // Mensaje de inicio del combate

        // El Pokémon activo del jugador (permite cambiar sin perder el turno)
        Pokemon pokeJugador = jugador.obtenerPokemonVivo(); // Si el jugador tiene Pokémon vivos, obtiene el primero para iniciar el combate

        while (jugador.tienePokemonVivos() && enemigo.tienePokemonVivos()) { // Mientras ambos entrenadores tengan Pokémon vivos, continúa el combate
            Pokemon pokeEnemigo = enemigo.obtenerPokemonVivo(); // Obtiene el primer Pokémon vivo del enemigo para luchar

            // Muestra en pantalla el nombre y la vida actual de ambos Pokémon que están luchando
            System.out.println("🔥 " + pokeJugador.getNombre() + " (Vida: " + pokeJugador.getVida() + ") VS " + 
                    pokeEnemigo.getNombre() + " (Vida: " + pokeEnemigo.getVida() + ")"); // Mensaje que muestra los Pokémon activos y sus vidas

            int accionJugador = elegirAccion(pokeJugador, jugador); // Llama al método para que el jugador elija una acción (ataque o cambio de Pokémon)
            if (accionJugador == -2) { // Cambio de Pokémon
                pokeJugador = cambiarPokemon(jugador, pokeJugador); // Llama al método para cambiar de Pokémon
                System.out.println("¡Has cambiado a " + pokeJugador.getNombre() + "!"); // Mensaje que indica el cambio de Pokémon
                // NO hay ataque enemigo, se respeta el turno
                continue; // Salta al siguiente ciclo del bucle para que el jugador pueda atacar con el nuevo Pokémon
            }

            // Ataque normal
            int ataqueJugador = accionJugador; // El jugador elige un ataque de su Pokémon
            int danoJugador = pokeJugador.getAtaques()[ataqueJugador].getDano(); // Obtiene el daño del ataque elegido por el jugador
            double multJugador = calcularMultiplicador(pokeJugador.getTipo(), pokeEnemigo.getTipo()); // Calcula el multiplicador de daño según los tipos de Pokémon
            int danoFinalJugador = (int)(danoJugador * multJugador); // Aplica el multiplicador al daño del ataque
            pokeEnemigo.recibirDano(danoFinalJugador); // Aplica el daño final al Pokémon enemigo
            System.out.println("⚡ " + pokeJugador.getNombre() + " usa " + 
                    pokeJugador.getAtaques()[ataqueJugador].getNombre() + " y causa " + danoFinalJugador + " de daño!"); // Mensaje que muestra el ataque del jugador y el daño causado
            if (multJugador > 1.0) System.out.println("¡Es muy efectivo!"); // Mensaje que indica si el ataque fue muy efectivo
            if (multJugador < 1.0) System.out.println("No es muy efectivo..."); // Mensaje que indica si el ataque no fue muy efectivo

            if (!pokeEnemigo.estaVivo()) { // Verifica si el Pokémon enemigo ha sido derrotado
                System.out.println("💀 " + pokeEnemigo.getNombre() + " ha caído!");     //// Mensaje que indica que el Pokémon enemigo ha sido derrotado
                continue; // Salta al siguiente ciclo del bucle para que el jugador pueda atacar con el mismo Pokémon o cambiar
            }

            int ataqueEnemigo = random.nextInt(pokeEnemigo.getAtaques().length); // El enemigo elige un ataque al azar de su Pokémon
            int danoEnemigo = pokeEnemigo.getAtaques()[ataqueEnemigo].getDano(); // Obtiene el daño del ataque elegido por el enemigo
            double multEnemigo = calcularMultiplicador(pokeEnemigo.getTipo(), pokeJugador.getTipo()); // Calcula el multiplicador de daño según los tipos de Pokémon
            int danoFinalEnemigo = (int)(danoEnemigo * multEnemigo); // Aplica el multiplicador al daño del ataque del enemigo
            pokeJugador.recibirDano(danoFinalEnemigo); // Aplica el daño final al Pokémon jugador
            System.out.println("🔥 " + pokeEnemigo.getNombre() + " contraataca con " + 
                    pokeEnemigo.getAtaques()[ataqueEnemigo].getNombre() + " causando " + danoFinalEnemigo + " de daño!"); // Mensaje que muestra el ataque del enemigo y el daño causado
            if (multEnemigo > 1.0) System.out.println("¡Es muy efectivo!"); // Mensaje que indica si el ataque del enemigo fue muy efectivo
            if (multEnemigo < 1.0) System.out.println("No es muy efectivo..."); // Mensaje que indica si el ataque del enemigo no fue muy efectivo

            if (!pokeJugador.estaVivo()) { // Verifica si el Pokémon jugador ha sido derrotado
                System.out.println("💥 " + pokeJugador.getNombre() + " ha sido derrotado!");
                // Cambia automáticamente al siguiente Pokémon vivo
                if (jugador.tienePokemonVivos()) { // Si el jugador aún tiene Pokémon vivos
                    pokeJugador = jugador.obtenerPokemonVivo(); // Obtiene el siguiente Pokémon vivo del jugador
                    System.out.println("¡" + jugador.getNombre() + " envía a " + pokeJugador.getNombre() + "!"); // Mensaje que indica el cambio de Pokémon del jugador
                }
            }
        }

        // Cuando termina el bucle, se verifica quién ganó el combate
        if (jugador.tienePokemonVivos()) { // Si el jugador tiene Pokémon vivos
            // Si el jugador aún tiene Pokémon vivos, muestra mensaje de victoria
            System.out.println("\n🏆 ¡" + jugador.getNombre() + " ha ganado el combate con valentía!"); // Mensaje que indica que el jugador ha ganado
        } else { // Si el jugador no tiene Pokémon vivos
            // Si el enemigo tiene Pokémon vivos y el jugador no, muestra mensaje de derrota
            System.out.println("\n❌ " + enemigo.getNombre() + " ha ganado la batalla."); // Mensaje que indica que el enemigo ha ganado
        }
    }

    // Menú de acción: atacar o cambiar de Pokémon
    private int elegirAccion(Pokemon poke, Entrenador entrenador) { // Método que muestra un menú para que el jugador elija una acción (ataque o cambio de Pokémon)
        while (true) { // Bucle infinito para que el jugador elija una acción válida
            System.out.println("Elige una acción:"); // Muestra el menú de acciones disponibles
            for (int i = 0; i < poke.getAtaques().length; i++) { // Recorre los ataques del Pokémon y muestra sus nombres y daños
                System.out.println((i + 1) + ". " + poke.getAtaques()[i].getNombre() + 
                        " (Daño: " + poke.getAtaques()[i].getDano() + ")"); // Muestra el número del ataque, su nombre y el daño que causa
            }
            System.out.println((poke.getAtaques().length + 1) + ". Cambiar de Pokémon"); // Opción para cambiar de Pokémon
            try {
                int opcion = Integer.parseInt(scanner.nextLine()); // Lee la opción elegida por el jugador
                if (opcion >= 1 && opcion <= poke.getAtaques().length) { // Si la opción es un ataque válido
                    return opcion - 1; // ataque
                } else if (opcion == poke.getAtaques().length + 1) { // Si la opción es cambiar de Pokémon
                    if (hayOtroPokemonVivo(entrenador, poke)) { // Verifica si el jugador tiene otro Pokémon vivo para cambiar
                        return -2; // cambiar
                    } else { // Si no hay otro Pokémon vivo, muestra mensaje de error
                        System.out.println("No tienes otros Pokémon vivos para cambiar."); // Mensaje que indica que no hay otros Pokémon vivos para cambiar
                    }
                } else { // Si la opción es inválida
                    System.out.println("Opción inválida."); // Mensaje que indica que la opción elegida no es válida
                }
            } catch (Exception e) { // Captura cualquier excepción (como entrada no numérica)
                System.out.println("Entrada inválida."); // Mensaje que indica que la entrada del jugador no es válida
            }
        }
    }

    // Cambiar de Pokémon (no permite elegir el mismo ni uno debilitado) 
    private Pokemon cambiarPokemon(Entrenador entrenador, Pokemon actual) { // Método que permite al jugador cambiar de Pokémon
        while (true) { // Bucle infinito para que el jugador elija un Pokémon válido
            System.out.println("Pokémon disponibles para cambiar:"); // Muestra los Pokémon disponibles para cambiar
            Pokemon[] equipo = entrenador.getEquipo(); // Obtiene el equipo completo del entrenador
            for (int i = 0; i < equipo.length; i++) { // Recorre el equipo de Pokémon y muestra sus nombres, tipos y estado
                String estado = equipo[i].estaVivo() ? "" : " (DEBILITADO)"; // Si el Pokémon está vivo, no muestra nada; si está debilitado, muestra "(DEBILITADO)"
                String actualStr = equipo[i] == actual ? " (ACTUAL)" : ""; // Si el Pokémon es el actual, muestra "(ACTUAL)" al final
                System.out.println((i + 1) + ". " + equipo[i].getNombre() + " (" + equipo[i].getTipo() + ")" + estado + actualStr); // Muestra el número del Pokémon, su nombre, tipo y estado (vivo o debilitado) con el indicador de actual si es el Pokémon activo
            }
            System.out.print("Elige el número del Pokémon al que quieres cambiar: "); // Pide al jugador que elija un Pokémon para cambiar
            try {
                int eleccion = Integer.parseInt(scanner.nextLine()) - 1; // Lee la elección del jugador y la convierte a índice (resta 1 para que coincida con el índice del arreglo)
                if (eleccion >= 0 && eleccion < equipo.length && equipo[eleccion].estaVivo() && equipo[eleccion] != actual) { // Verifica que la elección sea válida: debe ser un número dentro del rango del equipo, el Pokémon debe estar vivo y no puede ser el mismo Pokémon actual
                    return equipo[eleccion]; // Si la elección es válida, retorna el Pokémon elegido
                } else { // Si la elección no es válida
                    System.out.println("No puedes elegir ese Pokémon."); // Mensaje que indica que la elección del jugador no es válida (puede ser porque el Pokémon está debilitado o es el mismo que el actual)
                }
            } catch (Exception e) { // Captura cualquier excepción (como entrada no numérica)
                System.out.println("Entrada inválida."); // Mensaje que indica que la entrada del jugador no es válida (por ejemplo, si ingresa un texto en lugar de un número)
            }
        }
    }

    // Verifica si hay otro Pokémon vivo distinto al actual
    private boolean hayOtroPokemonVivo(Entrenador entrenador, Pokemon actual) { // Método que verifica si el entrenador tiene otro Pokémon vivo distinto al actual
        for (Pokemon p : entrenador.getEquipo()) { // Recorre el equipo de Pokémon del entrenador
            if (p != actual && p.estaVivo()) return true; // Si encuentra un Pokémon que no es el actual y está vivo, retorna true
        }
        return false; // Si no encuentra ningún otro Pokémon vivo, retorna false
    }
}

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