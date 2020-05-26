package br.edu.ifms.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifms.entity.AnimalEntity;

public class AnimalRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;

	public AnimalRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	
	public void salvar(AnimalEntity animalEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(animalEntity);
		this.entityManager.getTransaction().commit();
	}
	
	public void Alterar(AnimalEntity animalEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(animalEntity);
		this.entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<AnimalEntity> TodasAnimals(){
		return this.entityManager.createQuery("Select a from AnimalEntity a ORDER BY a.tipo").getResultList();
	}
	
	public AnimalEntity GetAnimal(Integer codigo){
		return this.entityManager.find(AnimalEntity.class, codigo);
	}
	
	public void Exluir(Integer codigo) {
		
		AnimalEntity animal = this.GetAnimal(codigo);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(animal);
		this.entityManager.getTransaction().commit();
	}
	
	
}
