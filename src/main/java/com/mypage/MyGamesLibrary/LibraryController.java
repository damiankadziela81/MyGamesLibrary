package com.mypage.MyGamesLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class LibraryController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/games")
    public List<Game> getAll(){
        return gameRepository.getAll();
    }
}
