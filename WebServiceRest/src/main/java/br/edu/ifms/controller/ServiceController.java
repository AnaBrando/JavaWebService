package br.edu.ifms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import br.edu.ifms.entity.AlunoEntity;
import br.edu.ifms.http.Aluno;
import br.edu.ifms.repository.AlunoRepository;

@Path("/service")
public class ServiceController {
	private final AlunoRepository alunoRepository = new AlunoRepository();
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(Aluno aluno) {
		AlunoEntity entity = new AlunoEntity();
		
		try {
			entity.setNome(aluno.getNome());
			entity.setRa(aluno.getRa());
			entity.setCodigo(aluno.getCodigo());
			
			
			alunoRepository.salvar(entity);
			
			return "Registro salvo com sucesso";
		}
		catch(Exception e) {
			return "Erro ao cadastrar um registro" + e.getMessage();
		}
	}
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/alterar")
	public String Alterar(Aluno aluno) {
		AlunoEntity entity = new AlunoEntity();
		
		try {
			entity.setNome(aluno.getNome());
			entity.setRa(aluno.getRa());
			entity.setCodigo((aluno.getCodigo()));
			
			alunoRepository.salvar(entity);
			
			return "Registro alterado com sucesso";
		}
		catch(Exception e) {
			return "Erro ao alterar um registro" + e.getMessage();
		}
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todosAlunos")
	public List<Aluno> TodasPessoas() {
		List<Aluno> alunos = new ArrayList<>();
		List<AlunoEntity> listaEntityPessoas = alunoRepository.TodasAlunos();
		for(AlunoEntity entity : listaEntityPessoas) {
			alunos.add(new Aluno(entity.getCodigo(), entity.getNome(), entity.getRa()));
		}		
		return alunos;		
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getaluno/{codigo}")
	public Aluno GetPessoa(@PathParam("codigo") Integer codigo) {
		AlunoEntity entity = alunoRepository.GetAluno(codigo);
		if(entity != null) {
			return new Aluno(entity.getCodigo(), entity.getNome(), entity.getRa());
		}		
		return null;		
	}
	
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{codigo}")
	public String excluir(@PathParam("codigo") Integer codigo) {
		try {
			alunoRepository.Exluir(codigo);
			return "Registro excluído com sucesso";
		}
		catch(Exception e) {
			return "Erro ao excluir o registro" + e.getMessage();
		}
	}
}
