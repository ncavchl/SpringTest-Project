package org.example.springboot.web.dto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        //검증하고 싶은 메소드의 인자를 받음. / 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용 가능.
        //isEqualTo - assertj의 동등 비교 메소드

    }



}
