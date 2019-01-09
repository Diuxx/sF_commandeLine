import org.json.simple.JSONObject;

import java.io.*;

/**
 * class Projet
 *
 * @author: Diuxx
 */
public class Projet {
    // nom du projet
    private String name;
    // format de sauvegarde
    private JSONObject obj;
    /**
     * Class constructor
     */
    public Projet(String name) {
        this.obj = new JSONObject();
        this.name = name;

        // json save
        obj.put("name", name);
        System.out.println("new project : " + name);
    }

    /**
     * Class constructor from file
     * @param file
     */
    public Projet(File file) {

    }

    // --
    public boolean build() {

        File dir = new File(this.name);
        if(dir.exists()) {
            System.out.println("Project : " + this.name + " already Exist !");
            return false;
        }
        if(!dir.mkdir())
            return false;

        System.out.println("Base repertorie created successfully");
        if(!save()) {
            System.out.println("Something wrong happened can't create " + this.name + "project");
        }
        System.out.println("configuration created successfully");

        // create all repertories here
        for(String d : Config.dirList) {
            if(!new File(this.name + Config.fileSeparator + d).mkdir())
                return false;

            System.out.println(d + " created");
        }

        // add config files
        for(String f : Config.fileList) {
            File file = new File(this.name + Config.fileSeparator + f);
            try {
                if(file.createNewFile()){
                    System.out.println(this.name + Config.fileSeparator + f + " File Created");
                } else {
                    System.out.println("File " + this.name + Config.fileSeparator + f + " already exists");
                }
            } catch (IOException e) {
                // --
                System.out.println("Unable to create " + this.name + Config.fileSeparator + f);
            }
        }
        return true;
    }

    /**
     * Sauvegarde du projet format json fichiers .sf
     * @return
     */
    public boolean save() {
        // sauvegarde des information du projet
        StringWriter out = new StringWriter();
        String filePath = this.name + "/config.sf";

        PrintWriter writer;
        try {
            obj.writeJSONString(out);
            String jsonText = out.toString();
            System.out.println(jsonText); // debug lines

            File file = new File(filePath);
            if(file.createNewFile()){
                System.out.println(filePath + " File Created");
            } else {
                System.out.println("File " + filePath + " already exists");
            }
            writer = new PrintWriter(filePath, "utf-8");
            writer.println(jsonText);

            writer.close(); // close the writer
        } catch (FileNotFoundException e) {
            System.out.println("File " + filePath + " not found");
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            // do some things

        }
        return true;
    }
}
