package exnihilocreatio.yaml

import exnihilocreatio.yaml.yamlRecipeClasses.ExNihiloRecipes
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import org.yaml.snakeyaml.nodes.Tag
import org.yaml.snakeyaml.representer.Representer

class TestClassYAML {
    static void main(String[] args){
        testLoad()
    }

    static void testLoad(){
        def con = new Constructor(ExNihiloRecipes.class)

        Yaml yaml = new Yaml(con)
        def f = new File("src\\yaml\\testYaml.yaml")
        ExNihiloRecipes ex = yaml.load(new FileInputStream(f))
        System.out.println("ex.toString() = " + ex.toString())

        def rep = new Representer()
        rep.addClassTag(ExNihiloRecipes.class, Tag.MAP)
        DumperOptions options = new DumperOptions()
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.AUTO) // TODO: Config option for BLOCK OR AUTO

        Yaml yamlDump = new Yaml(rep, options)
        String output = yamlDump.dump(ex)
        System.out.println(output)

    }
}
