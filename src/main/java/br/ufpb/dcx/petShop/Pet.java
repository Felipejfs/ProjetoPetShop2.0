package br.ufpb.dcx.petShop;

public class Pet {
    private String nome;
    private String especie;
    private int idade;
    private String cor;

    public Pet(String nome, String especie, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
        this.especie = especie;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}