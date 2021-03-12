package SpringBootProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootProject.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer>{

}
