package model.user;

import java.util.Arrays;

public enum AcessLevel {

  ADMIN("ADMIN"), USER("USER");

  private String value;

  private AcessLevel(String value) {
    this.value = value;
  }

  public static AcessLevel selectAcessLevel(String value) {

    for (AcessLevel funcaoUsuario : values()) {
      if (funcaoUsuario.value.equalsIgnoreCase(value)) {
        return funcaoUsuario;
      }
    }

    throw new IllegalArgumentException(
        "Funcao nao cadastrada no sistema " + value + ", as funções válidas são " + Arrays
            .toString(values()));
  }
}
