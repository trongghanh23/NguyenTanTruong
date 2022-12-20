package com.example.smartphones.model.smartphone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private boolean isDelete;
    private String screen;
    private String operatingSystem;
    private String rearCamera;
    private String frontCamera;
    private String processorChip;
    private String ram;
    private String storage;
    private String bettery;
    private String charge;

    public Specifications() {
    }

    public Specifications(Integer id, String name, boolean isDelete, String screen, String operatingSystem, String rearCamera, String frontCamera, String processorChip, String ram, String storage, String bettery, String charge) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.screen = screen;
        this.operatingSystem = operatingSystem;
        this.rearCamera = rearCamera;
        this.frontCamera = frontCamera;
        this.processorChip = processorChip;
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

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operating_system) {
        this.operatingSystem = operating_system;
    }

    public String getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(String rear_camera) {
        this.rearCamera = rear_camera;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(String front_camera) {
        this.frontCamera = front_camera;
    }

    public String getProcessorChip() {
        return processorChip;
    }

    public void setProcessorChip(String processor_chip) {
        this.processorChip = processor_chip;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
