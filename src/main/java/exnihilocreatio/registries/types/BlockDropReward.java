package exnihilocreatio.registries.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.item.ItemStack;

@AllArgsConstructor
public class BlockDropReward {
    @Getter
    private ItemStack stack;
    @Getter
    private float chance;
    @Getter
    private float fortuneChance;
    @Getter
    private int miningLevel;

    // Old BurnOutReward
    public BlockDropReward(ItemStack stack, float chance){
        this(stack, chance, 0,0);
    }

    // Old CrookReward
    public BlockDropReward(ItemStack stack, float chance, float fortuneChance){
        this(stack, chance, fortuneChance, 0);
    }
}
