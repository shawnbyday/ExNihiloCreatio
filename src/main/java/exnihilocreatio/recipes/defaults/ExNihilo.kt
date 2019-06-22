package exnihilocreatio.recipes.defaults

import exnihilocreatio.ExNihiloCreatio
import exnihilocreatio.ModBlocks
import exnihilocreatio.ModFluids
import exnihilocreatio.ModItems
import exnihilocreatio.api.registries.IOreRegistry
import exnihilocreatio.blocks.BlockSieve
import exnihilocreatio.config.ModConfig
import exnihilocreatio.items.ItemResource
import exnihilocreatio.registries.manager.ExNihiloRegistryManager
import exnihilocreatio.registries.registries.*
import exnihilocreatio.registries.types.Meltable
import exnihilocreatio.registries.types.WitchWaterWorld
import exnihilocreatio.texturing.Color
import exnihilocreatio.util.BlockInfo
import exnihilocreatio.util.ItemInfo
import exnihilocreatio.util.OreDictUtil
import exnihilocreatio.util.Util
import net.minecraft.block.Block
import net.minecraft.block.BlockLeaves
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.oredict.OreDictionary
import java.util.*

object ExNihilo: IRecipeDefaults {
    override fun getMODID() = ExNihiloCreatio.MODID
    override fun registerCompost(registry: CompostRegistry) {
        val dirtState = BlockInfo(Blocks.DIRT)

        registry.register("treeSapling", 0.125f, dirtState)
        registry.register("treeLeaves", 0.125f, dirtState)
        registry.register("flower", 0.1f, dirtState)
        registry.register("fish", 0.15f, dirtState)
        registry.register("listAllmeatcooked", 0.20f, dirtState)

        registry.register(ItemInfo(Items.ROTTEN_FLESH), 0.1f, dirtState, Color("C45631"))

        registry.register(ItemInfo(Items.SPIDER_EYE), 0.08f, dirtState, Color("963E44"))

        registry.register(ItemInfo(Items.WHEAT), 0.08f, dirtState, Color("E3E162"))
        registry.register(ItemInfo(Items.WHEAT_SEEDS), 0.08f, dirtState, Color("35A82A"))
        registry.register(ItemInfo(Items.BREAD), 0.16f, dirtState, Color("D1AF60"))

        registry.register(BlockInfo(Blocks.BROWN_MUSHROOM), 0.10f, dirtState, Color("CFBFB6"))
        registry.register(BlockInfo(Blocks.RED_MUSHROOM), 0.10f, dirtState, Color("D6A8A5"))

        registry.register(ItemInfo(Items.PUMPKIN_PIE), 0.16f, dirtState, Color("E39A6D"))

        registry.register(ItemInfo(Items.PORKCHOP), 0.2f, dirtState, Color("FFA091"))
        registry.register(ItemInfo(Items.BEEF), 0.2f, dirtState, Color("FF4242"))
        registry.register(ItemInfo(Items.CHICKEN), 0.2f, dirtState, Color("FFE8E8"))

        registry.register(ItemInfo(ModItems.resources, ItemResource.getMetaFromName(ItemResource.SILKWORM)), 0.04f, dirtState, Color("ff9966"))
        registry.register(ItemInfo(ModItems.cookedSilkworm), 0.04f, dirtState, Color("cc6600"))

        registry.register(ItemInfo(Items.APPLE), 0.10f, dirtState, Color("FFF68F"))
        registry.register(ItemInfo(Items.MELON), 0.04f, dirtState, Color("FF443B"))
        registry.register(BlockInfo(Blocks.MELON_BLOCK), 1.0f / 6, dirtState, Color("FF443B"))
        registry.register(BlockInfo(Blocks.PUMPKIN), 1.0f / 6, dirtState, Color("FFDB66"))
        registry.register(BlockInfo(Blocks.LIT_PUMPKIN), 1.0f / 6, dirtState, Color("FFDB66"))

        registry.register(BlockInfo(Blocks.CACTUS), 0.10f, dirtState, Color("DEFFB5"))

        registry.register(ItemInfo(Items.CARROT), 0.10f, dirtState, Color("FF9B0F"))
        registry.register(ItemInfo(Items.BEETROOT), 0.10f, dirtState, Color("FF5555"))
        registry.register(ItemInfo(Items.POTATO), 0.10f, dirtState, Color("FFF1B5"))
        registry.register(ItemInfo(Items.BAKED_POTATO), 0.15f, dirtState, Color("FFF1B5"))
        registry.register(ItemInfo(Items.POISONOUS_POTATO), 0.20f, dirtState, Color("E0FF8A"))

        registry.register(BlockInfo(Blocks.WATERLILY.defaultState), 0.10f, dirtState, Color("269900"))
        registry.register(BlockInfo(Blocks.VINE.defaultState), 0.10f, dirtState, Color("23630E"))
        registry.register(BlockInfo(Blocks.TALLGRASS, 1), 0.08f, dirtState, Color("23630E"))
        registry.register(ItemInfo(Items.EGG), 0.08f, dirtState, Color("FFFA66"))
        registry.register(ItemInfo(Items.NETHER_WART), 0.10f, dirtState, Color("FF2B52"))
        registry.register(ItemInfo(Items.REEDS), 0.08f, dirtState, Color("9BFF8A"))
        registry.register(ItemInfo(Items.STRING), 0.04f, dirtState, Util.whiteColor)

        //Register any missed items
        registry.register("listAllfruit", 0.10f, dirtState, Color("35A82A"))
        registry.register("listAllveggie", 0.10f, dirtState, Color("FFF1B5"))
        registry.register("listAllGrain", 0.08f, dirtState, Color("E3E162"))
        registry.register("listAllseed", 0.08f, dirtState, Color("35A82A"))
        registry.register("listAllmeatraw", 0.15f, dirtState, Color("FFA091"))

        // Misc. Modded Items
        registry.register("dustAsh", 0.125f, dirtState, Color("C0C0C0"))
    }


