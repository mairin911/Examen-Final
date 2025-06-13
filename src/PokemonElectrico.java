// =======================
// === MAIRIN: CLASES BASE, TIPOS DE POKÉMON, ATAQUES, ESTRUCTURA OOP ===
// =======================

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

