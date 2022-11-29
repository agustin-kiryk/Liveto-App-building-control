package com.c823.consorcio.repository;

import com.c823.consorcio.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IReportRepository extends JpaRepository< ReportEntity, Long> {
    public Optional<ReportEntity> findByTicketNo(int TicketNo);
    public boolean existsByTicketNo(int TicketNo);
}
