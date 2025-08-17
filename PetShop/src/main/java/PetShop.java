import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetShop {
    private static List<Produto> estoque = new ArrayList<>();
    private static List<Produto> carrinho = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializa o estoque de produtos
        popularEstoque();

        int opcao = -1;
        while (opcao != 0) {
            exibirMenuPrincipal();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        exibirMenuProdutos();
                        break;
                    case 2:
                        consultarProdutos();
                        break;
                    case 3:
                        gerenciarCarrinho();
                        break;
                    case 4:
                        marcarBanhoETosa();
                        break;
                    case 0:
                        System.out.println("Obrigado por utilizar o Pet Shop! Volte sempre.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpar a entrada
                opcao = -1;
            }
        }
        scanner.close();
    }

    private static void popularEstoque() {
        estoque.add(new Produto("Ração para Cães - 1kg", 25.50));
        estoque.add(new Produto("Ração para Gatos - 1kg", 22.00));
        estoque.add(new Produto("Brinquedo Mordedor", 15.75));
        estoque.add(new Produto("Coleira Antipulgas", 35.00));
        estoque.add(new Produto("Shampoo para Pets", 18.90));
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- Bem-vindo ao Pet Shop! ---");
        System.out.println("1. Comprar Produtos");
        System.out.println("2. Consultar Estoque de Produtos");
        System.out.println("3. Ver Carrinho e Finalizar Compra");
        System.out.println("4. Marcar Banho e Tosa");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void exibirMenuProdutos() {
        int opcaoProduto = -1;
        while (opcaoProduto != 0) {
            System.out.println("\n--- Produtos Disponíveis ---");
            for (int i = 0; i < estoque.size(); i++) {
                System.out.println((i + 1) + ". " + estoque.get(i));
            }
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Selecione um produto para adicionar ao carrinho (ou 0 para voltar): ");

            try {
                opcaoProduto = scanner.nextInt();
                if (opcaoProduto > 0 && opcaoProduto <= estoque.size()) {
                    Produto produtoSelecionado = estoque.get(opcaoProduto - 1);
                    carrinho.add(produtoSelecionado);
                    System.out.println(produtoSelecionado.getNome() + " adicionado ao carrinho!");
                } else if (opcaoProduto != 0) {
                    System.out.println("Opção de produto inválida.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcaoProduto = -1;
            }
        }
    }

    private static void consultarProdutos() {
        System.out.println("\n--- Estoque de Produtos ---");
        if (estoque.isEmpty()) {
            System.out.println("O estoque está vazio no momento.");
            return;
        }
        for (Produto produto : estoque) {
            System.out.println(produto);
        }
    }

    private static void gerenciarCarrinho() {
        int opcaoCarrinho = -1;
        while (opcaoCarrinho != 0) {
            System.out.println("\n--- Seu Carrinho ---");
            if (carrinho.isEmpty()) {
                System.out.println("Seu carrinho está vazio.");
                break;
            }

            double total = 0.0;
            for (int i = 0; i < carrinho.size(); i++) {
                Produto item = carrinho.get(i);
                System.out.println((i + 1) + ". " + item);
                total += item.getPreco();
            }
            System.out.println("--------------------");
            System.out.println("Total da Compra: R$" + String.format("%.2f", total));
            System.out.println("--------------------");

            System.out.println("1. Finalizar Compra");
            System.out.println("2. Remover um item");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcaoCarrinho = scanner.nextInt();
                switch (opcaoCarrinho) {
                    case 1:
                        finalizarCompra(total);
                        opcaoCarrinho = 0; // Sai do loop do carrinho
                        break;
                    case 2:
                        removerItemDoCarrinho();
                        break;
                    case 0:
                        break; // Volta ao menu principal
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcaoCarrinho = -1;
            }
        }
    }

    private static void finalizarCompra(double total) {
        if (carrinho.isEmpty()) {
            System.out.println("O carrinho está vazio. Não é possível finalizar a compra.");
            return;
        }

        System.out.println("\n--- Compra Finalizada ---");
        System.out.println("Itens Comprados:");
        for (Produto item : carrinho) {
            System.out.println("- " + item);
        }
        System.out.println("Total: R$" + String.format("%.2f", total));
        System.out.println("Obrigado pela sua compra!");
        carrinho.clear(); // Limpa o carrinho após a compra
    }

    private static void removerItemDoCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("O carrinho já está vazio.");
            return;
        }

        System.out.print("Digite o número do item que deseja remover: ");
        try {
            int indiceRemover = scanner.nextInt();
            if (indiceRemover > 0 && indiceRemover <= carrinho.size()) {
                Produto removido = carrinho.remove(indiceRemover - 1);
                System.out.println(removido.getNome() + " removido do carrinho.");
            } else {
                System.out.println("Número de item inválido.");
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.nextLine();
        }
    }

    private static void marcarBanhoETosa() {
        System.out.println("\n--- Agendamento de Banho e Tosa ---");
        System.out.print("Nome do seu Pet: ");
        String nomePet = scanner.nextLine();
        System.out.print("Seu nome: ");
        String nomeDono = scanner.nextLine();
        System.out.print("Data (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        System.out.print("Hora (hh:mm): ");
        String hora = scanner.nextLine();
        System.out.print("Serviço (Banho, Tosa ou Banho e Tosa): ");
        String servico = scanner.nextLine();

        Agendamento novoAgendamento = new Agendamento(nomePet, nomeDono, data, hora, servico);
        novoAgendamento.exibirDetalhes();
        System.out.println("Agendamento realizado com sucesso!");
    }
}