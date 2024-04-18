package tech.ada.projetow2.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import tech.ada.projetow2.domain.dto.exception.NotFoundException;
import tech.ada.projetow2.domain.dto.v1.AlunoDto;
import tech.ada.projetow2.domain.entities.Aluno;
import tech.ada.projetow2.domain.mappers.AlunoMapper;
import tech.ada.projetow2.repositories.AlunoRepository;
import tech.ada.projetow2.external.FeingBoredApi;


@Service
@RequiredArgsConstructor
@Primary
public class AlunoServicoBD implements IAlunoService {

    private final AlunoRepository repositorio;
    private final FeingBoredApi boredApi;


    @Override
    public AlunoDto criarAluno(AlunoDto pedido) {

        Aluno a = AlunoMapper.toEntity(pedido);

        return AlunoMapper.toDto(repositorio.save(a), boredApi.getActivity().activity());

    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return repositorio
                .findAll()
                .stream()
                .map(ent -> AlunoMapper.toDto(ent, boredApi.getActivity().activity()))
                .toList();
    }

    @Override
    public AlunoDto buscarAluno(int id) throws NotFoundException {
        System.out.println(boredApi.getActivity());
        return AlunoMapper.toDto(buscarAlunoPorId(id), boredApi.getActivity().activity());
    }

    @Override
    public AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException {
        final Aluno a = buscarAlunoPorId(id);
        a.setCpf(pedido.getCpf());
        a.setNome(pedido.getNome());
        a.setEMail(pedido.getEmail());
        return AlunoMapper.toDto(repositorio.save(a), boredApi.getActivity().activity());
    }

    @Override
    public void removerAluno(int id) throws NotFoundException {
        final Aluno a = buscarAlunoPorId(id);
        repositorio.delete(a);
        repositorio.deleteById(id);
    }

    private Aluno buscarAlunoPorId(int id) throws NotFoundException {
        return repositorio.findById(id).orElseThrow(() -> new NotFoundException(Aluno.class, String.valueOf(id)));
    }

    @Override
    public AlunoDto buscarPorCpf(String cpf) throws NotFoundException {
        return AlunoMapper.toDto(repositorio.findByCpf(cpf).orElseThrow(() -> new NotFoundException(Aluno.class, cpf)), boredApi.getActivity()
                .activity());
    }
}
