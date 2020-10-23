package pl.infapp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.infapp.demo.entity.Corona;

@Repository
public interface CoronaRepository extends JpaRepository<Corona, Long> {
}
