package br.com.fiap.quod.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Random;

@Service
public class ValidacaoAvancadaService {

    private Random random = new Random();

    public boolean detectarDeepfake(MultipartFile imagem) {
        // Simulação: 10% de chance de identificar Deepfake
        return random.nextInt(100) < 10;
    }

    public boolean detectarMascara(MultipartFile imagem) {
        // Simulação: 5% de chance de identificar uso de máscara
        return random.nextInt(100) < 5;
    }

    public boolean detectarFotoDeFoto(MultipartFile imagem) {
        // Simulação: 8% de chance de identificar foto de foto
        return random.nextInt(100) < 8;
    }

    public boolean validarFraude(MultipartFile imagem) {
        return detectarDeepfake(imagem) || detectarMascara(imagem) || detectarFotoDeFoto(imagem);
    }
}