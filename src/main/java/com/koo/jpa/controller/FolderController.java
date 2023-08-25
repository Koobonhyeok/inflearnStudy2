package com.koo.jpa.controller;

import com.koo.jpa.dto.FolderDto;
import com.koo.jpa.service.FolderService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FolderController {

    private final FolderService folderService;

    @GetMapping("/getFolderList")
    public ResponseEntity<?> getFolderList(@ModelAttribute FolderDto folderDto){
        Map<String, Object> pMap = new HashMap<>();
        System.out.println("들어옴    :::::::::::::::::   ");
        pMap = folderService.getFolderList(folderDto);

        return ResponseEntity.status(HttpStatus.OK).body( pMap );
    }
}
