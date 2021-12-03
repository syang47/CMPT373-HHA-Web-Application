package hha.website.services;

import hha.website.DeadLineRepository;
import hha.website.models.DeadLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.Year;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Service
@Transactional
public class DeadLineService {

    @Autowired
    DeadLineRepository deadLineRepository;

    @PostConstruct
    public void initializeDeadLine() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Calendar calendar = Calendar.getInstance(timeZone);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        List<DeadLine> deadLines = deadLineRepository.findAll();
        if (deadLines.size() <= 0) {
            DeadLine deadLine = new DeadLine();

            Integer year = calendar.get(Calendar.YEAR);
            String curr = month<=9?"0"+month:""+month;
            deadLine.setCurrentMonth(Integer.parseInt(year+""+curr));
            deadLineRepository.save(deadLine);
            return;
        }

        DeadLine deadLine = deadLines.get(0);
        if (day > 3) {
            deadLine.setCurrentMonth(month);
            deadLineRepository.delete(deadLine);
            deadLineRepository.save(deadLine);
        }
    }

    public DeadLine getDeadLine() {
        DeadLine deadLine = new DeadLine();
        List<DeadLine> deadLines = deadLineRepository.findAll();
        if (deadLines.size() <= 0) {
            TimeZone timeZone = TimeZone.getTimeZone("GMT");
            Calendar calendar = Calendar.getInstance(timeZone);
            int month = calendar.get(Calendar.MONTH) + 1;
            Integer year = calendar.get(Calendar.YEAR);
            String curr = month<=9?"0"+month:""+month;
            deadLine.setCurrentMonth(Integer.parseInt(year+""+curr));
            return deadLine;
        }
        deadLine = deadLines.get(0);
        return deadLine;
    }
}
