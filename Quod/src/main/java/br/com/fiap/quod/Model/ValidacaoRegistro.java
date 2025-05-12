package br.com.fiap.quod.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "validacoes")
public class ValidacaoRegistro {

    @Id
    private String id;

    private String tipoValidacao; // facial, digital, documento
    private boolean fraude;
    private String motivoFraude;
    private String dispositivo;
    private String localizacao;
    private LocalDateTime dataHora;

    public String getId() {
        return id;
    }

    public String getTipoValidacao() {
        return tipoValidacao;
    }

    public boolean isFraude() {
        return fraude;
    }

    public String getMotivoFraude() {
        return motivoFraude;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTipoValidacao(String tipoValidacao) {
        this.tipoValidacao = tipoValidacao;
    }

    public void setFraude(boolean fraude) {
        this.fraude = fraude;
    }

    public void setMotivoFraude(String motivoFraude) {
        this.motivoFraude = motivoFraude;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
