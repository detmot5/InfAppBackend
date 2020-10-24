package com.InfApp.InfApp.repository;
import com.InfApp.InfApp.entity.Corona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoronaRepository extends JpaRepository<Corona, Long> {
}
