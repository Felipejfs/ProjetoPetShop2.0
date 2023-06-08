package br.ufpb.dcx.petShop;

import java.util.ArrayList;
import java.util.List;

public class SistemaPetShop {
    private List<Pet> pets;

    public SistemaPetShop() {
        this.pets = new ArrayList<>();
    }

    public void inicializar() {
        GravadorDeDados gravadorDados = null;
        pets = gravadorDados.recuperarDados();
    }

    public void adicionarPet(Pet pet) {
        pets.add(pet);
        GravadorDeDados gravadorDados = null;
        gravadorDados.gravarDados(pets);
    }

    public void removerPet(Pet pet) {
        pets.remove(pet);
        GravadorDeDados gravadorDados = null;
        gravadorDados.gravarDados(pets);
    }

    public List<Pet> listarPets() {
        return pets;
    }

    public Pet buscarPet(String nome) {
        for (Pet pet : pets) {
            if (pet.getNome().equalsIgnoreCase(nome)) {
                return pet;
            }
        }
        return null;
    }
}
