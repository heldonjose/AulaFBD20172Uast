/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.model;

import br.com.jdbc.model.Medico;
import br.com.jdbc.model.Paciente;
import java.util.Calendar;

/**
 *
 * @author prof Heldon
 */
public class Consulta {
       private int id;
       private int codigoConsulta;
       private Calendar dataConsulta;
       private String tipoConsulta;
       private Medico medico;
       private Paciente paciente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(int codigo) {
        this.codigoConsulta = codigo;
    }

    public Calendar getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Calendar dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
