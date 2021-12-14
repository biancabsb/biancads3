
package com.trabalho.demo.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

import java.time.Instant;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "table_professsoor")

public class Professor {
    @OneToMany
    @JoinColumn(name="id_Professor")
    private List<Avaliacao> avalicoes;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 64, nullable = false)
    private String nome;
    @Column(name = "dataNascimento", nullable = false)
    private Instant dataNascimento;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    private int numero_avaliacoes;
    private int numero_roteiros;
    @Column(nullable = false)
    private String uf;
    

    @OneToMany(mappedBy = "Professor")
    private List<Turma> turmas;
    
    
    public static Professor parseNote(String line) {
        String[] text = line.split(",");
        Professor note = new Professor();
        note.setId(Long.parseLong(text[0]));
        note.setNome(text[1]);
        return note;
    }
}
