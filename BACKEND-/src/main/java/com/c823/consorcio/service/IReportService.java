package com.c823.consorcio.service;

import com.c823.consorcio.entity.ReportEntity;

import java.util.List;
import java.util.Optional;

public interface IReportService {
    public List<ReportEntity> getReportList();
    public void saveReport(ReportEntity report);
    public void deleteReport(Long id);
    public Optional<ReportEntity> findReportById(Long  id);
    public Optional<ReportEntity> findReportByTicketNo(int ticketNo);
    public boolean existsById(Long reportId);
    public boolean existsByTicketNo(int ticketNo);
}
