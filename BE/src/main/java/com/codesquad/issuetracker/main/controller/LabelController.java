package com.codesquad.issuetracker.main.controller;

import com.codesquad.issuetracker.main.dto.request.NewLabelDto;
import com.codesquad.issuetracker.main.dto.response.ApiResponse;
import com.codesquad.issuetracker.main.vo.labelVO.ContainedDescriptionLabelInformation;
import com.codesquad.issuetracker.main.service.LabelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/labels")
public class LabelController {

    private static final Logger logger = LoggerFactory.getLogger(LabelController.class);

    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<ContainedDescriptionLabelInformation>> showLabels() {
        return new ResponseEntity<>(ApiResponse.OK(labelService.containDescriptionLabelInformation()), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> create(@RequestBody NewLabelDto newLabelDto) {
        labelService.create(newLabelDto);
        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }

    @PatchMapping("/{labelId}")
    public ResponseEntity<ApiResponse<?>> update(@PathVariable Integer labelId, @RequestBody NewLabelDto newLabelDto) throws Exception {
        try {
            labelService.update(labelId, newLabelDto);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponse.FORBIDDEN("backgroundColor, color 를 hex code 형식으로 넣어주세요(예:#ffffff)"), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }

    @DeleteMapping("/{labelId}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Integer labelId) {
        labelService.delete(labelId);
        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }
}
