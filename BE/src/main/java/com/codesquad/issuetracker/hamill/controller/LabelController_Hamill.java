package com.codesquad.issuetracker.hamill.controller;

import com.codesquad.issuetracker.hamill.dto.response.ApiResponse;
import com.codesquad.issuetracker.hamill.service.LabelService_Hamill;
import com.codesquad.issuetracker.hamill.vo.labelVO.ContainedDescriptionLabelInformation;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hamill")
public class LabelController_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(LabelController_Hamill.class);

    private final LabelService_Hamill labelService_hamill;

    public LabelController_Hamill(LabelService_Hamill labelService_hamill) {
        this.labelService_hamill = labelService_hamill;
    }

    @GetMapping("/api/labels")
    public ResponseEntity<ApiResponse<ContainedDescriptionLabelInformation>> showLabels() {
        return new ResponseEntity<>(ApiResponse.OK(labelService_hamill.containDescriptionLabelInformation()), HttpStatus.OK);
    }
}
