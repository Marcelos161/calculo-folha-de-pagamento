import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//          Outras variaveis

        Scanner console = new Scanner(System.in);

//          Variaveis do funcionario

        String nomeFunc = "";
        String cargoFunc = "";
        double salBrutoFunc = 0; //Salario bruto do funcionario
        int diasTrabalho = 0; // Dias totais da semana em que o funcionario trabalha
        int horasDiasFunc = 0; //Quantas Horas no dia o funcionario trabalha
        int horasTotaisSem = 0; //Vai receber quantas horas totais o funcionario trabalha na semana
        int horasTotais = 0; // Vai receber as horas totais
        double salPorHora = 0; // Recebe o valor do salario dividido pelas horas trabalhadas
        String periculosidade = "";
        double adPeric = 0;
        double salLiquidoFunc = 0; // Salario liquido
        String insalubridade = "";
        String insalubridadeNivel = "";
        double valeTrans = 0;
        double salario6 = 0;

//          Inicio
        System.out.println("Bem vindo ao app para calcular a folha de pagamento de funcionario");

//          calculo de salario por horas trabalhadas
        System.out.print("Primeiramente digite o nome do funcionario: ");
        nomeFunc = console.nextLine();
        System.out.print("Seu cargo: ");
        cargoFunc = console.nextLine();
        System.out.print("Digite o salario bruto do funcionario: ");
        salBrutoFunc = console.nextDouble();
        System.out.print("Agora digite as horas diarias trabalhadas por esse funcionario:");
        horasDiasFunc = console.nextInt();
        System.out.print("Quantos dias esse funcionario trabalha na semana: ");
        diasTrabalho = console.nextInt();

        console.nextLine(); //Limpa o buffer do teclado

//          calculos

        horasTotaisSem = horasDiasFunc * diasTrabalho;
        horasTotais = horasTotaisSem * 5;
        salPorHora = salBrutoFunc / horasTotais;
        System.out.println(salPorHora);

//          calculo de periculosidade

           while (!periculosidade.equalsIgnoreCase("y") && !periculosidade.equalsIgnoreCase("n")) {
               System.out.print("O trabalhador tem direito ao adicional periculosidade? (Y/N)");
               periculosidade = console.nextLine();

               if (periculosidade.equalsIgnoreCase("y")) {
                   salLiquidoFunc = salBrutoFunc + (salBrutoFunc * adPeric);
               } else if (periculosidade.equalsIgnoreCase("n")){
                   System.out.println("Nao tem adicional periculosidade");
                   salLiquidoFunc = salBrutoFunc;
               } else {
                   System.out.println("Digite apenas Y ou N ");
               }

           }

//           Calculo de insalubridade

            while (!insalubridade.equalsIgnoreCase("y") && !insalubridade.equalsIgnoreCase("n")){
                System.out.print("O trabalhador tem direito ao adicional insalubridade? (Y/N): ");
                insalubridade = console.nextLine();
                if (insalubridade.equalsIgnoreCase("y")){
                    while (!insalubridadeNivel.equalsIgnoreCase("baixo") && !insalubridadeNivel.equalsIgnoreCase("medio") && !insalubridadeNivel.equalsIgnoreCase("alto")){
                        System.out.print("Qual o nivel de insalubridade?  (baixo/medio/alto): ");
                        insalubridadeNivel = console.nextLine();
                        if (insalubridadeNivel.equalsIgnoreCase("baixo")) {
                            salLiquidoFunc = salLiquidoFunc + 138.08;
                            System.out.println("salario baixo fica" + salLiquidoFunc);
                        }else if (insalubridadeNivel.equalsIgnoreCase("medio")) {
                            salLiquidoFunc = salLiquidoFunc + 276.12;
                            System.out.println("salario medio fica" + salLiquidoFunc);
                        } else if (insalubridadeNivel.equalsIgnoreCase("alto")) {
                            salLiquidoFunc = salLiquidoFunc + 552.2;
                            System.out.println("salario alto fica" + salLiquidoFunc);
                        }
                    }
                }else if (insalubridade.equalsIgnoreCase("n")){
                    System.out.println("Nao tem adicional insalubridade");
                }else {
                    System.out.println("Digite apenas Y ou N");
                }
            }
//        Desconto de vale transportes

        System.out.println("qual o valor do vale transporte desse funcionario:");
        valeTrans = console.nextDouble();
        salario6 = salBrutoFunc * 0.60;

        if (valeTrans >= salario6) {
            salLiquidoFunc = salLiquidoFunc - salario6;
        } else {
            salLiquidoFunc = salLiquidoFunc - valeTrans;
        }
    }
}