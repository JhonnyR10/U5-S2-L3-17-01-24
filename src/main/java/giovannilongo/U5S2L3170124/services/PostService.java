package giovannilongo.U5S2L3170124.services;

import giovannilongo.U5S2L3170124.entities.Post;
import giovannilongo.U5S2L3170124.exceptions.NotFoundException;
import giovannilongo.U5S2L3170124.repositories.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostDAO postDAO;

    public Page<Post> getPost(int page, int size, String orderBy) {
        if (size >= 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return postDAO.findAll(pageable);
    }

    public Post save(Post body) {

        return postDAO.save(body);
    }

    public Post findById(UUID id) {
        return postDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        Post found = this.findById(id);
        postDAO.delete(found);
    }

    public Post findByIdAndUpdate(UUID id, Post body) {
        Post found = this.findById(id);
        found.setCategoria(body.getCategoria());
        found.setTitolo(body.getTitolo());
        found.setCover(body.getCover());
        found.setContenuto(body.getContenuto());
        found.setTempoDiLettura(body.getTempoDiLettura());
        return postDAO.save(found);
    }
}
