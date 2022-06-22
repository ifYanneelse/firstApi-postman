package br.edu.ifsc.livro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivroApiApplication {

	public static void main(String[] args) {
		
		LivroDataSource.criarLista();
		
		SpringApplication.run(LivroApiApplication.class, args);
	}

}
