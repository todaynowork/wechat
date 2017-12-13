package com.tn.wechat.rest;

import com.mybatis.Icon;
import com.mybatis.cli.IconMapper;
import com.tn.wechat.util.IMyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/icon")
public class IconController {
    private IconMapper iconMapper;
    private IMyUtils utils;

    @Autowired
    public void setUtils(IMyUtils utils){
        this.utils = utils;
    }

    @Autowired
    public void IconMapper(IconMapper iconMapper) {
        this.iconMapper = iconMapper;
    }


    @GetMapping("/all")
    public @ResponseBody
    List<Icon> allIcons() {
        System.out.println("test dev tool 111");
        return iconMapper.selectAllIcons();
    }
    
    @GetMapping("{objectId}")
    public @ResponseBody
    Icon getIconById(@PathVariable Integer objectId, HttpSession session) {
        System.out.println("test dev tool 111");
        return iconMapper.selectById(objectId);
    }
    
}
