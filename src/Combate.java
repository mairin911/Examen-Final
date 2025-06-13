import java.util.*; // Importa todas las clases del paquete java.util, necesarias para Scanner (leer datos del usuario) y Random (números aleatorios)

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
