package com.resume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ResumeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/submit")
    public String submitResume(@RequestParam Map<String, String> formData, Model model) {
        model.addAttribute("formData", formData);
        model.addAttribute("score", calculateScore(formData));
        return "result";
    }

    private int calculateScore(Map<String, String> data) {
        int score = 0;
        if (data.get("skills") != null && data.get("skills").toLowerCase().contains("java")) score += 20;
        if (data.get("experience") != null && !data.get("experience").isEmpty()) score += 30;
        if (data.get("education") != null && !data.get("education").isEmpty()) score += 20;
        if (data.get("email") != null && data.get("email").contains("@")) score += 10;
        if (data.get("name") != null && !data.get("name").isEmpty()) score += 20;
        return score;
    }
}
