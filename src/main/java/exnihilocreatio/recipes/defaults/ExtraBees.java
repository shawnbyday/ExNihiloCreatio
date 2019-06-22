package exnihilocreatio.recipes.defaults;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.modules.forestry.ForestryHelper;
import exnihilocreatio.registries.registries.CrookRegistry;
import exnihilocreatio.util.BlockInfo;
import lombok.Getter;
import net.minecraft.init.Blocks;

public class ExtraBees implements IRecipeDefaults {
    @Getter
    private final String MODID = "extrabees";

    @Override
    public void registerCrook(CrookRegistry registry) {
        /*
         BEEEEEEEEEES
         */
        // All Leaves for Forest Bees
        registry.register("cobblestone", ForestryHelper.getDroneInfo("extrabees.species.rock").getItemStack(), 0.1f, 0.2f);
        registry.register("cobblestone", ForestryHelper.getIgnobleInfo("extrabees.species.rock").getItemStack(), 0.05f, 0.02f);
        registry.register("cobblestone", ForestryHelper.getPristineInfo("extrabees.species.rock").getItemStack(), 0.01f, 0.01f);
        // Crushed Diorite for Marbled Bees
        registry.register(new BlockInfo(ModBlocks.crushedDiorite), ForestryHelper.getDroneInfo("extrabees.species.marble").getItemStack(), 0.05f, 0.5f);
        registry.register(new BlockInfo(ModBlocks.crushedDiorite), ForestryHelper.getIgnobleInfo("extrabees.species.marble").getItemStack(), 0.05f, 0.01f);
        registry.register(new BlockInfo(ModBlocks.crushedDiorite), ForestryHelper.getPristineInfo("extrabees.species.marble").getItemStack(), 0.01f, 0.05f);
        // Crushed Netherrack for Embittered Bees
        registry.register(new BlockInfo(ModBlocks.netherrackCrushed), ForestryHelper.getDroneInfo("extrabees.species.basalt").getItemStack(), 0.05f, 0.5f);
        registry.register(new BlockInfo(ModBlocks.netherrackCrushed), ForestryHelper.getIgnobleInfo("extrabees.species.basalt").getItemStack(), 0.05f, 0.01f);
        registry.register(new BlockInfo(ModBlocks.netherrackCrushed), ForestryHelper.getPristineInfo("extrabees.species.basalt").getItemStack(), 0.01f, 0.05f);
        // Clay for Water Bees --- clearly the most balanced of bees
        registry.register(new BlockInfo(Blocks.CLAY), ForestryHelper.getDroneInfo("extrabees.species.water").getItemStack(), 0.05f, 0.5f);
        registry.register(new BlockInfo(Blocks.CLAY), ForestryHelper.getIgnobleInfo("extrabees.species.water").getItemStack(), 0.05f, 0.01f);
        registry.register(new BlockInfo(Blocks.CLAY), ForestryHelper.getPristineInfo("extrabees.species.water").getItemStack(), 0.01f, 0.05f);
    }

}
