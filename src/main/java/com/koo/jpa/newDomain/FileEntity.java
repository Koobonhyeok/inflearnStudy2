package com.koo.jpa.newDomain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "file_info")
public class FileEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private int fileId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_storage")
    private int fileStorage;

    @CreationTimestamp
    @Column(name = "reg_dttm")
    private LocalDateTime regDttm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private FolderEntity folder;

}
