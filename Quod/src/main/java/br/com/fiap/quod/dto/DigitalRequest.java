package br.com.fiap.quod.dto;

public class DigitalRequest {
    private String digitalBase64;
    private String tipoDigital;

    // Getters e setters
    public String getDigitalBase64() {
        return digitalBase64;
    }

    public void setDigitalBase64(String digitalBase64) {
        this.digitalBase64 = digitalBase64;
    }

    public String getTipoDigital() {
        return tipoDigital;
    }

    public void setTipoDigital(String tipoDigital) {
        this.tipoDigital = tipoDigital;
    }

    // Método auxiliar para limpar o base64
    public String cleanBase64() {
        if (this.digitalBase64 != null && this.digitalBase64.contains("data:image")) {
            return this.digitalBase64.split(",")[1];
        }
        return this.digitalBase64;
    }
}

