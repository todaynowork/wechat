package com.tn.wechat.rest;

import com.mybatis.Favorite;
import com.mybatis.cli.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FavoriteController {

    private FavoriteMapper favoriteMapper;

    @Autowired
    public void setFavoriteMapper(FavoriteMapper favoriteMapper){
        this.favoriteMapper = favoriteMapper;
    }

    @GetMapping("/favorite/all")
    public @ResponseBody
    List<Favorite> selectAll() {
        return favoriteMapper.selectAll();
    }
}