    override fun registerCrook(registry: CrookRegistry) {
        registry.register("treeLeaves", ItemResource.getResourceStack(ItemResource.SILKWORM), 0.1f, 0f)
    }

    override fun registerSieve(registry: SieveRegistry) {

        val crushedNetherrack = BlockInfo(ModBlocks.netherrackCrushed)
        val crushedEndStone = BlockInfo(ModBlocks.endstoneCrushed)
        val crushedAndesite = BlockInfo(ModBlocks.crushedAndesite)
        val crushedDiorite = BlockInfo(ModBlocks.crushedDiorite)
        val crushedGranite = BlockInfo(ModBlocks.crushedGranite)
        val soulSand = BlockInfo(Blocks.SOUL_SAND)

        //Stone Pebble
        registry.register("dirt", ItemInfo(ModItems.pebbles), getDropChance(1f), BlockSieve.MeshType.STRING.id)
        registry.register("dirt", ItemInfo(ModItems.pebbles), getDropChance(1f), BlockSieve.MeshType.STRING.id)
        registry.register("dirt", ItemInfo(ModItems.pebbles), getDropChance(0.5f), BlockSieve.MeshType.STRING.id)
        registry.register("dirt", ItemInfo(ModItems.pebbles), getDropChance(0.5f), BlockSieve.MeshType.STRING.id)
        registry.register("dirt", ItemInfo(ModItems.pebbles), getDropChance(0.1f), BlockSieve.MeshType.STRING.id)
        registry.register("dirt", ItemInfo(ModItems.pebbles), getDropChance(0.1f), BlockSieve.MeshType.STRING.id)

        //Granite Pebble
        registry.register("dirt", ItemInfo(ModItems.pebbles, 1), getDropChance(0.5f), BlockSieve.MeshType.STRING.id)
        registry.register("dirt", ItemInfo(ModItems.pebbles, 1), getDropChance(0.1f), BlockSieve.MeshType.STRING.id)

        //Diorite Pebble
        registry.register("dirt", ItemInfo(ModItems.pebbles, 2), getDropChance(0.5f), BlockSieve.MeshType.STRING.id)
        registry.register("dirt", ItemInfo(ModItems.pebbles, 2), getDropChance(0.1f), BlockSieve.MeshType.STRING.id)

        //Andesite Pebble
        registry.register("dirt", ItemInfo(ModItems.pebbles, 3), getDropChance(0.5f), BlockSieve.MeshType.STRING.id)
        registry.register("dirt", ItemInfo(ModItems.pebbles, 3), getDropChance(0.1f), BlockSieve.MeshType.STRING.id)

        registry.register("dirt", ItemInfo(Items.WHEAT_SEEDS), getDropChance(0.7f), BlockSieve.MeshType.STRING.id)
        registry.register("dirt", ItemInfo(Items.MELON_SEEDS), getDropChance(0.35f), BlockSieve.MeshType.STRING.id)
        registry.register("dirt", ItemInfo(Items.PUMPKIN_SEEDS), getDropChance(0.35f), BlockSieve.MeshType.STRING.id)

        //Ancient Spores
        registry.register("dirt", ItemInfo(ModItems.resources, 3), getDropChance(0.05f), BlockSieve.MeshType.STRING.id)
        //Grass Seeds
        registry.register("dirt", ItemInfo(ModItems.resources, 4), getDropChance(0.05f), BlockSieve.MeshType.STRING.id)


        registry.register("sand", ItemInfo(Items.DYE, 3), getDropChance(0.03f), BlockSieve.MeshType.STRING.id)
        registry.register("sand", ItemInfo(Items.PRISMARINE_SHARD), getDropChance(0.02f), BlockSieve.MeshType.DIAMOND.id)

        // There needs to be a way to get flint without a flint mesh
        registry.register("gravel", ItemInfo(Items.FLINT), getDropChance(0.25f), BlockSieve.MeshType.STRING.id)
        registry.register("gravel", ItemInfo(Items.FLINT), getDropChance(0.25f), BlockSieve.MeshType.FLINT.id)
        registry.register("gravel", ItemInfo(Items.COAL), getDropChance(0.125f), BlockSieve.MeshType.FLINT.id)
        registry.register("gravel", ItemInfo(Items.DYE, 4), getDropChance(0.05f), BlockSieve.MeshType.FLINT.id)

        registry.register("gravel", ItemInfo(Items.DIAMOND), getDropChance(0.008f), BlockSieve.MeshType.IRON.id)
        registry.register("gravel", ItemInfo(Items.EMERALD), getDropChance(0.008f), BlockSieve.MeshType.IRON.id)

        registry.register("gravel", ItemInfo(Items.DIAMOND), getDropChance(0.016f), BlockSieve.MeshType.DIAMOND.id)
        registry.register("gravel", ItemInfo(Items.EMERALD), getDropChance(0.016f), BlockSieve.MeshType.DIAMOND.id)


        registry.register(soulSand, ItemInfo(Items.QUARTZ), getDropChance(1f), BlockSieve.MeshType.FLINT.id)
        registry.register(soulSand, ItemInfo(Items.QUARTZ), getDropChance(0.33f), BlockSieve.MeshType.FLINT.id)

        registry.register(soulSand, ItemInfo(Items.NETHER_WART), getDropChance(0.1f), BlockSieve.MeshType.STRING.id)

        registry.register(soulSand, ItemInfo(Items.GHAST_TEAR), getDropChance(0.02f), BlockSieve.MeshType.DIAMOND.id)
        registry.register(soulSand, ItemInfo(Items.QUARTZ), getDropChance(1f), BlockSieve.MeshType.DIAMOND.id)
        registry.register(soulSand, ItemInfo(Items.QUARTZ), getDropChance(0.8f), BlockSieve.MeshType.DIAMOND.id)

        registry.register("dust", ItemInfo(Items.DYE, 15), getDropChance(0.2f), BlockSieve.MeshType.STRING.id)
        registry.register("dust", ItemInfo(Items.GUNPOWDER), getDropChance(0.07f), BlockSieve.MeshType.STRING.id)

        registry.register("dust", ItemInfo(Items.REDSTONE), getDropChance(0.125f), BlockSieve.MeshType.IRON.id)
        registry.register("dust", ItemInfo(Items.REDSTONE), getDropChance(0.25f), BlockSieve.MeshType.DIAMOND.id)

        registry.register("dust", ItemInfo(Items.GLOWSTONE_DUST), getDropChance(0.0625f), BlockSieve.MeshType.IRON.id)
        registry.register("dust", ItemInfo(Items.BLAZE_POWDER), getDropChance(0.05f), BlockSieve.MeshType.IRON.id)

        // Custom Ores for other mods
        val oreRegistry: IOreRegistry = ExNihiloRegistryManager.ORE_REGISTRY

        // All default Ores
        for (ore in oreRegistry.itemOreRegistry) {
            if (oreRegistry.sieveBlackList.contains(ore)) continue
            val info = ItemInfo(ore)
            when (ore.ore.name) {
                "gold" -> {
                    multiMeshRegister(registry, "gravel", info, null, 0.25f, 0.25f, 0.4f)
                    multiMeshRegister(registry, crushedNetherrack, info, null, 0.05f, 0.075f, 0.15f)
                }
                "iron" -> {
                    multiMeshRegister(registry, "gravel", info, null, 0.1f, 0.15f, 0.25f)
                    registry.register(BlockInfo(Blocks.SAND, 1), info, getDropChance(0.5f), BlockSieve.MeshType.DIAMOND.id)
                }
                "aluminum", "aluminium" -> {
                    multiMeshRegister(registry, "sand", info, null, 0.05f, 0.075f, null)
                    multiMeshRegister(registry, crushedEndStone, info, null, null, 0.15f, 0.25f)
                }
                "copper" ->
                    multiMeshRegister(registry, "gravel", info, null, 0.05f, 0.075f, null)
                "silver" -> {
                    registry.register("sand", info, getDropChance(0.15f), BlockSieve.MeshType.DIAMOND.id)
                    multiMeshRegister(registry, crushedEndStone, info, null, null, 0.15f, 0.25f)
                }
                "tin" ->
                    multiMeshRegister(registry, "sand", info, null, 0.05f, 0.075f, null)
                "uranium" ->
                    multiMeshRegister(registry, "gravel", info, null, null, 0.05f, 0.10f)
                "zinc" ->
                    multiMeshRegister(registry, "sand", info, 0.05f, 0.075f, 0.075f, 0.15f)
                "tungsten" ->
                    multiMeshRegister(registry, crushedNetherrack, info, null, null, 0.075f, 0.15f)
                else -> {
                    val hash = (ore.ore.name).hashCode() % 4
                    when(hash) {
                        0 -> multiMeshRegister(registry, crushedDiorite, info, null, 0.05f, 0.075f, 0.15f)
                        1 -> multiMeshRegister(registry, crushedAndesite, info, null, 0.05f, 0.075f, 0.15f)
                        2 -> multiMeshRegister(registry, crushedGranite, info, null, 0.05f, 0.075f, 0.15f)
                        else -> multiMeshRegister(registry, "gravel", info, null, 0.05f, 0.075f, 0.15f)
                    }
                }
            }
        }
        // Seeds
        for (seed in ModItems.itemSeeds) {
            registry.register("dirt", ItemInfo(seed), getDropChance(0.05f), BlockSieve.MeshType.STRING.id)
        }

        if (Item.REGISTRY.containsKey(ModItems.rubberSeed.registryName!!))
            multiMeshRegister(registry, "dirt", ItemInfo(ModItems.rubberSeed), null, 0.05f, 0.05f, 0.05f)

        getLeavesSapling().forEach { leaves, sapling ->
            val blockLeaves = Block.getBlockFromItem(leaves.itemStack.item) as BlockLeaves
            val chance = blockLeaves.getSaplingDropChance(blockLeaves.defaultState) / 100f

            registry.register(leaves, sapling, Math.min(chance * 1, 1.0f), BlockSieve.MeshType.STRING.id)
            registry.register(leaves, sapling, Math.min(chance * 2, 1.0f), BlockSieve.MeshType.FLINT.id)
            registry.register(leaves, sapling, Math.min(chance * 3, 1.0f), BlockSieve.MeshType.IRON.id)
            registry.register(leaves, sapling, Math.min(chance * 4, 1.0f), BlockSieve.MeshType.DIAMOND.id)

            //Apple
            multiMeshRegister(registry, leaves, ItemInfo(Items.APPLE), 0.05f, 0.10f, 0.15f, 0.20f)

            //Golden Apple
            multiMeshRegister(registry, leaves, ItemInfo(Items.GOLDEN_APPLE), 0.001f, 0.003f, 0.005f, 0.01f)

            //Silk Worm
            multiMeshRegister(registry, leaves, ItemInfo(ItemResource.getResourceStack(ItemResource.SILKWORM)), 0.025f, 0.05f, 0.1f, 0.2f)
        }
    }

