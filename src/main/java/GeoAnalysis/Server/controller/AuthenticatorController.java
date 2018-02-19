package GeoAnalysis.Server.controller;

import GeoAnalysis.Server.exceptions.PermissionException;
import GeoAnalysis.Server.exceptions.TokenException;
import GeoAnalysis.Server.model.token.Token;
import GeoAnalysis.Server.servive.TokenService;
import GeoAnalysis.Server.servive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticatorController {

  @Autowired
  TokenService tokenService;

  @Autowired
  UserService userService;

  protected Long getUsuarioId(String chave) {
    return tokenService.getTokenByChave(chave).getUserId();
  }

  protected void authorizeAdmin(String chave) {

    Token token = tokenService.validarToken(chave);

    if (token == null) {
      throw new TokenException();

    } else if (!userService.authorizeAdmin(token.getUserId())) {
      throw new PermissionException();
    }
  }

  public void authorizeUser(String chave) {

    Token token = tokenService.getTokenByChave(chave);

    if (token == null) {
      throw new TokenException();
    }
  }

}
