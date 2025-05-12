package br.com.fiap.quod.repository; // Corrigir o pacote para onde você deseja que o repositório esteja

import br.com.fiap.quod.Model.ValidacaoRegistro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ValidacaoRegistroRepository extends MongoRepository<ValidacaoRegistro, String> {

}
