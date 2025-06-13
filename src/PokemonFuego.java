// =======================
// === MAIRIN: CLASES BASE, TIPOS DE POKÉMON, ATAQUES, ESTRUCTURA OOP ===
// =======================

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
