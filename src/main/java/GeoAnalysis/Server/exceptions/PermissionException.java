package GeoAnalysis.Server.exceptions;

public class PermissionException extends RuntimeException {

  public PermissionException() {
    super("The user has not permission to make this action!");
  }
}
