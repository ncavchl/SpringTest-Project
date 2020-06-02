package org.example.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CustomDto {
    private String title;

    @Builder
    public CustomDto(String title){
        this.title = title;
    }
}
