package configurationClassInJaywayJsonPath;

public class ConfigurationClassMain {

public static void main(String[] args) {
    // Instantiate and test the different implementations
    CustomConfigurationWithBuilder customConfigExample = new CustomConfigurationWithBuilder();
    DefaultConfigurationWithAlwaysReturnList listConfigExample = new DefaultConfigurationWithAlwaysReturnList();
    DefaultConfigurationWithDefaultPathLeafToNull leafConfigExample = new DefaultConfigurationWithDefaultPathLeafToNull();

    // Run the methods to demonstrate functionality
    leafConfigExample.useDefaultConfigurationWithDefaultPathLeafToNull();
    listConfigExample.useDefaultConfigurationWithAlwaysReturnList();
    customConfigExample.useCustomConfigurationWithBuilder();
}

}
