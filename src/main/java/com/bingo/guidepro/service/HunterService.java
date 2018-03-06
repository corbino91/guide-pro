package com.bingo.guidepro.service;

import com.bingo.guidepro.dao.HunterDao;
import com.bingo.guidepro.model.Hunter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HunterService {
    @Autowired
    private HunterDao hunterDao;

    public Hunter get() {
        return hunterDao.getFirstHunter();
    }

    public int add(String firstName) {
        return hunterDao.add(firstName);
    }
}
