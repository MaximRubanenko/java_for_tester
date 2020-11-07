package ru.stqa.pft.addressbook;

public class GroupDAta {
  private final String groupName;
  private final String groupHeader;
  private final String groupFooter;

  public GroupDAta(String groupName, String groupHeader, String groupFooter) {
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
