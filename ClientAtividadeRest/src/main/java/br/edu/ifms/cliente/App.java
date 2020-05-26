package br.edu.ifms.cliente;

import javax.swing.JOptionPane;

import br.edu.ifms.entity.Aluno;
import br.edu.ifms.entity.Alunos;
import br.edu.ifms.service.ServiceClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  String opcao = JOptionPane.showInputDialog(null,
          		"Escolha uma opção: \n" + " 1-CADASTRAR | 2-CONSULTAR | 3-EXCLUIR | 4-ALTERAR | 5-LISTAR TODOS",
          		"OPÇÕES", JOptionPane.PLAIN_MESSAGE);
          if(opcao == null) 
          	System.exit(0);
          switch(Integer.parseInt(opcao)) {
          	case 1:
          		Cadastrar();
          	break;
          	case 2:
          		Consultar();
          	break;
          	case 3:
          		Excluir();
          	break;
          	case 4:
          		Alterar();
          	break;
          	case 5:
          		ListarTodos();
          	break;
          	default:
          		JOptionPane.showMessageDialog(null, "Opção inválida!");
          }
      }
      public static void Cadastrar() {
      	ServiceClient client = new ServiceClient();
      	
      	String nome = JOptionPane.showInputDialog(null, "Nome:", "Novo Cadastro", JOptionPane.PLAIN_MESSAGE);
      	String ra = JOptionPane.showInputDialog(null, "Ra:", "Novo Cadastro", JOptionPane.PLAIN_MESSAGE);
     
      	
      	Aluno aluno = new Aluno();
      	aluno.setNome(nome);
      	aluno.setRa(ra);
      	
      	String resultado = client.CadastrarAluno(aluno);
      	
      	JOptionPane.showMessageDialog(null, resultado);
      	
      	main(null);
      	
      }
      public static void Consultar() {
      	ServiceClient client = new ServiceClient();
      	
      	String codigo = JOptionPane.showInputDialog(null, "Informe o código para consulta:", "Consultar",
      			JOptionPane.PLAIN_MESSAGE);
      	
      	Aluno aluno = client.ConsultarAlunoPorCodigo(Integer.parseInt(codigo));
      	
      	if(aluno == null) {
      		JOptionPane.showMessageDialog(null, "Aluno não encontrado! :-(");
      		main(null);
      	} else {
      		String resultado = null;
      		
      		resultado = "Código: " + String.valueOf(aluno.getCodigo()) + "\n";
      		resultado += "Titulo: " + aluno.getRa()+ "\n";
      		resultado += "Autor: " + aluno.getNome() + "\n";
    
      		
      		JOptionPane.showMessageDialog(null, resultado);
      		
      		main(null);
      	}
      }
      public static void Excluir() {
      	ServiceClient client = new ServiceClient();
      	
      	String codigo = JOptionPane.showInputDialog(null, "Informe o código para excluir:", "Excluir",
      			JOptionPane.PLAIN_MESSAGE);
      	String resultado = client.ExcluirAlunoPorCodigo(Integer.parseInt(codigo));
      	
      	JOptionPane.showMessageDialog(null, resultado);
      	
      	main(null);
      }
      public static void Alterar() {
      	
      	ServiceClient client = new ServiceClient();
      	
      	String codigo = (String) JOptionPane.showInputDialog(null, "Informe o código para alteração:", "Alterar",
      			JOptionPane.PLAIN_MESSAGE);
      	Aluno aluno = client.ConsultarAlunoPorCodigo(Integer.parseInt(codigo));
      	
      	if(aluno == null) {
      		JOptionPane.showMessageDialog(null, "Aluno não encontrado! :-(");
      		main(null);
      	} else {
      	
      		String nome = (String) JOptionPane.showInputDialog(null, "Nome: ",
      				"Alterar registro - Nome:" + aluno.getCodigo(), JOptionPane.PLAIN_MESSAGE, null, null, 
      				aluno.getNome());
      		String ra = (String) JOptionPane.showInputDialog(null, "Ra: ",
      				"Alterar registro - Ra:" + aluno.getCodigo(), JOptionPane.PLAIN_MESSAGE, null, null, 
      				aluno.getRa());
      		
      		aluno.setNome(nome);
      		aluno.setRa(ra);
      		
      		String resultado = client.AlterarAluno(aluno);
      		
      		JOptionPane.showMessageDialog(null, resultado);
          	
          	main(null);
      		
      	}
      	
      }
      public static void ListarTodos() {
      	ServiceClient client = new ServiceClient();
      	
      	Alunos alunos = client.ConsultarTodosAlunos();
      	
      	StringBuilder stringBuilderDetalhesAluno = new StringBuilder();
      	
      	for(Aluno aluno : alunos) {
      		stringBuilderDetalhesAluno.append("Código: ");
      		stringBuilderDetalhesAluno.append(aluno.getCodigo());
      		stringBuilderDetalhesAluno.append(" Nome: ");
      		stringBuilderDetalhesAluno.append(aluno.getNome());
      		stringBuilderDetalhesAluno.append(" Ra: ");
      		stringBuilderDetalhesAluno.append(aluno.getRa());
      		
      		stringBuilderDetalhesAluno.append("\n\n");
      	}
      	
      	JOptionPane.showMessageDialog(null, stringBuilderDetalhesAluno.toString());
      	
      	main(null);
      }
}
