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

    public Game getById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM game WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Game.class), id);
    }

    public int save(List<Game> games) {
        games.forEach(game ->
                jdbcTemplate.update("INSERT INTO game(title, genre, release_year, developer, publisher, rating) " +
                "VALUES (?, ?, ?, ?, ?, ?)", game.getTitle(), game.getGenre(), game.getReleaseYear(),
                        game.getDeveloper(), game.getPublisher(), game.getRating()
                ));
        return 1;
    }
}
