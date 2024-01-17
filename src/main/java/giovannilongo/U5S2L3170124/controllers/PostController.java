package giovannilongo.U5S2L3170124.controllers;

import giovannilongo.U5S2L3170124.entities.Post;
import giovannilongo.U5S2L3170124.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public Page<Post> getPost(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              @RequestParam(defaultValue = "id") String orderBy) {
        return postService.getPost(page, size, orderBy);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable UUID postId) {
        return postService.findById(postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post newPostPayload) {
        return postService.save(newPostPayload);
    }

    @PutMapping("/{postId}")
    public Post getPostByIdAndUpdate(@PathVariable UUID postId, @RequestBody Post modifiedPostPayload) {
        return postService.findByIdAndUpdate(postId, modifiedPostPayload);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getPostByIdAndDelete(@PathVariable UUID postId) {
        postService.findByIdAndDelete(postId);
    }
}
