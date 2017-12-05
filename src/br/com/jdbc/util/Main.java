
package br.com.jdbc.util;

import br.com.jdbc.enuns.Constante;
import br.com.jdbc.exception.BusinessException;
import br.com.jdbc.fachada.CoreFacade;
import br.com.jdbc.fachada.ICoreFacade;
import br.com.jdbc.model.Consulta;
import br.com.jdbc.model.Contato;
import br.com.jdbc.model.Endereco;
import br.com.jdbc.model.Medico;
import br.com.jdbc.model.Paciente;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static ICoreFacade fachada = new CoreFacade();

    public static void main(String a[]) {


            //cadastrarPacientes();

            
            System.out.println("INICIO MEDICO");
            cadastrarMedicos();
            System.out.println("Fim MEDICO");

            
         //   listarMedicosEPacientes();

          //  cadastrarConsultas();

            listarConsultas();

        
    }

    private static void cadastrarPacientes() {

        Paciente p1 = new Paciente();

        p1.setNome("Héldon José Oliveira Albuquerque");
        p1.setCpf("050.140.284-54");

        Endereco e1 = new Endereco();
        e1.setCep("58701-090");
        e1.setCidade("Patos");
        e1.setLogradouro("Capitão Crisanto");
        e1.setNumero("42");
        e1.setUf("PB");

        p1.setEnd(e1);

        Contato c1 = new Contato("83-9-9627-9632", Constante.TIPO_CONTATO_TELEFONE);
        Contato c2 = new Contato("heldonjose@gmail.com", Constante.TIPO_CONTATO_EMAIL);

        p1.addContato(c1);
        p1.addContato(c2);

        try {
            fachada.salvarPaciente(p1);
        } catch (BusinessException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        p1 = new Paciente();

        p1.setNome("maria Galgane Oliveira Albuquerque");
        p1.setCpf("098.654.464-72");
        e1 = new Endereco();
        e1.setCep("58701-090");
        e1.setCidade("Patos");
        e1.setLogradouro("Capitão Crisanto");
        e1.setNumero("42");
        e1.setUf("PB");
        p1.setEnd(e1);
        c1 = new Contato("83-9-9601-8799", Constante.TIPO_CONTATO_TELEFONE);
        c2 = new Contato("galgane@gmail.com", Constante.TIPO_CONTATO_EMAIL);
        p1.addContato(c1);
        p1.addContato(c2);

        try {
            fachada.salvarPaciente(p1);
        } catch (BusinessException ex) {

            System.out.println(ex.getMessage());
            System.exit(1);

        }

        p1 = new Paciente();

        p1.setNome("Rafael Gentil");
        p1.setCpf("111.111.111-11");
        e1 = new Endereco();
        e1.setCep("56400-000");
        e1.setCidade("Serra Talhada");
        e1.setLogradouro("Epitásio Pessoa");
        e1.setNumero("L33-Q10");

        e1.setUf("PE");
        p1.setEnd(e1);
        c1 = new Contato("83-9-9999-9999", Constante.TIPO_CONTATO_TELEFONE);
        c2 = new Contato("gabrielgentil@gmail.com", Constante.TIPO_CONTATO_EMAIL);
        p1.addContato(c1);
        p1.addContato(c2);

        try {
            fachada.salvarPaciente(p1);
        } catch (BusinessException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

    }

    private static void cadastrarMedicos() {

        Medico m = new Medico();
        m.setNome("João Carlos");
        m.setCRM(123456);
        m.setEspecializacao(Constante.TIPO_ESPECIALIZACAO_ORTOPEISTA);

        try {
            fachada.salvarMedico(m);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            
        }
        System.out.println("Buscar Medico por CRM");
        String crm = sc.nextLine();

        try {
            Medico busca = fachada.getMedicoPorCRM(Integer.parseInt(crm));
            System.out.println("Medico Encontrado");
            System.out.println(busca);

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            
        }

        //medico 2
        m = new Medico();
        m.setNome("Pedro Augusto");
        m.setCRM(654321);
        m.setEspecializacao(Constante.TIPO_ESPECIALIZACAO_CLINICO_GERAL);

        try {
            fachada.salvarMedico(m);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Buscar Medico por CRM");
        crm = sc.nextLine();

        try {
            Medico busca = fachada.getMedicoPorCRM(Integer.parseInt(crm));
            System.out.println("Medico Encontrado");
            System.out.println(busca);

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void listarMedicosEPacientes() {
        try {
            List<Medico> medicos = fachada.getMedicos();
            List<Paciente> pacientes = fachada.getPacientes();

            System.out.println("------------Lista de médicos--------------");
            for (Medico m : medicos) {
                System.out.println(m);
            }

            System.out.println("------------Lista de pacientes--------------");
            for (Paciente p : pacientes) {
                System.out.println(p);
            }
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void cadastrarConsultas() {

        Consulta c = new Consulta();
        c.setCodigoConsulta(1);
        c.setDataConsulta(Calendar.getInstance());
        c.setTipoConsulta(Constante.TIPO_CONSULTA);// CONSULTA

        System.out.println("DIGITE O CRM PARA BUSCAR O MEDICO");
        int crm = Integer.parseInt(sc.nextLine());
        Medico medico = null;
        try {
            medico = fachada.getMedicoPorCRM(crm);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        System.out.println("medico Encontrado");
        System.out.println("medico: " + medico.getNome());
        c.setMedico(medico);

        System.out.println("Digite o CPF do Paciente");
        String cpf = sc.nextLine();

        Paciente p = null;
        try {
            p = fachada.getPacientePorCpf(cpf);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        System.out.println("Paciente encontrado");
        System.out.println("paciente: " + p);
        c.setPaciente(p);

        try {
            fachada.salvaConsulta(c);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        //Segunda Consulta
        c = new Consulta();
        c.setCodigoConsulta(2);
        c.setDataConsulta(Calendar.getInstance());
        c.setTipoConsulta(Constante.TIPO_RETORNO);// retorno

        System.out.println("DIGITE O CRM PARA BUSCAR O MEDICO");
        crm = Integer.parseInt(sc.nextLine());

        Medico medico2 = null;
        try {
            medico2 = fachada.getMedicoPorCRM(crm);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        System.out.println("medico Encontrado");
        System.out.println("medico: " + medico2);
        c.setMedico(medico2);

        System.out.println("Digite o CPF do Paciente");
        String cpf2 = sc.nextLine();

        Paciente p2 = null;
        try {
            p2 = fachada.getPacientePorCpf(cpf2);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        System.out.println("Paciente encontrado");
        System.out.println("paciente: " + p2);
        c.setPaciente(p2);

        try {
            fachada.salvaConsulta(c);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void listarConsultas() {

        System.out.println("---------------TODAS CONSULTAS");

        List<Consulta> consultas = null;
        try {
            consultas = fachada.getConsutlas();
        } catch (BusinessException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        for (Consulta c : consultas) {
            System.out.println(c);
        }

        System.out.println("----------Buscar Consulta por cpf paciente");
        String cpf = sc.nextLine();

        try {
            consultas = fachada.getConsutlasPorCPFPaciente(cpf);
        } catch (BusinessException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        for (Consulta c : consultas) {
            System.out.println(c);
        }
    }
}
