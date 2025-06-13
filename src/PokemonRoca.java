
// =======================
// === MAIRIN: CLASES BASE, TIPOS DE POKÉMON, ATAQUES, ESTRUCTURA OOP ===
// =======================

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
