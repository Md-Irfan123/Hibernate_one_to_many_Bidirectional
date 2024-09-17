package com.jpa.Hibernate_One_To_Many_Bidirectional.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jpa.Hibernate_One_To_Many_Bidirectional.dto.Trainee;
import com.jpa.Hibernate_One_To_Many_Bidirectional.dto.Trainer;

public class TrainerTraineeDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	public Trainer saveTrainerTaineeDao(Trainer trainer,List<Trainee> trainees) {
		
		et.begin();
		
//		em.persist(trainer);
		for (Trainee trainee : trainees) {
			em.persist(trainee);
		}
		
		et.commit();
		return trainer;
	}

	public Trainee associateTrianerTraineeDao(int trainerId,int traineeId) {

		Trainer trainer=em.find(Trainer.class, trainerId);
		Trainee trainee=em.find(Trainee.class, traineeId);
		
		if(trainer!=null && trainee !=null) {
			trainee.setTrainer(trainer);
			et.begin();
			em.merge(trainee);
			et.commit();
			
			return trainee;
		
		}
		return null;
		
		
	}
	public void deleteTrainerByTrainerId(int trainerId) {
		Trainer trainer=em.find(Trainer.class, trainerId);
		if(trainer!=null) {
		List<Trainee> trainee=trainer.getTrainees();
	
			et.begin();
			for (Trainee trainee2 : trainee) {
				trainee2.setTrainer(null);
				em.merge(trainee2);
			}
			

			et.commit();
		}
	}
	public Trainee deleteTraineeByIdDao(int traineeId ) {
		Trainee trainee=em.find(Trainee.class, traineeId);
		if(trainee!=null) {
			et.begin();
			em.remove(trainee);
			et.commit();
			return trainee;
			
		}
		return null;
	}
	public List<Trainee> getAllTrainerTrainee(){
		String selectQuery="select t from trainee t";
		Query query=em.createQuery(selectQuery);
		return query.getResultList();
		
	}

}
