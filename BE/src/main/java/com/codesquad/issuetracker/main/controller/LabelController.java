package com.codesquad.issuetracker.main.controller;

import com.codesquad.issuetracker.hamill.dto.request.NewLabelDto;
import com.codesquad.issuetracker.hamill.dto.response.ApiResponse;
import com.codesquad.issuetracker.hamill.service.LabelService_Hamill;
import com.codesquad.issuetracker.hamill.vo.labelVO.ContainedDescriptionLabelInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/labels")
public class LabelController {

    private static final Logger logger = LoggerFactory.getLogger(LabelController.class);

    private final LabelService_Hamill labelService_hamill;

    public LabelController(LabelService_Hamill labelService_hamill) {
        this.labelService_hamill = labelService_hamill;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<ContainedDescriptionLabelInformation>> showLabels() {
        return new ResponseEntity<>(ApiResponse.OK(labelService_hamill.containDescriptionLabelInformation()), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> create(@RequestBody NewLabelDto newLabelDto) {
        labelService_hamill.create(newLabelDto);
        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }
}
