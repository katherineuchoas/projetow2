package tech.ada.projetow2.service;
import java.util.List;


import tech.ada.projetow2.domain.dto.exception.NotFoundException;
import tech.ada.projetow2.domain.dto.v1.AlunoDto;
public interface IAlunoService {
    AlunoDto criarAluno(AlunoDto pedido);

    List<AlunoDto> listarAlunos();

    AlunoDto buscarAluno(int id) throws NotFoundException;

    AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException;

    void removerAluno(int id) throws NotFoundException;

    AlunoDto buscarPorCpf(String cpf) throws NotFoundException;

}
