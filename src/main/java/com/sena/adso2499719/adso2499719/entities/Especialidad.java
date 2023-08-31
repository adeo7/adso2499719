package com.sena.adso2499719.adso2499719.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="especialidades")
public class Especialidad {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	@Column(name = "nombre",length = 100,nullable = false)
	 private String nombre;
	@Column(name = "create_at",nullable = false)
	 private LocalDateTime createAt;
	 @Column(name = "update_at") 
	 private LocalDateTime updateAt;
	@Column(name = "delete_at")
	 private LocalDateTime deleteAt;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	public LocalDateTime getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	public LocalDateTime getDeleteAt() {
		return deleteAt;
	}
	public void setDeleteAt(LocalDateTime deleteAt) {
		this.deleteAt = deleteAt;
	}
	
}
