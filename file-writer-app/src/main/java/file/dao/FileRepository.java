package file.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import file.model.FileData;

@Repository
public interface FileRepository extends JpaRepository< FileData,Long>{

}
