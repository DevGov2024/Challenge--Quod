package br.com.fiap.quod.Model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "biometrias")
public class Biometria {

    @Id
    private String id;
    private String imagemBase64;
    private String tipoBiometria;
    private String dispositivo;
    private LocalDateTime dataCaptura;
    private boolean fraude;

    // Construtor padrão
    public Biometria() {}

    // Construtor completo
    public Biometria(String imagemBase64, String tipoBiometria, String dispositivo, LocalDateTime dataCaptura, boolean fraude) {
        this.imagemBase64 = imagemBase64;
        this.tipoBiometria = tipoBiometria;
        this.dispositivo = dispositivo;
        this.dataCaptura = dataCaptura;
        this.fraude = fraude;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    public String getTipoBiometria() {
        return tipoBiometria;
    }

    public void setTipoBiometria(String tipoBiometria) {
        this.tipoBiometria = tipoBiometria;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public LocalDateTime getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(LocalDateTime dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public boolean isFraude() {
        return fraude;
    }

    public void setFraude(boolean fraude) {
        this.fraude = fraude;
    }
}

