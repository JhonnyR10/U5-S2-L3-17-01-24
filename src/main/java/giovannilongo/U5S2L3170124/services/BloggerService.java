package giovannilongo.U5S2L3170124.services;

import giovannilongo.U5S2L3170124.entities.Blogger;
import giovannilongo.U5S2L3170124.exceptions.NotFoundException;
import giovannilongo.U5S2L3170124.repositories.BloggerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BloggerService {
    @Autowired
    private BloggerDAO bloggerDAO;

    public Page<Blogger> getBlogger(int page, int size, String orderBy) {
        if (size >= 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return bloggerDAO.findAll(pageable);
    }

    public Blogger save(Blogger body) {
        return bloggerDAO.save(body);
    }

    public Blogger findById(UUID id) {

        return bloggerDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        Blogger found = this.findById(id);
        bloggerDAO.delete(found);
    }

    public Blogger findByIdAndUpdate(UUID id, Blogger body) {
        Blogger found = this.findById(id);
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setDataDiNascita(body.getDataDiNascita());
        found.setAvatar(body.getAvatar());

        return bloggerDAO.save(found);
    }
}
