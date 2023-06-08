package br.ufpb.dcx.petShop;

import java.io.*;
import java.io.IOException;
import java.util.List;

public class GravadorDeDados {
    private String arquivo;

    public GravadorDeDados(String arquivo) {
        this.arquivo = arquivo;
    }

    public void gravarDados(List<Pet> pets) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Pet pet : pets) {
                writer.write(pet.getNome() + ";" + pet.getEspecie() + ";" + pet.getIdade() + ";" + pet.getCor());
                writer.newLine();
            }
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gravar os dados no arquivo.");
            e.printStackTrace();
        }
    }
}

