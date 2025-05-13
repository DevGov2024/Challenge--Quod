package br.com.fiap.quod.Controller;

import br.com.fiap.quod.Service.NotificacaoService;
import br.com.fiap.quod.Service.PersistenciaService;
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

    @Autowired
    private PersistenciaService persistenciaService;

    @PostMapping("/validar")
    public ResponseEntity<Map<String, String>> validarDocumento(@RequestParam("imagem") MultipartFile imagem) {
        Map<String, String> response = new HashMap<>();

        if (!validacaoImagemService.validarImagem(imagem)) {
            response.put("status", "erro");
            response.put("mensagem", "Imagem inválida (formato, tamanho ou resolução).");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        boolean fraude = validacaoAvancadaService.validarFraude(imagem);
        String mensagem = fraude ? "Documento suspeito de fraude." : "Documento validado com sucesso.";

        // Persistir o resultado no banco de dados
        persistenciaService.salvarValidacao("documento", fraude, mensagem);

        if (fraude) {
            notificacaoService.notificarFraude(mensagem);
            response.put("status", "fraude");
        } else {
            notificacaoService.notificarSucesso(mensagem);
            response.put("status", "sucesso");
        }

        response.put("mensagem", mensagem);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}