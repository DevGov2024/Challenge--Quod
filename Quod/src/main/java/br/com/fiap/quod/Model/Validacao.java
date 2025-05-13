package br.com.fiap.quod.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "validacoes")
public class Validacao {

    @Id
    private String id;
    private String tipo; // facial, digital, documento
    private boolean fraude;
    private String detalhes;
    private LocalDateTime dataHora;

    public Validacao(String tipo, boolean fraude, String detalhes) {
        this.tipo = tipo;
        this.fraude = fraude;
        this.detalhes = detalhes;
        this.dataHora = LocalDateTime.now();
    }

    // Getters e Setters
}
