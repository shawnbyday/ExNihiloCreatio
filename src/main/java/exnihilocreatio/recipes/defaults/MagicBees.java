package exnihilocreatio.recipes.defaults;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.modules.forestry.ForestryHelper;
import exnihilocreatio.registries.registries.CompostRegistry;
import exnihilocreatio.registries.registries.CrookRegistry;
import exnihilocreatio.texturing.Color;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class MagicBees implements IRecipeDefaults {
    @Getter
    private final String MODID = "magicbees";

    @Override
    public void registerCompost(CompostRegistry registry) {
        registry.register(new ItemInfo("magicbees:propolis:0"), 0.125f, new BlockInfo(Blocks.SLIME_BLOCK), new Color("7B934B"));
        registry.register(new ItemInfo("magicbees:propolis:1"), 0.125f, new BlockInfo(Blocks.SLIME_BLOCK), new Color("7B934B"));
        registry.register(new ItemInfo("magicbees:propolis:2"), 0.25f, new BlockInfo(Blocks.MAGMA), new Color("9B4314"));
        registry.register(new ItemInfo("magicbees:propolis:3"), 0.125f, new BlockInfo(Blocks.SLIME_BLOCK), new Color("7B934B"));
        registry.register(new ItemInfo("magicbees:propolis:4"), 0.25f, new BlockInfo(Blocks.STONE), new Color("ACAfA5"));
        registry.register(new ItemInfo("magicbees:propolis:5"), 0.125f, new BlockInfo(Blocks.SLIME_BLOCK), new Color("7B934B"));
        registry.register(new ItemInfo("magicbees:propolis:6"), 0.125f, new BlockInfo(Blocks.SLIME_BLOCK), new Color("7B934B"));
    }


    @Override
    public void registerCrook(CrookRegistry registry) {
        // Crushed Netherrack for Infernal Bees
        registerCrookBees(registry, ModBlocks.netherrackCrushed, -1, "magicbees.speciesInfernal", .05f, .02f, .01f);
        // Crushed Endstone for Oblivion Bees
        registerCrookBees(registry, ModBlocks.endstoneCrushed, -1, "magicbees.speciesOblivion", .05f, .02f, .01f);
        // Dirt for Unusual Bees
        registerCrookBees(registry, "dirt", "magicbees.speciesUnusual", .05f, .02f, .01f);
        // Grass for Mystical Bees
        registerCrookBees(registry, "grass", "magicbees.speciesMystical", .05f, .02f, .01f);
        // Sand for Sorcerous Bees
        registerCrookBees(registry, "sand", "magicbees.speciesSorcerous", .05f, .02f, .01f);
        // Crushed Andesite for Attuned Bees
        registerCrookBees(registry, ModBlocks.crushedAndesite, -1, "magicbees.speciesAttuned", .05f, .02f, .01f);
    }

    private void registerCrookBees(CrookRegistry registry, String oredict, String species, float drone, float ignoble, float pristine) {
        registry.register(oredict, ForestryHelper.getDroneInfo(species).getItemStack(), drone, drone*2);
        registry.register(oredict, ForestryHelper.getIgnobleInfo(species).getItemStack(), ignoble, ignoble/2);
        registry.register(oredict, ForestryHelper.getPristineInfo(species).getItemStack(), pristine, pristine*2);
    }

    private void registerCrookBees(CrookRegistry registry, Block target, int meta, String species, float drone, float ignoble, float pristine) {
        registry.register(target, meta, ForestryHelper.getDroneInfo(species).getItemStack(), drone, drone*2);
        registry.register(target, meta, ForestryHelper.getIgnobleInfo(species).getItemStack(), ignoble, ignoble/2);
        registry.register(target, meta, ForestryHelper.getPristineInfo(species).getItemStack(), pristine, pristine*2);
    }

}
