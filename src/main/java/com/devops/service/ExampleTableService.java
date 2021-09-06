package com.devops.service;

import java.util.Collection;

import com.devops.dto.ExampleTableDTO;

public interface ExampleTableService {

    Collection<ExampleTableDTO> findByTextField1(String textField1);

}
