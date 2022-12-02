package com.maksimzotov.tof.controller;

import com.maksimzotov.tof.model.ErrorMessage;
import com.maksimzotov.tof.model.FindOccurrencesRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class TofController {

    @PostMapping("/find/")
    public ResponseEntity<?> find(@RequestBody FindOccurrencesRequest request) {
        String mainText = request.mainText();
        String findText = request.findText();
        String errorDescription = null;

        if (mainText.isEmpty()) {
            errorDescription = "Основной текст является пустым";
        } else if (findText.isEmpty()) {
            errorDescription = "Искомый текст является пустым";
        } else if (mainText.length() < findText.length()) {
            errorDescription = "Искомый текст больше основного";
        }
        if (errorDescription != null) {
            return ResponseEntity.badRequest().body(new ErrorMessage(errorDescription));
        }

        Pattern pattern = Pattern.compile(findText);
        Matcher matcher = pattern.matcher(mainText);
        if (!matcher.find()) {
            return ResponseEntity.ok(new ErrorMessage("Вхождений не найдено"));
        }

        return null;
    }
}
