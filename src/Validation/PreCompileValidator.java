package Validation;

import org.antlr.runtime.tree.CommonTree;

import java.util.LinkedList;
import java.util.List;

public class PreCompileValidator {

    List<Validator> validators;

    public PreCompileValidator(List<Validator> validators) {
        this.validators = validators;
    }

    public PreCompileValidator(){
        this.validators = new LinkedList<>();
    }

    public void addValidator(Validator validator){
        validators.add(validator);
    }

    public void validate(CommonTree tree){
        for (Validator validator : validators) {
            validator.validate(tree);
        }
    }

}
