package br.com.fiap.Quod.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.fiap.Quod.Model.Biometria;

public interface BiometriaRepository extends MongoRepository<Biometria, String> {
}
