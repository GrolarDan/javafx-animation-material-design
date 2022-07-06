package dmk.jfxamd.management.table.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
  private String name;
  private String job;
  private String age;
  private String gender;
}
