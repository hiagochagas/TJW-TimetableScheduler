package br.edu.ifce.TimetableScheduler.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;

@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String dayName;
	private String startTime;
	private String endTime;
	@ManyToMany(mappedBy = "preferredSchedules")
	private List<Professor> professors;
	@OneToMany(mappedBy="schedule")
	private List<Class> classes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
	
	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	@PreRemove
	private void removeFromOtherTables() {
		removeFromProfessors();
		removeFromClasses();
	}
	
	private void removeFromProfessors() {
		for (Professor professor: this.professors) {
			professor.getPreferredSchedules().remove(this);
		}
	}
	
	private void removeFromClasses() {
		for (Class c: this.classes) {
			c.setSchedule(null);
		}
	}
}
