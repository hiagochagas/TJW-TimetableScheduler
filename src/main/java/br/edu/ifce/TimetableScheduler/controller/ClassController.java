package br.edu.ifce.TimetableScheduler.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifce.TimetableScheduler.model.Class;
import br.edu.ifce.TimetableScheduler.model.Discipline;
import br.edu.ifce.TimetableScheduler.model.Pair;
import br.edu.ifce.TimetableScheduler.model.Professor;
import br.edu.ifce.TimetableScheduler.model.Schedule;
import br.edu.ifce.TimetableScheduler.serviceImpl.ClassServiceImpl;
import br.edu.ifce.TimetableScheduler.serviceImpl.ProfessorServiceImpl;
import br.edu.ifce.TimetableScheduler.serviceImpl.ScheduleServiceImpl;

@Controller
@RequestMapping("/class")
public class ClassController {
	@Autowired
	ClassServiceImpl classService;
	@Autowired
	ScheduleServiceImpl scheduleService;
	@Autowired
	ProfessorServiceImpl professorService;
	
	@GetMapping("/reorganize")
	public String reorganizeClasses() {
		// delete all previous timetables
		classService.deleteAll();
		// create new timetables
		List<Class> classes = allocateClasses();
		// save to database
		for (Class c: classes) {
			classService.save(c);	
		}
		return "redirect:/";
	}
	
	private List<Class> allocateClasses() {
		List<Schedule> schedules = scheduleService.fetchAll();
		List<Professor> professors = professorService.fetchAll();
		List<Class> classes = createClasses(professors);
		int[][] graph = createGraph(classes);
		return nandalAlgorithm(graph, classes, schedules);
	}
	
	private List<Class> nandalAlgorithm(int[][] graph, List<Class> classes, List<Schedule> schedules) {
        List<Class> orderedClasses = orderClassesByVertexGrade(graph, classes);

        for (Class classObj : orderedClasses) {
            colorClass(classObj, graph, classes, schedules);
        }

        return orderedClasses;
    }
	
	public static List<Class> orderClassesByVertexGrade(int[][] graph, List<Class> classes) {
        List<Pair<Class, Integer>> result = new ArrayList<>();

        for (int index = 0; index < classes.size(); index++) {
            int vertexGrade = countOnes(graph[index]);
            result.add(new Pair<>(classes.get(index), vertexGrade));
        }

        result.sort(Comparator.comparing(Pair::getValue, Comparator.reverseOrder()));

        return result.stream().map(Pair::getKey).toList();
    }

    private static int countOnes(int[] array) {
        int count = 0;
        for (int value : array) {
            if (value == 1) {
                count++;
            }
        }
        return count;
    }
	
	public static void colorClass(Class c, int[][] graph, List<Class> classes, List<Schedule> schedules) {
        List<Class> adjacentClasses = findAdjacentClasses(graph, classes, c);
        Set<Schedule> adjacentSchedules = new HashSet<>();

        for (Class adjacentClass : adjacentClasses) {
            Schedule schedule = adjacentClass.getSchedule();
            if (schedule != null) {
                adjacentSchedules.add(schedule);
            }
        }

        for (Schedule preferredSchedule : c.getProfessor().getPreferredSchedules()) {
            if (!adjacentSchedules.contains(preferredSchedule)) {
                c.setSchedule(preferredSchedule);
                break;
            }
        }

        if (c.getSchedule() == null) {
            for (Schedule schedule : schedules) {
                if (!adjacentSchedules.contains(schedule)) {
                    c.setSchedule(schedule);
                    break;
                }
            }
        }
    }
	
	public static List<Class> findAdjacentClasses(int[][] graph, List<Class> classes, Class c) {
        int classIndex = classes.indexOf(c);
        if (classIndex == -1) {
            return new ArrayList<>();
        }

        List<Class> adjacents = new ArrayList<>();
        for (int index = 0; index < graph[classIndex].length; index++) {
            if (graph[classIndex][index] == 1) {
                adjacents.add(classes.get(index));
            }
        }
        return adjacents;
    }
	
	private List<Class> createClasses(List<Professor> professors) {
		List<Class> classes = new ArrayList<Class>();
		for (Professor professor: professors) {
			for (Discipline discipline: professor.getDisciplines()) {
				Class c = new Class();
				c.setProfessor(professor);
				c.setDiscipline(discipline);
				classes.add(c);
			}
		}
		return classes;
	}
	
	private int[][] createGraph(List<Class> classes) {
        int size = classes.size();
		int[][] graph = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || i > j) {
                    continue;
                }
                if (classes.get(i).equals(classes.get(j))) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        return graph;
    }
}
