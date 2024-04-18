package tech.ada.projetow2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import tech.ada.projetow2.domain.dto.exception.NotFoundException;
import tech.ada.projetow2.domain.dto.v1.AlunoDto;

@Service
public class AlunoService implements IAlunoService{
    private final List<AlunoDto> alunos = new ArrayList<>();
    private int id = 1;

    @Override
    public AlunoDto criarAluno(AlunoDto novoAluno) {
        final AlunoDto a = new AlunoDto(
                id++,
                novoAluno.getNome(),
                novoAluno.getCpf(),
                novoAluno.getEmail(),
                null
        );
        alunos.add(a);
        return a;
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return alunos;
    }

    @Override
    public AlunoDto buscarAluno(int id) throws NotFoundException {
        return alunos
                .stream()
                .filter(it -> it.getId()==id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(AlunoDto.class, String.valueOf(id)));
    }

    @Override
    public AlunoDto atualizarAluno(int id, AlunoDto pedido) {
        final AlunoDto aluno = alunos.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
        if (aluno == null) {
            return null;
        }
        alunos.remove(aluno);
        final AlunoDto a = new AlunoDto(aluno.getId(), pedido.getNome(), pedido.getCpf(), pedido.getEmail(), null);
        alunos.add(a);
        return a;
    }

    @Override
    public void removerAluno(int id) throws NotFoundException {
        final AlunoDto aluno = buscarAluno(id);
        alunos.remove(aluno);
    }

    @Override
    public AlunoDto buscarPorCpf(String cpf) throws NotFoundException {
        return null;
    }
}
