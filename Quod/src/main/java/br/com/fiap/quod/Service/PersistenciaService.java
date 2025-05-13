package br.com.fiap.quod.Service;

import br.com.fiap.quod.Model.Validacao;
import br.com.fiap.quod.Repository.ValidacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistenciaService {

    @Autowired
    private ValidacaoRepository validacaoRepository;

    public void salvarValidacao(String tipo, boolean fraude, String detalhes) {
        Validacao validacao = new Validacao(tipo, fraude, detalhes);
        validacaoRepository.save(validacao);
        if (fraude) {
            System.out.println("[ALERTA] Fraude registrada no banco de dados.");
        } else {
            System.out.println("[INFO] Validação registrada no banco de dados.");
        }
    }
}

