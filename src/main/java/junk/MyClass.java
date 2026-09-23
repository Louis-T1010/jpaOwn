package junk;

import java.util.Objects;

public class MyClass {
    private String s;

    public void setS(String s) {
        if (Objects.equals(s, "mike")){
            throw new RuntimeException();
        }
        this.s = s;
    }
}
