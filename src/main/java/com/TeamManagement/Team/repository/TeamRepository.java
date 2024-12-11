
package com.TeamManagement.Team.repository;

import com.TeamManagement.Team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    boolean existsByName(String name);
}
