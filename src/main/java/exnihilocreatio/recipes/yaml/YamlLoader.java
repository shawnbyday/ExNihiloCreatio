package exnihilocreatio.recipes.yaml;

import exnihilocreatio.ExNihiloCreatio;
import exnihilocreatio.recipes.yaml.yamlRecipeClasses.YamlExNihiloRecipes;
import lombok.Getter;
import org.apache.commons.io.IOUtils;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class YamlLoader {
    private static Constructor constructor = new Constructor(YamlExNihiloRecipes.class);
    private static Representer rep = new Representer();
    private static DumperOptions options = new DumperOptions();

    @Getter
    private static Map<String, YamlExNihiloRecipes> recipesToSave = new HashMap<>();

    @Getter
    private static YamlExNihiloRecipes noNameRecipes = new YamlExNihiloRecipes();

    public static String CURRENT_FILE_NAME = null;


    static {
        rep.addClassTag(YamlExNihiloRecipes.class, Tag.MAP);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.AUTO); // TODO: Config option for BLOCK OR AUTO
    }

    public static YamlExNihiloRecipes loadYaml(File file){
        try {
            Yaml yaml = new Yaml(constructor);
            return yaml.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void saveYaml(YamlExNihiloRecipes ex, File file, boolean overwrite){
        Yaml yamlDump = new Yaml(rep, options);
        String output = yamlDump.dump(ex);

        if (!file.exists() || overwrite){
            PrintWriter writer = null;
            try {
                if (file.createNewFile()){
                    writer = new PrintWriter(file);
                    writer.write(output);
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(writer);
            }
        }
    }

    public static void saveToAllYamlFromMap(boolean overwrite){
        for (Map.Entry<String, YamlExNihiloRecipes> entry : recipesToSave.entrySet()) {
            saveYaml(entry.getValue(), new File(ExNihiloCreatio.configDirectory, entry.getKey() + ".yaml"), overwrite);
        }
    }

    public static void registerRecipeToMap(IRegisterRecipe iRegisterRecipe){
        if (CURRENT_FILE_NAME == null){
            iRegisterRecipe.register(noNameRecipes);
        } else {
            YamlExNihiloRecipes ex = recipesToSave.getOrDefault(CURRENT_FILE_NAME, new YamlExNihiloRecipes());
            iRegisterRecipe.register(ex);
            recipesToSave.put(CURRENT_FILE_NAME, ex);
        }

        System.out.println("CURRENT_FILE_NAME = " + CURRENT_FILE_NAME);
    }

    @FunctionalInterface
    public interface IRegisterRecipe {
        void register(YamlExNihiloRecipes ex);
    }
}
