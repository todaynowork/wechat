package com.tn.wechat.rest;

import com.mybatis.Question;
import com.mybatis.cli.QuestionMapper;
import com.tn.wechat.util.IMyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class QuestionController {

    private QuestionMapper questionMapper;


    private IMyUtils utils;

    @Autowired
    public void setUtils(IMyUtils utils){
        this.utils = utils;
    }

    @GetMapping("/question/my/{userId}")
    public @ResponseBody
    List<Question> myQuestions(@PathVariable Integer userId, HttpSession session) {
        return questionMapper.selectMyQuestions(userId);
    }

    @GetMapping("/question/all")
    public @ResponseBody
    List<Question> allQuestions() {
        System.out.println("test dev tool 111");
        return questionMapper.selectAllQuestions();
    }

    @GetMapping("/question/{quesId}/detail")
    public @ResponseBody
    Question allQuestionsWithAnswer(@PathVariable Integer quesId) {
        return questionMapper.selectByPrimaryKeyWithAnswer(quesId);
    }

    @PostMapping("/question")
    public @ResponseBody
    Question createQuestion(@RequestBody Question question) {
        question.setUpdateTime(utils.getCurrentTimeStamp());
        if(question.getId()==null){
            this.questionMapper.insert(question);
        }else {
            this.questionMapper.updateByPrimaryKey(question);
        }

        return question;
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
