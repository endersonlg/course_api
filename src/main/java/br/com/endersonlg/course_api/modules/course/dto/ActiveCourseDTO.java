package br.com.endersonlg.course_api.modules.course.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActiveCourseDTO {
  @NotNull(message = "Active is required")
  private Boolean active;
}
