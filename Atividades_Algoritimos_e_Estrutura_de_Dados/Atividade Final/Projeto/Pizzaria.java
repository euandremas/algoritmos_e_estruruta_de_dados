package Projeto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import Projeto.Pizza.TamanhoPizza;

public class Pizzaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();

        // Adicionar alguns clientes para teste (opcional, para facilitar o teste
        // inicial)
        listaClientes.add(new Cliente("Ana Silva", "Rua A, 123", "987654321", "ana@email.com"));
        listaClientes.add(new Cliente("Bruno Costa", "Av B, 456", "123456789", "bruno@email.com"));

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n============= Gerenciador de Pizzaria =============");
            System.out.println("\nEscolha uma opção: ");
            System.out.println("\n1 - Fazer um novo pedido");
            System.out.println("2 - Alterar um pedido");
            System.out.println("3 - Adicionar um cliente");
            System.out.println("4 - Gerar relatório de vendas");
            System.out.println("5 - Gerar lista de clientes");
            System.out.println("6 - Calcular Frete"); // Nova opção no menu
            System.out.println("0 - Sair");

            System.out.print("\nOpção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            System.out.println();

            switch (opcao) {
                case 1:
                    fazerPedido(scanner, listaPedidos, listaClientes);
                    break;
                case 2:
                    alterarPedido(scanner, listaPedidos, listaClientes);
                    break;
                case 3:
                    listaClientes.add(adicionarCliente(scanner));
                    System.out.println("Cliente adicionado com sucesso!");
                    break;
                case 4:
                    gerarRelatorio(listaPedidos);
                    break;
                case 5:
                    gerarListaClientes(listaClientes);
                    break;
                case 6:
                    // Chamar o método para calcular frete
                    menuCalcularFrete(scanner, listaPedidos);
                    break;
                case 0:
                    System.out.println("Até amanhã...");
                    continuar = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void fazerPedido(Scanner scanner, List<Pedido> listaPedidos, List<Cliente> listaClientes) {
        List<Pizza> pizzasDoPedidoAtual = new ArrayList<>();
        System.out.println("--- FAZER PEDIDO ---");

        if (listaClientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados. Por favor, adicione um cliente primeiro.");
            return;
        }

        int i = 1;
        System.out.println("Selecione um cliente: ");
        for (Cliente cliente : listaClientes) {
            System.out.println(i + " - " + cliente.getNome());
            i++;
        }
        System.out.print("Opção: ");
        int clienteIndex = scanner.nextInt();
        scanner.nextLine();

        if (clienteIndex < 1 || clienteIndex > listaClientes.size()) {
            System.out.println("Opção de cliente inválida.");
            return;
        }
        Cliente clienteSelecionado = listaClientes.get(clienteIndex - 1);

        boolean continuarAdicionarPizza = true;
        while (continuarAdicionarPizza) {
            i = 1;
            System.out.println("\nQual o tamanho da pizza? ");
            System.out.println("Selecione um tamanho: ");
            for (TamanhoPizza tamanhos : Pizza.TamanhoPizza.values()) {
                System.out.println(i + " - " + tamanhos);
                i++;
            }
            System.out.print("Opção: ");
            int tamanhoOpcao = scanner.nextInt();
            scanner.nextLine();

            TamanhoPizza tamanhoSelecionado = null;
            try {
                tamanhoSelecionado = TamanhoPizza.getByIndex(tamanhoOpcao - 1);
            } catch (IllegalArgumentException e) {
                System.out.println("Tamanho de pizza inválido. Tente novamente.");
                continue;
            }

            int quantiSabores = 0;
            while (quantiSabores < 1 || quantiSabores > 4) {
                System.out.println("Digite a quantidade de sabores (1 - 4): ");
                System.out.print("Opção: ");
                quantiSabores = scanner.nextInt();
                scanner.nextLine();
            }

            Cardapio cardapio = new Cardapio();
            List<String> saboresDisponiveis = new ArrayList<>(cardapio.getCardapio().keySet());
            List<String> saboresSelecionadosParaPizza = new ArrayList<>();

            for (int j = 0; j < quantiSabores; j++) {
                System.out.println("\nSelecione o " + (j + 1) + "º sabor:");
                i = 1;
                for (String sabor : saboresDisponiveis) {
                    System.out.println(i + " - " + sabor);
                    i++;
                }
                System.out.print("Opção: ");
                int saborOpcao = scanner.nextInt();
                scanner.nextLine();

                if (saborOpcao < 1 || saborOpcao > saboresDisponiveis.size()) {
                    System.out.println("Opção de sabor inválida. Tente novamente.");
                    j--;
                    continue;
                }
                saboresSelecionadosParaPizza.add(saboresDisponiveis.get(saborOpcao - 1));
            }

            Pizza pizza = new Pizza(saboresSelecionadosParaPizza, cardapio.getPrecoJusto(saboresSelecionadosParaPizza),
                    tamanhoSelecionado);
            pizzasDoPedidoAtual.add(pizza);

            System.out.println("Pizza adicionada ao pedido com sucesso!");
            System.out.println("\nDeseja adicionar mais uma pizza a este pedido?");
            System.out.print("1 - Sim, 2 - Não: ");
            int opcaoContinuarPizza = scanner.nextInt();
            scanner.nextLine();

            if (opcaoContinuarPizza != 1) {
                continuarAdicionarPizza = false;
            }
        }
        double valorTotalPedido = somarPizzas(pizzasDoPedidoAtual);
        Pedido pedido = new Pedido(listaPedidos.size() + 1, clienteSelecionado, pizzasDoPedidoAtual, valorTotalPedido);
        listaPedidos.add(pedido);

        // --- Adição para o cálculo de frete no fazerPedido ---
        System.out.print("\nDigite a distância para entrega em km (ex: 5.2): ");
        double distanciaKm = scanner.nextDouble();
        scanner.nextLine();

        double valorFrete = calcularFrete(distanciaKm, pedido.getPizzas().size());

        System.out.println("\n--- PEDIDO FINALIZADO ---");
        System.out.println("ID do Pedido: " + pedido.getId());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Valor das Pizzas: R$" + String.format("%.2f", pedido.getValorTotal()));
        System.out.println("Valor do Frete: R$" + String.format("%.2f", valorFrete));
        System.out.println(
                "Valor Total do Pedido (com frete): R$" + String.format("%.2f", pedido.getValorTotal() + valorFrete));
        System.out.println("-------------------------");
    }

    private static double somarPizzas(List<Pizza> pizzas) {
        double valorTotal = 0;
        for (Pizza pizza : pizzas) {
            valorTotal += pizza.getPreco();
        }
        return valorTotal;
    }

    private static void alterarPedido(Scanner scanner, List<Pedido> listaPedidos, List<Cliente> listaClientes) {
        System.out.println("--- ALTERAR PEDIDO ---");
        if (listaPedidos.isEmpty()) {
            System.out.println("Não há pedidos para alterar.");
            return;
        }

        System.out.println("Deseja localizar o pedido por:");
        System.out.println("1 - ID do Pedido");
        System.out.println("2 - Nome do Cliente");
        System.out.print("Opção: ");
        int opcaoBusca = scanner.nextInt();
        scanner.nextLine();

        Pedido pedidoEncontrado = null;

        if (opcaoBusca == 1) {
            System.out.print("Digite o ID do pedido: ");
            int idBusca = scanner.nextInt();
            scanner.nextLine();
            for (Pedido pedido : listaPedidos) {
                if (pedido.getId() == idBusca) {
                    pedidoEncontrado = pedido;
                    break;
                }
            }
        } else if (opcaoBusca == 2) {
            System.out.print("Digite o nome do cliente: ");
            String nomeBusca = scanner.nextLine();

            List<Pedido> pedidosDoCliente = listaPedidos.stream()
                    .filter(p -> p.getCliente().getNome().equalsIgnoreCase(nomeBusca))
                    .collect(Collectors.toList());

            if (pedidosDoCliente.isEmpty()) {
                System.out.println("Nenhum pedido encontrado para o cliente '" + nomeBusca + "'.");
                return;
            } else if (pedidosDoCliente.size() == 1) {
                pedidoEncontrado = pedidosDoCliente.get(0);
            } else {
                System.out.println("Múltiplos pedidos encontrados para '" + nomeBusca + "':");
                for (int i = 0; i < pedidosDoCliente.size(); i++) {
                    System.out.println((i + 1) + " - Pedido ID: " + pedidosDoCliente.get(i).getId() +
                            ", Valor Total: R$" + String.format("%.2f", pedidosDoCliente.get(i).getValorTotal()));
                }
                System.out.print("Selecione o número do pedido que deseja alterar: ");
                int escolhaPedido = scanner.nextInt();
                scanner.nextLine();
                if (escolhaPedido > 0 && escolhaPedido <= pedidosDoCliente.size()) {
                    pedidoEncontrado = pedidosDoCliente.get(escolhaPedido - 1);
                } else {
                    System.out.println("Seleção inválida de pedido.");
                    return;
                }
            }

        } else {
            System.out.println("Opção de busca inválida.");
            return;
        }

        if (pedidoEncontrado == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("\n--- Pedido Encontrado ---");
        System.out.println("ID do Pedido: " + pedidoEncontrado.getId());
        System.out.println("Cliente: " + pedidoEncontrado.getCliente().getNome());
        System.out.println("Pizzas no Pedido:");
        int pizzaNum = 1;
        for (Pizza pizza : pedidoEncontrado.getPizzas()) {
            System.out.println("  " + pizzaNum + ". " + String.join(", ", pizza.getSabores()) +
                    " (" + pizza.getTamanho() + ") - R$" + String.format("%.2f", pizza.getPreco()));
            pizzaNum++;
        }
        System.out.println("Valor Total Atual: R$" + String.format("%.2f", pedidoEncontrado.getValorTotal()));
        System.out.println("-------------------------");

        boolean continuarAlterando = true;
        while (continuarAlterando) {
            System.out.println("\nO que deseja fazer com este pedido?");
            System.out.println("1 - Adicionar uma pizza");
            System.out.println("2 - Remover uma pizza");
            System.out.println("3 - Alterar sabor de uma pizza existente");
            System.out.println("9 - Finalizar alterações e voltar ao menu principal");
            System.out.print("Opção: ");
            int opcaoAlteracao = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoAlteracao) {
                case 1:
                    adicionarPizzaAoPedido(scanner, pedidoEncontrado);
                    break;
                case 2:
                    removerPizzaDoPedido(scanner, pedidoEncontrado);
                    break;
                case 3:
                    alterarSaborPizzaNoPedido(scanner, pedidoEncontrado);
                    break;
                case 9:
                    System.out.println("Finalizando alterações do pedido.");
                    continuarAlterando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            if (continuarAlterando) {
                System.out.println("\n--- Pedido Atualizado ---");
                System.out.println("ID do Pedido: " + pedidoEncontrado.getId());
                System.out.println("Pizzas no Pedido:");
                pizzaNum = 1;
                for (Pizza pizza : pedidoEncontrado.getPizzas()) {
                    System.out.println("  " + pizzaNum + ". " + String.join(", ", pizza.getSabores()) +
                            " (" + pizza.getTamanho() + ") - R$" + String.format("%.2f", pizza.getPreco()));
                    pizzaNum++;
                }
                pedidoEncontrado.setValorTotal(somarPizzas(pedidoEncontrado.getPizzas()));
                System.out.println("Valor Total Atual: R$" + String.format("%.2f", pedidoEncontrado.getValorTotal()));
                System.out.println("-------------------------");
            }
        }
    }

    private static void adicionarPizzaAoPedido(Scanner scanner, Pedido pedido) {
        System.out.println("\n--- ADICIONAR NOVA PIZZA AO PEDIDO ---");
        List<Pizza> pizzasAtuais = pedido.getPizzas();

        int i = 1;
        System.out.println("Qual o tamanho da nova pizza? ");
        System.out.println("Selecione um tamanho: ");
        for (TamanhoPizza tamanhos : Pizza.TamanhoPizza.values()) {
            System.out.println(i + " - " + tamanhos);
            i++;
        }
        System.out.print("Opção: ");
        int tamanhoOpcao = scanner.nextInt();
        scanner.nextLine();

        TamanhoPizza tamanhoSelecionado = null;
        try {
            tamanhoSelecionado = TamanhoPizza.getByIndex(tamanhoOpcao - 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Tamanho de pizza inválido.");
            return;
        }

        int quantiSabores = 0;
        while (quantiSabores < 1 || quantiSabores > 4) {
            System.out.println("Digite a quantidade de sabores (1 - 4): ");
            System.out.print("Opção: ");
            quantiSabores = scanner.nextInt();
            scanner.nextLine();
        }

        Cardapio cardapio = new Cardapio();
        List<String> saboresDisponiveis = new ArrayList<>(cardapio.getCardapio().keySet());
        List<String> saboresSelecionadosParaNovaPizza = new ArrayList<>();

        for (int j = 0; j < quantiSabores; j++) {
            System.out.println("\nSelecione o " + (j + 1) + "º sabor para a nova pizza:");
            i = 1;
            for (String sabor : saboresDisponiveis) {
                System.out.println(i + " - " + sabor);
                i++;
            }
            System.out.print("Opção: ");
            int saborOpcao = scanner.nextInt();
            scanner.nextLine();

            if (saborOpcao < 1 || saborOpcao > saboresDisponiveis.size()) {
                System.out.println("Opção de sabor inválida. Tente novamente.");
                j--;
                continue;
            }
            saboresSelecionadosParaNovaPizza.add(saboresDisponiveis.get(saborOpcao - 1));
        }

        Pizza novaPizza = new Pizza(saboresSelecionadosParaNovaPizza,
                cardapio.getPrecoJusto(saboresSelecionadosParaNovaPizza), tamanhoSelecionado);
        pizzasAtuais.add(novaPizza);
        pedido.setValorTotal(somarPizzas(pizzasAtuais));

        System.out.println("Nova pizza adicionada ao pedido com sucesso!");
    }

    private static void removerPizzaDoPedido(Scanner scanner, Pedido pedido) {
        System.out.println("\n--- REMOVER PIZZA DO PEDIDO ---");
        List<Pizza> pizzasAtuais = pedido.getPizzas();

        if (pizzasAtuais.isEmpty()) {
            System.out.println("Não há pizzas neste pedido para remover.");
            return;
        }

        System.out.println("Pizzas no pedido:");
        for (int i = 0; i < pizzasAtuais.size(); i++) {
            Pizza pizza = pizzasAtuais.get(i);
            System.out.println((i + 1) + ". " + String.join(", ", pizza.getSabores()) +
                    " (" + pizza.getTamanho() + ") - R$" + String.format("%.2f", pizza.getPreco()));
        }

        System.out.print("Digite o número da pizza que deseja remover: ");
        int indicePizza = scanner.nextInt();
        scanner.nextLine();

        if (indicePizza > 0 && indicePizza <= pizzasAtuais.size()) {
            Pizza pizzaRemovida = pizzasAtuais.remove(indicePizza - 1);
            pedido.setValorTotal(somarPizzas(pizzasAtuais));
            System.out.println("Pizza de " + String.join(", ", pizzaRemovida.getSabores()) + " removida com sucesso!");
        } else {
            System.out.println("Número de pizza inválido.");
        }
    }

    private static void alterarSaborPizzaNoPedido(Scanner scanner, Pedido pedido) {
        System.out.println("\n--- ALTERAR SABOR DE PIZZA NO PEDIDO ---");
        List<Pizza> pizzasAtuais = pedido.getPizzas();
        Cardapio cardapio = new Cardapio();
        List<String> saboresDisponiveis = new ArrayList<>(cardapio.getCardapio().keySet());

        if (pizzasAtuais.isEmpty()) {
            System.out.println("Não há pizzas neste pedido para alterar.");
            return;
        }

        System.out.println("Pizzas no pedido:");
        for (int i = 0; i < pizzasAtuais.size(); i++) {
            Pizza pizza = pizzasAtuais.get(i);
            System.out.println((i + 1) + ". " + String.join(", ", pizza.getSabores()) +
                    " (" + pizza.getTamanho() + ") - R$" + String.format("%.2f", pizza.getPreco()));
        }

        System.out.print("Digite o número da pizza cujo sabor deseja alterar: ");
        int indicePizza = scanner.nextInt();
        scanner.nextLine();

        if (indicePizza > 0 && indicePizza <= pizzasAtuais.size()) {
            Pizza pizzaParaAlterar = pizzasAtuais.get(indicePizza - 1);
            System.out.println("Pizza selecionada: " + String.join(", ", pizzaParaAlterar.getSabores()));

            int quantiSaboresAtuais = pizzaParaAlterar.getSabores().size();
            List<String> novosSabores = new ArrayList<>();

            System.out.println("Digite os novos sabores para esta pizza (quantidade: " + quantiSaboresAtuais + "):");
            for (int j = 0; j < quantiSaboresAtuais; j++) {
                System.out.println("\nSelecione o " + (j + 1) + "º novo sabor:");
                int i = 1;
                for (String sabor : saboresDisponiveis) {
                    System.out.println(i + " - " + sabor);
                    i++;
                }
                System.out.print("Opção: ");
                int saborOpcao = scanner.nextInt();
                scanner.nextLine();

                if (saborOpcao < 1 || saborOpcao > saboresDisponiveis.size()) {
                    System.out.println("Opção de sabor inválida. Tente novamente.");
                    j--;
                    continue;
                }
                novosSabores.add(saboresDisponiveis.get(saborOpcao - 1));
            }

            pizzaParaAlterar.setSabores(novosSabores);
            pizzaParaAlterar.setPreco(cardapio.getPrecoJusto(novosSabores));

            pedido.setValorTotal(somarPizzas(pizzasAtuais));

            System.out.println("Sabores da pizza alterados com sucesso!");

        } else {
            System.out.println("Número de pizza inválido.");
        }
    }

    private static Cliente adicionarCliente(Scanner scanner) {
        System.out.println("--- ADICIONAR CLIENTE ---");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(nome, endereco, telefone, email);
        return cliente;
    }

    private static void gerarRelatorio(List<Pedido> listaPedidos) {
        System.out.println("--- GERAR RELATÓRIO DE VENDAS ---");

        if (listaPedidos.isEmpty()) {
            System.out.println("Não há pedidos para gerar relatório.");
            return;
        }

        double faturamentoTotal = 0;
        Map<String, Integer> contagemSabores = new HashMap<>();
        Map<String, Map<String, Integer>> grafoSabores = new HashMap<>();

        for (Pedido pedido : listaPedidos) {
            faturamentoTotal += pedido.getValorTotal();

            for (Pizza pizza : pedido.getPizzas()) {
                List<String> saboresDaPizza = pizza.getSabores();

                for (String sabor : saboresDaPizza) {
                    contagemSabores.put(sabor, contagemSabores.getOrDefault(sabor, 0) + 1);
                }

                for (int i = 0; i < saboresDaPizza.size(); i++) {
                    for (int j = i + 1; j < saboresDaPizza.size(); j++) {
                        String sabor1 = saboresDaPizza.get(i);
                        String sabor2 = saboresDaPizza.get(j);

                        String menorSabor = (sabor1.compareTo(sabor2) < 0) ? sabor1 : sabor2;
                        String maiorSabor = (sabor1.compareTo(sabor2) < 0) ? sabor2 : sabor1;

                        grafoSabores.computeIfAbsent(menorSabor, k -> new HashMap<>())
                                .put(maiorSabor, grafoSabores.get(menorSabor).getOrDefault(maiorSabor, 0) + 1);
                    }
                }
            }
        }

        System.out.println("\nFaturamento Total: R$" + String.format("%.2f", faturamentoTotal));

        System.out.println("\n--- Sabores Mais Pedidos ---");
        List<Map.Entry<String, Integer>> listaSaboresOrdenada = new ArrayList<>(contagemSabores.entrySet());
        listaSaboresOrdenada.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        if (listaSaboresOrdenada.isEmpty()) {
            System.out.println("Nenhum sabor foi pedido ainda.");
        } else {
            for (Map.Entry<String, Integer> entry : listaSaboresOrdenada) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " vezes");
            }
        }

        System.out.println("\n--- Conexões de Sabores Mais Frequentes (Grafos) ---");
        if (grafoSabores.isEmpty()) {
            System.out.println(
                    "Não há conexões de sabores registradas (apenas pizzas de um sabor ou nenhum pedido multi-sabor).");
        } else {
            List<Map.Entry<String, Map<String, Integer>>> listaGrafoOrdenada = new ArrayList<>(grafoSabores.entrySet());

            for (Map.Entry<String, Map<String, Integer>> entrySabor1 : listaGrafoOrdenada) {
                String saborPrincipal = entrySabor1.getKey();
                Map<String, Integer> conexoes = entrySabor1.getValue();

                if (!conexoes.isEmpty()) {
                    System.out.println("Conexões para '" + saborPrincipal + "':");
                    List<Map.Entry<String, Integer>> listaConexoesOrdenada = new ArrayList<>(conexoes.entrySet());
                    listaConexoesOrdenada.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

                    for (Map.Entry<String, Integer> entryConexao : listaConexoesOrdenada) {
                        System.out.println(
                                "  -> Com '" + entryConexao.getKey() + "': " + entryConexao.getValue() + " vezes");
                    }
                }
            }
        }
        System.out.println("--------------------------------------------");
    }

    private static void gerarListaClientes(List<Cliente> listaClientes) {
        if (listaClientes.isEmpty()) {
            System.out.println("Lista de clientes está vazia.");
        } else {
            System.out.println("--- LISTA DE CLIENTES ---");
            int i = 1;
            for (Cliente cliente : listaClientes) {
                System.out.println("Cliente " + i + ":");
                System.out.println("  Nome: " + cliente.getNome());
                System.out.println("  Endereço: " + cliente.getEndereco());
                System.out.println("  Telefone: " + cliente.getTelefone());
                System.out.println("  Email: " + cliente.getEmail());
                System.out.println();
                i++;
            }
            System.out.println("-------------------------");
        }
    }

    // --- NOVO MÉTODO PARA CÁLCULO DE FRETE ---
    private static double calcularFrete(double distanciaKm, int quantidadePizzas) {
        // Você pode ajustar estes valores conforme a regra de negócio
        final double CUSTO_BASE_POR_KM = 2.00; // Ex: R$ 2,50 por km
        final double CUSTO_ADICIONAL_POR_PIZZA = 0.80; // Ex: R$ 0,80 por pizza

        double freteDistancia = distanciaKm * CUSTO_BASE_POR_KM;
        double fretePeso = quantidadePizzas * CUSTO_ADICIONAL_POR_PIZZA;

        return freteDistancia + fretePeso;
    }

    // --- NOVO MÉTODO PARA O MENU DE CÁLCULO DE FRETE ---
    private static void menuCalcularFrete(Scanner scanner, List<Pedido> listaPedidos) {
        System.out.println("--- CALCULAR FRETE ---");
        System.out.println("Deseja calcular o frete para:");
        System.out.println("1 - Um novo cálculo (inserir distância e quantidade de pizzas)");
        System.out.println("2 - Um pedido existente (buscar por ID do pedido)");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1) {
            System.out.print("Digite a distância em km: ");
            double distancia = scanner.nextDouble();
            System.out.print("Digite a quantidade de pizzas: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            double frete = calcularFrete(distancia, quantidade);
            System.out.println("\nValor do Frete para " + distancia + "km e " + quantidade + " pizzas: R$"
                    + String.format("%.2f", frete));
        } else if (opcao == 2) {
            if (listaPedidos.isEmpty()) {
                System.out.println("Não há pedidos para calcular frete.");
                return;
            }
            System.out.print("Digite o ID do pedido para calcular o frete: ");
            int idBusca = scanner.nextInt();
            scanner.nextLine();

            Pedido pedidoEncontrado = null;
            for (Pedido pedido : listaPedidos) {
                if (pedido.getId() == idBusca) {
                    pedidoEncontrado = pedido;
                    break;
                }
            }

            if (pedidoEncontrado != null) {
                System.out.print("Digite a distância para entrega em km (ex: 5.2): ");
                double distancia = scanner.nextDouble();
                scanner.nextLine();

                double frete = calcularFrete(distancia, pedidoEncontrado.getPizzas().size());
                System.out.println("\n--- Detalhes do Frete do Pedido " + pedidoEncontrado.getId() + " ---");
                System.out.println("Cliente: " + pedidoEncontrado.getCliente().getNome());
                System.out.println("Quantidade de Pizzas: " + pedidoEncontrado.getPizzas().size());
                System.out.println("Distância Informada: " + distancia + " km");
                System.out.println("Valor do Frete: R$" + String.format("%.2f", frete));
                System.out.println("Valor Total do Pedido (Pizzas + Frete): R$"
                        + String.format("%.2f", pedidoEncontrado.getValorTotal() + frete));
            } else {
                System.out.println("Pedido com ID " + idBusca + " não encontrado.");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
}