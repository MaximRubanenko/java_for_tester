package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  @Parameter(names = "-c", description = "Contacts count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {

    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jc = new JCommander(generator);
    try {
      jc.parse(args);
    } catch (ParameterException ex) {
      jc.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {

    List<ContactData> contacts = generateContacts(count);

    if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else {
      System.out.println("Ungecognized format " + format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try(Writer writer = new FileWriter(file);) {
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try(Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    File photo = new File("src/test/resources/medved.png");
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData()
              .withFirstname(String.format("Bob %s", i))
              .withLastname(String.format("Stewenson %s",i))
              .withHomePhone(String.format("111-222 %s",i))
              .withMobilePhone(String.format("7(222) %s",i))
              .withWorkPhone(String.format("333 999 222 %s",i))
              .withEmail(String.format("start@stop.ru %s",i))
              .withEmail2(String.format("bravo@next.com %s",i))
              .withEmail3(String.format("nike@prado.fi %s",i))
              .withAddress(String.format("Moscow, Stornaya  bld 4/52 fl. 9 %s",i)));
              //.withPhoto(photo)); // toString
    }
    return contacts;
  }
}
