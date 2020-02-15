package com.example.study.utils;

import org.springframework.stereotype.Component;

@Component
public class DataUtil {

    String[] chs = {
            "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ",
            "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ",
            "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ",
            "ㅋ", "ㅌ", "ㅍ", "ㅎ"
    };

    public String chosung(String text) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < text.length(); i++) {
            int code = text.codePointAt(i) - 44032;
            int choindex = code / 21 / 28;
            if (code > -1 && code < 11172) {// 가 ~ 힣
                result.append(chs[choindex]);
            } else if (code + 44032 >= 48 && code + 44032 <= 57) {// 0 ~ 9
                result.append(text.charAt(i));
            } else if (code + 44032 >= 65 && code + 44032 <= 90) { // A ~ Z
                result.append(text.charAt(i));
            } else if (code + 44032 >= 97 && code + 44032 <= 122) { // a ~ z
                result.append(text.charAt(i));
            } else if (code + 44032 >= 12593 && code + 44032 <= 12622) { // ㄱ ~ ㅎ
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }

    public String keyword(String text) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < text.length(); i++) {
            int code = text.codePointAt(i) - 44032;
            if (code > -1 && code < 11172) {// 가 ~ 힣
                result.append(text.charAt(i));
            } else if (code + 44032 >= 48 && code + 44032 <= 57) {// 0 ~ 9
                result.append(text.charAt(i));
            } else if (code + 44032 >= 65 && code + 44032 <= 90) { // A ~ Z
                result.append(text.charAt(i));
            } else if (code + 44032 >= 97 && code + 44032 <= 122) { // a ~ z
                result.append(text.charAt(i));
            } else if (code + 44032 >= 12593 && code + 44032 <= 12622) { // ㄱ ~ ㅎ
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }
}
