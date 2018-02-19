package GeoAnalysis.Server.servive;

import GeoAnalysis.Server.model.token.Token;
import GeoAnalysis.Server.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  @Autowired
  TokenRepository repository;

  public void deletarToken(Token token) {
    repository.delete(token);
  }

  public Token getTokenByChave(String chave) {
    return repository.findByChave(chave);
  }

  public Token getTokenByUsuarioId(Long userId) {
    return repository.findByUserId(userId);
  }

  public Token gerarToken(Long userId) {
    return repository.save(new Token(userId));
  }

  public Token validarToken(String chave) {
    Token token = getTokenByChave(chave);

    if (token != null && token.validateToken()) {
      return token;
    } else {
      deletarToken(token);
      return null;
    }
  }

  public boolean validarUsuarioId(String chave, Long id) {

    Token token = validarToken(chave);

    if (token != null && token.getUserId().equals(id)) {
      return true;
    } else {
      return false;
    }
  }

}
