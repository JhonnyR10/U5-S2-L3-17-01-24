package giovannilongo.U5S2L3170124.repositories;

import giovannilongo.U5S2L3170124.entities.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BloggerDAO extends JpaRepository<Blogger, UUID> {
}
