package com.mypage.MyGamesLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class GameRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Game> getAll(){
        return jdbcTemplate.query("SELECT * FROM game",
                BeanPropertyRowMapper.newInstance(Game.class));
    }
}
