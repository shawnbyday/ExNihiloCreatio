package exnihilocreatio.recipes.yaml.yamlRecipeClasses.prefab;

public class YamlItemInputRecipe {
    /**
     * String:meta
     */
    public String item;

    public String getItemName(){
        return "___";
    }

    public int getItemMeta(){
        return -1;
    }

    public YamlItemInputRecipe(String item) {
        this.item = item;
    }
}
