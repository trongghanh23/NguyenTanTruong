package com.example.smartphones.model.smartphone;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String link;

    private boolean isDelete;

    @JoinColumn(name = "smartphone_id",referencedColumnName = "id")
    @ManyToOne
    private Smartphone smartphone;

    public Image() {
    }

    public Image(Integer id, String name, String link, boolean isDelete, Smartphone smartphone) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.isDelete = isDelete;
        this.smartphone = smartphone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
