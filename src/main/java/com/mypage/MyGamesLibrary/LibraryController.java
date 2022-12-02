package com.mypage.MyGamesLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
class LibraryController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("")
    public List<Game> getAll(){
        return gameRepository.getAll();
    }

    @GetMapping("/{id}")
    public Game getById(@PathVariable("id") int id){
        return gameRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Game> games){
        return gameRepository.save(games);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Game updatedGame) {
        Game game = gameRepository.getById(id);
        if(game != null) {
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

}
