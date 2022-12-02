package com.maksimzotov.tof.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FindOccurrencesRequest(
        @JsonProperty("main_text")
        String mainText,
        @JsonProperty("find_text")
        String findText
) {}
