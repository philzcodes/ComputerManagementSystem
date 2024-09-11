package com.philzcodes.computer.management.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String model;
    private String manufacturer;
    private String location;
    private LocalDate installationDate;
    private String status;
    private String failureProbability;  // Store failure probabilities as comma-separated values
    private Integer riskLevel;

    private String resourceRecommendation;
    private String schedulingRecommendation;
    private String inventoryRecommendation;

    // Default constructor
    public Equipment() {}

    // Custom constructor
    public Equipment(String name) {
        this.name = name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(LocalDate installationDate) {
		this.installationDate = installationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFailureProbability() {
		return failureProbability;
	}

	public void setFailureProbability(String failureProbability) {
		this.failureProbability = failureProbability;
	}

	public Integer getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getResourceRecommendation() {
		return resourceRecommendation;
	}

	public void setResourceRecommendation(String resourceRecommendation) {
		this.resourceRecommendation = resourceRecommendation;
	}

	public String getSchedulingRecommendation() {
		return schedulingRecommendation;
	}

	public void setSchedulingRecommendation(String schedulingRecommendation) {
		this.schedulingRecommendation = schedulingRecommendation;
	}

	public String getInventoryRecommendation() {
		return inventoryRecommendation;
	}

	public void setInventoryRecommendation(String inventoryRecommendation) {
		this.inventoryRecommendation = inventoryRecommendation;
	}

    // Getters and Setters
   
}
