package br.edu.ifms.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifms.entity.AlunoEntity;

public class AlunoRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;

	public AlunoRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	
	public void salvar(AlunoEntity AlunoEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(AlunoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	public void Alterar(AlunoEntity AlunoEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(AlunoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<AlunoEntity> TodasAlunos(){
		return this.entityManager.createQuery("Select a from AlunoEntity a ORDER BY a.nome").getResultList();
	}
	
	public AlunoEntity GetAluno(Integer codigo){
		return this.entityManager.find(AlunoEntity.class, codigo);
	}
	
	public void Exluir(Integer codigo) {
		
		AlunoEntity Aluno = this.GetAluno(codigo);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(Aluno);
		this.entityManager.getTransaction().commit();
	}
	
	
}
