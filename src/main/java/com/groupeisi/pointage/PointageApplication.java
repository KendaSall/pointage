package com.groupeisi.pointage;

import com.groupeisi.pointage.entities.Professeur;
import com.groupeisi.pointage.repositories.ProfesseurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PointageApplication {

	public static void main(String[] args) {SpringApplication.run(PointageApplication.class, args);}

	@Bean
	CommandLineRunner commandLineRunner(ProfesseurRepository professeurRepository){
		return args -> {
			professeurRepository.save(
					new Professeur(null, "SALL", "Kenda", "kenda@gmail.com","1234", 1)
			);
			professeurRepository.save(
					new Professeur(null, "YAOU", "Souley", "yaou@gmail.com","yaou12", 1)
			);
			professeurRepository.save(
					new Professeur(null, "SOUMARE", "Diafara", "diaff@gmail.com","diaff34", 0)
			);
			professeurRepository.save(
					new Professeur(null, "BALDE", "Mousaa", "Mouss@gmail.com","1Mouss4", 0)
			);
			professeurRepository.save(
					new Professeur(null, "BAH", "Mamadou", "mam@gmail.com","1Mouss4", 0)
			);
			professeurRepository.save(
					new Professeur(null, "SOW", "Ismael", "iso@gmail.com","1Mouss4", 0)
			);

			professeurRepository.findAll().forEach(p->{
				System.out.println(p.getNom());
			});
		};
	}
}
