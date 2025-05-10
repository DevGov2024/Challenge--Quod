package br.com.fiap.Quod.Controller;

import br.com.fiap.Quod.Service.BiometriaService;
import br.com.fiap.Quod.dto.BiometriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/biometria")
public class BiometriaController {

    @PostMapping("/facial")
    public ResponseEntity<String> validarBiometriaFacial(@RequestBody BiometriaRequest request) {
        // Chama o serviço para validar a imagem
        boolean isFraude = biometriaService.validarBiometriaFacial(request);

        if (isFraude) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Fraude detectada: Acesso negado!");
        }

        return ResponseEntity.ok("Biometria facial validada com sucesso!");
    }
    @Autowired
    private BiometriaService biometriaService;

}

