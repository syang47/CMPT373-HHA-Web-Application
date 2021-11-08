package hha.website;

import hha.website.models.MessageBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageBoardRepository extends JpaRepository<MessageBoard, Integer> {

}
