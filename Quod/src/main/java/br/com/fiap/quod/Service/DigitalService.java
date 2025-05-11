package br.com.fiap.quod.Service;


import org.springframework.stereotype.Service;
import br.com.fiap.quod.dto.DigitalRequest;

@Service
public class DigitalService {

    public boolean validarDigital(DigitalRequest request) {
        // Validação básica: verificar se a imagem está presente
        if (request.getImagemBase64() == null || request.getImagemBase64().isEmpty()) {
            return true;  // Fraude se a imagem está vazia
        }

        // Verificação de metadados
        if (request.getDispositivo() == null || request.getDataCaptura() == null) {
            return true;  // Fraude: dados incompletos
        }

        // Simulação de validação avançada
        return simularDeteccaoFraude(request.getImagemBase64());
    }

    // Método fictício para simulação de fraude
    private boolean simularDeteccaoFraude(String imagemBase64) {
        return imagemBase64.contains("fraude");  // Simulação simples
    }
}