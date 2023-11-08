package br.edu.ifce.TimetableScheduler.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToMany
	@JoinTable(name = "professor_discipline", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "discipline_id"))
	private Set<Discipline> disciplines;
	@ManyToMany
	@JoinTable(name = "professor_schedule", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "schedule_id"))
	private Set<Schedule> preferredSchedules;

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

	public Set<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(Set<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	public Set<Schedule> getPreferredSchedules() {
		return preferredSchedules;
	}

	public void setPreferredSchedules(Set<Schedule> preferredSchedules) {
		this.preferredSchedules = preferredSchedules;
	}

}
