package org.fasttrackit.automation;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.junit.Test;

public class TablesTest extends TestBase {

    private ElementTestView elementsView = new ElementTestView();
    protected LoginView page = new LoginView();

    @Test

    public void clickOnTable() {


        openBrowser();

        page.login("eu@fast.com", "eu.pass");

        WebLocator tableCheckBox = new WebLocator().setElPath("//table//tr[1]//input");

        tableCheckBox.click();

        Utils.sleep(1000);

        tableCheckBox = new WebLocator().setElPath("//table//tr[2]//input");

        tableCheckBox.click();
    }

    @Test

    public void selectTableRowTest() {

        openBrowser();

        page.login("eu@fast.com", "eu.pass");

        Table table =new Table();

        Row row = table.getRow(new Cell(4, "davidmiller@mail.com" ));

//         WebLocator checkbox = new WebLocator(row).setTag("input");
        CheckBox checkbox = new CheckBox(row);
         checkbox.click();


         WebLocator tableLocator = new WebLocator().setTag("table");
         WebLocator firstNameLocator = new WebLocator().setText("Bob");
         WebLocator lastNameLocator = new WebLocator().setText("Smith");
         WebLocator rowLocator = new WebLocator(tableLocator).setTag("tr").setChildNodes(firstNameLocator, lastNameLocator);
         WebLocator checkBoxLocator = new WebLocator().setContainer(rowLocator).setTag("input");
         checkBoxLocator.click();
    }





}
