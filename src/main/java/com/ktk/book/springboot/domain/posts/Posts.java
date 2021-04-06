package com.ktk.book.springboot.domain.posts;

import com.ktk.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
@Entity // 테이블과 링크될 클래스, 네이밍 class == table ex)SalesManager.java -> sales_manager table
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id; // pk

    @Column(length = 500, nullable = false) // varchar(500), not null
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //varchar -> text변경
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
