package com.example.study.jpa.projection.team.repository;


import com.example.study.jpa.projection.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    <T> List<T> findAllBy(Class<T> clazz);
}
