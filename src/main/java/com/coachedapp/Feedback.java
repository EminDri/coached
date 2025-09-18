package com.coachedapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonProperty("id")
    private Integer id;

    @Column(name = "player_name")
    @JsonProperty("player_name")
    private String playerName;

    @Column(name = "player_last_name")
    @JsonProperty("player_last_name")
    private String playerLastName;

    @Column(name = "player_email")
    @JsonProperty("player_email")
    private String playerEmail;

    @Column(name = "message")
    @JsonProperty("message")
    private String message;

    @Column(name = "rating")
    @JsonProperty("rating")
    private Double rating;


    protected Feedback() {
        
    }
    
    public Feedback(Integer id, String playerName, String playerLastName, String playerEmail, String message,  Double rating) {
        this.id = id;
        this.playerName = playerName;
        this.playerLastName = playerLastName;
        this.playerEmail = playerEmail;
        this.message = message;
        this.rating = rating;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(id, feedback.id) && Objects.equals(playerName, feedback.playerName) && Objects.equals(playerLastName, feedback.playerLastName) && Objects.equals(playerEmail, feedback.playerEmail) && Objects.equals(message, feedback.message) && Objects.equals(rating, feedback.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerName, playerLastName, playerEmail, message, rating);
    }
}
