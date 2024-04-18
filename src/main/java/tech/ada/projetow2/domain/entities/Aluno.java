package tech.ada.projetow2.domain.entities;
import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_completo")
    private String nome;

    @Column(unique = true)
    private String cpf;

    private String eMail;

    @CreationTimestamp
    private Instant createdAt;
}
