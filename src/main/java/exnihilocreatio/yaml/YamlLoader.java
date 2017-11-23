package exnihilocreatio.yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class YamlLoader {
    private Yaml yaml = new Yaml();

    public void loadYaml(File file){
        try {
            Object object = yaml.load(new FileInputStream(file));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
