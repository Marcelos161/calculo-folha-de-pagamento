
import calculos.Calculos;
import models.FolhaDePagamento;
import models.Funcionario;

import java.time.LocalDate;

public class Main {

    static String mesAtual() {
        int mes = LocalDate.now().getMonthValue();
        String mesAtual;
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
        return mesAtual;
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

    static Funcionario funcionario = new Funcionario("Marcelo Diogo", "22/11/2002", "Padeiro", "14247822608", 1350.80, 7.4, 6, 2);

    public static void main(String[] args) {


        System.out.println(gerarFolha());
    }
}