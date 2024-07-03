package br.com.endersonlg.course_api.modules.course.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCourseDTO {
  @NotBlank(message = "Name is required")
  private String name;

  @NotBlank(message = "Category is required")
  private String category;
}