    private fun multiMeshRegister(registry: SieveRegistry, block: BlockInfo, drop: ItemInfo, string: Float?, flint: Float?, iron: Float?, diamond: Float?) {
        if(string != null && string > 0)
            registry.register(block, drop, getDropChance(string), BlockSieve.MeshType.STRING.id)
        if(flint != null && flint > 0)
            registry.register(block, drop, getDropChance(flint), BlockSieve.MeshType.FLINT.id)
        if(iron != null && iron > 0)
            registry.register(block, drop, getDropChance(iron), BlockSieve.MeshType.IRON.id)
        if(diamond != null && diamond > 0)
            registry.register(block, drop, getDropChance(diamond), BlockSieve.MeshType.DIAMOND.id)
    }

    private fun multiMeshRegister(registry: SieveRegistry, block: String, drop: ItemInfo, string: Float?, flint: Float?, iron: Float?, diamond: Float?) {
        if(string != null && string > 0)
            registry.register(block, drop, getDropChance(string), BlockSieve.MeshType.STRING.id)
        if(flint != null && flint > 0)
            registry.register(block, drop, getDropChance(flint), BlockSieve.MeshType.FLINT.id)
        if(iron != null && iron > 0)
            registry.register(block, drop, getDropChance(iron), BlockSieve.MeshType.IRON.id)
        if(diamond != null && diamond > 0)
            registry.register(block, drop, getDropChance(diamond), BlockSieve.MeshType.DIAMOND.id)
    }

