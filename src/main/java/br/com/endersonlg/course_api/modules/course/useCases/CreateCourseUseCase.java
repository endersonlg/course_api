package br.com.endersonlg.course_api.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.endersonlg.course_api.modules.course.dto.CreateCourseDTO;
import br.com.endersonlg.course_api.modules.course.entities.CourseEntity;
import br.com.endersonlg.course_api.modules.course.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(CreateCourseDTO courseEntityDTO) {

    var course = CourseEntity.builder().name(courseEntityDTO.getName()).category(courseEntityDTO.getCategory())
        .build();

    return this.courseRepository.save(course);
  }
}
