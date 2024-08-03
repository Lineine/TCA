package net.mooctest.internal;

public class TroubleshootingGuide {
  private TroubleshootingGuide() {}

  /** Creates a URL referring to the specified troubleshooting section. */
  public static String createUrl(String id) {
    return "https://github.net.mooctest/blob/main/Troubleshooting.md#" + id;
  }
}