    override fun registerHammer(registry: HammerRegistry) {
        registry.register("cobblestone", ItemStack(Blocks.GRAVEL, 1), 0, 1.0f, 0.0f)
        registry.register("gravel", ItemStack(Blocks.SAND, 1), 0, 1.0f, 0.0f)
        registry.register("sand", ItemStack(ModBlocks.dust, 1), 0, 1.0f, 0.0f)
        registry.register("netherrack", ItemStack(ModBlocks.netherrackCrushed, 1), 0, 1.0f, 0.0f)
        registry.register("endstone", ItemStack(ModBlocks.endstoneCrushed, 1), 0, 1.0f, 0.0f)

        registry.register("stoneAndesite", ItemStack(ModBlocks.crushedAndesite), 0, 1f, 0f)
        registry.register("stoneGranite", ItemStack(ModBlocks.crushedGranite), 0, 1f, 0f)
        registry.register("stoneDiorite", ItemStack(ModBlocks.crushedDiorite), 0, 1f, 0f)

        registry.register("crushedGranite", ItemStack(Blocks.SAND, 1, 1), 0, 1.0f, 0.0f)


        // Hammer concrete into concrete powder
        for (meta in 0..15)
            registry.register(BlockInfo.getStateFromMeta(Blocks.CONCRETE, meta), ItemStack(Blocks.CONCRETE_POWDER, 1, meta), 1, 1.0f, 0.0f)

        // Wool into string
        for (meta in 0..15) {
            val wool = BlockInfo.getStateFromMeta(Blocks.WOOL, meta)
            registry.register(wool, ItemStack(Items.STRING, 3), 0, 1f, 0f)
            registry.register(wool, ItemStack(Items.STRING, 1), 0, 0.5f, 0.25f)
            registry.register(wool, ItemStack(Items.DYE, 1, meta), 0, 1f/8f, 2f)
        }

    }

