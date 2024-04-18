package tech.ada.projetow2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.openfeign.EnableFeignClients;
import lombok.RequiredArgsConstructor;

import tech.ada.projetow2.domain.dto.v1.AlunoDto;
import tech.ada.projetow2.service.IAlunoService;


@SpringBootApplication()
@RequiredArgsConstructor
@EnableFeignClients
public class Projetow2Application implements CommandLineRunner{

	private final IAlunoService alunoService;

	public static void main(String... args) {
		SpringApplication.run(Projetow2Application.class, args);
	}

	@Override
	public void run(String... args) throws InterruptedException {
		Thread.sleep(2000);
		var aluno = new AlunoDto(1, "Katherine", "12345678900", "katherine@email.com", null);
		alunoService.criarAluno(aluno);
	}
}
