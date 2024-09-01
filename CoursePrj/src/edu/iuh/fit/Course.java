package edu.iuh.fit;
/**
 * @description A class representing a course with id, title, credit, and department attributes, and methods to get and set these attributes with validation checks.
 * @author 
 * @version 1.0
 * @created Sep 1, 2024
 */

public class Course {
	private String id;
	private String title;
	private int credit;
	private String department;

	/**
	 * Default constructor initializing the course with default values.
	 */
	public Course() {
		// Default constructor
	}

	/**
	 * Constructor to initialize the course with specified id, title, credit, and department.
	 * @param id the id of the course
	 * @param title the title of the course
	 * @param credit the credit value of the course
	 * @param department the department of the course
	 * @throws IllegalArgumentException if id, title, or credit are invalid
	 */
	public Course(String id, String title, int credit, String department) {
		setId(id);
		setTitle(title);
		setCredit(credit);
		this.department = department;
	}

	/**
	 * Gets the id of the course.
	 * @return the id of the course
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the course.
	 * @param id the new id of the course
	 * @throws IllegalArgumentException if id is less than 3 characters or contains non-alphanumeric characters
	 */
	public void setId(String id) {
		if (id.length() < 3) {
			throw new IllegalArgumentException("ID must have at least 3 characters");
		}
		if (!id.matches("[a-zA-Z0-9]+")) {
			throw new IllegalArgumentException("ID must contain only letters or digits");
		}
		this.id = id;
	}

	/**
	 * Gets the title of the course.
	 * @return the title of the course
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the course.
	 * @param title the new title of the course
	 * @throws IllegalArgumentException if title is null or empty
	 */
	public void setTitle(String title) {
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Title must not be empty");
		}
		this.title = title;
	}

	/**
	 * Gets the credit value of the course.
	 * @return the credit value of the course
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * Sets the credit value of the course.
	 * @param credit the new credit value of the course
	 * @throws IllegalArgumentException if credit is less than or equal to 0
	 */
	public void setCredit(int credit) {
		if (credit <= 0) {
			throw new IllegalArgumentException("Credit must be greater than 0");
			}
		this.credit = credit;
	}

	/**
	 * Gets the department of the course.
	 * @return the department of the course
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the department of the course.
	 * @param department the new department of the course
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Returns a string representation of the course.
	 * @return a formatted string with course details
	 */
	@Override
	public String toString() {
		return String.format("Course ID: %s, Title: %s, Credit: %d, Department: %s", id, title, credit, department);
	}
}
