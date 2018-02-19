package GeoAnalysis.Server.exceptions;

public class TokenException extends RuntimeException{

  public TokenException() {
    super("Invalid token!");
  }

}
