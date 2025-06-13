
// =======================
// === MAIRIN: CLASES BASE, TIPOS DE POKÉMON, ATAQUES, ESTRUCTURA OOP ===
// =======================

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