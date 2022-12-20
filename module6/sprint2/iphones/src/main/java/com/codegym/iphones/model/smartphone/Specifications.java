package com.codegym.iphones.model.smartphone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean isDelete;
    private String screen;
    private String operating_system;
    private String rear_camera;
    private String front_camera;
    private String processor_chip;
    private String ram;
    private String storage;
    private String bettery;
    private String charge;

    public Specifications() {
    }

    public Specifications(Integer id, boolean isDelete, String screen, String operating_system, String rear_camera, String front_camera, String processor_chip, String ram, String storage, String bettery, String charge) {
        this.id = id;
        this.isDelete = isDelete;
        this.screen = screen;
        this.operating_system = operating_system;
        this.rear_camera = rear_camera;
        this.front_camera = front_camera;
        this.processor_chip = processor_chip;
        this.ram = ram;
        this.storage = storage;
        this.bettery = bettery;
        this.charge = charge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getOperating_system() {
        return operating_system;
    }

    public void setOperating_system(String operating_system) {
        this.operating_system = operating_system;
    }

    public String getRear_camera() {
        return rear_camera;
    }

    public void setRear_camera(String rear_camera) {
        this.rear_camera = rear_camera;
    }

    public String getFront_camera() {
        return front_camera;
    }

    public void setFront_camera(String front_camera) {
        this.front_camera = front_camera;
    }

    public String getProcessor_chip() {
        return processor_chip;
    }

    public void setProcessor_chip(String processor_chip) {
        this.processor_chip = processor_chip;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getBettery() {
        return bettery;
    }

    public void setBettery(String bettery) {
        this.bettery = bettery;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}
