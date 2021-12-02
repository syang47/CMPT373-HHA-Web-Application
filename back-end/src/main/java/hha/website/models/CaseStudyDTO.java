package hha.website.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaseStudyDTO {

    private String caseStudyType;

    private String caseStudyInfo;

    public String getCaseStudyType() {
        return caseStudyType;
    }

    public String getCaseStudyInfo() {
        return caseStudyInfo;
    }
}
