package GeoAnalysis.Server.repository;

import java.util.List;
import model.user.AcessLevel;
import model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


  User findByName(String name);

  @Query("SELECT usr FROM User usr where usr.acessLevel = :acessLevel")
  List<User> findByAcessLevel(@Param("acessLevel") AcessLevel acessLevel);
}
