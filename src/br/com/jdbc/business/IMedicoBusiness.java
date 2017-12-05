/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.business;


import br.com.jdbc.exception.BusinessException;
import br.com.jdbc.model.Medico;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IMedicoBusiness {
    
    public Medico salvar(Medico medico)throws BusinessException;

    public List<Medico> getAll(String busca) throws BusinessException;

    public Medico getPorId(int id)  throws BusinessException;
}
