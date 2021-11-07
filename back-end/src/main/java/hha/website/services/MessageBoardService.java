package hha.website.services;

import hha.website.MessageBoardRepository;
import hha.website.models.Department;
import hha.website.models.MessageBoard;
import hha.website.models.MessageBoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Optional;

@Service
@Transactional
public class MessageBoardService {

    @Autowired
    private MessageBoardRepository messageBoardRepository;
    @Autowired
    private HHADepartmentService hhaDepartmentService;

    public MessageBoard save(MessageBoardDTO data) {

        MessageBoard entry = new MessageBoard();
        entry.setDateSubmitted(Calendar.getInstance());
        entry.setTitle(data.getTitle());
        entry.setMessage(data.getMessage());
        Optional<Department> department = hhaDepartmentService.loadDepartmentByDepartmentName(data.getDepartmentname());
        department.ifPresent(d -> entry.setDepartment(d));

        return messageBoardRepository.save(entry);
    }


}
