package com.example.study.requests;

import com.example.study.models.types.LangType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RawDataRequest {
    private Map<LangType, String> rawData;
}
