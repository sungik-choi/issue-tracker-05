package com.codesquad.issuetracker.hamill.controller;

import com.codesquad.issuetracker.hamill.dto.request.NewLabelDto;
import com.codesquad.issuetracker.hamill.dto.response.ApiResponse;
import com.codesquad.issuetracker.hamill.service.LabelService_Hamill;
import com.codesquad.issuetracker.hamill.vo.labelVO.ContainedDescriptionLabelInformation;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hamill/api/labels")
public class LabelController_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(LabelController_Hamill.class);

    private final LabelService_Hamill labelService_hamill;

    public LabelController_Hamill(LabelService_Hamill labelService_hamill) {
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

    @PatchMapping("{labelId}")
    public ResponseEntity<ApiResponse<?>> update(@PathVariable Integer labelId,@RequestBody NewLabelDto newLabelDto) throws Exception {
        try {
            labelService_hamill.update(labelId, newLabelDto);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponse.FORBIDDEN("backgroundColor, color 를 hex code 형식으로 넣어주세요(예:#ffffff)"), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }
}
