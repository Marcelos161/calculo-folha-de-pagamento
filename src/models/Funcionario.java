package models;

public class Funcionario {
    private String nome;
    private String dataDeAdmissao;
    private String cargo;
    private String CPF;
    private double salBruto;
    private double horasTrabalhadas;
    private int diasTrabalhadosSem;
    private int dependetes;

    public int getDependetes() {
        return dependetes;
    }

    public void setDependetes(int dependetes) {
        this.dependetes = dependetes;
    }

    public int getDiasTrabalhadosSem() {
        return diasTrabalhadosSem;
    }

    public void setDiasTrabalhadosSem(int diasTrabalhadosSem) {
        this.diasTrabalhadosSem = diasTrabalhadosSem;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(String dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
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


    public Funcionario(String nome, String dataDeAdmissao, String cargo, String CPF, double salBruto, double horasTrabalhadas, int diasTrabalhadosSem, int dependentes) {
        this.cargo = cargo;
        this.dataDeAdmissao = dataDeAdmissao;
        this.nome = nome;
        this.CPF = CPF;
        this.salBruto = salBruto;
        this.horasTrabalhadas = horasTrabalhadas;
        this.diasTrabalhadosSem = diasTrabalhadosSem;
        this.dependetes = dependentes;
    }
}
