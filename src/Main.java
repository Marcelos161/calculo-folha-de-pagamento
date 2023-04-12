
import java.time.LocalDate;
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
        double adPeric = 30;
        double valorAddPeric = 0;
        double salLiquidoFunc = 0; // Salario liquido
        String insalubridade = "";
        String insalubridadeNivel = "";
        double valorValeTrans = 0;
        double salario6 = 0;
        int diasTrabMes = 0;
        int semanasMesAtual = 5;
        String valeAlimentacao = "";
        double valeAlimentacaoDia = 0;
        String descValeAlimentacao = "";
        double valorDescVA = 0;
        double aliquotaEfetINSS = 0; // Aliquota efetiva do inss, ou seja é a porcentagem que vai incidir diretamente no salariow
        double valorINSS = 0;
        double valorFGTS = 0;
        double salBase = 0;
        int depFunc = 0;
        double outDeducoes = 0;
        double deducaoIRRF = 0;
        double baseCalcIRRF = 0;
        double valorIrrf = 0;
        double aliquotaEfetIRRF = 0;
        double valorAddInsa = 0;
        double valorDescVT = 0;
        double valorValeAli = 0;
        int mes = LocalDate.now().getMonthValue();
        String mesAtual = "";
        int horasExtra = 0;
        int faltas = 0;
        double valorHorasExtra = 0;
        double qtdDescVA = 0;
        double valorFaltas = 0;
        double dataContrato = 0;



//        Switch para pegar mes
        switch (mes) {
            case 1: mesAtual = "Janeiro";
            break;
            case 2: mesAtual = "Fevereiro";
            break;
            case 3: mesAtual = "Março";
            break;
            case 4: mesAtual = "Abril";
            break;
            case 5: mesAtual = "Maio";
            break;
            case 6: mesAtual = "Junho";
            break;
            case 7: mesAtual = "Julho";
            break;
            case 8: mesAtual = "Agosto";
            break;
            case 9: mesAtual = "Outubro";
            break;
            case 10: mesAtual = "Setembro";
            break;
            case 11: mesAtual = "Novembro";
            break;
            case 12: mesAtual = "Dezembro";
            break;
            default: mesAtual = "Nao foi possivel definir o mes";
            break;
        }


//          Inicio
        System.out.println("Bem vindo ao app para calcular a folha de pagamento de funcionario");

        System.out.print("Primeiramente digite o nome do funcionario: ");
        nomeFunc = console.nextLine();

        System.out.print("Digite a data de admissao do funcionario: ");
        dataContrato = console.nextDouble();

        console.nextLine();

        System.out.print("Cargo do funcionario: ");
        cargoFunc = console.nextLine();

        System.out.print("Salario bruto do funcionario: ");
        salBrutoFunc = console.nextDouble();

        System.out.print("Horas diarias trabalhadas por esse funcionario:");
        horasDiasFunc = console.nextInt();

        System.out.print("Houveram horas extras, quantas? (caso nao tenha digite 0): ");
        horasExtra = console.nextInt();

        System.out.print("Quantos dias esse funcionario trabalha na semana: ");
        diasTrabalho = console.nextInt();

        System.out.print("Houveram faltas? quantas (caso nao tenha digite 0): ");
        faltas = console.nextInt();

        console.nextLine();
