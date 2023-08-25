package com.koo.jpa.newDomain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folder_info")
@NoArgsConstructor
@Getter
public class FolderEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folder_id")
    private int folderId;

    @Column(name = "folder_name")
    private String folderName;

    @CreationTimestamp
    @Column(name = "reg_dttm")
    private LocalDateTime regDttm;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "folder_parent_id", referencedColumnName = "folder_id")
    private FolderEntity parent;

//    orphanRemoval  : 부모 엔티티가 삭제되면 자식 엔티티들도 삭제
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FolderEntity> folderList = new ArrayList<>();

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FileEntity> fileList = new ArrayList<>();

    @Builder
    public FolderEntity(int folderId, String folderName, FolderEntity parent){
        this.folderId = folderId;
        this.folderName = folderName;
        this.parent = parent;
    }
}
