package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import com.mysite.sbb.answer.AnswerForm;

import lombok.RequiredArgsConstructor;

//프리픽스 해당 코드에 기본 주소를 기본으로 세팅되는값
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
    	Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }
    
    @GetMapping(value = "detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
    	Question question = this.questionService.getQuestion(id);
    	model.addAttribute("question",question);
    	return "question_detail";
    }
    
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
    	return "question_form";
    }
    
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
    	return "redirect:/question/list";
    }
}
/*
 * list 메서드의 URL 매핑은 /list이지만 @RequestMapping 애너테이션에서 이미 /question URL을 매핑했기 때문에
 *  /question + /list가 되어 최종 URL 매핑은 /question/list가 된다. 
 *  그러므로 이와 같이 수정하면 기존과 완전히 동일하게 URL 매핑이 이루어진다. 
 *  다만, 앞으로 QuestionController.java에서 URL을 매핑할 때 반드시 /question으로 시작한다는 것을 기억해 두자.
 */
 