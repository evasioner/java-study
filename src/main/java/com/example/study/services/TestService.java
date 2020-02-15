package com.example.study.services;

import com.example.study.models.Test;
import com.example.study.models.types.LangType;
import com.example.study.repositories.TestRepository;
import com.example.study.requests.RawDataRequest;
import com.example.study.utils.DataUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TestService {
    private final TestRepository testRepository;
    private final DataUtil dataUtil;

    public TestService(TestRepository testRepository, DataUtil dataUtil) {
        this.testRepository = testRepository;
        this.dataUtil = dataUtil;
    }

    public List<Test> search(String query) {
        return this.testRepository.search(dataUtil.keyword(query));
    }

    public Test register(RawDataRequest request) {
        Test test = new Test();
        StringBuilder keyword = new StringBuilder();
        Map<String, String> rawData = request.getRawData().entrySet().stream().collect(Collectors.toMap(e -> e.getKey().name(), e -> e.getValue()));
        test.setRawData(rawData);
        request.getRawData().forEach((key, value) -> {
            if (key.equals(LangType.ko)) {
                keyword.append(dataUtil.chosung(value)).append(" ").append(dataUtil.keyword(value));
            } else {
                keyword.append(" ").append(dataUtil.keyword(value));
            }
        });
        test.setKeyword(keyword.toString());
        return this.testRepository.saveAndFlush(test);

    }
}
