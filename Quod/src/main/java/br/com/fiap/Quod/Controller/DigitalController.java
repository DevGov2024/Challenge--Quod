package br.com.fiap.Quod.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.Quod.dto.DigitalRequest;
import br.com.fiap.Quod.Service.DigitalService;

@RestController
@RequestMapping("/api/digital")
public class DigitalController {

    @Autowired
    private DigitalService digitalService;

    @PostMapping("/validar")
    public ResponseEntity<String> validarDigital(@RequestBody DigitalRequest request) {
        boolean fraude = digitalService.validarDigital(request);

        if (fraude) {
            return ResponseEntity.status(403).body("Fraude detectada: Acesso negado!");
        }
        return ResponseEntity.ok("Digital validada com sucesso!");
    }
}
