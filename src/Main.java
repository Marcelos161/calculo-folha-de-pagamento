import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Outras variaveis
        Scanner console = new Scanner(System.in);

        // Variaveis do funcionario
        String nomeFunc = "";
        String cargoFunc = "";
        BigDecimal salBrutoFunc = new BigDecimal("0"); //Salario bruto do funcionario
        int diasTrabalho = 0; // Dias totais da semana em que o funcionario trabalha
        int horasDiasFunc = 0; //Quantas Horas no dia o funcionario trabalha
        int horasTotaisSem = 0; //Vai receber quantas horas totais o funcionario trabalha na semana
        int horasTotais = 0; // Vai receber as horas totais
        BigDecimal salPorHora = new BigDecimal("0"); // Recebe o valor do salario dividido pelas horas trabalhadas
        String periculosidade = "N";
        BigDecimal adPeric = new BigDecimal(0.30);
        BigDecimal salLiquidoFunc = new BigDecimal("0"); // Salario liquido

        // Inicio
        System.out.println("Bem vindo ao app para calcular a folha de pagamento de funcionario");

        // calculo de salario por horas trabalhadas
        System.out.print("Primeiramente digite o nome do funcionario: ");
        nomeFunc = console.nextLine();
        System.out.print("Seu cargo: ");
        cargoFunc = console.nextLine();
        System.out.print("Digite o salario bruto do funcionario: ");
        salBrutoFunc = console.nextBigDecimal();
        System.out.print("Agora digite as horas diarias trabalhadas por esse funcionario:");
        horasDiasFunc = console.nextInt();
        System.out.print("Quantos dias esse funcionario trabalha na semana: ");
        diasTrabalho = console.nextInt();

        console.nextLine(); //Limpa o buffer do teclado
//        calculos
        horasTotaisSem = horasDiasFunc * diasTrabalho;
        horasTotais = horasTotaisSem * 5;
        salPorHora = salBrutoFunc.divide(BigDecimal.valueOf(horasTotais));
        System.out.println(salPorHora);

//      calculo de periculosidade
        
        System.out.print("O trabalhador tem direito ao adicional periculosidade? (Y/N)");
        periculosidade = console.nextLine();

           if (periculosidade.equalsIgnoreCase("y")) {
           salLiquidoFunc = salBrutoFunc.add(salBrutoFunc.multiply(adPeric));
           } else if (periculosidade.equalsIgnoreCase("n")){
            System.out.println("Nao tem adicional periculosidade");
           } else {
               System.out.println("Digite apenas Y ou N ");
           }

        System.out.println(salLiquidoFunc);
    }
}