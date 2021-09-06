package com.devops.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devops.dto.ExampleTableDTO;
import com.devops.repository.ExampleTableRepository;
import com.devops.service.ExampleTableService;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ExampleTableServiceImp implements ExampleTableService {

    private ExampleTableRepository ExampleTableRepository;

    @Autowired
    public ExampleTableServiceImp(ExampleTableRepository ExampleTableRepository) {
        this.ExampleTableRepository = ExampleTableRepository;
    }

    @Override
    public Collection<ExampleTableDTO> findByTextField1(String textField1) {
        return this.ExampleTableRepository.findByTextField1(textField1)
                .stream()
                .map(ExampleTableDTO::instanceOf)
                .collect(Collectors.toList());
    }

}
