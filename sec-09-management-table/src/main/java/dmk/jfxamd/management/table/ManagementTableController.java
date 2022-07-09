package dmk.jfxamd.management.table;

import dmk.jfxamd.management.table.model.Person;
import dmk.jfxamd.utilities.common.Utils;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Function;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class ManagementTableController implements Initializable {

  @FXML
  private MFXTableView<Person> table;
  @FXML
  private Label ageLbl;
  @FXML
  private Label genderLbl;
  @FXML
  private Label jobLbl;
  @FXML
  private Label nameLbl;
  @FXML
  private MFXTextField ageTxt;
  @FXML
  private MFXComboBox<String> genderCmb;
  @FXML
  private MFXTextField jobTxt;
  @FXML
  private MFXTextField nameTxt;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    MFXTableColumn<Person> nameColumn = new MFXTableColumn<>("NAME", true);
    MFXTableColumn<Person> jobColumn = new MFXTableColumn<>("JOB", true);
    MFXTableColumn<Person> ageColumn = new MFXTableColumn<>("AGE", true);
    MFXTableColumn<Person> genderColumn = new MFXTableColumn<>("GENDER", true);

    double columnWidth = table.getPrefWidth() / 4;
    nameColumn.setRowCellFactory(createTableRowCell(Person::getName));
    nameColumn.setPrefWidth(columnWidth);
    jobColumn.setRowCellFactory(createTableRowCell(Person::getJob));
    jobColumn.setPrefWidth(columnWidth);
    ageColumn.setRowCellFactory(createTableRowCell(Person::getAge));
    ageColumn.setPrefWidth(columnWidth);
    genderColumn.setRowCellFactory(createTableRowCell(Person::getGender));
    genderColumn.setPrefWidth(columnWidth);

    table.getTableColumns().addAll(nameColumn, jobColumn, ageColumn, genderColumn);
    table.setItems(initData(10));
    table.getSelectionModel().selectionProperty().addListener((MapChangeListener<? super Integer, ? super Person>) change -> {
      if (change.wasAdded()) {
        Person person = change.getValueAdded();
        nameTxt.setText(person.getName());
        nameLbl.setText(person.getName());
        jobTxt.setText(person.getJob());
        jobLbl.setText(person.getJob());
        ageTxt.setText(person.getAge());
        ageLbl.setText(person.getAge());
        genderCmb.getSelectionModel().selectItem(person.getGender());
        genderLbl.setText(person.getGender());
      }
    });
    genderCmb.getItems().addAll("Male", "Female");
  }

  @FXML
  void add(ActionEvent event) {
    var person = new Person(nameTxt.getText(), jobTxt.getText(), ageTxt.getText(), genderCmb.getSelectedItem());
    table.getItems().add(person);
  }

  @FXML
  void clear(ActionEvent event) {
    nameTxt.clear();
    jobTxt.clear();
    ageTxt.clear();
    genderCmb.getSelectionModel().clearSelection();
  }

  @FXML
  void delete(ActionEvent event) {
    var personOpt = table.getSelectionModel().getSelectedValues().stream().findFirst();
    personOpt.ifPresent(person -> table.getItems().remove(person));
  }

  @FXML
  void edit(ActionEvent event) {
    var selectedKey = table.getSelectionModel().getSelection().keySet().stream().findFirst();
    selectedKey.ifPresent(key -> {
      var person = table.getItems().get(key);
      person.setName(nameTxt.getText());
      person.setJob(jobTxt.getText());
      person.setAge(ageTxt.getText());
      person.setGender(genderCmb.getSelectedItem());
      table.getCell(key).updateRow();
    });
  }

  private ObservableList<Person> initData(int count) {
    var list = new ArrayList<Person>();
    var faker = Utils.faker();

    for (int i = 0; i < count; i++) {
      list.add(new Person(faker.name().name(), faker.job().title(), String.valueOf(faker.random().nextInt(20, 100)), faker.bool().bool() ? "Male" : "Female"));
    }

    return FXCollections.observableList(list);
  }

  private Function<Person, MFXTableRowCell<Person, ?>> createTableRowCell(Function<Person, ?> extractor) {
    return person -> new MFXTableRowCell<>(extractor);
  }
}