//          calculo de periculosidade

        while (!periculosidade.equalsIgnoreCase("y") && !periculosidade.equalsIgnoreCase("n")) {
            System.out.print("O trabalhador tem direito ao adicional periculosidade? (Y/N)");
            periculosidade = console.nextLine();

            if (periculosidade.equalsIgnoreCase("y")) {
                valorAddPeric = (salBrutoFunc * (adPeric / 100));
            } else if (periculosidade.equalsIgnoreCase("n")){
                System.out.println("Nao tem adicional periculosidade");
                valorAddPeric = 0;
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
                            valorAddInsa = 138.08;
                        }else if (insalubridadeNivel.equalsIgnoreCase("medio")) {
                            valorAddInsa = 276.12;
                        } else if (insalubridadeNivel.equalsIgnoreCase("alto")) {
                            valorAddInsa = 552.2;
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
        valorValeTrans = console.nextDouble();
        salario6 = salBrutoFunc * 0.06;

        if (valorValeTrans >= salario6) {
            valorDescVT = salario6;
        } else {
            valorDescVT = valorValeTrans;
        }
//                                      ATE AQUI TODAS AS CONTAS MATEMATICAS ESTAO CORRETAS obs: faltam algumas coisas no salario hora

        //        calculo de salario por horas

        diasTrabMes = diasTrabalho * semanasMesAtual - faltas; //calculo de dias trablhados no mes no total

        horasTotaisSem = horasDiasFunc * diasTrabalho;
        horasTotais = horasTotaisSem * semanasMesAtual;
        salPorHora = salBrutoFunc / horasTotais;
        valorFaltas = salPorHora * faltas * horasDiasFunc;

        console.nextLine(); // Limpeza de buffer novamente

//        Vale alimentacao

        while (!valeAlimentacao.equalsIgnoreCase("y") && !valeAlimentacao.equalsIgnoreCase("n")) {
            System.out.print("O seu funcionario recebe o vale alimentacao? (Y/N): ");
            valeAlimentacao = console.nextLine();

            if (valeAlimentacao.equalsIgnoreCase("y")) {
                System.out.print("Qual o valor diario desse beneficio?:");
                valeAlimentacaoDia = console.nextDouble();

                valorValeAli = valeAlimentacaoDia * diasTrabMes;

                console.nextLine(); // Limpeza de buffer

                while (!descValeAlimentacao.equalsIgnoreCase("y") && !descValeAlimentacao.equalsIgnoreCase("n")) {
                    System.out.print("Ha desconto no salario por causa do vale alimentacao? (Y/N)");
                    descValeAlimentacao = console.nextLine();

                    if (descValeAlimentacao.equalsIgnoreCase("y")) {
                        System.out.print("Qual o valor do desconto em %: ");
                        qtdDescVA = console.nextDouble();

                        valorDescVA = qtdDescVA / 100 * salBrutoFunc;
                    }
                }
            }
        }

//          valor do INSS + aliquota efetiva

        if (salBrutoFunc <= 1302.00) { //1 faixa ate 1302 bruto
            valorINSS = salBrutoFunc * 0.075;

        } else if (salBrutoFunc <= 2571.29) { //2 faixa
            valorINSS = (salBrutoFunc - 1302.00) * 0.09 + 97.65;

        } else if (salBrutoFunc <= 3856.94) { //3 faixa
            valorINSS = (salBrutoFunc - 2571.29) * 0.12 + 211.89;

        } else if (salBrutoFunc <= 7507.49) { //4 faixa
            valorINSS = (salBrutoFunc - 3856.94) * 0.14 + 366.16;
        } else {
            valorINSS = 877.24;
        }

        aliquotaEfetINSS = valorINSS / salBrutoFunc; // aliquota efetiva do INSS em %

//        FGTS Calculo

        valorFGTS = salBrutoFunc * 0.08;

//        IRRF Calculo

        salBase = salBrutoFunc - valorINSS;

        System.out.print("O empregado tem quantos dependentes?: ");
        depFunc = console.nextInt();

        System.out.print("Digite o valor das outras deducoes, se nao houver digite 0: ");
        outDeducoes = console.nextDouble();

        deducaoIRRF = 189.59 * depFunc + outDeducoes;

        baseCalcIRRF = salBase - deducaoIRRF;

        if (baseCalcIRRF <= 1903.98){
            valorIrrf = 0;
        } else if (baseCalcIRRF <= 2826.65) {
            valorIrrf = (baseCalcIRRF - 142.80) * 0.075;
        } else if (baseCalcIRRF <= 3751.05) {
            valorIrrf = (baseCalcIRRF - 354.80) * 0.15;
        } else if (baseCalcIRRF <= 4664.68) {
            valorIrrf = (baseCalcIRRF - 636.13) * 0.225;
        } else  {
            valorIrrf = (baseCalcIRRF - 869.36) * 0.275;
        }

        aliquotaEfetIRRF = valorIrrf / salBrutoFunc;


//        calculo de horas extras

        valorHorasExtra = (horasExtra * salPorHora) + (salPorHora / 2 * horasExtra);

//        faltas
        valorFaltas = (faltas * salPorHora * diasTrabalho);
//        Salario Liquido
        salLiquidoFunc = salBrutoFunc + valorAddPeric + valorAddInsa - valorINSS + valorHorasExtra - valorDescVA - valorFaltas + valorValeAli - valorDescVT;

//        Resultados pedidos

        System.out.println("Mes de referencia " + mesAtual);
        System.out.println("----------------------------------------------");
        System.out.println("O colaborador de nome: " + nomeFunc);
        System.out.println("Com data de admissao em " + dataContrato);
        System.out.println("Cargo: " + cargoFunc);
        System.out.println("Salario liquido: " + Math.round(salLiquidoFunc));
        System.out.println("--------------------------------------------------");
        System.out.println("Proventos: " );
        System.out.println("Adicional periculosidade: " + Math.round(valorAddPeric) + "R$ " + adPeric + "%");
        System.out.println("Adicional insalubridade: " + Math.round(valorAddInsa) + "R$ Grau:" + insalubridadeNivel);
        System.out.println("Vale alimentacao no valor de: " + valeAlimentacaoDia + " que no total fica: " + Math.round(valorValeAli) + " e é descontado:" + Math.round(valorDescVA) + "R$ no salario");
        System.out.println("Vale transporte no valor de: " + valorValeTrans + "R$ e é descontado:" + valorDescVT + "R$ no salario");
        System.out.println("Horas extras: " + horasExtra + "Horas, valor total das horas extras: " + Math.round(valorHorasExtra));
        System.out.println("---------------------------------------------------------------");
        System.out.println("Descontos: ");
        System.out.println("O Inss desconta: " + aliquotaEfetINSS + "% de aliquota efetiva do seu salario, e corresponde a " + Math.round(valorINSS) + "R$");
        System.out.println("O FGTS desconta: 8% que corresponde a: " + Math.round(valorFGTS));
        System.out.println("O IRRF desconta: " + aliquotaEfetIRRF + "% de aliquota efetiva do salario base que é:" + Math.round(baseCalcIRRF) + ", e corresponde a " + Math.round(valorIrrf) + "R$");
        System.out.println("Desconto de faltas: " + Math.round(valorFaltas) + "R$");
    }
}