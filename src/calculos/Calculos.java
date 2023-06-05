package calculos;

public class Calculos {

    private double salBruto;
    private double horasTrabalhadas;
    private int diasTrabalhadosSem;
    private int dependentes;
    private double baseCalcIRRF = salBruto - valorINSS() - (dependentes * 189.59);
    static final double FGTS = 0.08;
    static final double BAIXO = 138.08;
    static final double MEDIO = 276.12;
    static final double ALTO = 552.2;
    static final double ADPERIC = 0.30;

    public Calculos (double salBruto, double horasTrabalhadas, int diasTrabalhadosSem, int dependentes) {
        this.salBruto = salBruto;
        this.horasTrabalhadas = horasTrabalhadas;
        this.diasTrabalhadosSem = diasTrabalhadosSem;
        this.dependentes = dependentes;
    }

    //calcular salario hora
    public double salHora() {
        return salBruto / (horasTrabalhadas * (diasTrabalhadosSem * 4)) ;
    }

    //calcular FGTS
    public double valorFgts() {
        return salBruto * FGTS;
    }

    //desconto vale transporte
    public double descValeTrans(double valorVale) {
        if (valorVale >= (salBruto * 0.06)) {
            return salBruto * 0.06;
        } else {
            return valorVale;
        }
    }

    //calcular insalubridade
    public double Insalubridade(String nivel) {
        if (nivel.equalsIgnoreCase("baixo")) {
            return BAIXO;
        } else if (nivel.equalsIgnoreCase("medio")) {
            return MEDIO;
        } else if (nivel.equalsIgnoreCase("alto")){
            return ALTO;
        }
        return 0;
    }

    //desconto do INSS
    public double valorINSS () {
        if (salBruto <= 1302.00) { //1 faixa ate 1302 bruto
            return salBruto * 0.075;

        } else if (salBruto <= 2571.29) { //2 faixa
            return  (salBruto - 1302.00) * 0.09 + 97.65;

        } else if (salBruto <= 3856.94) { //3 faixa
            return (salBruto - 2571.29) * 0.12 + 211.89;

        } else if (salBruto <= 7507.49) { //4 faixa
            return (salBruto - 3856.94) * 0.14 + 366.16;
        } else {
            return  877.24;
        }
    }
    public double aliquotaEfetINSS (double valorINSS) {
        return valorINSS /salBruto;
    }

    //calcular periculosidade
    public double Periculosidade () {
        return (salBruto * ADPERIC);
    }

    //calcular vale ali
    public double valorValeAli(double valorDiario) {
       return valorDiario * (diasTrabalhadosSem * 4);
    }
    public double descValeAli(double desconto) {
        return (salBruto * (desconto/100));
    }

    //calcular IRRF
    public double valorIRRF () {

        if (baseCalcIRRF <= 1903.98){
           return 0;
        } else if (baseCalcIRRF <= 2826.65) {
            return (baseCalcIRRF - 142.80) * 0.075;
        } else if (baseCalcIRRF <= 3751.05) {
            return (baseCalcIRRF - 354.80) * 0.15;
        } else if (baseCalcIRRF <= 4664.68) {
            return (baseCalcIRRF - 636.13) * 0.225;
        } else  {
            return (baseCalcIRRF - 869.36) * 0.275;
        }
    }
    public double getBaseCalcIRRF() {
        return baseCalcIRRF;
    }
    public double aliquotaEfetIRRF() {
        return valorIRRF() / salBruto;
    }

}


