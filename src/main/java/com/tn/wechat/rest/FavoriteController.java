package com.tn.wechat.rest;

import com.mybatis.Favorite;
import com.mybatis.cli.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/favorite/{id}")
    public @ResponseBody
    Favorite selectFavoriteById(@PathVariable Integer id) {
        return favoriteMapper.selectByPrimaryKey(id);
    }

    @DeleteMapping("/favorite/{id}")
    public @ResponseBody
    void delFavoriteById(@PathVariable Integer id) {
        favoriteMapper.deleteByPrimaryKey(id);
    }

    @PostMapping("/favorite")
    public @ResponseBody
    Favorite updateFavorite(@RequestBody Favorite favorite) {
        if(favorite.getId() == null){
            favoriteMapper.insert(favorite);
        }else {
            favoriteMapper.updateByPrimaryKey(favorite);
        }

        return favorite;
    }
}
