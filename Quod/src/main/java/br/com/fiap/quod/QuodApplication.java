package br.com.fiap.quod;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuodApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuodApplication.class, args);
		System.out.println("🔥 Quod Application Iniciada com Sucesso!");
	}
}
