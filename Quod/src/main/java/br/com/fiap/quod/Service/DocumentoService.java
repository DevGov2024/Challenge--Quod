package br.com.fiap.quod.Service;

import br.com.fiap.quod.dto.DocumentoRequest;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService {

    public boolean validarDocumento(DocumentoRequest documentoRequest) {
        // Aqui você pode implementar a lógica de validação de documento.
        // Isso pode envolver verificar o formato, tipo, a autenticidade da imagem, etc.
        if (documentoRequest.getDocumentoBase64() != null && !documentoRequest.getDocumentoBase64().isEmpty()) {
            // Simulação de uma validação de documento
            return true;  // ou false se o documento for inválido
        }
        return false;
    }
}
