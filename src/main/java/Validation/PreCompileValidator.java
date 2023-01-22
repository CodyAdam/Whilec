package Validation;

import org.antlr.runtime.tree.Tree;
import runner.Main;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PreCompileValidator {

    List<Validator> validators;
    String filepath;

    int errorCount = 0;

    public PreCompileValidator(String filepath, List<Validator> validators) {
        this.filepath = filepath;
        this.validators = validators;
    }

    public PreCompileValidator(String filepath) {
        this.filepath = filepath;
        this.validators = new LinkedList<>();
    }

    public void addValidator(Validator validator) {
        validators.add(validator);
        validator.setParent(this);
    }

    public void validate(Tree tree) throws Exception {
        if(Main.verbose) this.printBanner();

        SymbolsCreator symbols = new SymbolsCreator();

        for (Validator validator : validators) {
            validator.validate(tree, symbols.getFunctionsSymbols(tree));
            if(errorCount>0) break;
        }

        if(Main.verbose || errorCount>0) this.printReportBanner();
        if(errorCount>0) System.exit(1);
    }

    private void printBanner(){
        File file = new File(filepath);
        String message = "### STARTING VALIDATION OF " + file.getName() +" ###";
        String line = String.join("", Collections.nCopies(message.length(), "#"));
        FontDetail font = new FontDetail(Color.CYAN, true, false);
        VPrinter.getInstance().println(line, font);
        VPrinter.getInstance().println(message, font);
        VPrinter.getInstance().println(line+"\n", font);
    }

    private void printReportBanner(){
        String message = "###  VALIDATION REPORT  ###";
        String reportmessage = errorCount + " ERROR(S) FOUND";
        int n = (message.length() - reportmessage.length() - 6);
        String space = String.join("", Collections.nCopies(n/2, " "));
        reportmessage = "###" + space + reportmessage + space + (n%2!=0 ? " " : "") + "###";
        String line = String.join("", Collections.nCopies(message.length(), "#"));
        FontDetail font;
        if(errorCount>0){
            font = new FontDetail(Color.RED, true, false);
        } else {
            font = new FontDetail(Color.GREEN, true, false);
        }
        VPrinter.getInstance().println(line, font);
        VPrinter.getInstance().println(message, font);
        VPrinter.getInstance().println(reportmessage, font);
        VPrinter.getInstance().println(line+"\n", font);
    }

    public String getFilepath() {
        return filepath;
    }

    public void incrementErrorCount(){
        errorCount++;
    }
}
