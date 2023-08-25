package com.koo.jpa.repository;

import com.koo.jpa.newDomain.FolderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class FolderRepository {

    private final EntityManager em;

    public void folderRegist( FolderEntity folderEntity ){
        em.persist(folderEntity);
    }

    public FolderEntity findFolderById( int folderId ){
        String query = "select f from FolderEntity f " +
                "left join fetch f.folderList "+
                "where f.folderId = :folderId";

        FolderEntity folder = em.createQuery(query, FolderEntity.class)
                .setParameter("folderId", folderId)
                .getSingleResult();

        return folder;
    }

//    public FolderEntity getFolderList(FolderDto folderDto){
//        String query = "select m from FolderEntity m where folderId = :folderId";
//
//        try {
//            FolderEntity folder = em.createQuery(query, FolderEntity.class)
//                    .setParameter("folderId", folderDto.getFolderId())
//                    .getSingleResult();
//
//            return folder;
//        }catch (Exception e){
//            return new FolderEntity();
//        }
//    }


}
