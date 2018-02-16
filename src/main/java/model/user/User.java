package model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "User")
@Table(name = "tb_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(nullable = false)
  @NotEmpty(message = "O name do usuário não pode ser vazio.")
  private String name;

  @Column(nullable = false)
  private AcessLevel acessLevel;

  public User(String nome, AcessLevel acessLevel) {
    this.name = nome;
    this.acessLevel = acessLevel;
  }

  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AcessLevel getAcessLevel() {
    return acessLevel;
  }

  public void setAcessLevel(AcessLevel tipoUsuario) {
    this.acessLevel = tipoUsuario;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    User user = (User) o;

    if (!getName().equals(user.getName())) {
      return false;
    }

    return getAcessLevel() == user.getAcessLevel();
  }

  @Override
  public int hashCode() {
    int result = getName().hashCode();
    result = 31 * result + getAcessLevel().hashCode();
    return result;
  }
}
