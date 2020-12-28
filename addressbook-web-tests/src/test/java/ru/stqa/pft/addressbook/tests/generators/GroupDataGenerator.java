package ru.stqa.pft.addressbook.tests.generators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.tests.model.Contacts;
import ru.stqa.pft.addressbook.tests.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class GroupDataGenerator {
  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);
    List<GroupData> groups = generateGroups(count);
    saveAsJson(groups, file);
  }
/*
  private void run() throws IOException{
    List<GroupData> groups = generateGroups(count);
    if (format.equals("json")){
      saveAsJson(groups, new File(file));
    }
  }
*/
  private static void saveAsJson(List<GroupData> groups, File file) throws IOException {
    //System.out.println(new File(".").getAbsolutePath());
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(groups);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private static List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      groups.add(new GroupData().withName(String.format("test %s", i))
              .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
    }
    return groups;
  }
}
