package br.edu.ifce.TimetableScheduler.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToMany
	@JoinTable(name = "professor_discipline", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "discipline_id"))
	private List<Discipline> disciplines;
	@ManyToMany
	@JoinTable(name = "professor_schedule", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "schedule_id"))
	private List<Schedule> preferredSchedules;
	@OneToMany(mappedBy = "professor")
	private List<Class> classes;

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

	public List<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	public List<Schedule> getPreferredSchedules() {
		return preferredSchedules;
	}

	public void setPreferredSchedules(List<Schedule> preferredSchedules) {
		this.preferredSchedules = preferredSchedules;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	public void removeDiscipline(Discipline discipline) {
		this.disciplines.remove(discipline);
		discipline.getProfessors().remove(this);
	}
	
	@PreRemove
	private void removeFromClasses() {
		for (Class c: this.classes) {
			c.setProfessor(null);
		}
	}
}
