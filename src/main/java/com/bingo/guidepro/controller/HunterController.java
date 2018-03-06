package com.bingo.guidepro.controller;

import com.bingo.guidepro.model.Hunter;
import com.bingo.guidepro.service.HunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/hunter")
@RestController
public class HunterController {
    @Autowired
    private HunterService hunterService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Hunter> get() {
        List<Hunter> hunters = new ArrayList<>();
        hunters.add(hunterService.get());
        return hunters;
    }

    @RequestMapping("/add")
    public HttpStatus add(@RequestParam(value="firstName") String firstName){
        HttpStatus httpStatus;
        Hunter hunter = new Hunter(firstName);

        int result = hunterService.add(hunter.getFirstName());

        if (result == 1) {
            httpStatus = HttpStatus.CREATED;
        } else {
            httpStatus = HttpStatus.NOT_MODIFIED;
        }

        return httpStatus;
    }
}
