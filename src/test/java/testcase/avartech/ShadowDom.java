package testcase.avartech;

public class ShadowDom {
    // Static method
    static void myStaticMethod() {
        System.out.println("Static methods can be called without creating objects1");
    }

    // Public method
    public void myPublicMethod() {
        System.out.println("Public methods must be called by creating objects");
    }

    // Main method
    public static void main(String[] args) {
       myStaticMethod(); // Call the static method

    }
}