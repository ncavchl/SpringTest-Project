package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.service.PostsService;
import org.example.springboot.web.dto.PostsSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

}