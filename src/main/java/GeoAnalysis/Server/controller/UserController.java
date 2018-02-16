package GeoAnalysis.Server.controller;

import GeoAnalysis.Server.servive.UserService;
import model.user.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private AuthenticatorController authenticatorController;

  @PostMapping
  @ResponseBody
  public User createUsuario(@RequestBody User user, @RequestHeader String key) {

    authenticatorController.authorizeAdmin(key);
    return userService.create(user);
  }

  @GetMapping("/{id}")
  @ResponseBody
  public User getUsuarioPelaId(@PathVariable("id") Long id, @RequestHeader String key) {

    authenticatorController.authorizeUser(key);
    return userService.getUserById(id);
  }

  @PutMapping("/{id}")
  @ResponseBody
  public Boolean updateUser(@RequestBody User user, @RequestHeader String key) {

    authenticatorController.authorizeAdmin(key);

    return userService.update(user);
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public Boolean deleteUser(@PathVariable("id") Long id, @RequestHeader String key) {

    authenticatorController.authorizeAdmin(key);

    return userService.delete(id);
  }

  @GetMapping("/list")
  @ResponseBody
  public List<User> getAll(@RequestHeader String key) {

    authenticatorController.authorizeAdmin(key);
    return userService.getAll();
  }

  @GetMapping("/list/{acessLevel}")
  @ResponseBody
  private List<User> getUserByAcessLevel(@PathVariable("acessLevel") String acessLevel,
      @RequestHeader String key) {

    authenticatorController.authorizeAdmin(key);
    return userService.getUsuariosPelaFuncao(acessLevel);
  }
}
