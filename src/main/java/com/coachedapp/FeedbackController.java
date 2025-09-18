package com.coachedapp;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> findAll() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("{id}")
    public Feedback findById(@PathVariable Integer id) {
        return feedbackService.getFeedbackById(id);
    }


    @PostMapping
    public Feedback addFeedback (@RequestBody Feedback feedback){
        return feedbackService.insertFeedback(feedback);
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        return "index";
    }

}
        