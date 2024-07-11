package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "cavalos")
public class Cavalo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;

    @Column(unique = true)
    private Long numeroPassaporte;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente proprietario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ParticipacaoProva> participacaoProvas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vacina> vacinas;

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getNumeroPassaporte() {
        return numeroPassaporte;
    }

    public void setNumeroPassaporte(Long numeroPassaporte) {
        this.numeroPassaporte = numeroPassaporte;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    public List<ParticipacaoProva> getParticipacaoProvas() {
        return participacaoProvas;
    }

    public void setParticipacaoProvas(List<ParticipacaoProva> participacaoProvas) {
        this.participacaoProvas = participacaoProvas;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }
}
