package model.token;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.validation.annotation.Validated;

@Entity(name = "Token")
@Table(name = "tb_token")
@Validated
public class Token {

  private static final int UMA_HORA = 1;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(nullable = false)
  private String key;

  @Column(nullable = false)
  private String expirationDate;

  @Column(unique = true, nullable = false)
  private Long userId;

  public Token(Long userId) {
    setExpirationDate(LocalDateTime.now().plusHours(UMA_HORA));
    setKey(UUID.randomUUID().toString());
    setUserId(userId);
  }

  public Token() {
  }

  public String getKey() {
    return key;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void setExpirationDate(LocalDateTime expirationDate) {
    this.expirationDate = expirationDate.toString();
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public boolean validateToken() {

    String now = LocalDateTime.now().toString();
    return this.expirationDate.compareTo(now) >= 0;
  }
}
