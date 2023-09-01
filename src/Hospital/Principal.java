package Hospital;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Macário
 */
public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        Medico med = new Medico();
        MedicoDAO mDao = new MedicoDAO();
        ArrayList medico = new ArrayList();
        
        Quarto qua = new Quarto();
        QuartoDAO qDao = new QuartoDAO();
        ArrayList quarto = new ArrayList();
        
        Paciente pac = new Paciente();
        PacienteDAO pDao = new PacienteDAO();
        ArrayList paciente = new ArrayList();
        
        
        int op = 0;
        int resp = 0;
        do{
            System.out.println("===================== MENU =======================");
        System.out.println("//////////////////////////////////////////////////");
        System.out.println("| [1] - CADASTRAR QUARTOS                        |");
        System.out.println("| [2] - ALTERAR QUARTOS                          |");
        System.out.println("| [3] - DELETAR QUARTOS                          |");
        System.out.println("| [4] - LISTA DE QUARTOS                         |");
        System.out.println("| [5] - CADASTRAR MEDICOS                        |");
        System.out.println("| [6] - ALTERAR MEDICOS                          |");
        System.out.println("| [7] - DELETAR MEDICOS                          |");
        System.out.println("| [8] - LISTA DE MEDICOS                          |");
        System.out.println("| [9] - CADASTRAR PACIENTES                       |");
        System.out.println("| [10] - ALTERAR PACIENTES                         |");
        System.out.println("| [11] - DELETAR PACIENTES                         |");
        System.out.println("| [12] - LISTA DE PACIENTES                        |");
        System.out.println("| [13] - RESERVAR QUARTOS                          |");
       System.out.println("//////////////////////////////////////////////////");
        System.out.println("==================================================");
        System.out.println("RESPOSTA");
        op = teclado.nextInt();
        System.out.println("-----------------------------------------");
        
        switch(op){
            case 1:
                System.out.println("============CADASTRAR QUARTOS=====================");
                System.out.println("DIGITE O ANDAR: "); qua.setAndarDoQuarto(teclado.nextInt());
                System.out.println("DIGITE O NUMERO: "); qua.setNumeroDoQuarto(teclado.nextInt());
                System.out.println("DIGITE O TIPO DE AREA: "); qua.setTipoDeArea(teclado.next());
                System.out.println("DIGITE O ESTADO DE OCUPAÇÃO: "); qua.setEstadoDeOcupacao(teclado.next());
                qDao.CadastrarQuarto(qua);
                break;
            case 2:
                quarto = qDao.ListarQuarto();
                int id;
                for(int i = 0; i < quarto.size(); i++) {
                qua = (Quarto) quarto.get(i);
                System.out.println("================INFORMAÇOES DO BANCO==================");
                System.out.println("ID do Quarto:" + qua.getIdQuarto());
                System.out.println("Anda do Quarto:" +qua.getAndarDoQuarto());
                System.out.println("Numero do Quarto: " + qua.getNumeroDoQuarto());
                System.out.println("Tipo de Area: " +qua.getTipoDeArea());
                System.out.println("Estado de Ocupação do Quarto: " +qua.getEstadoDeOcupacao());
                System.out.println("==================================================");
                }

                System.out.println("DIGITE O ID DO QUARTO QUE DESEJA ALTERAR: ");
                id = teclado.nextInt();

                 for (int i = 0; i < quarto.size(); i++) {
                    qua = (Quarto) quarto.get(i);
                    if (id == qua.getIdQuarto()) {
                    System.out.println("===================Informe os Dados Atual=================");
                    System.out.println("Andar do Quarto : ");
                    qua.setAndarDoQuarto(teclado.nextInt());
                    System.out.println("Numero do Quarto :");
                    qua.setNumeroDoQuarto(teclado.nextInt());
                    System.out.println("Tipo de Area: ");
                    qua.setTipoDeArea(teclado.next());
                    System.out.println("Estado de Ocupação do Quarto: ");
                    qua.setEstadoDeOcupacao(teclado.next());
                    qDao.AlterarQuarto(qua);
                        System.out.println("======================================================");
                    }
                }
                 
                break;
            case 3:
                System.out.println("=================Deletar Quarto====================");
                quarto = qDao.ListarQuarto();
                for(int i = 0; i < quarto.size(); i++) {
                qua = (Quarto) quarto.get(i);
                System.out.println("================INFORMAÇOES DO BANCO==================");
                System.out.println("ID do Quarto:" + qua.getIdQuarto());
                System.out.println("Anda do Quarto:" +qua.getAndarDoQuarto());
                System.out.println("Numero do Quarto: " + qua.getNumeroDoQuarto());
                System.out.println("Tipo de Area: " +qua.getTipoDeArea());
                System.out.println("Estado de Ocupação do Quarto" +qua.getEstadoDeOcupacao());
                System.out.println("==================================================");
                }
                System.out.println("INFORME A ID DO QUARTO QUE DESEJA DELETAR: ");
                id = teclado.nextInt();
                    if(id== qua.getIdQuarto()){
                        qDao.DeletarQuarto(qua);
                        System.out.println("=================================================");
                    }
            break;
            
            case 4:
                System.out.println("============LISTA DE QUARTO==================");
                quarto = qDao.ListarQuarto();
                for(int i = 0; i < quarto.size(); i++) {
                qua = (Quarto) quarto.get(i);
                System.out.println("ID do Quarto:" + qua.getIdQuarto());
                System.out.println("Anda do Quarto:" +qua.getAndarDoQuarto());
                System.out.println("Numero do Quarto: " + qua.getNumeroDoQuarto());
                System.out.println("Tipo de Area: " +qua.getTipoDeArea());
                System.out.println("Estado de Ocupação do Quarto" +qua.getEstadoDeOcupacao());
                System.out.println("==================================================");
                }
            break;
            
            case 5:
                System.out.println("================CADASTAR MEDICOS==================");
                System.out.println("DIGITE O NOME: "); med.setNome(teclado.next());
                System.out.println("DIGITE A ESPECIALIZAÇÃO: "); med.setEspecialidade(teclado.next());
                System.out.println("DIGITE O CIM: "); med.setCim(teclado.next());
                System.out.println("DIGITE O CBO: "); med.setCbo(teclado.next());
                mDao.CadastrarMedico(med);
                break;
            case 6:
                medico = mDao.ListarMedico();
                for (int i = 0; i < medico.size(); i++) {
                    med = (Medico) medico.get(i);
                    System.out.println(":::::::::::::::::::::::::::::::::");
                    System.out.println("ID do Medico:" + med.getIdMedico());
                    System.out.println("Nome:" +med.getNome());
                    System.out.println("Especialidade: " + med.getEspecialidade());
                    System.out.println("Carteira de Identidade em Medicina - CIM: " +med.getCim());
                    System.out.println("Cadastro Brasileiro de Ocupação - CBO: " +med.getCbo());
                    System.out.println(":::::::::::::::::::::::::::::::::");
                    }

                System.out.println("DIGITE O ID DO MEDICO QUE DESEJA ALTERAR: ");
                id = teclado.nextInt();

                for (int i = 0; i < medico.size(); i++) {
                    med = (Medico) medico.get(i);
                        if (id == med.getIdMedico()) {
                        System.out.println("Digite o Nome atual: ");
                        med.setNome(teclado.next());
                        System.out.println("Digite a especialidade :");
                        med.setEspecialidade(teclado.next());
                        System.out.println("Digite o CIM: ");
                        med.setCim(teclado.next());
                        System.out.println("Digite O CBO: ");
                        med.setCbo(teclado.next());
                        mDao.AlterarMedico(med);
                        }
                    }
                break;
            case 7:
                System.out.println("=================DELETAR MEDICOS====================");
                medico = mDao.ListarMedico();
                for (int i = 0; i < medico.size(); i++) {
                    med = (Medico) medico.get(i);
                    System.out.println(":::::::::::::::::::::::::::::::::");
                    System.out.println("ID do Medico:" + med.getIdMedico());
                    System.out.println("Nome:" +med.getNome());
                    System.out.println("Especialidade: " + med.getEspecialidade());
                    System.out.println("Carteira de Identidade em Medicina - CIM: " +med.getCim());
                    System.out.println("Cadastro Brasileiro de Ocupação - CBO: " +med.getCbo());
                    System.out.println(":::::::::::::::::::::::::::::::::");
                    }

                System.out.println("INFORME A ID DO MEDICO QUE DESEJA DELETAR: ");
                id = teclado.nextInt();
                    if(id == med.getIdMedico()){
                     mDao.DeletarMedico(med);
                }
                System.out.println("=================================================");
            break;
            
            case 8:
                System.out.println("==============LISTA DE MEDICOS===================");
                medico = mDao.ListarMedico();

                 for (int i = 0; i < medico.size(); i++) {
                    med = (Medico) medico.get(i);
                    System.out.println("===============================================");
                    System.out.println("ID do Medico:" + med.getIdMedico());
                    System.out.println("Nome:" +med.getNome());
                    System.out.println("Especialidade: " + med.getEspecialidade());
                    System.out.println("Carteira de Identidade em Medicina - CIM: " +med.getCim());
                    System.out.println("Cadastro Brasileiro de Ocupação - CBO: " +med.getCbo());
                    System.out.println("================================================");
                }
                 break;
            case 9:
                
                System.out.println("===============CADASTRAR PACIENTES==================");
                System.out.println("Digite o Nome: "); pac.setNome(teclado.next());
                System.out.println("Digite a Idade: ");pac.setIdade(teclado.nextInt());
                System.out.println("Digite o RG: ");pac.setRg(teclado.next());
                System.out.println("Digite o Telefone: ");pac.setTelefone(teclado.next());
                System.out.println("Digite a Causa Da Internação: "); pac.setCausaDaInternacao(teclado.next());
                pDao.CadastrarPaciente(pac);
                break;
            case 10:
                System.out.println("=================ALTERAR PACIENTES======================");
                paciente = pDao.ListarPaciente();
                for (int i = 0; i < paciente.size(); i++) {
                    pac = (Paciente) paciente.get(i);
                    System.out.println("============================================");
                    System.out.println("ID do Paciente:" + pac.getIdPaciente());
                    System.out.println("Nome:" +pac.getNome());
                    System.out.println("Idade: " + pac.getIdade());
                    System.out.println("RG " +pac.getRg());
                    System.out.println("Telefone: " +pac.getTelefone());
                    System.out.println("Causa da Internação" +pac.getCausaDaInternacao());
                    System.out.println("============================================");
                }

                    System.out.println("DIGITE O ID DO PACIENTE QUE DESEJA ALTERAR: ");
                    id = teclado.nextInt();
                  
                for (int i = 0; i < paciente.size(); i++) {
                    pac = (Paciente) paciente.get(i);
                        if (id == pac.getIdPaciente()) {
                            System.out.println("Digite o Nome atual: "); pac.setNome(teclado.next());
                            System.out.println("Idade :"); pac.setIdade(teclado.nextInt());
                            System.out.println("RG: "); pac.setRg(teclado.next());
                            System.out.println("Telefone : ");pac.setTelefone(teclado.next());
                            System.out.println("Causa Da Internação");pac.setCausaDaInternacao(teclado.next());
                            pDao.AlterarPaciente(pac);
                            }
                    }
                break;
            case 11:
                System.out.println("=============DELETAR PACIENTES========================");
                paciente = pDao.ListarPaciente();
                for (int i = 0; i < paciente.size(); i++) {
                pac = (Paciente) paciente.get(i);
                        System.out.println("======================================");
                        System.out.println("ID do Paciente:" + pac.getIdPaciente());
                        System.out.println("Nome:" +pac.getNome());
                        System.out.println("Idade: " + pac.getIdade());
                        System.out.println("RG " +pac.getRg());
                        System.out.println("Telefone: " +pac.getTelefone());
                        System.out.println("Causa da Internação" +pac.getCausaDaInternacao());
                        System.out.println("=======================================");
                }

                System.out.println("DIGITE A ID DO PACIENTE QUE DESEJA ALTERAR: ");
                id = teclado.nextInt();
                if(id== pac.getIdPaciente()){
                    pDao.DeletarPaciente(pac);
                }
                break;
                
            case 12:
                System.out.println("==================LISTA DE PACIENTE=====================");
                paciente = pDao.ListarPaciente();
                for (int i = 0; i < paciente.size(); i++) {
                pac = (Paciente) paciente.get(i);
                        System.out.println("======================================");
                        System.out.println("ID do Paciente:" + pac.getIdPaciente());
                        System.out.println("Nome:" +pac.getNome());
                        System.out.println("Idade: " + pac.getIdade());
                        System.out.println("RG " +pac.getRg());
                        System.out.println("Telefone: " +pac.getTelefone());
                        System.out.println("Causa da Internação" +pac.getCausaDaInternacao());
                        System.out.println("=======================================");
                }
                break;
        }
        System.out.println("Digite [1] para voltar ao Menu ou [2] para Sair");
              resp=teclado.nextInt();
        }while(resp==1);
    }
}