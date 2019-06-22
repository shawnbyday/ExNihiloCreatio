package exnihilocreatio.recipes.defaults;

import exnihilocreatio.modules.forestry.ForestryHelper;
import exnihilocreatio.registries.registries.CrookRegistry;
import lombok.Getter;

public class MoreBees implements IRecipeDefaults {
    @Getter
    private final String MODID = "morebees";

    @Override
    public void registerCrook(CrookRegistry registry) {
        // All Leaves for Forest Bees
        registry.register("cobblestone", ForestryHelper.getDroneInfo("morebees.species.rock").getItemStack(), 0.1f, 0.2f);
        registry.register("cobblestone", ForestryHelper.getIgnobleInfo("morebees.species.rock").getItemStack(), 0.05f, 0.02f);
        registry.register("cobblestone", ForestryHelper.getPristineInfo("morebees.species.rock").getItemStack(), 0.01f, 0.01f);
    }

}
