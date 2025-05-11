package br.com.fiap.quod.Controller;

import br.com.fiap.quod.Service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/biometria/facial")
public class BiometriaFacial {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping("/capturar")
    public ResponseEntity<Map<String, String>> capturarFace(@RequestParam("imagem") MultipartFile imagem) {
        Map<String, String> response = new HashMap<>();

        if (imagem.isEmpty()) {
            response.put("status", "erro");
            response.put("mensagem", "Arquivo de imagem não fornecido.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (!imagem.getContentType().startsWith("image/")) {
            response.put("status", "erro");
            response.put("mensagem", "Arquivo não é uma imagem válida.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // Simulação de validação da biometria facial
        boolean fraudeDetectada = false; // Para simulação

        if (fraudeDetectada) {
            notificacaoService.notificarFraude("Biometria facial não reconhecida.");
            response.put("status", "fraude");
            response.put("mensagem", "Biometria facial não reconhecida.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        notificacaoService.notificarSucesso("Biometria facial capturada com sucesso.");
        response.put("status", "sucesso");
        response.put("mensagem", "Biometria facial capturada com sucesso.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


