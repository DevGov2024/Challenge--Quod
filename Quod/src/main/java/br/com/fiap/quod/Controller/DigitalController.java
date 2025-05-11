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
@RequestMapping("/api/biometria/digital")
public class DigitalController {

    @PostMapping
    public ResponseEntity<Map<String, String>> validarImpressaoDigital(@RequestParam("imagem") MultipartFile imagem) {
        Map<String, String> response = new HashMap<>();

        if (imagem.isEmpty()) {
            response.put("status", "erro");
            response.put("mensagem", "Arquivo de impressão digital não fornecido.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // Validação básica: verificar formato e tamanho
        if (!imagem.getContentType().startsWith("image/")) {
            response.put("status", "erro");
            response.put("mensagem", "Arquivo não é uma imagem válida.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // Simulação de detecção de fraude (placeholder)
        boolean fraudeDetectada = detectarFraude(imagem);

        if (fraudeDetectada) {
            response.put("status", "fraude");
            response.put("mensagem", "Possível tentativa de fraude detectada.");
            response.put("detalhes", "Imagem identificada como impressão digital falsa.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        response.put("status", "sucesso");
        response.put("mensagem", "Impressão digital validada com sucesso.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private boolean detectarFraude(MultipartFile imagem) {
        // Lógica simulada de detecção de fraude (deepfake, impressão falsa, etc.)
        return false;
    }
}


