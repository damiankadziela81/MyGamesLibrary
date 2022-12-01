package com.mypage.MyGamesLibrary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class LibraryController {

    @GetMapping("/test")
    public int test(){
        return 1;
    }
}
