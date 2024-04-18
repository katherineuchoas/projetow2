package tech.ada.projetow2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.projetow2.domain.entities.Aluno;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Optional<Aluno> findByCpf(String cpf);

    boolean existsByCpf(@Param("cpf") String cpf);
}
