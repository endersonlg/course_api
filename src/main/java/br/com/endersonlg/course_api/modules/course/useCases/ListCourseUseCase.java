package br.com.endersonlg.course_api.modules.course.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.endersonlg.course_api.modules.course.entities.CourseEntity;
import br.com.endersonlg.course_api.modules.course.repositories.CourseRepository;

@Service
public class ListCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public List<CourseEntity> execute() {

    return this.courseRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
  }
}
