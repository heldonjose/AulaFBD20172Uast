/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.dao;

import br.com.jdbc.exception.DaoException;
import br.com.jdbc.model.Contato;
import br.com.jdbc.model.Medico;
import br.com.jdbc.util.SQLUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prof Heldon
 */
public class MedicoDao implements IMedicoDao {

    Connection conexao;
    PreparedStatement statement;

    @Override
    public Medico salvar(Medico medico) throws DaoException {
        try {

            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.INSERT_MEDICO_ALL);
            statement.setString(1, medico.getNome());
            statement.setInt(2, medico.getCRM());
            statement.setString(3, medico.getEspecializacao());
            statement.execute();
            int id_medico = SQLUtil.getCurrentValorTabela("medico");
            medico.setId(id_medico);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao inserir no banco de dados");
        }

        return medico;
    }

    @Override
    public List<Medico> getAll() throws DaoException {
          List<Medico> medicos = new ArrayList<>();
        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);

            this.statement = conexao.prepareStatement("select * from medico " );
            
            ResultSet result = this.statement.executeQuery();
            Medico medico;
            while(result.next()){
           
            medico= new Medico();
            
            medico.setId(result.getInt(1));
            medico.setNome(result.getString(2));
            medico.setCRM(result.getInt(3));
            medico.setEspecializacao(result.getString(4));
            medicos.add(medico);
            }
            return medicos;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao buscar no banco de Dados");
        
        }
    
    
    }

    @Override
    public List<Medico> getPorBusca(String busca) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medico getPorId(int id) throws DaoException {
           Medico medico = new Medico();
        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);

            this.statement = conexao.prepareStatement("select * from medico where id = " + String.valueOf(id));

            ResultSet result = this.statement.executeQuery();
            result.next();

            medico.setId(result.getInt(1));
            medico.setNome(result.getString(2));
            medico.setCRM(result.getInt(3));
            medico.setEspecializacao(result.getString(4));
            return medico;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao buscar no banco de Dados");
        }
    }

    @Override
    public Medico getPorCrm(int crm) throws DaoException {
        Medico medico = new Medico();
        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);

            this.statement = conexao.prepareStatement("select * from medico where crm = " + String.valueOf(crm));

            ResultSet result = this.statement.executeQuery();
            result.next();

            medico.setId(result.getInt(1));
            medico.setNome(result.getString(2));
            medico.setCRM(result.getInt(3));
            medico.setEspecializacao(result.getString(4));
            return medico;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao buscar no banco de Dados");
        }

    }

}
