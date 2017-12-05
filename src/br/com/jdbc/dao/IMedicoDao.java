/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.dao;

import br.com.jdbc.exception.DaoException;
import br.com.jdbc.model.Medico;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IMedicoDao {
    public Medico salvar(Medico medico) throws DaoException;
    
    public List<Medico> getAll() throws DaoException;
    public List<Medico> getPorBusca(String busca) throws DaoException;
    
    public Medico getPorId(int id)throws DaoException;
}
