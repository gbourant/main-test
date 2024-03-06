package gr.main;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTestProfile;
import io.quarkus.test.junit.TestProfile;
import io.quarkus.test.junit.main.Launch;
import io.quarkus.test.junit.main.QuarkusMainTest;

@QuarkusMainTest
class MainTest {

    @Nested
    @TestProfile(Inner.MyTestProfile.class)
    class Inner {

        public static class MyTestProfile implements QuarkusTestProfile {
        }

        @Test
        @Launch(value = {}, exitCode = 0)
        public void testMain() {
        }
    }

    @Nested
    @TestProfile(Inner2Test.MyTest2Profile.class)
    class Inner2Test {

        public static class MyTest2Profile implements QuarkusTestProfile {

            @Override
            public Map<String, String> getConfigOverrides() {
                return Map.of("project.required", "false");
            }

        }

        @Test
        @Launch(value = {}, exitCode = 1000)
        public void testMain() {
        }
    }

    @Test
    @Launch(value = {}, exitCode = 0)
    public void testMain() {
    }

}
