package Mavreactors.app.Repository;

import Mavreactors.app.Model.Prendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrendaRepository  extends JpaRepository<Prendas, Long> {
}
