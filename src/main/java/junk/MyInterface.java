package junk;

public interface MyInterface {
    void myAbstractMethod();
    default void myDefaultMethod(){
        System.out.println("default behavior");
    }
}
