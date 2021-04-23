import java.net.URL;

public class Root {
  Root() {
    URL relativeURL = this.getClass().getResource("/tutu/toto.txt");
    String relativePath = "";
    String externalRelativePath = "";
    String systemRelativePath = "";

    if (relativeURL != null) {
      relativePath = relativeURL.getPath();
      externalRelativePath = relativeURL.toExternalForm();
    }
    Root.class.getClassLoader();
    URL systemURL = ClassLoader.getSystemResource("tutu/tete.txt");
    if (systemURL != null) systemRelativePath = systemURL.getPath();

    System.out.println("root relativePath : " + relativePath);
    System.out.println("root externalRelativePath : " + externalRelativePath);
    System.out.println("root systemRelativePath : " + systemRelativePath);
  }
}
