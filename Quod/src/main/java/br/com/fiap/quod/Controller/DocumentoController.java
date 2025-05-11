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
@RequestMapping("/api/documento")
public class DocumentoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private ValidacaoImagemService validacaoImagemService;

    @Autowired
    private ValidacaoAvancadaService validacaoAvancadaService;

    @PostMapping("/validar")
    public ResponseEntity<Map<String, String>> validarDocumento(@RequestParam("imagem") MultipartFile imagem) {
        Map<String, String> response = new HashMap<>();

        if (!validacaoImagemService.validarImagem(imagem)) {
            response.put("status", "erro");
            response.put("mensagem", "Imagem inválida (formato, tamanho ou resolução).");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (validacaoAvancadaService.validarFraude(imagem)) {
            notificacaoService.notificarFraude("Documento suspeito de fraude.");
            response.put("status", "fraude");
            response.put("mensagem", "Documento suspeito de fraude.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        notificacaoService.notificarSucesso("Documento validado com sucesso.");
        response.put("status", "sucesso");
        response.put("mensagem", "Documento validado com sucesso.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
