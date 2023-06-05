package models;

public class FolhaDePagamento {
    private String nomeFunc;
    private String dataDeAdmissao;
    private String mesDeRef;
    private String cargo;
    private double salBruto;
    private double salPorhora;
    private double salLiquido;
    // Proventos
    private double valeTrans;
    private double valeAli;
    private double periculosidade;
    private double insalubridade;
    // Descontos
    private double valorInss;
    private double aliquotaEfetInss;
    private double baseDeCalcInss;
    private double valorIrrf;
    private double aliquotaEfetIrrf;
    private double baseDeCalcIrrf;
    private double valorFgts;
    private double aliquotaEfetFgts;
    private double baseDeCalcFgts;
    private double descValeTrans;
    private double descValeRef;
    private int numFaltas;

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(String dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public String getMesDeRef() {
        return mesDeRef;
    }

    public void setMesDeRef(String mesDeRef) {
        this.mesDeRef = mesDeRef;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalBruto() {
        return salBruto;
    }

    public void setSalBruto(double salBruto) {
        this.salBruto = salBruto;
    }

    public double getSalPorhora() {
        return salPorhora;
    }

    public void setSalPorhora(double salPorhora) {
        this.salPorhora = salPorhora;
    }

    public double getSalLiquido() {
        return salLiquido;
    }

    public void setSalLiquido(double salLiquido) {
        this.salLiquido = salLiquido;
    }

    public double getValeTrans() {
        return valeTrans;
    }

    public void setValeTrans(double valeTrans) {
        this.valeTrans = valeTrans;
    }

    public double getValeAli() {
        return valeAli;
    }

    public void setValeAli(double valeAli) {
        this.valeAli = valeAli;
    }

    public double getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(double periculosidade) {
        this.periculosidade = periculosidade;
    }

    public double getInsalubridade() {
        return insalubridade;
    }

    public void setInsalubridade(double insalubridade) {
        this.insalubridade = insalubridade;
    }

    public double getValorInss() {
        return valorInss;
    }

    public void setValorInss(double valorInss) {
        this.valorInss = valorInss;
    }

    public double getAliquotaEfetInss() {
        return aliquotaEfetInss;
    }

    public void setAliquotaEfetInss(double aliquotaEfetInss) {
        this.aliquotaEfetInss = aliquotaEfetInss;
    }

    public double getBaseDeCalcInss() {
        return baseDeCalcInss;
    }

    public void setBaseDeCalcInss(double baseDeCalcInss) {
        this.baseDeCalcInss = baseDeCalcInss;
    }

    public double getValorIrrf() {
        return valorIrrf;
    }

    public void setValorIrrf(double valorIrrf) {
        this.valorIrrf = valorIrrf;
    }

    public double getAliquotaEfetIrrf() {
        return aliquotaEfetIrrf;
    }

    public void setAliquotaEfetIrrf(double aliquotaEfetIrrf) {
        this.aliquotaEfetIrrf = aliquotaEfetIrrf;
    }

    public double getBaseDeCalcIrrf() {
        return baseDeCalcIrrf;
    }

    public void setBaseDeCalcIrrf(double baseDeCalcIrrf) {
        this.baseDeCalcIrrf = baseDeCalcIrrf;
    }

    public double getValorFgts() {
        return valorFgts;
    }

    public void setValorFgts(double valorFgts) {
        this.valorFgts = valorFgts;
    }

    public double getAliquotaEfetFgts() {
        return aliquotaEfetFgts;
    }

    public void setAliquotaEfetFgts(double aliquotaEfetFgts) {
        this.aliquotaEfetFgts = aliquotaEfetFgts;
    }

    public double getBaseDeCalcFgts() {
        return baseDeCalcFgts;
    }

    public void setBaseDeCalcFgts(double baseDeCalcFgts) {
        this.baseDeCalcFgts = baseDeCalcFgts;
    }

    public double getDescValeTrans() {
        return descValeTrans;
    }

    public void setDescValeTrans(double descValeTrans) {
        this.descValeTrans = descValeTrans;
    }

    public double getDescValeRef() {
        return descValeRef;
    }

    public void setDescValeRef(double descValeRef) {
        this.descValeRef = descValeRef;
    }

    public int getNumFaltas() {
        return numFaltas;
    }

    public void setNumFaltas(int numFaltas) {
        this.numFaltas = numFaltas;
    }


//    /**
//     * @param nomeFunc
//     * @param dataDeAdmissao
//     * @param mesDeRef
//     * @param cargo
//     * @param salBruto
//     * @param salPorhora
//     * @param salLiquido
//     * @param valeTrans
//     * @param valeAli
//     * @param periculosidade
//     * @param insalubridade
//     * @param valorInss
//     * @param aliquotaEfetInss
//     * @param baseDeCalcInss
//     * @param valorIrrf
//     * @param aliquotaEfetIrrf
//     * @param baseDeCalcIrrf
//     * @param valorFgts
//     * @param aliquotaEfetFgts
//     * @param baseDeCalcFgts
//     * @param descValeTrans
//     * @param descValeRef
//     * @param numFaltas
//     */
////    public FolhaDePagamento (String nomeFunc, String dataDeAdmissao, String mesDeRef, String cargo, double salBruto, double salPorhora, double salLiquido, double valeTrans, double valeAli, double periculosidade, double insalubridade, double valorInss, double aliquotaEfetInss, double baseDeCalcInss, double valorIrrf, double aliquotaEfetIrrf, double baseDeCalcIrrf, double valorFgts, double aliquotaEfetFgts, double baseDeCalcFgts, double descValeTrans, double descValeRef, int numFaltas) {
////        this.nomeFunc = nomeFunc;
////        this.dataDeAdmissao = dataDeAdmissao;
////        this.mesDeRef = mesDeRef;
////        this.cargo = cargo;
////        this.salBruto = salBruto;
////        this.salPorhora = salPorhora;
////        this.salLiquido = salLiquido;
////        this.valeAli = valeAli;
////        this.valeTrans = valeTrans;
////        this.periculosidade = periculosidade;
////        this.insalubridade = insalubridade;
////        this.valorInss = valorInss;
////        this.aliquotaEfetFgts = aliquotaEfetFgts;
////        this.aliquotaEfetInss = aliquotaEfetInss;
////        this.aliquotaEfetIrrf = aliquotaEfetIrrf;
////        this.baseDeCalcFgts = baseDeCalcFgts;
////        this.baseDeCalcInss = baseDeCalcInss;
////        this.baseDeCalcIrrf = baseDeCalcIrrf;
////        this.valorIrrf = valorIrrf;
////        this.valorFgts = valorFgts;
////        this.descValeTrans = descValeTrans;
////        this.descValeRef = descValeRef;
////        this.numFaltas = numFaltas;
////
////    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Mes de Referencia = %s \n", mesDeRef));
        sb.append(String.format("Nome = %s \n", nomeFunc));
        sb.append(String.format("Cargo do Colaborador = %s \n", cargo));
        sb.append(String.format("Salario Bruto = %s \n", salBruto));
        sb.append(String.format("Data de admissao em = %s \n", dataDeAdmissao));

        sb.append(String.format("Provento 1 insalubridade = %s \n", insalubridade));
        sb.append(String.format("Provento 2 periculosidade = %s \n", periculosidade));
        sb.append(String.format("Provento 3 vale alimentacao= %s \n", valeAli));
        sb.append(String.format("Provento 4 vale transporte= %s \n", valeTrans));

        sb.append(String.format("Desconto 1 INSS= %s \n", valorInss));
        sb.append(String.format("Desconto 2 FGTS= %s \n", valorFgts));
        sb.append(String.format("Desconto 3 Irrf= %s \n", valorIrrf));
        sb.append(String.format("Desconto 4 Vale refeicao= %s \n", descValeRef));
        sb.append(String.format("Desconto 5 Vale transporte= %s \n", descValeTrans));
        sb.append(String.format("Desconto 6 Numero de faltas= %s \n", numFaltas));


        sb.append(String.format("aliquota efetiva INSS = %s \n", aliquotaEfetInss));
        sb.append(String.format("Base de calculo IRRF = %s \n", baseDeCalcIrrf));
        sb.append(String.format("Salario Liquido = %s \n", salLiquido));
        sb.append(String.format("Salario por Hora = %s \n", salPorhora));


        return sb.toString();
    }

}
