package com.tn.wechat.rest;

import com.mybatis.FavoriteAnswer;
import com.mybatis.FavoriteAnswerExample;
import com.mybatis.Question;
import com.mybatis.cli.FavoriteAnswerMapper;
import com.mybatis.cli.QuestionMapper;
import com.tn.wechat.util.IMyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private FavoriteAnswerMapper favoriteAnswerMapper;

    @Autowired
    public void setFavoriteAnswerMapper(FavoriteAnswerMapper favoriteAnswerMapper){
        this.favoriteAnswerMapper = favoriteAnswerMapper;
    }

    private QuestionMapper questionMapper;


    private IMyUtils utils;

    @Autowired
    public void setUtils(IMyUtils utils){
        this.utils = utils;
    }

    @GetMapping("/my/{userId}")
    public @ResponseBody
    List<Question> myQuestions(@PathVariable Integer userId, HttpSession session) {
        return questionMapper.selectMyQuestions(userId);
    }

    @GetMapping("/all")
    public @ResponseBody
    List<Question> allQuestions() {
        System.out.println("test dev tool 111");
        return questionMapper.selectAllQuestions();
    }

    @GetMapping("/{quesId}/detail")
    public @ResponseBody
    Question allQuestionsWithAnswer(@PathVariable Integer quesId) {
        return questionMapper.selectByPrimaryKeyWithAnswer(quesId);
    }

    @PostMapping("")
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

    @DeleteMapping("/{quesId}")
    public @ResponseBody
    void deleteQuestion(@PathVariable Integer quesId, HttpSession session) {
        this.questionMapper.deleteByPrimaryKey(quesId);
    }

    @PostMapping("/favorite")
    public FavoriteAnswer markFavorite(@RequestBody FavoriteAnswer favoriteAnswer){

        FavoriteAnswerExample example = new FavoriteAnswerExample();
        example.createCriteria().andQuestionIdEqualTo(favoriteAnswer.getQuestionId());
        long lst =  favoriteAnswerMapper.countByExample(example);
//        favoriteAnswer.setIsFavorite("Y");
        if(lst>0){
            favoriteAnswerMapper.updateByPrimaryKey(favoriteAnswer);
        }else{
            favoriteAnswerMapper.insert(favoriteAnswer);
        }

        return favoriteAnswer;
    }

    @Autowired
    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }
}
