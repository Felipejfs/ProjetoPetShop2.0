package br.ufpb.dcx.petShop;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDados {
    private String arquivo;

    public GravadorDeDados(String arquivo) {
        this.arquivo = arquivo;
    }

    public void gravarDados(List<Pet> pets) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            outputStream.writeObject(pets);
        } catch (IOException e) {
            System.out.println("Erro ao gravar dados no arquivo: " + e.getMessage());
        }
    }

    public List<Pet> recuperarDados() {
        List<Pet> pets = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivo))) {
            Object obj = inputStream.readObject();
            if (obj instanceof List) {
                pets = (List<Pet>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados do arquivo: " + e.getMessage());
        }
        return pets;
    }
}

