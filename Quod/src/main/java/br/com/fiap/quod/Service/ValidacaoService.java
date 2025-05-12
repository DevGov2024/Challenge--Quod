package br.com.fiap.quod.Service;

import br.com.fiap.quod.Model.ValidacaoRegistro;
import br.com.fiap.quod.repository.ValidacaoRegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ValidacaoService {

    @Autowired
    private ValidacaoRegistroRepository validacaoRegistroRepository;

    public void salvarRegistro(String tipo, boolean fraude, String motivo, String dispositivo, String localizacao) {
        ValidacaoRegistro registro = new ValidacaoRegistro();
        registro.setTipoValidacao(tipo);
        registro.setFraude(fraude);
        registro.setMotivoFraude(motivo);
        registro.setDispositivo(dispositivo);
        registro.setLocalizacao(localizacao);
        registro.setDataHora(LocalDateTime.now());

        validacaoRegistroRepository.save(registro);
    }
}

