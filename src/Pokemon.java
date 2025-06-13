// =======================
// === MAIRIN: CLASES BASE, TIPOS DE POKÉMON, ATAQUES, ESTRUCTURA OOP ===
// =======================

// -----------------------------
// Clase abstracta base para todos los Pokémon
// -----------------------------
abstract class Pokemon  {  // Clase abstracta que define la estructura básica de un Pokémon
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