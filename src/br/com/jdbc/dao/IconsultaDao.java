/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.dao;

import br.com.jdbc.exception.DaoException;
import br.com.jdbc.model.Consulta;
import br.com.jdbc.model.Paciente;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IconsultaDao {
    
        public void salvar(Consulta consulta) throws DaoException;
        
        public List<Consulta> getAll() throws DaoException;
        

        public List<Consulta> getConsultasPorCpf(String cpf) throws DaoException;

}
