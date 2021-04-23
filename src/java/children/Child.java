package children;

import java.net.URL;

public class Child {

  public Child() {
    URL relativeURL = this.getClass().getResource("titi.txt");
    String relativePath = "";
    String externalRelativePath = "";
    String systemRelativePath = "";

    if (relativeURL != null) {
      relativePath = relativeURL.getPath();
      externalRelativePath = relativeURL.toExternalForm();
    }
    Child.class.getClassLoader();
    URL systemURL = ClassLoader.getSystemResource("tutu/tete.txt");
    if (systemURL != null) systemRelativePath = systemURL.getPath();

    System.out.println("child relativePath : " + relativePath);
    System.out.println("child externalRelativePath : " + externalRelativePath);
    System.out.println("child systemRelativePath : " + systemRelativePath);
  }
}
