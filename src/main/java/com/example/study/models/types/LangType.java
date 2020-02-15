package com.example.study.models.types;

import lombok.Getter;

public enum LangType implements Code<String> {
    en("en"), ko("ko"), jp("jp");

    @Getter
    private final String code;

    LangType(String code) {
        this.code = code;
    }
}

