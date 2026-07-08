package model;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionar(Contato contato) {
        contatos.add(contato);
    }

    public void listar() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }
        for (Contato c : contatos) {
            System.out.println(c);
        }
    }

    public Contato buscarPorNome(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public boolean remover(String nome) {
        Contato encontrado = buscarPorNome(nome);
        if (encontrado != null) {
            contatos.remove(encontrado);
            return true;
        }
        return false;
    }

    public boolean atualizarTelefone(String nome, String novoTelefone) {
        Contato encontrado = buscarPorNome(nome);
        if (encontrado != null) {
            encontrado.setTelefone(novoTelefone);
            return true;
        }
        return false;
    }

    public void listarFavoritos() {
        boolean encontrouAlgum = false;

        for (Contato c : contatos) {
            if (c instanceof ContatoPessoal) {
                ContatoPessoal pessoal = (ContatoPessoal) c;
                if (pessoal.isFavorito()) {
                    System.out.println(pessoal);
                    encontrouAlgum = true;
                }
            }
        }

        if (!encontrouAlgum) {
            System.out.println("Nenhum contato favorito encontrado.");
        }
    }

    public int totalContatos() {
        return contatos.size();
    }
}
