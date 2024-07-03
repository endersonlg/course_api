package br.com.endersonlg.course_api.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.endersonlg.course_api.exceptions.CourseIdNotFound;
import br.com.endersonlg.course_api.modules.course.dto.UpdateCourseDTO;
import br.com.endersonlg.course_api.modules.course.entities.CourseEntity;
import br.com.endersonlg.course_api.modules.course.repositories.CourseRepository;

@Service
public class UpdateCourseUseCase {
  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(UUID id, UpdateCourseDTO updateCourseDTO) {
    var course = this.courseRepository.findById(id).orElseThrow(
        () -> {
          throw new CourseIdNotFound();
        });

    if (updateCourseDTO.getName() != null) {
      course.setName(updateCourseDTO.getName());
    }

    if (updateCourseDTO.getCategory() != null) {
      course.setCategory(updateCourseDTO.getCategory());
    }

    return this.courseRepository.save(course);
  }

}
