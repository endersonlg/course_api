package br.com.endersonlg.course_api.exceptions;

public class CourseIdNotFound extends RuntimeException {
  public CourseIdNotFound() {
    super("Id not found");
  }

}
