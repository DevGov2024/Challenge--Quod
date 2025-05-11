package br.com.fiap.quod.Controller;

import br.com.fiap.quod.Service.NotificacaoService;
import br.com.fiap.quod.Service.ValidacaoAvancadaService;
import br.com.fiap.quod.Service.ValidacaoImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/biometria/digital")
public class DigitalController {

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private ValidacaoImagemService validacaoImagemService;

    @Autowired
    private ValidacaoAvancadaService validacaoAvancadaService;

    @PostMapping("/capturar")
    public ResponseEntity<Map<String, String>> capturarDigital(@RequestParam("imagem") MultipartFile imagem) {
        Map<String, String> response = new HashMap<>();

        if (!validacaoImagemService.validarImagem(imagem)) {
            response.put("status", "erro");
            response.put("mensagem", "Imagem inválida (formato, tamanho ou resolução).");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (validacaoAvancadaService.validarFraude(imagem)) {
            notificacaoService.notificarFraude("Biometria digital suspeita de fraude.");
            response.put("status", "fraude");
            response.put("mensagem", "Biometria digital suspeita de fraude.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        notificacaoService.notificarSucesso("Biometria digital capturada com sucesso.");
        response.put("status", "sucesso");
        response.put("mensagem", "Biometria digital capturada com sucesso.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}