    override fun registerHeat(registry: HeatRegistry) {
        // Vanilla fluids are weird, the "flowing" variant is simply a temporary state of checking if it can flow.
        // So, once the lava has spread out all the way, it will all actually be "still" lava.
        // Thanks Mojang <3
        registry.register(BlockInfo(Blocks.FLOWING_LAVA), 3)
        registry.register(BlockInfo(Blocks.LAVA), 3)
        registry.register(BlockInfo(Blocks.FIRE), 4)
        registry.register(BlockInfo(Blocks.TORCH), 1)
        registry.register(BlockInfo(Blocks.MAGMA), 2)
        registry.register(BlockInfo(Blocks.GLOWSTONE), 2)

        // Hot Fluids
        for (fluid in FluidRegistry.getRegisteredFluids().values) {
            if (fluid !== FluidRegistry.LAVA) {
                val temp = fluid.temperature / 350 // Value arbitrarily chosen to make it line up with lava's heat value
                if (temp > 0 && fluid.block != null) {
                    registry.register(BlockInfo(fluid.block), temp)
                }
            }
        }

        // TODO Move HeatRegistry to Ingredient
        // registry.register(new OreStoringIngredient("blockUranium", 20);
        // registry.register(new OreStoringIngredient("blockBlaze", 10);
        // registry.register(new OreStoringIngredient("torch", 1); // Torch OreDict
    }

