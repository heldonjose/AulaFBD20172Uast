/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.util;

import br.com.jdbc.exception.BusinessException;
import br.com.jdbc.model.Medico;
import br.com.jdbc.model.Paciente;

/**
 *
 * @author prof Heldon
 */
public class ValidacaoUtil {

    public static void validarMedico(Medico medico) throws BusinessException {
        if (medico.getNome().split(" ").length < 2) {
            throw new BusinessException("Medico deve conter nome e sobrenome");
        }
    }

    private ValidacaoUtil() {
    }
    
    
    
     public static void validarPaciente(Paciente paciente) throws BusinessException {

        if (paciente.getNome().split(" ").length < 2) {
            throw new BusinessException("Paciente deve conter nome e sobrenome");
        }
        
        if(paciente.getContatos().isEmpty()){
            throw new BusinessException("Paciente deve conter pelo menos 1 contato");
            
        }
        
        
        

    }
}
