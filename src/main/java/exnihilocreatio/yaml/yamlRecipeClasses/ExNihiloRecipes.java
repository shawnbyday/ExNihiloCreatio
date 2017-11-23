package exnihilocreatio.yaml.yamlRecipeClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExNihiloRecipes {
    /**
     * Sieve:
     *      mod:block:meta: (or maaaabye later 'ore:orename')
     *          meshlevel: (string, flint, iron, diamond)
     *              - item: mod:item:meta
     *                chance: floatChance
     *              - item: mod:item:meta
     *                chance: floatChance
     */
    public Map<String, Map<String, List<YamlSieveRecipe>>> Sieve = new HashMap<>();

    /**
     * Crook:
     *      mod:block:meta: (or maaaabye later 'ore:orename')
     *          - item: mod:item:meta
     *            chance: floatChance (maybe with > 100% drop chance?)
     *            fortuneChance: floatChance
     */
    public Map<String, List<YamlCrookRecipe>> Crook = new HashMap<>();

    /**
     * Compost:
     *      mod:block:meta: (output block)
     *          - item: mod:item:meta
     *            chance: floatChance (maybe with > 100% drop chance?)
     *            fortuneChance: floatChance
     */
    public Map<String, List<YamlCompostRecipe>> Compost = new HashMap<>();

    public List<String> BarrelBlacklistStone = new ArrayList<>();

    public List<String> BarrelBlacklistWood = new ArrayList<>();


    public void addRecipeToSieve(String blockName, String dropName, int meta, int meshLevel, float chance){
        /*Map<String, List<HashMap<String, Object>>> blockMap = Sieve.getOrDefault(blockName, new HashMap<>());

        blockMap.getOrDefault()*/
    }

    @Override
    public String toString() {
        return "ExNihiloRecipes{" +
                "Sieve=" + Sieve +
                ", Crook=" + Crook +
                ", Compost=" + Compost +
                '}';
    }
}
