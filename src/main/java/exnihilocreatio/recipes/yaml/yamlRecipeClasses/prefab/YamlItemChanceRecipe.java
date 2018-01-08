package exnihilocreatio.recipes.yaml.yamlRecipeClasses.prefab;

public class YamlItemChanceRecipe extends YamlItemInputRecipe {
    /**
     * Chance for the drops
     */
    public float chance = 0;

    public YamlItemChanceRecipe(String item, float chance) {
        super(item);
        this.chance = chance;
    }
}
