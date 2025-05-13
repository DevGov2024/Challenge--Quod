package br.com.fiap.quod.Repository;

import br.com.fiap.quod.Model.Validacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidacaoRepository extends MongoRepository<Validacao, String> {
}
