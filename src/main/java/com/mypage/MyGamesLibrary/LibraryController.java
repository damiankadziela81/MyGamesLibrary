package com.mypage.MyGamesLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
class LibraryController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAll(){
        return gameRepository.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getById(@PathVariable("id") int id){
        return gameRepository.getById(id);
    }

    @GetMapping("/title/{title}")
    public List<Game> getByTitle(@PathVariable("title") String title){
        return gameRepository.getByTitle(title);
    }

    @GetMapping("dev/{developer}")
    public List<Game> getByDeveloper(@PathVariable("developer") String developer){
        return gameRepository.getByDeveloper(developer);
    }

    @GetMapping("/rating/{rating}") //For String varialbles space replaced by %20 in URL
    public List<Game> getByRating(@PathVariable("rating") int rating){
        return gameRepository.getByRating(rating);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public int add(@RequestBody List<Game> games){
        return gameRepository.save(games);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Game updatedGame) {
        Game game = gameRepository.getById(id);
        if (game != null) {
            game.setTitle(updatedGame.getTitle());
            game.setGenre(updatedGame.getGenre());
            game.setReleaseYear(updatedGame.getReleaseYear());
            game.setDeveloper(updatedGame.getDeveloper());
            game.setPublisher(updatedGame.getPublisher());
            game.setRating(updatedGame.getRating());
            gameRepository.update(game);
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partialUpdate(@PathVariable("id") int id, @RequestBody Game updatedGame) {
        Game game = gameRepository.getById(id);
        if (game != null){
            if (updatedGame.getTitle() != null) game.setTitle(updatedGame.getTitle());
            if (updatedGame.getGenre() != null) game.setGenre(updatedGame.getGenre());
            if (updatedGame.getReleaseYear() > 1970) game.setReleaseYear(updatedGame.getReleaseYear());
            if (updatedGame.getDeveloper() != null) game.setDeveloper(updatedGame.getDeveloper());
            if (updatedGame.getPublisher() != null) game.setPublisher(updatedGame.getPublisher());
            if (updatedGame.getRating() > 0) game.setRating(updatedGame.getRating());
            gameRepository.update(game);
            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return gameRepository.delete(id);
    }
}
