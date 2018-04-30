package exnihilocreatio.recipes.defaults;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.items.ore.ItemOre;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.registries.registries.OreRegistry;
import exnihilocreatio.registries.registries.SieveRegistry;
import exnihilocreatio.texturing.Color;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import exnihilocreatio.util.Util;
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
    @Nullable
    @ObjectHolder("draconiumingot")
    public static final Item DRACO_INGOT = null;

    @Getter
    public String MODID = "draconicevolution";

    public void registerSieve(SieveRegistry registry) {
        OreRegistry oreRegistry = ExNihiloRegistryManager.ORE_REGISTRY;
        ItemOre ore = oreRegistry.getOreItem("draconium");
        if(ore != null){
            registry.register(new BlockInfo(ModBlocks.endstoneCrushed), new ItemInfo(ore), Util.getDropChance(0.04f), BlockSieve.MeshType.IRON.getID());
            registry.register(new BlockInfo(ModBlocks.netherrackCrushed), new ItemInfo(ore), Util.getDropChance(0.04f), BlockSieve.MeshType.DIAMOND.getID());
        }
    }

    public void registerOreChunks(OreRegistry registry) {
        registry.register("draconium", new Color("C58FF0"), new ItemInfo(DRACO_INGOT));
    }
}
