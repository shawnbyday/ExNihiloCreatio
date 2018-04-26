package exnihilocreatio.recipes.defaults;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.ModFluids;
import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.registries.registries.BurnOutRegistry;
import exnihilocreatio.registries.registries.FluidOnTopRegistry;
import exnihilocreatio.registries.registries.SieveRegistry;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import lombok.Getter;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@SuppressWarnings("ConstantConditions")
public class EnderIO implements IRecipeDefaults {
    @GameRegistry.ObjectHolder("enderio:item_material")
    // 20 = Grains of Infinity/Bedrock Dust
    public static final Item EIO_DUST_BEDROCK = null;
    @Getter
    public final String MODID = "enderio";

    public void registerSieve(SieveRegistry registry) {
        if (EIO_DUST_BEDROCK != null){
            registry.register("dust", new ItemInfo(EIO_DUST_BEDROCK, 20), 0.01f, BlockSieve.MeshType.DIAMOND.getID());
        }
    }

    public void registerBurnOut(BurnOutRegistry registry) {
        registry.register(new BlockInfo(ModBlocks.pseudoBedrock), new ItemInfo(EIO_DUST_BEDROCK, 20), 0.5f);
    }

    public void registerFluidOnTop(FluidOnTopRegistry registry) {
        registry.register(FluidRegistry.LAVA, ModFluids.fluidWitchwater, new BlockInfo(ModBlocks.pseudoBedrock.getDefaultState()));
    }
}
