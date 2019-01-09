import java.util.Scanner;
/**
 * class Simple
 *
 * @author: Diuxx
 */
public class Simple {

    private String[] args;

    /**
     * Class constructor
     * @param args
     */
    public Simple(String[] args) {
        // --
        this.args = args;
    }

    public void run() {
        System.out.println("Simple framework is running");
        System.out.println("arguments : " + showArgs());

        for(int i=0, j=0; i<args.length || j==1; i++)
        {
            switch(args[i]) {
                case "-p": // création d'un projet
                    try {
                        // création du projet
                        Projet p = new Projet(args[i + 1]);
                        p.build();
                        i++;
                    } catch(ArrayIndexOutOfBoundsException e) {
                        System.out.println("Project File Not Found");
                        j++;// condition de sortie
                    }
                    break;
                default:
                    System.out.println("Erreur d'argument !");
            }
        }
    }

    /**
     * affichage des arguments de la commande
     * @return
     */
    public String showArgs()  {
        String line = "";
        for(String w : args) {
            line += w + " ";
        }
        return line;
    }
}
