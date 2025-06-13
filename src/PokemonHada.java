
// =======================
// === MAIRIN: CLASES BASE, TIPOS DE POKÉMON, ATAQUES, ESTRUCTURA OOP ===
// =======================

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
