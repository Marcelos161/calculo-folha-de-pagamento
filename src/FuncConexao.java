import models.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncConexao {
    private static final String INSERIR_FUNC = "INSERT INTO funcionarios (nome, datadeadmissao, cargo, CPF, salBruto, horastrabalhadas, diastrabalhadossem, dependentes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String MOSTRAR_FUNCS = "SELECT * FROM funcionarios WHERE id = ?";
    private static final String MOSTRAR_FUNC_ID = "SELECT * FROM funcionarios";
    private static final String ATUALIZAR_SAL = "UPDATE funcionarios SET salBruto = ? WHERE id = ?";
    private static final String DESLIGAR_FUNC = "DELETE FROM funcionarios WHERE id = ?";

    public String adicionarFunc(String nome, String datadeadmissao, String cargo, String CPF, double salBruto, double horastrabalhadas, int diastrabalhadossem, int dependentes) {
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement statement = conexao.prepareStatement(INSERIR_FUNC);
            statement.setString(1, nome);
            statement.setString(2, datadeadmissao);
            statement.setString(3, cargo);
            statement.setString(4, CPF);
            statement.setDouble(5, salBruto);
            statement.setDouble(6, horastrabalhadas);
            statement.setInt(7, diastrabalhadossem);
            statement.setInt(8, dependentes);
            statement.executeUpdate();
            return "Funcionario adicionado com sucesso";
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "Erro ao adicionar funcionario";
    }

    public List<Funcionario> mostrarTodosFuncs() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement statement = conexao.prepareStatement(MOSTRAR_FUNCS);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("idfuncionarios");
                String nome = resultado.getString("nome");
                String cargo = resultado.getString("cargo");
                String dtadimssao = resultado.getString("datadeadmissao");
                String CPF = resultado.getString("CPF");
                double salBruto = resultado.getDouble("salBruto");
                double horastrabalhadas = resultado.getDouble("horastrabalhadas");
                int diastrabalhados = resultado.getInt("diastrabalhadossem");
                int depedentes = resultado.getInt("dependentes");
                Funcionario funcionario = new Funcionario(id, nome, dtadimssao, cargo, CPF, salBruto, horastrabalhadas, diastrabalhados, depedentes);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return funcionarios;
    }

    public String desligarFunc(int id) {
        String status = "erro ao deletar funcionario";
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement statement = conexao.prepareStatement(DESLIGAR_FUNC);
            statement.setInt(1, id);
            statement.executeUpdate();
            status = "Contato deletado com sucesso";
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public String atualizarSalario(int id, double salBruto) {
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement statement = conexao.prepareStatement(ATUALIZAR_SAL);
            statement.setDouble(1, salBruto);
            statement.setInt(2, id);
            statement.executeUpdate();
            return "Salario atualizado com sucesso";
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "erro ao atualizar funcionario";
    }

    public Funcionario FuncionarioPorID(int idPesquisa){
        try {
            Connection conexao = ConexaoBD.conectar();
            PreparedStatement statement = conexao.prepareStatement(MOSTRAR_FUNC_ID);
            statement.setInt(1, idPesquisa);
            ResultSet resultado = statement.executeQuery();

            int id = resultado.getInt("idfuncionarios");
            String nome = resultado.getString("nome");
            String cargo = resultado.getString("cargo");
            String dtadimssao = resultado.getString("datadeadmissao");
            String CPF = resultado.getString("CPF");
            double salBruto = resultado.getDouble("salBruto");
            double horastrabalhadas = resultado.getDouble("horastrabalhadas");
            int diastrabalhados = resultado.getInt("diastrabalhadossem");
            int depedentes = resultado.getInt("dependentes");
            Funcionario funcionario =new Funcionario(id, nome, dtadimssao, cargo, CPF, salBruto, horastrabalhadas,diastrabalhados, depedentes );
            return funcionario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
