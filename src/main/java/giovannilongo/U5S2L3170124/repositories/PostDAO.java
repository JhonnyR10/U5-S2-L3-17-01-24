package giovannilongo.U5S2L3170124.repositories;

import giovannilongo.U5S2L3170124.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostDAO extends JpaRepository<Post, UUID> {
}
