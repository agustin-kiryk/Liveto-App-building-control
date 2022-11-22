package com.c823.consorcio.service.Impl;

import com.c823.consorcio.entity.ReportEntity;
import com.c823.consorcio.repository.IReportRepository;
import com.c823.consorcio.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReportServiceImpl implements IReportService {
    @Autowired
    IReportRepository reportRepository;

    @Override
    public List<ReportEntity> getReportList() {
        return reportRepository.findAll();
    }

    @Override
    public void saveReport(ReportEntity report) {
        reportRepository.save(report);
    }

    @Override
    public void deleteReport(Long reportId) {
        reportRepository.deleteById(reportId);
    }

    @Override
    public Optional<ReportEntity> findReportById(Long reportId) {
        return reportRepository.findById(reportId);
    }

    @Override
    public Optional<ReportEntity> findReportByTicketNo(int ticketNo) {
        return reportRepository.findByTicketNo(ticketNo);
    }

    @Override
    public boolean existsById(Long reportId) {
        return reportRepository.existsById(reportId);
    }

    @Override
    public boolean existsByTicketNo(int ticketNo) {
        return reportRepository.existsByTicketNo(ticketNo);
    }
}