    override fun registerBarrelLiquidBlacklist(registry: BarrelLiquidBlacklistRegistry) {
        for (fluid in FluidRegistry.getRegisteredFluids().values) {
            if (fluid.temperature >= ModConfig.mechanics.woodBarrelMaxTemp)
                registry.register(ModBlocks.barrelWood.tier, fluid)
        }
    }

    override fun registerFluidOnTop(registry: FluidOnTopRegistry) {
        registry.register(FluidRegistry.LAVA, FluidRegistry.WATER, BlockInfo(Blocks.OBSIDIAN.defaultState))
        registry.register(FluidRegistry.WATER, FluidRegistry.LAVA, BlockInfo(Blocks.COBBLESTONE.defaultState))
    }

    override fun registerOreChunks(registry: OreRegistry) {
        registry.register("gold", Color("FFFF00"), ItemInfo(Items.GOLD_INGOT, 0), OreDictUtil.getOreDictEntry("dustGold"))
        registry.register("iron", Color("BF8040"), ItemInfo(Items.IRON_INGOT, 0), OreDictUtil.getOreDictEntry("dustIron"))

        for (metal in EnumModdedMetals.values()) {
            if (metal.getRegistryName() == "aluminum" && (!OreDictionary.getOres("oreAluminium").isEmpty() || !OreDictionary.getOres("oreAluminum").isEmpty())) {
                // Blame Humphry Davy
                registry.register("aluminium", metal.color, metal.getIngot(), metal.getDust())
            } else if (!OreDictionary.getOres(metal.getOreName()).isEmpty()) {
                registry.register(metal.getRegistryName(), metal.color, metal.getIngot(), metal.getDust())
            }
        }
    }

    override fun registerFluidTransform(registry: FluidTransformRegistry) {
        registry.register("water", "witchwater", 12000, arrayOf(BlockInfo(Blocks.MYCELIUM.defaultState)), arrayOf(BlockInfo(Blocks.BROWN_MUSHROOM.defaultState), BlockInfo(Blocks.RED_MUSHROOM.defaultState)))
    }

    override fun registerFluidBlockTransform(registry: FluidBlockTransformerRegistry) {
        registry.register(FluidRegistry.WATER, "dust", ItemInfo(ItemStack(Blocks.CLAY)))
        registry.register(FluidRegistry.LAVA, "dustRedstone", ItemInfo(ItemStack(Blocks.NETHERRACK)))
        registry.register(FluidRegistry.LAVA, "dustGlowstone", ItemInfo(ItemStack(Blocks.END_STONE)))
        registry.register(ModFluids.fluidWitchwater, "sand", ItemInfo(ItemStack(Blocks.SOUL_SAND)))

        if (FluidRegistry.isFluidRegistered("milk")) {
            registry.register(FluidRegistry.getFluid("milk"), ItemInfo(ItemStack(Blocks.BROWN_MUSHROOM)), ItemInfo(ItemStack(Blocks.SLIME_BLOCK)), "Slime")
            registry.register(FluidRegistry.getFluid("milk"), ItemInfo(ItemStack(Blocks.RED_MUSHROOM)), ItemInfo(ItemStack(Blocks.SLIME_BLOCK)), "Slime")
        } else {
            // No milk, fall back to witch water
            registry.register(ModFluids.fluidWitchwater, ItemInfo(ItemStack(Blocks.BROWN_MUSHROOM)), ItemInfo(ItemStack(Blocks.SLIME_BLOCK)), "Slime")
            registry.register(ModFluids.fluidWitchwater, ItemInfo(ItemStack(Blocks.RED_MUSHROOM)), ItemInfo(ItemStack(Blocks.SLIME_BLOCK)), "Slime")
        }

        // Vanilla Concrete
        for (meta in 0..15)
            registry.register(FluidRegistry.WATER, ItemInfo(ItemStack(Blocks.CONCRETE_POWDER, 1, meta)), ItemInfo(ItemStack(Blocks.CONCRETE, 1, meta)))
    }

    override fun registerFluidItemFluid(registry: FluidItemFluidRegistry) {
        registry.register(FluidRegistry.WATER, ItemInfo(ItemResource.getResourceStack(ItemResource.ANCIENT_SPORES)), ModFluids.fluidWitchwater)
    }

