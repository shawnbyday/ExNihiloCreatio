package exnihilocreatio.recipes.defaults;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.registries.registries.OreRegistry;
import exnihilocreatio.registries.registries.SieveRegistry;
import exnihilocreatio.texturing.Color;
import exnihilocreatio.util.ItemInfo;
import lombok.Getter;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import javax.annotation.Nullable;

@ObjectHolder("draconicevolution")
public class DraconicEvolution implements IRecipeDefaults {
    //C58FF0
    @Nullable
    @ObjectHolder("draconium_dust")
    public static final Item DRACO_DUST = null;

    @Getter
    public String MODID = "draconicevolution";

    public void registerSieve(SieveRegistry registry) {
        registry.register(ModBlocks.endstoneCrushed, 0, new ItemInfo("exnihilocreatio:item_ore_draconium:0"), 0.04f, BlockSieve.MeshType.IRON.getID());
        registry.register(ModBlocks.netherrackCrushed, 0, new ItemInfo("exnihilocreatio:item_ore_draconium:0"), 0.08f, BlockSieve.MeshType.DIAMOND.getID());
    }

    public void registerOreChunks(OreRegistry registry) {
        registry.register("draconium", new Color("C58FF0"), new ItemInfo("draconicevolution:draconiumingot"));
    }
}
