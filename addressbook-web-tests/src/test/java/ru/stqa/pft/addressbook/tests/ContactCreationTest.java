package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {}.getType());
    return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validContactFromJson")
  public void testCreationContact(ContactData contact) {
    app.goTo().gotoHomePage();
    Contacts before = app.getContactHelper().allContact();

//    ContactData contact = //new ContactData().withFirstname("Nicke").withLastname("Marley");
//            new ContactData()
//                    .withFirstname("Bob")
//                    .withLastname("Stewenson")
//                    .withHomePhone("111-222")
//                    .withMobilePhone("+7(222)")
//                    .withWorkPhone("333 999 222")
//                    .withEmail("start@stop.ru")
//                    .withEmail2("bravo@next.com")
//                    .withEmail3("nike@prado.fi")
//                    .withAddress("Moscow, Stornaya  bld 4/52 fl.   9")
//                    .withPhoto(photo);

    app.getContactHelper().createContact(contact);
    Contacts after = app.getContactHelper().allContact();
    assertThat(after, equalTo(before.withAdded(contact)));
  }

}
