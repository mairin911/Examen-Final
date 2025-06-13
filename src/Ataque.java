// =======================
// === MAIRIN: CLASES BASE, TIPOS DE POKÉMON, ATAQUES, ESTRUCTURA OOP ===
// =======================

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
