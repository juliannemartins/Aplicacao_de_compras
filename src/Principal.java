import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);
        int sair = 1;
        int opcao = 1;

        String espaco = """
                         """;

        System.out.println(espaco);
        while (sair != 0){

            System.out.println("Digite a descrição da compra: ");
            String descricao = leitura.next();
            System.out.println(espaco);

            System.out.println("Digite o valor da compra: ");
            double valor = leitura.nextDouble();
            System.out.println(espaco);

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada){

                System.out.println("Compra realizada!");
                System.out.println(espaco);

                System.out.println("Digite 0 para sair ou 1 para continuar");
                opcao = leitura.nextInt();

            } else{

                System.out.println("Saldo insuficiente!");
                opcao = 0;

            }

            switch (opcao) {
                case 0:
                    System.out.println("\n***********************");
                    System.out.println("COMPRAS REALIZADAS:");
                    for (Compra c : cartao.getCompras()) {
                        System.out.println(c.getDescricao() + "- " + c.getValor());
                    }
                    System.out.println("\n***********************");
                    System.out.println("\nSaldo do cartão: " +cartao.getSaldo());
                    sair = 0;
                    break;

                case 1:
                    System.out.println(espaco);
                    break;

                default:
                    System.out.println("Código inválido");
                    break;
            }
        }

    }
}
