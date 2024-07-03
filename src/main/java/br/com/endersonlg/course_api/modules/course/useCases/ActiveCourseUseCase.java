package br.com.endersonlg.course_api.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.endersonlg.course_api.exceptions.CourseIdNotFound;
import br.com.endersonlg.course_api.modules.course.dto.ActiveCourseDTO;
import br.com.endersonlg.course_api.modules.course.entities.CourseEntity;
import br.com.endersonlg.course_api.modules.course.repositories.CourseRepository;

@Service
public class ActiveCourseUseCase {
  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(UUID id, ActiveCourseDTO courseActiveDTO) {
    var course = this.courseRepository.findById(id).orElseThrow(
        () -> {
          throw new CourseIdNotFound();
        });

    course.setIsActive(courseActiveDTO.getActive());

    return this.courseRepository.save(course);
  }

}