    override fun registerCrucibleStone(registry: CrucibleRegistry) {
        registry.register("cobblestone", FluidRegistry.LAVA, 250)
        registry.register("stone", FluidRegistry.LAVA, 250)
        registry.register("gravel", FluidRegistry.LAVA, 200)
        registry.register("sand", FluidRegistry.LAVA, 100)
        registry.register(BlockInfo(ModBlocks.dust.defaultState), FluidRegistry.LAVA, 50)

        // 1:1 Back to lava
        registry.register("netherrack", FluidRegistry.LAVA, 1000)
        registry.register("obsidian", FluidRegistry.LAVA, 1000)
    }

    override fun registerCrucibleWood(registry: CrucibleRegistry) {
        val water = Meltable(FluidRegistry.WATER.name, 250, BlockInfo(Blocks.LEAVES, 0))
        registry.register("treeLeaves", FluidRegistry.WATER, 250)
        registry.register("treeSapling", water)
        registry.register("listAllfruit", water)
        registry.register("listAllveggie", water)

        registry.register(ItemInfo(Blocks.SAPLING, 0), water)
        registry.register(ItemInfo(Blocks.SAPLING, 1), water.copy().setTextureOverrideChain(BlockInfo(Blocks.LEAVES, 1)))
        registry.register(ItemInfo(Blocks.SAPLING, 2), water.copy().setTextureOverrideChain(BlockInfo(Blocks.LEAVES, 2)))
        registry.register(ItemInfo(Blocks.SAPLING, 3), water.copy().setTextureOverrideChain(BlockInfo(Blocks.LEAVES, 3)))
        registry.register(ItemInfo(Blocks.SAPLING, 4), water.copy().setTextureOverrideChain(BlockInfo(Blocks.LEAVES2, 0)))
        registry.register(ItemInfo(Blocks.SAPLING, 5), water.copy().setTextureOverrideChain(BlockInfo(Blocks.LEAVES2, 1)))
        registry.register(ItemInfo(Items.APPLE), water)
    }

    override fun registerMilk(registry: MilkEntityRegistry) {
        registry.register("minecraft:cow", "milk", 10, 20)
    }


    override fun registerWitchWaterWorld(registry: WitchWaterWorldRegistry) {
        val waterResults = ArrayList<BlockInfo>()
        waterResults.add(BlockInfo(Blocks.DIRT, 0))
        waterResults.add(BlockInfo(Blocks.DIRT, 1))
        waterResults.add(BlockInfo(Blocks.DIRT, 2))
        registry.register(FluidRegistry.WATER, WitchWaterWorld(waterResults))
        val lavaResults = ArrayList<BlockInfo>()
        lavaResults.add(BlockInfo(Blocks.COBBLESTONE))
        lavaResults.add(BlockInfo(Blocks.STONE, 1))
        lavaResults.add(BlockInfo(Blocks.STONE, 3))
        lavaResults.add(BlockInfo(Blocks.STONE, 5))
        registry.register(FluidRegistry.LAVA, WitchWaterWorld(lavaResults))
    }

    private fun getDropChance(chance: Float): Float {
        return if (ModConfig.world.isSkyWorld)
            chance
        else
            chance / 100f * ModConfig.world.normalDropPercent.toFloat()
    }

    private fun getLeavesSapling(): Map<BlockInfo, BlockInfo> {
        val saplingMap = LinkedHashMap<BlockInfo, BlockInfo>()
        saplingMap[BlockInfo(Blocks.LEAVES, 0)] = BlockInfo(Blocks.SAPLING, 0)
        saplingMap[BlockInfo(Blocks.LEAVES, 1)] = BlockInfo(Blocks.SAPLING, 1)
        saplingMap[BlockInfo(Blocks.LEAVES, 2)] = BlockInfo(Blocks.SAPLING, 2)
        saplingMap[BlockInfo(Blocks.LEAVES, 3)] = BlockInfo(Blocks.SAPLING, 3)
        saplingMap[BlockInfo(Blocks.LEAVES2, 0)] = BlockInfo(Blocks.SAPLING, 4)
        saplingMap[BlockInfo(Blocks.LEAVES2, 1)] = BlockInfo(Blocks.SAPLING, 5)

        return saplingMap
    }
}