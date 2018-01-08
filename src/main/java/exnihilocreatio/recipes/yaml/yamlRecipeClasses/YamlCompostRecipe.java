package exnihilocreatio.recipes.yaml.yamlRecipeClasses;

import exnihilocreatio.recipes.yaml.yamlRecipeClasses.prefab.YamlItemInputRecipe;

public class YamlCompostRecipe extends YamlItemInputRecipe {
    float value;
    String color;

    public YamlCompostRecipe(String item, float value, String color) {
        super(item);
        this.value = value;
        this.color = color;
    }
}
