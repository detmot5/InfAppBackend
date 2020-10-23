package pl.infapp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.infapp.demo.entity.User;

@Repository//do dodawnia uzywnikow
public interface UserRepository extends JpaRepository <User, Long> {
}
