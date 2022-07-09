package dmk.jfxamd.management.table.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
  private StringProperty name;
  private StringProperty job;
  private StringProperty age;
  private StringProperty gender;

  public Person(String name, String job, String age, String gender) {
    this.name = new SimpleStringProperty(name);
    this.job = new SimpleStringProperty(job);
    this.age = new SimpleStringProperty(age);
    this.gender = new SimpleStringProperty(gender);
  }

  public String getName() {
    return name.get();
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public String getJob() {
    return job.get();
  }

  public void setJob(String job) {
    this.job.set(job);
  }

  public String getAge() {
    return age.get();
  }

  public void setAge(String age) {
    this.age.set(age);
  }

  public String getGender() {
    return gender.get();
  }

  public void setGender(String gender) {
    this.gender.set(gender);
  }

  public StringProperty nameProperty() {
    return name;
  }

  public StringProperty jobProperty() {
    return job;
  }

  public StringProperty ageProperty() {
    return age;
  }

  public StringProperty genderProperty() {
    return gender;
  }
}
