package br.ufpb.dcx.petShop;

import java.util.ArrayList;
import java.util.List;

public class SistemaPetShop {
    private List<Pet> pets;

    public SistemaPetShop() {
        this.pets = new ArrayList<>();
    }

    public void inicializar() {
    }

    public void adicionarPet(Pet pet) {
        pets.add(pet);
    }

    public void removerPet(Pet pet) {
        pets.remove(pet);
    }

    public List<Pet> listarPets() {
        return pets;
    }

    public Pet buscarPetNome(String nome) {
        for (Pet pet : pets) {
            if (pet.getNome().equalsIgnoreCase(nome)) {
                return pet;
            }
        }
        return null;
    }

    public Pet buscarPetEspecie(String especie) {
        for (Pet pet : pets) {
            if (pet.getEspecie().equalsIgnoreCase(especie)) {
                return pet;
            }
        }
        return null;
    }
}
