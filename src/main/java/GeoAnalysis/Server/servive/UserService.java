package GeoAnalysis.Server.servive;

import java.util.List;
import model.user.AcessLevel;
import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import GeoAnalysis.Server.repository.UserRepository;


@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public void setRepository(UserRepository repository) {
    this.repository = repository;
  }

  public User create(User user) {
    return repository.save(user);
  }

  public User getUserById(Long id) {
    return repository.findOne(id);
  }

  public User getUserByName(String name) {
    return repository.findByName(name);
  }

  public List<User> getUsuariosPelaFuncao(String acessLevel) {
    return repository.findByAcessLevel(AcessLevel.selectAcessLevel(acessLevel));
  }


  public List<User> getAll() {
    return repository.findAll();
  }

  public boolean update(User user) {

    if (repository.exists(user.getId())) {
      repository.save(user);
      return true;
    }

    return false;
  }

  public boolean delete(Long id) {
    if (repository.exists(id)) {
      repository.delete(id);
      return true;
    }
    return false;
  }

  public boolean authorizeAdmin(Long id) {
    User user = getUserById(id);

    return user.getAcessLevel() == AcessLevel.ADMIN;
  }

  public boolean authorizeUser(Long id) {
    User user = getUserById(id);

    return user.getAcessLevel() == AcessLevel.USER;
  }
}