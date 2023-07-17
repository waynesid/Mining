package com.AthenaData.Mining.Batch;

import com.AthenaData.Mining.Model.MatchStats;
import com.AthenaData.Mining.Repository.MatchRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wayne
 * @Date 17/07/2023
 */
@Component
public class DBWriter implements ItemWriter<MatchStats> {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public void write(Chunk<? extends MatchStats> chunk) throws Exception {
        System.out.println("Data Saved for Users: " + chunk);
        matchRepository.saveAll(chunk);
    }
}
