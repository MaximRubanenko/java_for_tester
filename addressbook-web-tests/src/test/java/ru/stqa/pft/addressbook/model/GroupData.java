package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  public void setId(int id) {
    this.id = id;
  }

  private  int id;
  private final String groupName;
  private final String groupHeader;
  private final String groupFooter;

  @Override
  public String toString() {
    return "GroupData{" +
            "groupName='" + groupName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(id, groupData.id) &&
            Objects.equals(groupName, groupData.groupName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, groupName);
  }

  public int getId() {
    return id;
  }

  public GroupData(int id, String groupName, String groupHeader, String groupFooter) {
    this.id = id;
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
  }
  public GroupData( String groupName, String groupHeader, String groupFooter) {
    this.id = 0;
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
  }
  public String getGroupName() {
    return groupName;
  }

  public String getGroupHeader() {
    return groupHeader;
  }

  public String getGroupFooter() {
    return groupFooter;
  }
}
