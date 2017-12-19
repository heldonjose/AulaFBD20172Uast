/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.dao;

import br.com.jdbc.adapter.PacienteAdapter;
import br.com.jdbc.exception.DaoException;
import br.com.jdbc.model.Contato;
import br.com.jdbc.model.Endereco;
import br.com.jdbc.model.Paciente;
import br.com.jdbc.util.SQLUtil;
import static br.com.jdbc.util.SQLUtil.INSERT_ENDERECO_ALL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacienteDao implements IPacienteDao {

    Connection conexao;
    PreparedStatement statement;

    public PacienteDao() {
    }

    @Override

    public Paciente salvar(Paciente paciente) throws DaoException {

        try {
            SQLUtil.salvarEndereco(paciente.getEnd());
            int id_endereco = SQLUtil.getCurrentValorTabela("endereco");

            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.INSERT_PACIENTE_ALL);
            statement.setString(1, paciente.getNome());
            statement.setString(2, paciente.getCpf());
            statement.setInt(3, id_endereco);
            statement.execute();
            int id_paciente = SQLUtil.getCurrentValorTabela("paciente");
            paciente.setId(id_paciente);

            for (Contato c : paciente.getContatos()) {
                SQLUtil.salvarContato(c, id_paciente);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao inserir no banco de dados");
        }

        return paciente;
    }

    @Override
    public List<Paciente> getAll() throws DaoException {
        List<Paciente> pacientes = new ArrayList<>();

        try {

            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement("select * from paciente");
            //this.statement = conexao.prepareStatement("select * from paciente p , endereco e where p.endereco_id = e.id");

            ResultSet result = this.statement.executeQuery();
            Paciente p;
            while (result.next()) {
                p = new Paciente();
                p.setId(result.getInt(1));
                p.setNome(result.getString(2));
                p.setCpf(result.getString(3));
                //Endereco end = new Endereco();
                //end.setId(result.getInt(5));
                //end.setCep(result.getString(6));
                //end.setLogradouro(result.getString(7));
                //end.setNumero(result.getString(8));
                //end.setCidade(result.getString(9));
                //end.setUf(result.getString(10));
                //p.setEnd(end);
                p.setEnd(SQLUtil.getEnderecoPorID(result.getInt(4)));
                p.setContatos(SQLUtil.getContatosPorPacienteId(p.getId()));
                pacientes.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pacientes;
    }

    @Override
    public List<PacienteAdapter> getAllAdapter() throws DaoException {

        List<PacienteAdapter> pacientes = new ArrayList<>();

        try {

            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.SELECT_ALL_PACINETE_ID_NOME);

            ResultSet result = this.statement.executeQuery();
            PacienteAdapter p;
            while (result.next()) {
                p = new PacienteAdapter();
                p.setId(result.getInt(1));
                p.setNome(result.getString(2));
                pacientes.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pacientes;
    }

    @Override
    public Paciente getPorId(int id) throws DaoException {
        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement("SELECT * FROM paciente WHERE id = " + id);
            ResultSet result = this.statement.executeQuery();
            result.next();
            Paciente p = new Paciente();
            p.setId(result.getInt(1));
            p.setNome(result.getString(2));
            p.setCpf(result.getString(3));
            return p;
        } catch (SQLException ex) {
            throw new DaoException("ERRO AO CONSULTAR NO BANCO DE DADOS");
        }

    }

    @Override
    public List<Paciente> getPorBusca(String busca) throws DaoException {

        List<Paciente> pacientes = new ArrayList<>();
        try {

            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement("SELECT * FROM paciente WHERE nome ilike '%" + busca + "%' or "
                    + "cpf ilike '%" + busca + "%';");

            ResultSet result = this.statement.executeQuery();
            Paciente p;
            while (result.next()) {
                p = new Paciente();
                p.setId(result.getInt(1));
                p.setNome(result.getString(2));
                p.setCpf(result.getString(3));
                pacientes.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pacientes;
    }

    @Override
    public Paciente getPorCpf(String cpf) throws DaoException {
          try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement("SELECT * FROM paciente where cpf  = '" + cpf + "'");
            ResultSet result = this.statement.executeQuery();
            result.next();
            Paciente p = new Paciente();
            p.setId(result.getInt(1));
            p.setNome(result.getString(2));
            p.setCpf(result.getString(3));
            return p;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("ERRO AO CONSULTAR NO BANCO DE DADOS");
        }

    }

}
