package exnihilocreatio.registries.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.item.ItemStack;

@AllArgsConstructor
public class BurnOutReward {

    @Getter
    private ItemStack stack;
    @Getter
    private float chance;

}
