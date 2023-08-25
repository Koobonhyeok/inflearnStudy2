package com.koo.jpa.service;

import com.koo.jpa.dto.FolderDto;
import com.koo.jpa.newDomain.FolderEntity;
import com.koo.jpa.repository.FolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FolderService {

    private final FolderRepository folderRepository;

    @Transactional
    public Map<String, Object> getFolderList(FolderDto folderDto){
        Map<String, Object> pMap = new HashMap<>();
        FolderEntity folder = folderRepository.findFolderById( folderDto.getFolderId() );

        System.out.println("folder Data   ::   " + FolderDto.of(folder).toString());

        pMap.put("status", "Success");
        pMap.put("data", FolderDto.of(folder));
        return pMap;
    }
}
