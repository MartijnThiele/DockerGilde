package helpers;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class JunitProperties implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {

        if (System.getenv("PARALLEL") != null) {
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.setProperty("junit.jupiter.execution.parallel.enabled", "true");
            System.setProperty("junit.jupiter.execution.parallel.mode.default", "concurrent");
        } else {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.setProperty("junit.jupiter.execution.parallel.enabled", "false");
        }
    }
}