/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.business;

import br.com.jdbc.exception.BusinessException;
import br.com.jdbc.model.Consulta;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IConsultaBusiness {
    public void salvar(Consulta consulta);
     
//   public Consulta salvar(Consulta consulta)throws BusinessException;
//
    public List<Consulta> getAll() throws BusinessException;
//
//    public Consulta getPorId(int id)  throws BusinessException;
//
   public List<Consulta> getPorCPF(String cpf) throws BusinessException;
//
//    public List<Consulta> getAll() throws BusinessException;

}
