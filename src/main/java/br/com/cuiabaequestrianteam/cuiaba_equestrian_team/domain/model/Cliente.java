package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "clientes")
public class Cliente {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nome;
   @Column(unique = true)
   private String cpf;
   private String telefone;

   @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Cavalo> cavalos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Cavalo> getCavalos() {
        return cavalos;
    }

    public void setCavalos(List<Cavalo> cavalos) {
        this.cavalos = cavalos;
    }
}
