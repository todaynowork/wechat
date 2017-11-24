package com.tn.wechat.rest;

import com.mybatis.Question;
import com.mybatis.cli.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class QuestionController {

    private QuestionMapper questionMapper;



    @GetMapping("/question/my/{userId}")
    public @ResponseBody
    List<Question> myQuestions(@PathVariable String userId, HttpSession session) {
        return questionMapper.selectMyQuestions(userId);
    }

    @GetMapping("/question/all")
    public @ResponseBody
    List<Question> allQuestions() {
        return questionMapper.selectAllQuestions();
    }

    @GetMapping("/question/{quesId}/detail")
    public @ResponseBody
    Question allQuestionsWithAnswer(@PathVariable Integer quesId) {
        return questionMapper.selectByPrimaryKeyWithAnswer(quesId);
    }

    @PostMapping("/question/{userId}")
    public @ResponseBody
    void createQuestion(@RequestBody Question question, @PathVariable String userId, HttpSession session) {
        this.questionMapper.insert(question);
    }

    @DeleteMapping("/question/{quesId}")
    public @ResponseBody
    void deleteQuestion(@PathVariable Integer quesId, HttpSession session) {
        this.questionMapper.deleteByPrimaryKey(quesId);
    }

    @Autowired
    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }
}
