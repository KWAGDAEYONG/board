package com.kdy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by user on 2017-03-29.
 */
@Entity
public class Board {

    @Id
    @GeneratedValue
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private int viewcnt;
    private boolean deleted = false;

    public Long getBno() {
        return bno;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public Date getRegdate() {
        return regdate;
    }

    public int getViewcnt() {
        return viewcnt;
    }

    public void setBno(Long bno) {
        this.bno = bno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public void setViewcnt(int viewcnt) {
        this.viewcnt = viewcnt;
    }
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void delete(){
        this.deleted = true;
    }

    public void update(Board board){
        this.title = board.title;
        this.content = board.content;

    }



    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", regdate=" + regdate +
                ", viewcnt=" + viewcnt +
                '}';
    }
}
