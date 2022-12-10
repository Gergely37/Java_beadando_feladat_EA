package com.example.varosok.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Contact implements Comparable<Contact>{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "send_date")
    private Date sendDate;
    @Basic
    @Column(name = "sender")
    private String sender;
    @Basic
    @Column(name = "msg")
    @NotBlank(message = "Kérem írjon le egy üzenetet!")
    @Length(max = 500, message = "Üzenet maximum 500 karakter hosszú lehet!")
    private String msg;
    @Basic
    @Column(name = "role")
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id && Objects.equals(sendDate, contact.sendDate) && Objects.equals(sender, contact.sender) && Objects.equals(msg, contact.msg) && Objects.equals(role, contact.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sendDate, sender, msg, role);
    }


    @Override
    public int compareTo(Contact o) {
        return o.getSendDate().compareTo(getSendDate());
    }
}
