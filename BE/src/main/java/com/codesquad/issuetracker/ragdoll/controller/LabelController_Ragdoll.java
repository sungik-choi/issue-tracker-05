package com.codesquad.issuetracker.ragdoll.controller;

import com.codesquad.issuetracker.ragdoll.dto.LabelRequestDto;
import com.codesquad.issuetracker.ragdoll.response.ApiResponse;
import com.codesquad.issuetracker.ragdoll.service.LabelService_Ragdoll;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelInformation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ragdoll")
public class LabelController_Ragdoll {

    private LabelService_Ragdoll labelService;

    public LabelController_Ragdoll(LabelService_Ragdoll labelService) {
        this.labelService = labelService;
    }

    @GetMapping("/labels")
    public ResponseEntity<ApiResponse<LabelInformation>> list() {
        return new ResponseEntity(ApiResponse.OK(labelService.findAllLabels()), HttpStatus.OK);
    }

    @PostMapping("/labels")
    public ResponseEntity<ApiResponse<String>> create(@RequestBody LabelRequestDto labelRequestDto) {
        return new ResponseEntity(ApiResponse.CREATED(labelService.createNewLabel(labelRequestDto)), HttpStatus.CREATED);
    }

    @PatchMapping("/labels/{labelId}")
    public ResponseEntity<ApiResponse<String>> update(@PathVariable Integer labelId, @RequestBody LabelRequestDto labelRequestDto) {
        return new ResponseEntity(ApiResponse.OK(labelService.updateLabel(labelId, labelRequestDto.getLabelName(),
                                                                          labelRequestDto.getDescription(),
                                                                          labelRequestDto.getHexCode())), HttpStatus.OK);
    }

    @DeleteMapping("/labels/{labelId}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Integer labelId) {
        return new ResponseEntity(ApiResponse.OK(labelService.deleteLabel(labelId)), HttpStatus.OK);
    }
}
