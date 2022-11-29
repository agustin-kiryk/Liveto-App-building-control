package com.c823.consorcio.controller;

import com.c823.consorcio.enums.Issue;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import com.c823.consorcio.dto.ReportDTO;
import com.c823.consorcio.entity.ReportEntity;
import com.c823.consorcio.service.Impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
//@CrossOrigin(origins = "aca va la url local")
public class ReportController {
    @Autowired
    ReportServiceImpl reportService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReportDTO reportDto){
        if(StringUtils.isBlank(reportDto.getDetail())){
            return new ResponseEntity("el detalle del reporte no puede estar vacío", HttpStatus.BAD_REQUEST);
        }

        ReportEntity report = new ReportEntity(
                reportDto.getCreationDate(),
                reportDto.getIssue(),
                reportDto.getStatus(),
                reportDto.getDetail(),
                reportDto.getPlace(),
                reportDto.getUser());

        reportService.saveReport(report);

        return new ResponseEntity("el reporte fue creado correctamente", HttpStatus.OK);

    }

    @GetMapping("/list")
    public ResponseEntity<List<ReportEntity>> getReportList(){
        List<ReportEntity> reportList = reportService.getReportList();
        return new ResponseEntity(reportList, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<ReportEntity> getReportById(@PathVariable Long reportId){
        if(!reportService.existsById(reportId)){
            return new ResponseEntity("el id proporcionado no existe", HttpStatus.NOT_FOUND);
        }
        ReportEntity report = reportService.findReportById(reportId).get();
        return new ResponseEntity(report, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable Long reportId){
        if(!reportService.existsById(reportId)){
            return new ResponseEntity("el id proporcionado no existe", HttpStatus.NOT_FOUND);
        }
        reportService.deleteReport(reportId);

        return new ResponseEntity("el reporte se ha borrado correctamente", HttpStatus.OK);
    }
}
