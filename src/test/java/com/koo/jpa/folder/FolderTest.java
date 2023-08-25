package com.koo.jpa.folder;

import com.koo.jpa.dto.FolderDto;
import com.koo.jpa.newDomain.FolderEntity;
import com.koo.jpa.repository.FolderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
public class FolderTest {

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    public void folderRegist(){
//        folderRepository.folderRegist(folder);
        System.out.println("등록 완 ::::::::::::::");
        String query = "select f from FolderEntity f " +
                "left join fetch f.folderList "+
                "where f.folderId = :folderId";

        FolderEntity findFolder = em.createQuery(query, FolderEntity.class)
                .setParameter("folderId", 1)
                .getSingleResult();

//        FolderEntity findFolder = folderRepository.findFolderById(1);

        System.out.println("찾았다 폴더    ::   ");
        System.out.println(findFolder.toString());

    }

    @Test
    public void getFolderList(){
        // folder정보 가져오는지 부터 확인
        FolderDto folderDto = new FolderDto();
        folderDto.setFolderId(1);

//        FolderEntity folder = folderRepository.getFolderList( folderDto );

//        System.out.println("폴더 정보 확인 ::   " + folder.toString());
    }
}
