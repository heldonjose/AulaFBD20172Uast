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
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public class MedicoDao implements IMedicoDao{
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medico> getPorBusca(String busca) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medico getPorId(int id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
