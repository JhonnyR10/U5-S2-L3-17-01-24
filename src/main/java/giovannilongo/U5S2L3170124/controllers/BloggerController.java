package giovannilongo.U5S2L3170124.controllers;

import giovannilongo.U5S2L3170124.entities.Blogger;
import giovannilongo.U5S2L3170124.services.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/blogger")
public class BloggerController {
    @Autowired
    private BloggerService bloggerService;

    @GetMapping
    public Page<Blogger> getBlogger(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String orderBy) {
        return bloggerService.getBlogger(page, size, orderBy);
    }

    @GetMapping("/{bloggerId}")
    public Blogger getBloggerById(@PathVariable UUID bloggerId) {
        return bloggerService.findById(bloggerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blogger createBlogger(@RequestBody Blogger newBloggerPayload) {
        return bloggerService.save(newBloggerPayload);
    }

    @PutMapping("/{bloggerId}")
    public Blogger getBloggerByIdAndUpdate(@PathVariable UUID bloggerId, @RequestBody Blogger modifiedBloggerPayload) {
        return bloggerService.findByIdAndUpdate(bloggerId, modifiedBloggerPayload);
    }

    @DeleteMapping("/{bloggerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getBloggerByIdAndDelete(@PathVariable UUID bloggerId) {
        bloggerService.findByIdAndDelete(bloggerId);
    }

}
