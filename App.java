package app;

import java.util.Scanner;
import model.Agenda;
import model.Contato;
import model.ContatoPessoal;
import model.ContatoProfissional;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Agenda agenda = new Agenda();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> cadastrarContatoPessoal();
                case 2 -> cadastrarContatoProfissional();
                case 3 -> agenda.listar();
                case 4 -> buscarContato();
                case 5 -> removerContato();
                case 6 -> atualizarTelefone();
                case 7 -> agenda.listarFavoritos();
                case 0 -> System.out.println("Saindo... Até logo!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("===== AGENDA =====");
        System.out.println("1 - Novo contato pessoal");
        System.out.println("2 - Novo contato profissional");
        System.out.println("3 - Listar contatos");
        System.out.println("4 - Buscar contato por nome");
        System.out.println("5 - Remover contato");
        System.out.println("6 - Atualizar telefone");
        System.out.println("7 - Listar favoritos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        String entrada = scanner.nextLine();
        try {
            return Integer.parseInt(entrada.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void cadastrarContatoPessoal() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Deseja favoritar este contato? (s/n): ");
        String resposta = scanner.nextLine().trim().toLowerCase();
        boolean favorito = resposta.equals("s");

        Contato contato = new ContatoPessoal(nome, telefone, favorito);
        agenda.adicionar(contato);

        System.out.println("Contato pessoal cadastrado com sucesso!");
    }

    private static void cadastrarContatoProfissional() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Empresa: ");
        String empresa = scanner.nextLine();

        Contato contato = new ContatoProfissional(nome, telefone, empresa);
        agenda.adicionar(contato);

        System.out.println("Contato profissional cadastrado com sucesso!");
    }

    private static void buscarContato() {
        System.out.print("Nome do contato a buscar: ");
        String nome = scanner.nextLine();

        Contato encontrado = agenda.buscarPorNome(nome);
        if (encontrado != null) {
            System.out.println("Contato encontrado: " + encontrado);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void removerContato() {
        System.out.print("Nome do contato a remover: ");
        String nome = scanner.nextLine();

        boolean removido = agenda.remover(nome);
        if (removido) {
            System.out.println("Contato removedo com sucesso.");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void atualizarTelefone() {
        System.out.print("Nome do contato: ");
        String nome = scanner.nextLine();

        System.out.print("Novo telefone: ");
        String novoTelefone = scanner.nextLine();

        boolean updated = agenda.atualizarTelefone(nome, novoTelefone);
        if (updated) {
            System.out.println("Telefone atualizado com sucesso.");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
    }
