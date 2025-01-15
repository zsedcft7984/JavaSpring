package com.mysite.sbb.question; 

import java.time.LocalDateTime; 
import java.util.List;
import java.util.Set;
import com.mysite.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;

import com.mysite.sbb.user.SiteUser;
import lombok.Getter; 
import lombok.Setter; 

@Getter 
@Setter 
@Entity 
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 200)
	private String subject;

	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate;
	 //One  1(답변): N(질문) 관계
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
	
	@ManyToOne
    private SiteUser author;
    private LocalDateTime modifyDate;
    
    @ManyToMany
    Set<SiteUser> voter;

}