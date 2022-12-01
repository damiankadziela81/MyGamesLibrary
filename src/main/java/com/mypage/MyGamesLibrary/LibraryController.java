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

}
