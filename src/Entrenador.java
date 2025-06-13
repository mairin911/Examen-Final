// =======================
// === MAIRIN: CLASES BASE, TIPOS DE POKÉMON, ATAQUES, ESTRUCTURA OOP ===
// =======================

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
