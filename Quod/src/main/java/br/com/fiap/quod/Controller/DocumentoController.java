package br.com.fiap.quod.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {

    @PostMapping("/validar")
    public ResponseEntity<Map<String, String>> validarDocumento(@RequestParam("imagem") MultipartFile imagem) {
        Map<String, String> response = new HashMap<>();

        if (imagem.isEmpty()) {
            response.put("status", "erro");
            response.put("mensagem", "Arquivo de documento não fornecido.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }


        if (!imagem.getContentType().startsWith("image/")) {
            response.put("status", "erro");
            response.put("mensagem", "Arquivo não é uma imagem válida.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }


        boolean documentoValido = validarAutenticidade(imagem);

        if (!documentoValido) {
            response.put("status", "fraude");
            response.put("mensagem", "Documento inválido ou suspeito de falsificação.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        response.put("status", "sucesso");
        response.put("mensagem", "Documento validado com sucesso.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private boolean validarAutenticidade(MultipartFile imagem) {
        // Lógica simulada de validação do documento (detecção de falsificação, etc.)
        return true;
    }
}