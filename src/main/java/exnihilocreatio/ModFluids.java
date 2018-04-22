package exnihilocreatio;

import exnihilocreatio.blocks.BlockFluidMilk;
import exnihilocreatio.blocks.BlockFluidWitchwater;
import exnihilocreatio.fluid.FluidMilk;
import exnihilocreatio.fluid.FluidWitchWater;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModFluids {

    public static final FluidWitchWater fluidWitchwater = new FluidWitchWater();
    public static BlockFluidWitchwater blockWitchwater = new BlockFluidWitchwater();

    public static FluidMilk fluidMilk;
    public static BlockFluidMilk blockMilk;

    public static void init() {
        FluidRegistry.addBucketForFluid(fluidWitchwater);

        // Milk
        fluidMilk = new FluidMilk();
        blockMilk = new BlockFluidMilk();
        FluidRegistry.addBucketForFluid(fluidMilk);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        fluidWitchwater.initModel();
        fluidMilk.initModel();
    }
}
