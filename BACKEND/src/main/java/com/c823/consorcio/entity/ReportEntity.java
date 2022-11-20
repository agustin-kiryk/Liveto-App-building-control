package com.c823.consorcio.entity;

import com.c823.consorcio.enums.Issue;
import com.c823.consorcio.enums.Status;
import javax.persistence.EnumType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
public class ReportEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private int ticketNo;
    private Date creationDate;
    @Enumerated (EnumType.STRING)
    private Issue issue;
    @Enumerated (EnumType.STRING)
    private Status status;
    private String detail;
    private String place;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ReportEntity() {
    }

    public ReportEntity(int ticketNo, Date creationDate, Issue issue, String detail, String place, Status status) {
        this.ticketNo = ticketNo;
        this.creationDate = creationDate;
        this.issue = issue;
        this.detail = detail;
        this.place = place;
        this.status = status;
    }

}
