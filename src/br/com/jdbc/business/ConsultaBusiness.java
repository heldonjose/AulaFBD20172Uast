/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.business;

import br.com.jdbc.model.Consulta;
import br.com.jdbc.util.ValidacaoUtil;

/**
 *
 * @author prof Heldon
 */
public class ConsultaBusiness implements IConsultaBusiness{

    @Override
    public void salvar(Consulta consulta) {
    try {
            ValidacaoUtil.validarConsulta(consulta);
            medico = daoMedico.salvar(medico);
            return medico;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }  
    }
    
}
