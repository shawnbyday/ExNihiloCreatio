package exnihilocreatio.compatibility.jei.burnout;

import com.google.common.collect.Lists;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.registries.types.BurnOutReward;
import exnihilocreatio.registries.types.HammerReward;
import exnihilocreatio.util.LogUtil;
import lombok.Getter;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import org.apache.logging.log4j.Level;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BurnOutRecipe implements IRecipeWrapper {
    @Getter
    private List<ItemStack> inputs;
    @Getter
    private List<ItemStack> outputs;

    public BurnOutRecipe(Ingredient ingredient) {
        List<BurnOutReward> rewards = ExNihiloRegistryManager.BURNOUT_REGISTRY.getRewards(ingredient);
        if (rewards.isEmpty())
            return;

        List<ItemStack> allOutputs = rewards.stream().map(BurnOutReward::getStack).collect(Collectors.toList());
        inputs = Arrays.asList(ingredient.getMatchingStacks());
        if(inputs.size() == 0){
            inputs = Arrays.asList(ingredient.matchingStacks);
        }
        outputs = Lists.newArrayList();

        for (ItemStack stack : allOutputs) {
            boolean alreadyExists = false;

            for (ItemStack outputStack : outputs) {
                if (ItemStack.areItemsEqual(stack, outputStack)) {
                    outputStack.grow(stack.getCount());
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                outputs.add(stack);
            }
        }
    }

    @Override
    public void getIngredients(@Nonnull IIngredients ingredients) {
        ingredients.setInputs(ItemStack.class, inputs);
        ingredients.setOutputs(ItemStack.class, outputs);
    }

    public boolean isValid() {
        return !inputs.isEmpty() && !outputs.isEmpty();
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {}

    @Override
    @Nonnull
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return Lists.newArrayList();
    }

    @Override
    public boolean handleClick(@Nonnull Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
        return false;
    }

}
