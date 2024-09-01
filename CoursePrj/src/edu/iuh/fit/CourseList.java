package edu.iuh.fit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * @description Class to manage a list of courses and count courses per department
 * @author: Ngoc, Tang The Ngoc 
 * @version 1.0
 * @created Sep 1, 2024
 */

public class CourseList {
    private int count = 0;
    private Course[] courses;

    /**
     * Constructor to initialize the CourseList with a specified capacity.
     * @param capacity the maximum number of courses the list can hold
     * @throws IllegalArgumentException if the capacity is less than or equal to 0
     */
    public CourseList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        }
        courses = new Course[capacity];
    }

    /**
     * Adds a course to the list.
     * @param course the course to add
     * @return true if the course was added, false if the list is full
     */
    public boolean addCourse(Course course) {
        if (count >= courses.length) {
            return false; // No more space to add a new course
        }
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(course.getId())) {
            	throw new IllegalArgumentException("This course ID already exists");
            }
        }
        courses[count++] = course;
        return true;
    }

    /**
     * Finds the department with the most courses.
     * @return the department with the most courses, or an empty string if there are no courses
     */
    public String findDepartmentWithMostCourses() {
        if (count == 0) {
            return "";
        }

        // Count courses per department
        Map<String, Integer> departmentCount = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String department = courses[i].getDepartment();
            departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
        }

        // Find department with most courses
        String maxDepartment = "";
        int maxCount = 0;
        for (String department : departmentCount.keySet()) {
            int currentCount = departmentCount.get(department);
            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxDepartment = department;
            }
        }

        return maxDepartment;
    }

    /**
     * Finds the courses with the maximum credit value.
     * @return an array of courses with the maximum credit value
     */
    public Course[] findMaxCreditCourses() {
        if (count == 0) {
            return new Course[0];
        }

        // Find the maximum credit value
        int maxCredit = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() > maxCredit) {
                maxCredit = courses[i].getCredit();
            }
        }

        // Collect all courses with the maximum credit value
        List<Course> maxCreditCourses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxCredit) {
                maxCreditCourses.add(courses[i]);
            }
        }

        return maxCreditCourses.toArray(new Course[0]);
    }

    /**
     * Removes a course from the list by its ID.
     * @param courseId the ID of the course to remove
     * @return true if the course was removed, false if the course was not found
     */
    public boolean removeCourse(String courseId) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(courseId)) {
                // Shift remaining courses to the left
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--count] = null; // Decrease count and nullify the last element
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for courses by a keyword in their title.
     * @param keyword the keyword to search for
     * @return an array of courses that contain the keyword in their title
     */
    public Course[] searchCourse(String keyword) {
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(courses[i]);
            }
        }
        return result.toArray(new Course[0]);
    }

    /**
     * Searches for courses by department.
     * @param department the department to search for
     * @return an array of courses in the specified department
     */
    public Course[] searchCourseByDepartment(String department) {
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                result.add(courses[i]);
            }
        }
        return result.toArray(new Course[0]);
    }

    /**
     * Searches for a course by its ID.
     * @param courseId the ID of the course to search for
     * @return the course with the specified ID, or null if not found
     */
    public Course searchCourseById(String courseId) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(courseId)) {
                return courses[i];
            }
        }
        return null;
    }

    /**
     * Sorts the courses by their ID.
     * @return a sorted array of courses
     */
    public Course[] sortCourses() {
        Course[] sortedCourses = Arrays.copyOf(courses, count);
        Arrays.sort(sortedCourses, Comparator.comparing(Course::getTitle));
        return sortedCourses;
    }

    /**
     * Gets all the courses in the list.
     * @return an array of all courses
     */
    public Course[] getCourses() {
        return Arrays.copyOf(courses, count);
    }

    /**
     * Returns a string representation of all courses in the list.
     * @return a formatted string of all courses
     */
    @Override
    public String toString() {
        if (count == 0) {
            return "No courses found.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-30s %-10s %-20s%n", "ID", "Title", "Credit", "Department"));
        sb.append("---------------------------------------------------------------\n");
        for (int i = 0; i < count; i++) {
            Course course = courses[i];
            if (course != null) {
                sb.append(String.format("%-10s %-30s %-10d %-20s%n", course.getId(), course.getTitle(), course.getCredit(), course.getDepartment()));
            }
        }
        return sb.toString();
    }
}
