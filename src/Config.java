
public class Config {

    public static String fileSeparator = System.getProperty("file.separator");

    // répertoires crée par le framework
    public static String[] dirList = {
            "controllers",
            "models",
            "views",
            "js", "css",
            "template",
            "pref" // prameters,routes,api
    };

    // fichiers coeur du framework
    public static String[] fileList = {
            ".htaccess",
            "index.php",
            "pref" + fileSeparator + "parameter.php",
            "pref" + fileSeparator + "routes.php",
            "pref" + fileSeparator + "api.php"
    };

    // template des modeles lors de la création
    public static String modelName = "model_";
    public static String contollerName = "controller_";
    public static String ViewName = "view_";
}
