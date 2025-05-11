package br.com.fiap.quod.dto;

public class DocumentoRequest {
    private String documentoBase64;
    private String tipoDocumento;

    // Getters e setters
    public String getDocumentoBase64() {
        return documentoBase64;
    }

    public void setDocumentoBase64(String documentoBase64) {
        this.documentoBase64 = documentoBase64;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}

