package dmk.jfxamd.management.table;

import dmk.jfxamd.management.table.model.Person;
import dmk.jfxamd.utilities.common.Utils;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.function.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class ManagementTableController implements Initializable {

  @FXML
  private MFXTableView<Person> table;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    MFXTableColumn<Person> nameColumn = new MFXTableColumn<>("NAME", true);
    MFXTableColumn<Person> jobColumn = new MFXTableColumn<>("JOB", true);
    MFXTableColumn<Person> ageColumn = new MFXTableColumn<>("AGE", true);
    MFXTableColumn<Person> genderColumn = new MFXTableColumn<>("GENDER", true);

    nameColumn.setRowCellFactory(createTableRowCell(Person::getName));
    jobColumn.setRowCellFactory(createTableRowCell(Person::getJob));
    ageColumn.setRowCellFactory(createTableRowCell(Person::getAge));
    genderColumn.setRowCellFactory(createTableRowCell(Person::getGender));

    table.getTableColumns().addAll(nameColumn, jobColumn, ageColumn, genderColumn);
    table.setItems(initData(10));
  }

  private ObservableList<Person> initData(int count) {
    var list = new ArrayList<Person>();
    var faker = Utils.faker();

    for (int i = 0; i < count; i++) {
      list.add(new Person(faker.name().name(), faker.job().title(), String.valueOf(faker.random().nextInt(100)), faker.bool().bool() ? "Male" : "Female"));
    }

    return FXCollections.observableList(list);
  }

  private Function<Person, MFXTableRowCell<Person, ?>> createTableRowCell(Function<Person, ?> extractor) {
    return person -> new MFXTableRowCell<>(extractor);
  }
}
