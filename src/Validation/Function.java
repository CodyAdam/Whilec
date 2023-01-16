package Validation;

import java.util.ArrayList;
import java.util.HashMap;

public class Function {
    public String functionName;
    public HashMap<String, VariableBinding> args;
    public HashMap<String, VariableBinding> returnType;
    public ArrayList<String> outputOrder;
    public Context context;
    public int outputInd;

    public Function(String functionName) {
        this.functionName = functionName;
        this.args = new HashMap<>();
        this.returnType = new HashMap<>();
        this.outputOrder = new ArrayList<>();
        this.context = new Context();
    }
}
