package woopaca.practice.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @PostMapping
    public ResponseEntity<String> writeReview(Authentication authentication) {
        return ResponseEntity.ok().body(authentication.getName()+ " 님, 리뷰가 작성되었습니다.");
    }
}
