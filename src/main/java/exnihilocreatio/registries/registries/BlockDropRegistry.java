package exnihilocreatio.registries.registries;

import com.google.common.collect.Lists;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import exnihilocreatio.compatibility.jei.blockdrop.BlockDropRecipe;
import exnihilocreatio.json.CustomIngredientJson;
import exnihilocreatio.json.CustomItemStackJson;
import exnihilocreatio.registries.ingredient.IngredientUtil;
import exnihilocreatio.registries.ingredient.OreIngredientStoring;
import exnihilocreatio.registries.manager.IDefaultRecipeProvider;
import exnihilocreatio.registries.registries.prefab.BaseRegistryMap;
import exnihilocreatio.registries.types.BlockDropReward;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockDropRegistry extends BaseRegistryMap<Ingredient, NonNullList<BlockDropReward>> {

    public BlockDropRegistry(@Nonnull List<? extends IDefaultRecipeProvider> defaultRecipeProviders) {
        super(
                new GsonBuilder()
                        .setPrettyPrinting()
                        .registerTypeAdapter(ItemStack.class, new CustomItemStackJson())
                        .registerTypeAdapter(Ingredient.class, new CustomIngredientJson())
                        .registerTypeAdapter(OreIngredientStoring.class, new CustomIngredientJson())
                        .enableComplexMapKeySerialization()
                        .create(),
                new TypeToken<Map<Ingredient, List<BlockDropReward>>>() {
                }.getType(),
                defaultRecipeProviders
        );
    }

    public void register(String block, ItemStack drop, float chance, float fortuneChance) {
        register(new OreIngredientStoring(block), new BlockDropReward(drop, chance, fortuneChance, 0));
    }

    public void register(Block block, int meta, ItemStack drop, float chance) {
        register(block, meta, drop, chance, 0, 0);
    }

    public void register(IBlockState state, ItemStack drop, float chance) {
        register(new BlockInfo(state), drop, chance);
    }

    public void register(BlockInfo blockinfo, ItemStack drop, float chance) {
        register(blockinfo, drop, chance, 0, 0);
    }

    public void register(BlockInfo blockinfo, ItemInfo drop, float chance) {
        register(blockinfo, drop.getItemStack(), chance, 0, 0);
    }

    public void register(Block block, int meta, ItemStack drop, float chance, float fortuneChance) {
        register(new BlockInfo(block, meta), drop, chance, fortuneChance, 0);
    }

    public void register(IBlockState state, ItemStack reward, float chance, float fortuneChance) {
        register(new BlockInfo(state), reward, chance, fortuneChance, 0);
    }

    public void register(BlockInfo blockinfo, ItemStack reward, float chance, float fortuneChance) {
        register(blockinfo, reward, chance, fortuneChance, 0);
    }

    public void register(Block block, int meta, ItemStack drop, float chance, float fortuneChance, int miningLevel) {
        register(new BlockInfo(block, meta), drop, chance, fortuneChance, miningLevel);
    }

    public void register(IBlockState state, ItemStack reward, float chance, float fortuneChance, int miningLevel) {
        register(new BlockInfo(state), reward, chance, fortuneChance, miningLevel);
    }

    public void register(BlockInfo info, ItemStack drop, float chance, float fortuneChance, int miningLevel) {
        Ingredient ingredient = Ingredient.fromStacks(info.getItemStack());
        register(ingredient, new BlockDropReward(drop, chance, fortuneChance, miningLevel));
    }

    public void register(Ingredient ingredient, ItemStack drop, float chance, float fortuneChance, int miningLevel) {
        register(ingredient, new BlockDropReward(drop, chance, fortuneChance, miningLevel));
    }

    public void register(Ingredient ingredient, BlockDropReward reward){
        Ingredient search = registry.keySet()
                .stream()
                .filter(entry -> IngredientUtil.ingredientEquals(entry, ingredient))
                .findAny()
                .orElse(null);
        if (search != null) {
            registry.get(search).add(reward);
        } else {
            NonNullList<BlockDropReward> drops = NonNullList.create();
            drops.add(reward);
            registry.put(ingredient, drops);
        }
    }

    public boolean isRegistered(Block block) {
        ItemStack stack = new ItemStack(block);
        return registry.keySet().stream().anyMatch(ingredient -> ingredient.test(stack));
    }

    public List<BlockDropReward> getRewards(IBlockState state) {
        BlockInfo info = new BlockInfo(state);
        ArrayList<BlockDropReward> list = new ArrayList<>();

        registry.entrySet()
                .stream()
                .filter(ingredient -> ingredient.getKey().test(info.getItemStack()))
                .forEach(ingredient -> list.addAll(ingredient.getValue()));

        return list;
    }

    public NonNullList<BlockDropReward> getRewards(Ingredient ingredient) {
        NonNullList<BlockDropReward> drops = NonNullList.create();
        registry.entrySet().stream().filter(entry -> entry.getKey() == ingredient).forEach(entry -> drops.addAll(entry.getValue()));
        return drops;
    }

    @Override
    public void registerEntriesFromJSON(FileReader fr) {
        HashMap<String, NonNullList<BlockDropReward>> gsonInput = gson.fromJson(fr, new TypeToken<HashMap<String, NonNullList<BlockDropReward>>>() {
        }.getType());

        gsonInput.forEach((key, value) -> {
            Ingredient ingredient = IngredientUtil.parseFromString(key);

            if (ingredient != null) {
                NonNullList<BlockDropReward> list = registry.getOrDefault(ingredient, NonNullList.create());
                list.addAll(value);
                registry.put(ingredient, list);
            }
        });
    }

    @Override
    public List<BlockDropRecipe> getRecipeList() {
        List<BlockDropRecipe> recipes = Lists.newLinkedList();

        getRegistry().keySet().forEach(ingredient ->  {
            BlockDropRecipe recipe = new BlockDropRecipe(ingredient);
            recipes.add(recipe);
        });

        return recipes;
    }
}
