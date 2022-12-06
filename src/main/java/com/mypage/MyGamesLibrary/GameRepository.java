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

    List<Game> getByTitle(String title) {
        return jdbcTemplate.query("SELECT * FROM game WHERE title = ?",
                BeanPropertyRowMapper.newInstance(Game.class), title);
    }

    public List<Game> getByDeveloper(String developer) {
        return jdbcTemplate.query("SELECT * FROM game WHERE developer = ?",
                BeanPropertyRowMapper.newInstance(Game.class), developer);
    }

    public List<Game> getByRating(int rating) {
        return jdbcTemplate.query("SELECT * FROM game WHERE rating = ?",
                BeanPropertyRowMapper.newInstance(Game.class), rating);
    }

    public int save(List<Game> games) {
        games.forEach(game ->
                jdbcTemplate.update("INSERT INTO game(title, genre, release_year, developer, publisher, rating) " +
                "VALUES (?, ?, ?, ?, ?, ?)", game.getTitle(), game.getGenre(), game.getReleaseYear(),
                        game.getDeveloper(), game.getPublisher(), game.getRating()
                ));
        return 1;
    }

    public int update(Game game) {
        return jdbcTemplate.update("UPDATE game SET title=?, genre=?, release_year=?, developer=?, publisher=?," +
                        " rating=? WHERE id=?",
                game.getTitle(),game.getGenre(),game.getReleaseYear(),
                game.getDeveloper(),game.getPublisher(),game.getRating(),
                game.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM game WHERE id=?", id);
    }
}
