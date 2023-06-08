package br.ufpb.dcx.petShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SistemaPetShopGUI extends JFrame{
    private JTextField nomeField;
    private JTextField especieField;
    private JTextField idadeField;
    private JTextField corField;

    private JTextArea outputArea;

    private SistemaPetShop sistemaPet;

    public SistemaPetShopGUI() {
        sistemaPet = new SistemaPetShop();

        setTitle("Sistema PetShop");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(8, 4));
        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Espécie:"));
        especieField = new JTextField();
        inputPanel.add(especieField);
        inputPanel.add(new JLabel("Idade:"));
        idadeField = new JTextField();
        inputPanel.add(idadeField);
        inputPanel.add(new JLabel("Cor:"));
        corField = new JTextField();
        inputPanel.add(corField);


        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String especie = especieField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String cor = corField.getText();
                Pet pet = new Pet(nome, especie,idade, cor);

                sistemaPet.adicionarPet(pet);

                // Chamar o gravador de dados para salvar os pets no arquivo
                GravadorDeDados gravador = new GravadorDeDados("dados.txt");
                gravador.gravarDados(sistemaPet.listarPets());

                JOptionPane.showMessageDialog(SistemaPetShopGUI.this, "Pet adicionado com sucesso!");            }
        });

        JButton listarButton = new JButton("Listar");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                List<Pet> pets = sistemaPet.listarPets();
                for (Pet pet : pets) {
                    sb.append("Nome: ").append(pet.getNome()).append(", Espécie: ").append(pet.getEspecie()).append(", Idade: ").append(pet.getIdade())
                            .append(", Cor: ").append(pet.getCor()).append("\n");
                }
                outputArea.setText(sb.toString());
            }
        });

        JButton buscarNomeButton = new JButton("Buscar pelo Nome");
        buscarNomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                Pet pet = sistemaPet.buscarPetNome(nome);
                if (pet != null) {
                    outputArea.setText("Nome: " + pet.getNome() + ", Espécie: " + pet.getEspecie() +", Idade: " + pet.getIdade() + ", Cor: " + pet.getCor());
                } else {
                    outputArea.setText("Pet não encontrado!");
                }
            }
        });

        JButton buscarEspecieButton = new JButton("Buscar pela Espécie");
        buscarEspecieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String especie = especieField.getText();
                Pet pet = sistemaPet.buscarPetEspecie(especie);
                if (pet != null) {
                    outputArea.setText("Nome: " + pet.getNome() + ", Espécie: " + pet.getEspecie() +", Idade: " + pet.getIdade() + ", Cor: " + pet.getCor());
                } else {
                    outputArea.setText("Pet não encontrado!");
                }
            }
        });

        JButton removerButton = new JButton("Remover");
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                Pet pet = sistemaPet.buscarPetNome(nome);
                if (pet != null) {
                    sistemaPet.removerPet(pet);
                    JOptionPane.showMessageDialog(SistemaPetShopGUI.this, "Pet removido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(SistemaPetShopGUI.this, "Pet não encontrado!");
                }
            }
        });

        inputPanel.add(adicionarButton);
        inputPanel.add(listarButton);
        inputPanel.add(buscarNomeButton);
        inputPanel.add(buscarEspecieButton);
        inputPanel.add(removerButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SistemaPetShopGUI();
    }
}

