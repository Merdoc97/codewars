public class Matrix {

    public static void enter() {
            throwsUnchecked(new Neo());
    }

    public static <T extends Exception> void throwsUnchecked(Exception toThrow) throws T{
        // Since the type is erased, this cast actually does nothing!!!
        // we can throw any exception
        throw (T) toThrow;
    }

    public static final class Neo extends Exception {
    }


    public static void main(String[] args) {
        Matrix.enter();
    }
}
