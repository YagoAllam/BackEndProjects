package com.epicode.gestioneIncendi.medels;



public class Sonda {
	

	private Long id;
    private Double latitude;
    private Double longitude;
    private Double smokeLevel;
    
    
    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the smokeLevel
	 */
	public Double getSmokeLevel() {
		return smokeLevel;
	}
	/**
	 * @param smokeLevel the smokeLevel to set
	 */
	public void setSmokeLevel(Double smokeLevel) {
		this.smokeLevel = smokeLevel;
	}
	
	public Sonda(Long id, Double latitude, Double longitude, Double smokeLevel) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.smokeLevel = smokeLevel;
	}
	
	



}
