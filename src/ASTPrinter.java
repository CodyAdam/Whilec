import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ASTPrinter {

    String UMLResult = "";
    int currentID = 0;

    public ASTPrinter (){
        this.UMLResult = "";
        this.currentID = 0;
    }

    public void save(String fileName) throws IOException {
        if(this.UMLResult.equals("")) return;
        File file = new File("ASTPrinted/"+fileName);
        file.createNewFile();
        FileOutputStream out = new FileOutputStream(file, false);
        out.write(this.UMLResult.getBytes());
        out.close();
    }

    public void printTree(Tree tree){
        this.currentID = 0;
        this.UMLResult = "@startuml\n"+"object \"ROOT\" as "+this.currentID+" #A88\n";

        int parentNode = this.currentID;
        for(int i = 0; i < tree.getChildCount(); i++) {
            printNode(tree.getChild(i), parentNode);
        }

        this.UMLResult += "@enduml";
    }

    private void printNode(Tree node, int parentID){
        this.UMLResult += "object \""+node.getText()+"\" as "+(++this.currentID)+" #A8A\n";
        this.UMLResult += parentID + " -down-> "+this.currentID+"\n";
        int parentNode = this.currentID;
        for(int i = 0; i < node.getChildCount(); i++) {
            printNode(node.getChild(i), parentNode);
        }
    }


}
