package com.philzcodes.computer.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MaintenancePrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String equipment;
    private String riskLevel;
    private String suggestedAction;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	public String getSuggestedAction() {
		return suggestedAction;
	}
	public void setSuggestedAction(String suggestedAction) {
		this.suggestedAction = suggestedAction;
	}

    // Getters and Setters
    
    
}
