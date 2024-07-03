package br.com.endersonlg.course_api.modules.course.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.endersonlg.course_api.modules.course.dto.ActiveCourseDTO;
import br.com.endersonlg.course_api.modules.course.dto.CreateCourseDTO;
import br.com.endersonlg.course_api.modules.course.dto.UpdateCourseDTO;
import br.com.endersonlg.course_api.modules.course.entities.CourseEntity;
import br.com.endersonlg.course_api.modules.course.useCases.CreateCourseUseCase;
import br.com.endersonlg.course_api.modules.course.useCases.DeleteCourseUseCase;
import br.com.endersonlg.course_api.modules.course.useCases.ListCourseUseCase;
import br.com.endersonlg.course_api.modules.course.useCases.ActiveCourseUseCase;
import br.com.endersonlg.course_api.modules.course.useCases.UpdateCourseUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CourseController {

  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @Autowired
  private ListCourseUseCase listCourseUseCase;

  @Autowired
  private DeleteCourseUseCase deleteCourseUseCase;

  @Autowired
  private UpdateCourseUseCase updateCourseUseCaseBy;

  @Autowired
  private ActiveCourseUseCase updateCourseActiveUseCase;

  @PostMapping
  public CourseEntity create(@Valid @RequestBody CreateCourseDTO courseDTO) {
    return this.createCourseUseCase.execute(courseDTO);
  }

  @GetMapping
  public List<CourseEntity> list() {
    return this.listCourseUseCase.execute();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteById(@PathVariable("id") String id) {
    try {
      this.deleteCourseUseCase.execute(UUID.fromString(id));
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@PathVariable("id") String id,
      @Valid @RequestBody UpdateCourseDTO updateCourseDTO) {
    try {
      var course = this.updateCourseUseCaseBy.execute(UUID.fromString(id), updateCourseDTO);
      return ResponseEntity.ok().body(course);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PatchMapping("/{id}/active")
  public ResponseEntity<Object> update(@PathVariable("id") String id,
      @Valid @RequestBody ActiveCourseDTO courseActiveDTO) {
    try {
      var course = this.updateCourseActiveUseCase.execute(UUID.fromString(id), courseActiveDTO);
      return ResponseEntity.ok().body(course);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
