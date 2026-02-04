package gr.george.volosbeerservice.repository;

import gr.george.volosbeerservice.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {

}
