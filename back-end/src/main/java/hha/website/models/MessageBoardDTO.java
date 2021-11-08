package hha.website.models;

public class MessageBoardDTO {
    private String title;
    private String messageToPost;
    private String departmentname;
    private String username;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageToPost() {
        return messageToPost;
    }

    public void setMessageToPost(String messageToPost) {
        this.messageToPost = messageToPost;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
