package com.example.demo;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {
    private static final String[] QUOTES = {
        "Believe in yourself!",
        "Keep pushing forward.",
        "Every day is a fresh start.",
        "You are stronger than you think.",
        "Success is not final, failure is not fatal."
    };

    private final AtomicLong counter = new AtomicLong();
    private final Random random = new Random();

    @GetMapping("/quote")
    public Quote getQuote(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        String randomQuote = QUOTES[random.nextInt(QUOTES.length)];
        return new Quote(counter.incrementAndGet(), name + ", " + randomQuote);
    }
}
