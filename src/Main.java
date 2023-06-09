
import calculos.Calculos;
import models.FolhaDePagamento;
import models.Funcionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner console = new Scanner(System.in);

    static Funcionario funcionario = new Funcionario();

    static String mesAtual() {
        int mes = LocalDate.now().getMonthValue();
        String mesAtual;
        switch (mes) {
            case 1:
                mesAtual = "Janeiro";
                break;
            case 2:
                mesAtual = "Fevereiro";
                break;
            case 3:
                mesAtual = "Março";
                break;
            case 4:
                mesAtual = "Abril";
                break;
            case 5:
                mesAtual = "Maio";
                break;
            case 6:
                mesAtual = "Junho";
                break;
            case 7:
                mesAtual = "Julho";
                break;
            case 8:
                mesAtual = "Agosto";
                break;
            case 9:
                mesAtual = "Outubro";
                break;
            case 10:
                mesAtual = "Setembro";
                break;
            case 11:
                mesAtual = "Novembro";
                break;
            case 12:
                mesAtual = "Dezembro";
                break;
            default:
                mesAtual = "Nao foi possivel definir o mes";
                break;
        }
        return mesAtual;
    }

    static List<Funcionario> funcionarios = new ArrayList<>();

    static FuncConexao conexao = new FuncConexao();

    static String adicionarNovoFunc() {
        String nomeFunc;
        String admissaoFunc;
        String cargoFunc;
        String cpfFunc;
        double salBruto;
        double horasTrabalhadasFunc;
        int diasTrabalhadosFunc;
        int dependentes;
        System.out.println("voce selecionou adicionar um novo funcionario,");
        System.out.print("Digite o nome do funcionario:");
        nomeFunc = console.nextLine();
        System.out.print("Data de adimissao (dd/mm/aa):");
        admissaoFunc = console.nextLine();
        System.out.print("Cargo do Funcionario:");
        cargoFunc = console.nextLine();
        System.out.print("CPF do Funcionario:");
        cpfFunc = console.nextLine();
        System.out.print("Digite o valor bruto do Funcionario:");
        salBruto = console.nextDouble();
        System.out.print("Digite as horas trabalhas pelo Funcionario:");
        horasTrabalhadasFunc = console.nextDouble();
        System.out.print("Digite quantos dias na semana trabalhada esse Funcionario:");
        diasTrabalhadosFunc = console.nextInt();
        System.out.print("Digite o numero de dependentes que tem esse Funcionario:");
        dependentes = console.nextInt();

        conexao.adicionarFunc(nomeFunc, admissaoFunc, cargoFunc, cpfFunc, salBruto, horasTrabalhadasFunc, diasTrabalhadosFunc, dependentes);
        return "Funcionario adicionado com sucesso";
    }

    static FolhaDePagamento gerarFolha() {
        FolhaDePagamento folha = new FolhaDePagamento();
        Calculos calc = new Calculos(funcionario.getSalBruto(), funcionario.getHorasTrabalhadas(), funcionario.getDiasTrabalhadosSem(), funcionario.getDependetes());

        folha.setMesDeRef(mesAtual());
        folha.setNomeFunc(funcionario.getNome());
        folha.setDataDeAdmissao(funcionario.getDataDeAdmissao());
        folha.setCargo(funcionario.getCargo());
        folha.setSalBruto(funcionario.getSalBruto());
        folha.setValorFgts(calc.valorFgts());
        folha.setSalPorhora(calc.salHora());
        folha.setInsalubridade(calc.Insalubridade("0"));
        folha.setPericulosidade(calc.Periculosidade());
        folha.setValeAli(calc.valorValeAli(50));
        folha.setValeTrans(100);
        folha.setValorInss(calc.valorINSS());
        folha.setValorFgts(calc.valorFgts());
        folha.setValorIrrf(calc.valorIRRF());
        folha.setDescValeRef(calc.descValeAli(5));
        folha.setDescValeTrans(calc.descValeTrans(150));
        folha.setNumFaltas(5);
        folha.setAliquotaEfetInss(calc.aliquotaEfetINSS(folha.getValorInss()));
        folha.setBaseDeCalcIrrf(calc.getBaseCalcIRRF());

        return folha;
    }

    static void mostrarFuncs() {
        conexao.mostrarTodosFuncs();
    }

    static void modifierFunc() {

    }

    static void desligarFunc() {

    }

    public static void main(String[] args) {
        int entrada;
        System.out.println("Bem vindo ao programa de gera folha de pagamentos.");
        System.out.println("Deseja fazer o que? 1. Adicionar novo funcionario; 2. Mostrar todos os funcionarios registrados; 3. Modificar salario bruto de funcionario; 4. Deletar funcionario; 5. Gerar folha de funcionario especifico;");
        entrada = console.nextInt();
        switch (entrada) {
            case 1:
                System.out.println(adicionarNovoFunc());
                break;
            case 2:
                mostrarFuncs();
                break;
            case 3:
                modifierFunc();
                break;
            case 4:
                desligarFunc();
                break;
            default:
                gerarFolha();
        }
    }
}
