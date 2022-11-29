package com.c823.consorcio.entity;

import com.c823.consorcio.enums.Issue;
import com.c823.consorcio.enums.Status;
import javax.persistence.EnumType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@Entity
public class ReportEntity {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long reportId;
    @GeneratedValue (strategy= GenerationType.AUTO)
    @Column (name= "TICKET_NUMBER")
    private int ticketNo;
    @Column (name= "CREATION_DATE")
    private LocalDate creationDate;
    @Enumerated (EnumType.STRING)
    @Column (name= "ISSUE")
    private Issue issue;
    @Enumerated (EnumType.STRING)
    @Column (name= "STATUS")
    private Status status;

    @Column (name= "DETAIL", length= 300)
    @Size (min= 2, max= 300, message = ("el detalle debe tener mínimo 2 caracteres y máximo 300"))
    private String detail;

    @Column (name = "PLACE", length = 30)
    @Size (min= 2, max= 30, message = ("el detalle debe tener mínimo 2 caracteres y máximo 30"))
    private String place;

    @ManyToOne
    @JoinColumn(name= "user_id", nullable = false)
    private UserEntity user;

    public ReportEntity() {
    }

    public ReportEntity(LocalDate creationDate, Issue issue, Status status, String detail, String place, UserEntity user) {
        this.creationDate = creationDate;
        this.issue = issue;
        this.detail = detail;
        this.place = place;
        this.status = status;
        this.user = user;
    }

}
