package java25;

import java.util.Objects;

public class ClassB extends ClassA {
    private final String a;

    ClassB(String a) {
        super();
        this.a = Objects.requireNonNull(a);
    }

    String a() {
        return this.a;
    }
}
