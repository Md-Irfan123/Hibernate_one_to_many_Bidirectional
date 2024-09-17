package com.jpa.Hibernate_One_To_Many_Bidirectional.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.jpa.Hibernate_One_To_Many_Bidirectional.dao.TrainerTraineeDao;
import com.jpa.Hibernate_One_To_Many_Bidirectional.dto.Trainee;
import com.jpa.Hibernate_One_To_Many_Bidirectional.dto.Trainer;

public class TrainerTraineeInsertController {
	
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
	
	TrainerTraineeDao dao=new TrainerTraineeDao();
	
	char p;
	
	do {
		System.out.println("Enter your option....");
		System.out.println("1.INSERT\n2.GetById\n3.DELETE\n4.UPDATE\n5.DISPLAY\n6.DeleteByJPQL\n7.UpdateByJPQL");
		int key=sc.nextInt();
		switch(key) {
	case 1:{
			Trainer trainer=new Trainer(999, "Rohan", "Noida", 859459459);
			Trainee trainee=new Trainee("Md Irfan", "Bihar", 38494494, trainer);
			Trainee trainee1=new Trainee("Suresh kumar", "Bihar", 384798348, trainer);
		
//
//		System.out.println("Enter Trainer id");
//		int id=sc.nextInt();
//		sc.nextLine();
//		System.out.println("Enter Trainer name");
//		String name=sc.nextLine();
//		System.out.println("Enter Trainer Address");
//		String address=sc.nextLine();
//		System.out.println("Enter Trainer phone no.");
//		long phone=sc.nextLong();
//		Trainer trainer=new Trainer(id, name, address, phone);
//		
//		
//		System.out.println("Enter Trainee Id");
//		int id1=sc.nextInt();
//		sc.nextLine();
//		System.out.println("Enter Trainee name");
//		String name1 =sc.nextLine();
//		System.out.println("Enter Trainee address");
//		String address1=sc.nextLine();
//		System.out.println(" Enter Trainee phone ");
//		long phone1 =sc.nextLong();
//		
//		Trainee trainee1=new Trainee(id1, name1, address1, phone1, trainer);
//		System.out.println("Enter Trainee Id");
//		int id2=sc.nextInt();
//		sc.nextLine();
//		System.out.println("Enter Trainee name");
//		String name2 =sc.nextLine();
//		System.out.println("Enter Trainee address");
//		String addres2=sc.nextLine();
//		System.out.println(" Enter Trainee phone ");
//		long phone2 =sc.nextLong();
//		
//		Trainee trainee2=new Trainee(id2, name2, address1, phone2, trainer);
		
			List<Trainee> trainees=Arrays.asList(trainee1,trainee);
			
			dao.saveTrainerTaineeDao(trainer, trainees);
		}
		break;
	case 2:{
		System.out.println("Enter trainer id");
		int id=sc.nextInt();
		System.out.println("Enter trainee id");
		int id1=sc.nextInt();
		Trainee trainee=dao.associateTrianerTraineeDao(id, id1);
		if(trainee!=null) {
			System.out.println("Trainer id is associated with trainee successfully");
		}else
			System.out.println("Trainer id is not associate with trainee ");
		
		
	}
	break;
	case 3:{
		System.out.println("Enter trainer id to delete");
		int id=sc.nextInt();
		dao.deleteTrainerByTrainerId(id);
	}break;
	case 4:{
		System.out.println("Enter trainee id to delete");
		int id=sc.nextInt();
		Trainee trainee=dao.deleteTraineeByIdDao(id);
		if(trainee!=null)
			System.out.println("Data deleted successfully");
		else
			System.out.println("Data not deleted");
		}
	break;
	case 5:
	{
		for (Trainee trainee : dao.getAllTrainerTrainee()) {
			System.out.println(trainee);
			
		}
	}
		}System.out.println("Press Y/y to continue");
		p=sc.next().charAt(0);
		
		}while(p=='Y'|| p== 'y');
	System.out.println("Program ends");
	
	
	
	
	}

	
	
}
