package tech.ada.projetow2.domain.mappers;

import tech.ada.projetow2.domain.entities.Aluno;
import tech.ada.projetow2.domain.dto.v1.AlunoDto;

public class AlunoMapper {

    public static Aluno toEntity(AlunoDto dto) {
        return Aluno
                .builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .eMail(dto.getEmail())
                .build();
    }

    public static AlunoDto toDto(Aluno entity, String activity) {
        return new AlunoDto(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEMail(),
                activity
        );
    }
}
