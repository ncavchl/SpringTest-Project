package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//주요 어노테이션
@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 설정
    private Long id;

    @Column(length=500, nullable=false)
    private String title;

    @Column(columnDefinition="TEXT", nullable=false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content=content;
        this.author = author;
    }

    //@Entity 테이블과 링크될 클래스임을 나타냄
    //@GeneratedValue PK 생성 규칙을 나타냄.
    //@Column 테이블의 칼럼을 나타내며 굳이 선언안하더라도 해당 클래스의 필드는 모두 칼럼이 됨.
    //@NoArgContructor 기본 생성자 자동 추가 / public Posts() {} 와 같은 효과
    //@Getter 클래스 내 모든 필드의 Getter 메소드를 자동생성
    //@Builder 해당 클래스의 빌더 패턴 클래스를 생성 / 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    //Entity 클래스에서는 절.대. Setter 메소드를 만들지 않음.

}
