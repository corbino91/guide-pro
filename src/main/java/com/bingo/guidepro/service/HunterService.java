package com.bingo.guidepro.service;

import com.bingo.guidepro.dao.HunterDao;
import com.bingo.guidepro.model.Hunter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HunterService {
    @Autowired
    private HunterDao hunterDao;

    public List<Hunter> getHunters() {
        return hunterDao.getHunters();
    }

    public Hunter getHunter(String id) {
        return hunterDao.getHunter(id);
    }

    public Hunter deleteHunter(String id) {
        return hunterDao.deleteHunter(id);
    }
}
