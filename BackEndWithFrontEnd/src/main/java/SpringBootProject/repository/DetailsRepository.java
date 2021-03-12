package SpringBootProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootProject.model.CardDetails;

@Repository
public interface DetailsRepository extends JpaRepository<CardDetails, Integer>{

}
