package com.bingo.guidepro.controller;

import com.bingo.guidepro.model.Hunter;
import com.bingo.guidepro.service.HunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/hunters")
@RestController
public class HunterController {
    @Autowired
    private HunterService hunterService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Hunter> getHunters() {
        return hunterService.getHunters();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id")
    public Hunter getHunter(@RequestParam String id) {
        return hunterService.getHunter(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/id")
    public Hunter deleteHunter(@RequestParam String id) {
        return hunterService.deleteHunter(id);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public HttpStatus addHunter(@RequestParam(value="hunter") Hunter hunter){
//        HttpStatus httpStatus;
//        //Hunter hunter = new Hunter(firstName);
//
//        int result = hunterService.add(hunter.getFirstName());
//
//        if (result == 1) {
//            httpStatus = HttpStatus.CREATED;
//        } else {
//            httpStatus = HttpStatus.NOT_MODIFIED;
//        }
//
//        return httpStatus;
//    }
}
