package com.fabiano.professorallocation.entity;
import java .time.DayOfWeek;
import java .util.Date;

public class Allocation {
	private Long id;
	private DayOfWeek day;
	private Date end;
	private Long courseId;
	private Long professorId;	
}
