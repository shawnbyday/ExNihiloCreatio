package exnihilocreatio.registries.manager;

import exnihilocreatio.recipes.defaults.*;
import exnihilocreatio.registries.registries.*;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;
import java.util.List;

import static exnihilocreatio.recipes.yaml.YamlLoader.CURRENT_FILE_NAME;

public class CompatDefaultRecipes {
    private static List<IRecipeDefaults> MODS = new ArrayList<>();
    static {
        // TODO use config options to dynamically add mod support
        // TODO consider making the default Ex Nihilo recipes use this same programatic method.
        MODS.add(new ExNihilo()); // Not exactly a "cross" mod support ¯\_(ツ)_/¯
        MODS.add(new TinkersConstruct());
        MODS.add(new AppliedEnergistics2());
        MODS.add(new IntegratedDynamics());
        MODS.add(new Mekanism());
        MODS.add(new BigReactors());
        MODS.add(new ActuallyAdditions());
    }

    public void registerCompost(CompostRegistry registry) {
        genericRegister(mod -> mod.registerCompost(registry));

        /*for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerCompost(registry);
            }
        }*/
    }

    public void registerCrook(CrookRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerCrook(registry);
            }
        }
    }

    public void registerSieve(SieveRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerSieve(registry);
            }
        }
    }

    public void registerHammer(HammerRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerHammer(registry);
            }
        }
    }

    public void registerHeat(HeatRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerHeat(registry);
            }
        }
    }

    public void registerBarrel(BarrelLiquidBlacklistRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerBarrelLiquidBlacklist(registry);
            }
        }
    }

    public void registerFluidOnTop(FluidOnTopRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerFluidOnTop(registry);
            }
        }
    }

    public void registerOreChunks(OreRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerOreChunks(registry);
            }
        }
    }

    public void registerFluidTransform(FluidTransformRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerFluidTransform(registry);
            }
        }
    }

    public void registerFluidBlockTransform(FluidBlockTransformerRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerFluidBlockTransform(registry);
            }
        }
    }

    public void registerFluidItemFluid(FluidItemFluidRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerFluidItemFluid(registry);
            }
        }
    }

    public void registerCrucibleStone(CrucibleRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerCrucibleStone(registry);
            }
        }
    }

    public void registerCrucibleWood(CrucibleRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerCrucibleWood(registry);
            }
        }

    }

    public void registerMilk(MilkEntityRegistry registry) {
        for(IRecipeDefaults mod : MODS){
            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                mod.registerMilk(registry);
            }
        }
    }

    /**
     * Helper function to not have too much duplicate code
     */
    private void genericRegister(IGenericRegister genericRegister){
        for(IRecipeDefaults mod : MODS){
            CURRENT_FILE_NAME = mod.getFileName();
            if (CURRENT_FILE_NAME == null) CURRENT_FILE_NAME = mod.getMODID();

            if(mod.getMODID() == null || Loader.isModLoaded(mod.getMODID())){
                genericRegister.registerGeneric(mod);
            }

            CURRENT_FILE_NAME = null;
        }
    }

    private interface IGenericRegister {
        void registerGeneric(IRecipeDefaults mod);
    }
}
