package exnihilocreatio.recipes.yaml.yamlRecipeClasses;

import exnihilocreatio.recipes.yaml.yamlRecipeClasses.prefab.YamlItemInputRecipe;

public class YamlCrucibleRecipe extends YamlItemInputRecipe{
    public int amount;
    public String displayOverwrite;
    public String itemGroup;

    public YamlCrucibleRecipe(String item) {
        super(item);
    }
}
