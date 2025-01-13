package com.mysite.sbb.answer; 

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter; 

@Getter
@Setter
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate;
	//@ManyToOne 애너테이션을 설정하면 Answer(답변) 엔티티의 question 속성과 Question(질문) 엔티티가
    //서로 연결된다(실제 데이터베이스에서는 외래키(foreign key) 관계가 생성된다. N(답변) : 1(질문) 관계
	@ManyToOne
	private Question question;
}