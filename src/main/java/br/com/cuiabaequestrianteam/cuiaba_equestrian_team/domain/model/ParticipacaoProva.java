package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "participacao_provas")
public class ParticipacaoProva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String categoria;
    private LocalDate data;
    private String colocacao;

    @ManyToOne
    @JoinColumn(name = "id_cavalo", nullable = false)
    private Cavalo cavalo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getColocacao() {
        return colocacao;
    }

    public void setColocacao(String colocacao) {
        this.colocacao = colocacao;
    }

    public Cavalo getCavalo() {
        return cavalo;
    }

    public void setCavalo(Cavalo cavalo) {
        this.cavalo = cavalo;
    }
}
