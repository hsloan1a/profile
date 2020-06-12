package com.test.profile.controller;

import com.test.profile.ModelCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Profile("dev")
public class HelloWorldV2 {

    @Value("${spring.profiles.active:}")
    private String activeProfiles;


    @GetMapping("/hello")
    public String HelloWorld() {
        ModelCreator modelCreator = new ModelCreator();
        return modelCreator.showAllTables();
    }

    @PostMapping("/hello")
    public ResponseEntity<Object> createTable(@RequestBody String tableName){
        ModelCreator modelCreator = new ModelCreator();
        modelCreator.showAllTables();
        if (modelCreator.createTable(tableName))
            return new ResponseEntity<>("", HttpStatus.CREATED);

        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/hello")
    public void deleteAllTables(){
        ModelCreator modelCreator = new ModelCreator();
        modelCreator.deleteAllTables();
    }
}
