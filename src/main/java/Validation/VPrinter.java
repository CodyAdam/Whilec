package Validation;

import java.util.HashMap;

public class VPrinter {

    private static VPrinter instance;
    private static HashMap<FontDetail, String> fontDetailToCode = new HashMap<>();

    public static VPrinter getInstance() {
        if(instance == null) {
            instance = new VPrinter();
        }
        return instance;
    }

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    static {
        fontDetailToCode.put(new FontDetail(Color.WHITE, false, false), "\033[0;37m");
        fontDetailToCode.put(new FontDetail(Color.CYAN, false, false), "\033[0;36m");
        fontDetailToCode.put(new FontDetail(Color.PURPLE, false, false), "\033[0;35m");
        fontDetailToCode.put(new FontDetail(Color.BLUE, false, false), "\033[0;34m");
        fontDetailToCode.put(new FontDetail(Color.YELLOW, false, false), "\033[0;33m");
        fontDetailToCode.put(new FontDetail(Color.GREEN, false, false), "\033[0;32m");
        fontDetailToCode.put(new FontDetail(Color.RED, false, false), "\033[0;31m");
        fontDetailToCode.put(new FontDetail(Color.BLACK, false, false), "\033[0;30m");

        fontDetailToCode.put(new FontDetail(Color.WHITE, true, false), "\033[1;37m");
        fontDetailToCode.put(new FontDetail(Color.CYAN, true, false), "\033[1;36m");
        fontDetailToCode.put(new FontDetail(Color.PURPLE, true, false), "\033[1;35m");
        fontDetailToCode.put(new FontDetail(Color.BLUE, true, false), "\033[1;34m");
        fontDetailToCode.put(new FontDetail(Color.YELLOW, true, false), "\033[1;33m");
        fontDetailToCode.put(new FontDetail(Color.GREEN, true, false), "\033[1;32m");
        fontDetailToCode.put(new FontDetail(Color.RED, true, false), "\033[1;31m");
        fontDetailToCode.put(new FontDetail(Color.BLACK, true, false), "\033[1;30m");

        fontDetailToCode.put(new FontDetail(Color.WHITE, false, true), "\033[4;37m");
        fontDetailToCode.put(new FontDetail(Color.CYAN, false, true), "\033[4;36m");
        fontDetailToCode.put(new FontDetail(Color.PURPLE, false, true), "\033[4;35m");
        fontDetailToCode.put(new FontDetail(Color.BLUE, false, true), "\033[4;34m");
        fontDetailToCode.put(new FontDetail(Color.YELLOW, false, true), "\033[4;33m");
        fontDetailToCode.put(new FontDetail(Color.GREEN, false, true), "\033[4;32m");
        fontDetailToCode.put(new FontDetail(Color.RED, false, true), "\033[4;31m");
        fontDetailToCode.put(new FontDetail(Color.BLACK, false, true), "\033[4;30m");
    }

    public void print(String message) {
        print(message, new FontDetail(Color.WHITE, false, false));
    }

    public void print(String message, FontDetail font) {
        System.out.print(fontDetailToCode.get(font) + message + RESET);
    }

    public void println(String message) {
        println(message, new FontDetail(Color.WHITE, false, false));
    }

    public void println(String message, FontDetail font) {
        System.out.println(fontDetailToCode.get(font) + message + RESET);
    }

    public void printError(String message, String path, int line, int charPositionInLine) {
        println("ERROR : "+message, new FontDetail(Color.RED, true, false));
        println("Error found at ("+path+":"+line+":"+charPositionInLine+")\n", new FontDetail(Color.RED, false, false));
    }
}

