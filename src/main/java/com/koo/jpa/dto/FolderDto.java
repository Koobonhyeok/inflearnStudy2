package com.koo.jpa.dto;

import com.koo.jpa.newDomain.FileEntity;
import com.koo.jpa.newDomain.FolderEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FolderDto {

    private int folderId;
    private String folderName;
    private List<FolderDto> folderList;
    private List<FileDto> fileList;

    public static FolderDto of(FolderEntity folderEntity){
        return FolderDto.builder()
                .folderId(folderEntity.getFolderId())
                .folderName(folderEntity.getFolderName())
                .folderList( folderEntity.getFolderList().stream()
                        .map(FolderDto::of)
                        .collect(Collectors.toList()) )
//                .fileList( folderEntity.getFileList().stream()
//                        .map(s->s.toString())
//                        .collect(Collectors.toList()) )
                .build();
    }
}
