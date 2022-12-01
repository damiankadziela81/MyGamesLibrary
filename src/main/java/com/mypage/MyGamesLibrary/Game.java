package com.mypage.MyGamesLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Game {
    private int id;
    private String title;
    private String genre;
    private int releaseYear;
    private String developer;
    private String publisher;
    private int rating;

}
