package br.edu.ifms.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import br.edu.ifms.entity.Aluno;
import br.edu.ifms.entity.Alunos;

public class ServiceClient {
	
	private Client client;
	
	private WebTarget webTarget;
	
	final String URL_SERVICE = "http://localhost:8080/WebServiceRest/rest/service/";
	
	public ServiceClient() {
		this.client = ClientBuilder.newClient();
	}
	
	public String CadastrarAluno(Aluno aluno) {
		this.webTarget = this.client.target(URL_SERVICE).path("cadastrar");
		
		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");
		
		Response response = invocationBuilder.post(Entity.entity(aluno, "application/json;charset=UTF-8"));
		
		return response.readEntity(String.class);
	}
	
	public String AlterarAluno(Aluno aluno) {
		this.webTarget = this.client.target(URL_SERVICE).path("alterar");
		
		Invocation.Builder invocationBuilder = 
				this.webTarget.request("application/json;charset=UTF-8");
		Response response = 
				invocationBuilder.put(Entity.entity(aluno, "application/json;charset=UTF-8"));
		
		return response.readEntity(String.class);	
	}
	
	public 	Alunos ConsultarTodosAlunos() {
		this.webTarget = this.client.target(URL_SERVICE).path("todosAlunos");
		
		Invocation.Builder invocationBuilder = 
				this.webTarget.request("application/json;charset=UTF-8");
		Response response = 
				invocationBuilder.get();
		
		return response.readEntity(Alunos.class);
	}
	
	public Aluno ConsultarAlunoPorCodigo(int codigo) {
		
		this.webTarget = this.client.target(URL_SERVICE).
				path("getAluno").path(String.valueOf(codigo));
		
		Invocation.Builder invocationBuilder = 
				this.webTarget.request("application/json;charset=UTF-8");
		Response response = 
				invocationBuilder.get();
		
		return response.readEntity(Aluno.class);
	}
	
	public String ExcluirAlunoPorCodigo(int codigo) {
		
		this.webTarget = this.client.target(URL_SERVICE).
				path("excluir").path(String.valueOf(codigo));
		Invocation.Builder invocationBuilder = 
				this.webTarget.request("application/json;charset=UTF-8");
		Response response = invocationBuilder.delete();
		
		return response.readEntity(String.class);
		
	}
	
}
