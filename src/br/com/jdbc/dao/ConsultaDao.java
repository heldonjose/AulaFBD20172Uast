/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.dao;

import br.com.jdbc.exception.DaoException;
import br.com.jdbc.model.Consulta;
import br.com.jdbc.model.Contato;
import br.com.jdbc.model.Paciente;
import br.com.jdbc.util.SQLUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prof Heldon
 */
public class ConsultaDao implements IconsultaDao {

    Connection conexao;
    PreparedStatement statement;

    public ConsultaDao() {

    }

    @Override
    public void salvar(Consulta consulta) throws DaoException {
        Calendar c = Calendar.getInstance();
        c.setTime(consulta.getDataConsulta());
        System.out.println("AQUi.;.............");
        System.out.println(c.getTimeInMillis());
        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.INSERT_CONSULTA_ALL);
            statement.setInt(1, consulta.getCodigoConsulta());
            statement.setDate(2, new java.sql.Date(c.getTimeInMillis()));
            statement.setInt(3, consulta.getMedico().getId());
            statement.setInt(4, consulta.getPaciente().getId());
            statement.setString(5, consulta.getTipoConsulta());
            statement.execute();
            int id_consulta = SQLUtil.getCurrentValorTabela("consulta");
            consulta.setId(id_consulta);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao inserir no banco de dados");
        }

    }

    @Override
    public List<Consulta> getAll() throws DaoException {
        List<Consulta> consultas = new ArrayList<>();

        //this.statement = conexao.prepareStatement("select * from consulta where " + param " = " + valor);
        try {

            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement("select * from consulta");
            //this.statement = conexao.prepareStatement("select * from paciente p , endereco e where p.endereco_id = e.id");

            ResultSet result = this.statement.executeQuery();
            Consulta c;
            MedicoDao medicoDao = new MedicoDao();
            PacienteDao pacienteDao = new PacienteDao();

            while (result.next()) {
                c = new Consulta();
                c.setId(result.getInt(1));
                c.setCodigoConsulta(result.getInt(2));
                c.setDataConsulta(result.getDate(3));
                c.setMedico(medicoDao.getPorId(result.getInt(4)));
                c.setPaciente(pacienteDao.getPorId(result.getInt(5)));
                c.setTipoConsulta(result.getString(6));

                consultas.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return consultas;

    }

    @Override
    public List<Consulta> getConsultasPorCpf(String cpf) throws DaoException {

        PacienteDao dao = new PacienteDao();
        Paciente paciente = dao.getPorCpf(cpf);

        return getConsultasPorIdPaciente(paciente.getId());

    }

    private List<Consulta> getConsultasPorIdPaciente(int id) {

        List<Consulta> consultas = new ArrayList<>();

        try {

            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement("select * from consulta where paciente_id = " + id);
            //this.statement = conexao.prepareStatement("select * from paciente p , endereco e where p.endereco_id = e.id");

            ResultSet result = this.statement.executeQuery();
            Consulta c;
            MedicoDao medicoDao = new MedicoDao();
            PacienteDao pacienteDao = new PacienteDao();

            while (result.next()) {
                c = new Consulta();
                c.setId(result.getInt(1));
                c.setCodigoConsulta(result.getInt(2));
                c.setDataConsulta(result.getDate(3));
                c.setMedico(medicoDao.getPorId(result.getInt(4)));
                c.setPaciente(pacienteDao.getPorId(result.getInt(5)));
                c.setTipoConsulta(result.getString(6));

                consultas.add(c);
            }

        } catch (Exception ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return consultas;
    }

}
