/**
 * class Main
 *
 * @author: Diuxx
 */
public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        String[] expArgs = "-p test".split(" ");

        // instance de l'apli
        Simple sf = new Simple(expArgs); // --
        sf.run();// new Simple(expArgs).run();
    }
}
/**
 * commandes :
 * sf -p myPage // création d'un nouveau projet web
 * - create config file with all information (json)
 * - add all repertory
 * - add all configuration files
 *
 */
