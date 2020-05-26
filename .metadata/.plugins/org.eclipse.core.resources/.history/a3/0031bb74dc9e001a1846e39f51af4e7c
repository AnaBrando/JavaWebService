package br.edu.ifms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.edu.ifms.entity.AnimalEntity;
import br.edu.ifms.http.Animal;
import br.edu.ifms.repository.AnimalRepository;

@Path("/service")
public class ServiceController {
	private final AnimalRepository animalRepository = new AnimalRepository();
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(Animal animal) {
		AnimalEntity entity = new AnimalEntity();
		
		try {
			entity.setTipo(animal.getTipo());
			entity.setSexo(animal.getSexo());
			entity.setIdade(animal.getIdade());
			entity.setPeso(animal.getPeso());
			
			animalRepository.salvar(entity);
			
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
	public String Alterar(Animal animal) {
		AnimalEntity entity = new AnimalEntity();
		
		try {
			entity.setTipo(animal.getTipo());
			entity.setSexo(animal.getSexo());
			entity.setIdade(animal.getIdade());
			entity.setPeso(animal.getPeso());
			
			animalRepository.salvar(entity);
			
			return "Registro alterado com sucesso";
		}
		catch(Exception e) {
			return "Erro ao alterar um registro" + e.getMessage();
		}
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todasAnimals")
	public List<Animal> TodasPessoas() {
		List<Animal> animals = new ArrayList<>();
		List<AnimalEntity> listaEntityPessoas = animalRepository.TodasAnimals();
		for(AnimalEntity entity : listaEntityPessoas) {
			animals.add(new Animal(entity.getCodigo(), entity.getTipo(), entity.getSexo(), entity.getPeso(), entity.getIdade()));
		}		
		return animals;		
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getAnimal/{codigo}")
	public Animal GetPessoa(@PathParam("codigo") Integer codigo) {
		AnimalEntity entity = animalRepository.GetAnimal(codigo);
		if(entity != null) {
			return new Animal(entity.getCodigo(), entity.getTipo(), entity.getSexo(), entity.getPeso(), entity.getIdade());
		}		
		return null;		
	}
	
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{codigo}")
	public String excluir(@PathParam("codigo") Integer codigo) {
		try {
			animalRepository.Exluir(codigo);
			return "Registro excluído com sucesso";
		}
		catch(Exception e) {
			return "Erro ao excluir o registro" + e.getMessage();
		}
	}
}
