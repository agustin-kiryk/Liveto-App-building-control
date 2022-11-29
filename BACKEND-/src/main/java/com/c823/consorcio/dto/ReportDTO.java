package com.c823.consorcio.dto;

import com.c823.consorcio.entity.UserEntity;
import com.c823.consorcio.enums.Issue;
import com.c823.consorcio.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class ReportDTO {
    private int ticketNo;
    private LocalDate creationDate;
    private Issue issue;
    private Status status;
    @NotBlank
    private String detail;
    private String place;
    private UserEntity user;

    public ReportDTO() {
    }

    public ReportDTO(LocalDate creationDate, Issue issue, Status status, String detail, String place, UserEntity user) {
        this.creationDate = creationDate;
        this.issue = issue;
        this.status = status;
        this.detail = detail;
        this.place = place;
        this.user = user;
    }
}
