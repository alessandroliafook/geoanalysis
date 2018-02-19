package GeoAnalysis.Server.repository;

import GeoAnalysis.Server.model.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

  Token findByChave(String chave);

  Token findByUserId(Long UserId);
}