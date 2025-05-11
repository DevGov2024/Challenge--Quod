package br.com.fiap.quod.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.fiap.quod.Model.Biometria;

public interface BiometriaRepository extends MongoRepository<Biometria, String> {
}
