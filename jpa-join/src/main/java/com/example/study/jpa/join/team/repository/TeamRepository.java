package com.example.study.jpa.join.team.repository;


import com.example.study.jpa.join.team.entity.Team;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    <T> T findByTeamId(Long id, Class<T> clazz);
    <T> List<T> findAllBy(Class<T> clazz);

    @Query("SELECT t FROM Team t join fetch t.members")
    List<Team> findAllFetch();

    @EntityGraph(attributePaths = "members")
    @Query("SELECT t FROM Team t")
    List<Team> findAllEntityGraph();
}
