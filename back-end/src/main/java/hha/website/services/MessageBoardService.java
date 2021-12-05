package hha.website.services;

import hha.website.MessageBoardRepository;
import hha.website.models.Department;
import hha.website.models.MessageBoard;
import hha.website.models.MessageBoardDTO;
import hha.website.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
@Transactional
public class MessageBoardService {

    @Autowired
    private MessageBoardRepository messageBoardRepository;
    @Autowired
    private HHADepartmentService hhaDepartmentService;

    public MessageBoard save(User user, MessageBoardDTO data) {
        MessageBoard entry = new MessageBoard();
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        entry.setDateSubmitted(Calendar.getInstance(timeZone));
        entry.setTitle(data.getTitle());
        entry.setMessage(data.getMessageToPost());
        entry.setUsername(user.getUsername());
        Optional<Department> department = hhaDepartmentService.loadDepartmentByDepartmentName(data.getDepartmentname());
        department.ifPresent(entry::setDepartment);
        return messageBoardRepository.save(entry);
    }


    public List<MessageBoard> listAllMessages() {
        return messageBoardRepository.findAll();
    }

    public void deleteMessage(Integer documentId){
        System.out.println("message deleted");
        messageBoardRepository.deleteById(documentId);
    }
}
