package exnihilocreatio.recipes.yaml.yamlRecipeClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YamlExNihiloRecipes {
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

    /**
     * BarrelBlacklistStone:
     *  - bla
     *  - bla
     *  - blub
     */
    public List<String> BarrelBlacklistStone = new ArrayList<>();

    /**
     * BarrelBlacklistWood:
     *  - bla
     *  - bla
     *  - blub
     */
    public List<String> BarrelBlacklistWood = new ArrayList<>();

    /**
     * StoneCrucible:
     *   lava:
     *   - item: minecraft:cobblestone:0
     *     displayOverwrite: minecraft:dirt         (optional)(display overwrite should match with the rest of the group or it might cause some strange effects)
     *     itemGroup: stone                         (optional)
     *     amount: 90
     *   - item: arg
     *     amount: 3443
     */
    public Map<String, List<YamlCrucibleRecipe>> StoneCrucible = new HashMap<>();

    /**
     * Same as stone
     */
    public Map<String, List<YamlCrucibleRecipe>> WoodCrucible = new HashMap<>();

    /**
     * OreRegistry:
     * - name: osmium
     *   color: B4BED4
     *   result: mekanism:ingot:1
     *   displayname: Opposmium                             (optional)
     *   oredict: Oppo      (... leads to dustOppo, etc)    (optional)
     *
     */
    public List<YamlOreRegistryRecipe> OreRegistry = new ArrayList<>();

    /**
     * Heat:
     *   minecraft:flowing_lava: 3         (no '   -   ' on the new lines)
     *   minecraft:lava: 3.3
     *   minecraft:fire: 4
     *   minecraft:torch: 1
     */
    public HashMap<String, Double> Heat = new HashMap<>();

    /**
     * Hammer:
     *   minecraft:gravel:0:
     *   - item: minecraft:sand:2
     *     chance: 2.3
     *     miningLevel: 2
     *     fortuneChance: 2.6
     *   - item: minecraft:sand:4
     *     chance: 2.1
     *     miningLevel: 5
     *     fortuneChance: 2.6
     */
    public HashMap<String, List<YamlHammerRecipe>> Hammer = new HashMap<>();

    @Override
    public String toString() {
        return "YamlExNihiloRecipes{" +
                "Sieve=" + Sieve +
                ", Crook=" + Crook +
                ", Compost=" + Compost +
                '}';
    }
}


/* TODO:
FluidBlockTransformerRegistry
FluidItemFluidRegistry
FluidOnTopRegistry
FluidTransformRegistry
MilkEntityRegistry
 */