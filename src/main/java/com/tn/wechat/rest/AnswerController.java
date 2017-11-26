package com.tn.wechat.rest;

import com.mybatis.Answer;
import com.mybatis.AnswerExample;
import com.mybatis.cli.AnswerMapper;
import com.tn.wechat.util.IMyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    private AnswerMapper answerMapper;
    private IMyUtils utils;

    @Autowired
    public void setUtils(IMyUtils utils){
        this.utils = utils;
    }

    @Autowired
    public void setAnswerMapper(AnswerMapper answerMapper){
        this.answerMapper = answerMapper;

    }

    @GetMapping("/{id}")
    public Answer selectAnswer(@PathVariable Integer id){
        return answerMapper.selectByPrimaryKey(id);
    }

    @GetMapping("/all/{questId}")
    public List<Answer> selectAnswerForQ(@PathVariable Integer questId){
        AnswerExample criteria  = new AnswerExample();
        criteria.createCriteria().andQuestionIdEqualTo(questId);
        return answerMapper.selectByExample(criteria);
    }

    @DeleteMapping("/{id}")
    public void delAnswer(@PathVariable Integer id){
        answerMapper.deleteByPrimaryKey(id);
    }

    @PostMapping("")
    Answer createAnswer(@RequestBody Answer answer){
        answer.setUpdateTime(utils.getCurrentTimeStamp());
        if(answer.getId() == null){
            answerMapper.insert(answer);
        }else {
            answerMapper.updateByPrimaryKey(answer);
        }

        return answer;
    }
}
