package gr.main;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {

        @ConfigProperty(name = "project.required")
        boolean required;

        @Override
        public int run(String... args) throws Exception {
            if (!required) {
                return 1000;
            }
            Quarkus.asyncExit(0);
            return 0;
        }
    }

}
