package com.AthenaData.Mining.Batch;

import com.AthenaData.Mining.Model.MatchStats;
import com.AthenaData.Mining.Model.MatchStatsDto;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author wayne
 * @Date 17/07/2023
 */
@Component
public class MatchStatsProcessor implements ItemProcessor<MatchStats, MatchStatsDto> {

    @Override
    public MatchStatsDto process(MatchStats MatchStats) throws Exception {
        System.out.println("Transforming MatchStats(s) to MatchStatsDto(s)..");
         MatchStatsDto matchStatsDto = new MatchStatsDto(
                MatchStats.getLeague(),
                MatchStats.getYear(),
                MatchStats.getH_a(),
                MatchStats.getXg(),
                MatchStats.getxGa(),
                MatchStats.getNpxG(),
                MatchStats.getDeep(),
                MatchStats.getDeep_allowed(),
                MatchStats.getScored(),
                MatchStats.getMissed(),
                MatchStats.getScored(),
                MatchStats.getResult(),
                MatchStats.getDate(),
                MatchStats.getWins(),
                MatchStats.getDraws(),
                MatchStats.getLoses(),
                MatchStats.getPts(),
                MatchStats.getNpxGD(),
                MatchStats.getPpda_coef(),
                MatchStats.getPpda_att(),
                MatchStats.getPpda_def(),
                MatchStats.getOppda_coef(),
                MatchStats.getOppda_att(),
                MatchStats.getOppda_def(),
                MatchStats.getTeam(),
                MatchStats.getxG_diff(),
                MatchStats.getXpts_diff(),
                MatchStats.getXg());

        return matchStatsDto;
    }

}
