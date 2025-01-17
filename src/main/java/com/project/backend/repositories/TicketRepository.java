package com.project.backend.repositories;

import com.project.backend.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    @Procedure
    Integer getTicketCount(Integer instanceId);

}
