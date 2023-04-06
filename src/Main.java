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
        int horasTotais = 0; // Vai receber as horas totais no mes
        double salPorHora = 0; // Recebe o valor do salario dividido pelas horas trabalhadas
        String periculosidade = "";
        double adPeric = 0.30;
        double salLiquidoFunc = 0; // Salario liquido
        String insalubridade = "";
        String insalubridadeNivel = "";
        double valeTrans = 0;
        double salario6 = 0;
        int diasTrabMes = 0;
        int semanasMesAtual = 5;
        String valeAlimentacao = "";
        double valeAlimentacaoDia = 0;
        String descValeAlimentacao = "";
        double valorDescVA = 0;
        double valeAlimentacaoTotal = 0;
        double INSSContri = 0; //a quantidade em reais que o empregado tem que contribuir
        double aliquotaEfet = 0; // Aliquota efetiva do inss, ou seja é a porcentagem que vai incidir diretamente no salario
        double valorINSS = 0;


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

        diasTrabMes = diasTrabalho * semanasMesAtual; //calculo de dias trablhados no mes no total

        console.nextLine(); //Limpa o buffer do teclado

        horasTotaisSem = horasDiasFunc * diasTrabalho;
        horasTotais = horasTotaisSem * semanasMesAtual;
        salPorHora = salBrutoFunc / horasTotais;
        System.out.println(salPorHora); // CORRETO, JA DEBUGADO

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
                            System.out.println("salario baixo fica " + salLiquidoFunc);
                        }else if (insalubridadeNivel.equalsIgnoreCase("medio")) {
                            salLiquidoFunc = salLiquidoFunc + 276.12;
                            System.out.println("salario medio fica " + salLiquidoFunc);
                        } else if (insalubridadeNivel.equalsIgnoreCase("alto")) {
                            salLiquidoFunc = salLiquidoFunc + 552.2;
                            System.out.println("salario alto fica " + salLiquidoFunc);
                        }
                    }
                }else if (insalubridade.equalsIgnoreCase("n")){
                    System.out.println("Nao tem adicional insalubridade");
                }else {
                    System.out.println("Digite apenas Y ou N");
                }
            }
//        Desconto de vale transportes

        System.out.print("qual o valor do vale transporte desse funcionario em reais:");
        valeTrans = console.nextDouble();
        salario6 = salBrutoFunc * 0.06;

        if (valeTrans >= salario6) {
            salLiquidoFunc = salLiquidoFunc - salario6;
        } else {
            salLiquidoFunc = salLiquidoFunc - valeTrans;
        }
//                                      ATE AQUI TODAS AS CONTAS MATEMATICAS ESTAO CORRETAS obs: faltam algumas coisas no salario hora

//        Vale alimentacao

        console.nextLine(); // Limpeza de buffer novamente

        while (!valeAlimentacao.equalsIgnoreCase("y") && !valeAlimentacao.equalsIgnoreCase("n")) {
            System.out.print("O seu funcionario recebe o vale alimentacao? (Y/N): ");
            valeAlimentacao = console.nextLine();

            if (valeAlimentacao.equalsIgnoreCase("y")) {
                System.out.print("Qual o valor diario desse beneficio?:");
                valeAlimentacaoDia = console.nextDouble();

                valeAlimentacaoTotal = valeAlimentacaoDia * diasTrabMes;

                console.nextLine(); // Limpeza de buffer

                while (!descValeAlimentacao.equalsIgnoreCase("y") && !descValeAlimentacao.equalsIgnoreCase("n")) {
                    System.out.print("Ha desconto no salario por causa do vale alimentacao? (Y/N)");
                    descValeAlimentacao = console.nextLine();

                    if (descValeAlimentacao.equalsIgnoreCase("y")) {
                        System.out.print("Qual o valor do desconto em %: ");
                        valorDescVA = console.nextDouble();

                        salLiquidoFunc = salLiquidoFunc - ((valorDescVA / 100) * salLiquidoFunc);
                    }
                }
            }
        }

//        INSS obs: a calculadora ja esta calculando o valor do inss mas ainda falta calcular a aliquota efetiva

        if (salBrutoFunc <= 1302.00) { //1 faixa ate 1302 bruto
            valorINSS = salBrutoFunc * 0.075;

        } else if (salBrutoFunc <= 2571.29) { //2 faixa
            valorINSS = (salBrutoFunc - 1302.00) * 0.09 + 97.65;

        } else if (salBrutoFunc <= 3856.94) { //3 faixa
            valorINSS = (salBrutoFunc - 2571.29) * 0.12 + 114.24;

        } else if (salBrutoFunc <= 7507.49) { //4 faixa
            valorINSS = (salBrutoFunc - 3856.94) * 0.14 + 154.28;
        } else {
            valorINSS = 877.24;
        }

//        RESULTADOS DOS REQUISITOS #DEBUG
        System.out.println(nomeFunc);
        System.out.println(cargoFunc);
        System.out.println(salBrutoFunc);
        System.out.println(horasDiasFunc);
        System.out.println(diasTrabalho);
        System.out.println(horasTotaisSem);
        System.out.println(horasTotais);
        System.out.println(salPorHora);

        System.out.println(periculosidade); //periculosidade debbuger
        if (periculosidade.equalsIgnoreCase("y")){
            System.out.println(adPeric);
        } else {
            System.out.println("Nao teve adicional insalubridade");
        }

        if (insalubridadeNivel.equalsIgnoreCase("")) { //insalubridade debbuger
            System.out.println("nao houve adicional insalubridade"); //retorno se nao houve
        } else {
            System.out.println("insalubridade nivel:" + insalubridadeNivel.toUpperCase()); //retorno se houve, e qual o nivel
        }

        System.out.println(valeTrans);
        System.out.println(salario6); //6% do salario bruto

        System.out.println(valeAlimentacao);
    }
}