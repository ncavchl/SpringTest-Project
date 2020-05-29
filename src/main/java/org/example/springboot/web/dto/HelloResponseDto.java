package org.example.springboot.web.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//getter- 선언된 모든 필드의 get 메소드를 생성해줌.
//Re~ - 선언된 모든 final 필드가 포함된 생성재 생성해줌. final 없는 필드는 생성자에 포함X
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}


