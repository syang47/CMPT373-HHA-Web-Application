package hha.website.controllers;

import hha.website.models.LoginInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @PostMapping("/api/login")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public void createCalculateDate(@RequestBody LoginInfo user) {
        System.out.println(user.username);
        System.out.println(user.password);
        System.out.println("Success");
    }

}
