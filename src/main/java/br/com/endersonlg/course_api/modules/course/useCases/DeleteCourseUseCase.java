package br.com.endersonlg.course_api.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.endersonlg.course_api.exceptions.CourseIdNotFound;
import br.com.endersonlg.course_api.modules.course.repositories.CourseRepository;

@Service
public class DeleteCourseUseCase {
  @Autowired
  private CourseRepository courseRepository;

  public void execute(UUID id) {
    var course = this.courseRepository.findById(id).orElseThrow(
        () -> {
          throw new CourseIdNotFound();
        });

    this.courseRepository.deleteById(course.getId());
  }

}
