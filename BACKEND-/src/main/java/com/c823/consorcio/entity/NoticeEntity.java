package com.c823.consorcio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class NoticeEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String subject;
    private String detail;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public NoticeEntity() {
    }

    public NoticeEntity( String detail, String subject, UserEntity user) {
        this.detail = detail;
        this.subject = subject;
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
