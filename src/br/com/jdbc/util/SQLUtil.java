package br.com.jdbc.util;

import br.com.jdbc.dao.SQLConnection;
import br.com.jdbc.exception.DaoException;
import br.com.jdbc.model.Contato;
import br.com.jdbc.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SQLUtil {

    private SQLUtil() {
    }

//SQL CONEXAO
    public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/aulafbd";
    public static String USUARIO_POSTGRES = "postgres";
    public static String SENHA_POSTGRES = "postgres";

//SQLs PACIENTE
    public static String INSERT_ENDERECO_ALL = "insert into endereco  (cep, logradouro, numero, cidade, uf) values (?,?, ?, ?, ?) ";
    public static String INSERT_CONTATO_ALL = "insert into contato  (descricao, tipo, paciente_id) values (?,?, ?) ";
    public static String INSERT_PACIENTE_ALL = "INSERT INTO paciente (nome, cpf, endereco_id) values (?, ?, ?)";
    public static String SELECT_ALL_PACINETE = "SELECT * FROM PACIENTE";
    public static String SELECT_ALL_PACINETE_ID_NOME = "SELECT id, nome FROM PACIENTE";
    public static String SELECT_PACINETE_WHERE = "SELECT * FROM paciente WHERE ";
    
    

//SQLs Médico
    public static String INSERT_MEDICO_ALL = "INSERT INTO medico (nome, crm, especializacao) values(?, ?, ?)";
    
    //sqls Consulta
    
      public static String INSERT_CONSULTA_ALL = "INSERT INTO consulta (codigoconsulta, dataconsulta, medico_id, paciente_id, descricao) values (?, ?,? , ?, ?)";
    
    public static int getCurrentValorTabela(String nomeTabela) throws DaoException {
        int id = 0;
        try {
            Connection conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            //PreparedStatement statement = conexao.prepareStatement("SELECT currval('endereco_id_seq');");
            PreparedStatement statement = conexao.prepareStatement("select * from " + nomeTabela + " order by id desc limit 1");
            ResultSet result = statement.executeQuery();
            result.next();
            id = result.getInt(1);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("erro ao consulta corrent valor da tabela no banco de dados");
        }
        return id;
    }

    public static void salvarEndereco(Endereco end) throws DaoException {
        try {
            Connection conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            //PreparedStatement statement = conexao.prepareStatement("SELECT currval('endereco_id_seq');");
            PreparedStatement statement = conexao.prepareStatement(INSERT_ENDERECO_ALL);
            statement.setString(1, end.getCep());
            statement.setString(2, end.getLogradouro());
            statement.setString(3, end.getNumero());
            statement.setString(4, end.getCidade());
            statement.setString(5, end.getUf());
            statement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao inserir no banco de dados");
        }
    }

    public static void salvarContato(Contato contato, int id_paciente) throws DaoException {
        try {
            Connection conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            //PreparedStatement statement = conexao.prepareStatement("SELECT currval('endereco_id_seq');");
            PreparedStatement statement = conexao.prepareStatement(INSERT_CONTATO_ALL);
            statement.setString(1, contato.getDescricao());
            statement.setString(2, contato.getTipo());
            statement.setInt(3, id_paciente);
            statement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao inserir no banco de dados");
        }

    }

    public static Endereco getEnderecoPorID(int id) throws DaoException {
        try {
            Connection conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            //PreparedStatement statement = conexao.prepareStatement("SELECT currval('endereco_id_seq');");
            PreparedStatement statement = conexao.prepareStatement("select * from endereco where id = " + id);
            ResultSet result = statement.executeQuery();
            result.next();

            Endereco end = new Endereco();
            end.setId(result.getInt(1));
            end.setCep(result.getString(2));
            end.setLogradouro(result.getString(3));
            end.setNumero(result.getString(4));
            end.setCidade(result.getString(5));
            end.setUf(result.getString(6));
            return end;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("erro ao consulta corrent valor da tabela no banco de dados");
        }
    }

    public static List<Contato> getContatosPorPacienteId(int id) throws DaoException {
        try {
            Connection conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            //PreparedStatement statement = conexao.prepareStatement("SELECT currval('endereco_id_seq');");
            PreparedStatement statement = conexao.prepareStatement("select * from contato where paciente_id = " + id);
            ResultSet result = statement.executeQuery();
            List<Contato> contatos = new ArrayList<>();
            Contato c;
            while (result.next()) {
                c = new Contato(result.getString(2), result.getString(3));
                c.setId(result.getInt(1));
                contatos.add(c);
            }
            return contatos;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("erro ao consulta corrent valor da tabela no banco de dados");
        }
    }
    
   

}
