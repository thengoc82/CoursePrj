package edu.iuh.fit;

import java.util.Scanner;

/**
 * @description 
 * @author: Ngoc, Tang The Ngoc 
 * @version 1.0
 * @created Sep 1, 2024
 */

public class TestCourse {
    
    private static void initData(CourseList courseList) {
        courseList.addCourse(new Course("CS101", "Introduction to Programming", 3, "Computer Science"));
        courseList.addCourse(new Course("MT201", "Calculus I", 4, "Mathematics"));
        courseList.addCourse(new Course("PH301", "Physics for Engineers", 4, "Physics"));
        courseList.addCourse(new Course("EN401", "Advanced English", 3, "English"));
        courseList.addCourse(new Course("EN501", "Intermediate English", 3, "English"));
    }

    public static void main(String[] args) {
        CourseList courseList = new CourseList(10);
        initData(courseList);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display all courses");
            System.out.println("2. Find department with most courses");
            System.out.println("3. Find courses with maximum credits");
            System.out.println("4. Remove a course by ID");
            System.out.println("5. Search courses by keyword");
            System.out.println("6. Search courses by department");
            System.out.println("7. Search course by ID");
            System.out.println("8. Sort courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println(courseList.toString());
                    break;
                case 2:
                    System.out.println("Department with most courses: " + courseList.findDepartmentWithMostCourses());
                    break;
                case 3:
                    Course[] maxCreditsCourses = courseList.findMaxCreditCourses();
                    System.out.println("Max credit courses: ");
                    for (Course course : maxCreditsCourses) {
                        System.out.println(course.toString());
                    }
                    break;
                case 4:
                    System.out.print("Enter course ID to remove: ");
                    String removeId = scanner.nextLine();
                    System.out.println("Remove " + removeId + ": " + courseList.removeCourse(removeId));
                    break;
                case 5:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    Course[] keywordCourses = courseList.searchCourse(keyword);
                    if (keywordCourses.length > 0) {
                        for (Course course : keywordCourses) {
                            System.out.println(course.toString());
                        }
                    } else {
                        System.out.println("No courses found with the keyword.");
                    }
                    break;
                case 6:
                    System.out.print("Enter department to search: ");
                    String department = scanner.nextLine();
                    Course[] departmentCourses = courseList.searchCourseByDepartment(department);
                    if (departmentCourses.length > 0) {
                        for (Course course : departmentCourses) {
                            System.out.println(course.toString());
                        }
                    } else {
                        System.out.println("No courses found in the department.");
                    }
                    break;
                case 7:
                    System.out.print("Enter course ID to search: ");
                    String searchId = scanner.nextLine();
                    Course foundCourse = courseList.searchCourseById(searchId);
                    if (foundCourse != null) {
                        System.out.println(foundCourse.toString());
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 8:
                    Course[] sortedCourses = courseList.sortCourses();
                    System.out.println("Sorted courses:");
                    for (Course course : sortedCourses) {
                        System.out.println(course.toString());
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
