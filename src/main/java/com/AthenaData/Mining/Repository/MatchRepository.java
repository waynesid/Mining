package com.AthenaData.Mining.Repository;

import com.AthenaData.Mining.Model.MatchStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wayne
 * @Date 17/07/2023
 */

public interface MatchRepository extends JpaRepository<MatchStats, String> {
}
