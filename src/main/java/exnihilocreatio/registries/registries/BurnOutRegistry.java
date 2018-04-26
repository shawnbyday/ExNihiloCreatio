package exnihilocreatio.registries.registries;

import com.google.common.collect.Lists;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import exnihilocreatio.json.CustomIngredientJson;
import exnihilocreatio.json.CustomItemStackJson;
import exnihilocreatio.registries.ingredient.IngredientUtil;
import exnihilocreatio.registries.ingredient.OreIngredientStoring;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.registries.registries.prefab.BaseRegistryMap;
import exnihilocreatio.registries.types.BurnOutReward;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.crafting.CraftingHelper;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BurnOutRegistry extends BaseRegistryMap<Ingredient, NonNullList<BurnOutReward>> {

    public BurnOutRegistry() {
        super(
                new GsonBuilder()
                        .setPrettyPrinting()
                        .registerTypeAdapter(ItemStack.class, new CustomItemStackJson())
                        .registerTypeAdapter(Ingredient.class, new CustomIngredientJson())
                        .registerTypeAdapter(OreIngredientStoring.class, new CustomIngredientJson())
                        .enableComplexMapKeySerialization()
                        .create(),
                new TypeToken<Map<Ingredient, List<BurnOutReward>>>() {
                }.getType(),
                ExNihiloRegistryManager.BURNOUT_DEFAULT_REGISTRY_PROVIDERS
        );
    }

    public void register(Block block, int meta, ItemStack reward, float chance) {
        register(new BlockInfo(block, meta), reward, chance);
    }

    public void register(BlockInfo blockinfo, ItemInfo reward, float chance) {
        register(blockinfo, reward.getItemStack(), chance);
    }

    public void register(IBlockState state, ItemStack reward, float chance) {
        register(new BlockInfo(state), reward, chance);
    }

    public void register(BlockInfo info, ItemStack reward, float chance) {
        Ingredient ingredient = registry.keySet().stream().filter(entry -> entry.test(info.getItemStack())).findFirst().orElse(null);

        if (ingredient != null) {
            registry.get(ingredient).add(new BurnOutReward(reward, chance));
        } else {
            NonNullList<BurnOutReward> list = NonNullList.create();
            list.add(new BurnOutReward(reward, chance));
            registry.put(CraftingHelper.getIngredient(info.getBlock()), list);
        }
    }

    public void register(String name, ItemStack reward, float chance) {
        Ingredient ingredient = new OreIngredientStoring(name);

        BurnOutReward burnOutReward = new BurnOutReward(reward, chance);

        Ingredient search = registry.keySet()
                .stream()
                .filter(entry -> IngredientUtil.ingredientEquals(entry, ingredient))
                .findAny()
                .orElse(null);


        if (search != null) {
            registry.get(search).add(burnOutReward);
        } else {
            NonNullList<BurnOutReward> drops = NonNullList.create();
            drops.add(burnOutReward);
            registry.put(ingredient, drops);
        }
    }

    public boolean isRegistered(Block block) {
        ItemStack stack = new ItemStack(block);
        return registry.keySet().stream().anyMatch(ingredient -> ingredient.test(stack));
    }

    public List<BurnOutReward> getRewards(IBlockState state) {
        BlockInfo info = new BlockInfo(state);
        ArrayList<BurnOutReward> list = new ArrayList<>();

        registry.entrySet()
                .stream()
                .filter(ingredient -> ingredient.getKey().test(info.getItemStack()))
                .forEach(ingredient -> list.addAll(ingredient.getValue()));

        return list;
    }

    @Override
    public void registerEntriesFromJSON(FileReader fr) {
        HashMap<String, NonNullList<BurnOutReward>> gsonInput = gson.fromJson(fr, new TypeToken<HashMap<String, NonNullList<BurnOutReward>>>() {
        }.getType());

        gsonInput.forEach((key, value) -> {
            Ingredient ingredient = IngredientUtil.parseFromString(key);

            if (ingredient != null) {
                NonNullList<BurnOutReward> list = registry.getOrDefault(ingredient, NonNullList.create());
                list.addAll(value);
                registry.put(ingredient, list);
            }
        });
    }

    @Override
    public List<?> getRecipeList() {
        return Lists.newLinkedList();
    }
}
