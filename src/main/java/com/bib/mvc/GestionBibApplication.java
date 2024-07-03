package com.bib.mvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication()
public class GestionBibApplication implements CommandLineRunner {
	
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(GestionBibApplication.class, args);
		//ApplicationContext ctx = SpringApplication.run(GestionBibApplication.class, args);
		//AdherentRepository adRepository = ctx.getBean(AdherentRepository.class);
		
		//documentRepository.save(new Adherent("lam", "Ahmed", "kenitra", "abc1234", new Date(2002, 12, 12)));
	
	}
	
	@Override
	public void run(String... arg0) throws Exception{
		
		//System.out.println("this is"+adRepository.findByCIN("LM2309"));
		//Document l1=documentRepository.save(new Livre("les Miserables", 120.00, "Victor Hugo",100 ));
		
	}
	{
		
	}

}
