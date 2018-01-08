package exnihilocreatio.recipes.yaml;

import exnihilocreatio.recipes.yaml.yamlRecipeClasses.ExNihiloRecipes;
import lombok.Getter;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class YamlLoader {
    private static Constructor constructor = new Constructor(ExNihiloRecipes.class);
    private static Representer rep = new Representer();
    private static DumperOptions options = new DumperOptions();

    @Getter
    private static Map<String, ExNihiloRecipes> recipesToSave = new HashMap<>();

    @Getter
    private static ExNihiloRecipes noNameRecipes = new ExNihiloRecipes();

    public static String CURRENT_FILE_NAME = null;


    static {
        rep.addClassTag(ExNihiloRecipes.class, Tag.MAP);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.AUTO); // TODO: Config option for BLOCK OR AUTO
    }

    public static ExNihiloRecipes loadYaml(File file){
        try {
            Yaml yaml = new Yaml(constructor);
            return yaml.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void saveYaml(ExNihiloRecipes ex, File file, boolean overwrite){
        Yaml yamlDump = new Yaml(rep, options);
        String output = yamlDump.dump(ex);

        if (!file.exists() || overwrite){
            try {
                if (file.createNewFile()){
                    PrintWriter writer = new PrintWriter(file);
                    writer.write(output);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void registerRecipeToMap(IRegisterRecipe iRegisterRecipe){
        if (CURRENT_FILE_NAME == null){
            iRegisterRecipe.register(noNameRecipes);
        } else {
            ExNihiloRecipes ex = recipesToSave.getOrDefault(CURRENT_FILE_NAME, new ExNihiloRecipes());
            iRegisterRecipe.register(ex);
            recipesToSave.put(CURRENT_FILE_NAME, ex);
        }

        System.out.println("CURRENT_FILE_NAME = " + CURRENT_FILE_NAME);
    }

    @FunctionalInterface
    public interface IRegisterRecipe{
        void register(ExNihiloRecipes ex);
    }
}
