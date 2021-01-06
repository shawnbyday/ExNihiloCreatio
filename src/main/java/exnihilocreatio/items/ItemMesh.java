package exnihilocreatio.items;

import exnihilocreatio.ExNihiloCreatio;
import exnihilocreatio.blocks.BlockSieve.MeshType;
import exnihilocreatio.config.ModConfig;
import exnihilocreatio.util.Data;
import exnihilocreatio.util.IHasModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class ItemMesh extends Item implements IHasModel {

    public ItemMesh() {
        super();
        this.setHasSubtypes(true);
        this.setTranslationKey("item_mesh");
        this.setRegistryName("item_mesh");
        this.setMaxStackSize(ModConfig.sieve.meshMaxStackSize);
        this.setCreativeTab(ExNihiloCreatio.tabExNihilo);
        Data.ITEMS.add(this);
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (stack.getMetadata()) {
            case 1:
                return 15;
            case 2:
                return 7;
            case 3:
                return 14;
            case 4:
                return 10;
            case 5:
                return 11;
            case 6:
                return 12;
            case 7:
                return 13;
            case 8:
                return 16;
            case 9:
                return 17;
            case 10:
                return 18;
            case 11:
                return 19;
            default:
                return 0;
        }
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack){
        return true;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book)
    {
        return stack.getCount() == 1;
    }

    @Override
    @Nonnull
    public String getTranslationKey(ItemStack stack) {
        return super.getTranslationKey() + "." + stack.getItemDamage();
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab))
            for (int i = 1; i < MeshType.values().length - 1; i++) { //0 is the "none" case, 5 the "no render" case
                list.add(new ItemStack(this, 1, i));
            }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initModel(ModelRegistryEvent e) {
        ModelLoader.setCustomModelResourceLocation(this, 1, new ModelResourceLocation("exnihilocreatio:item_mesh_string"));
        ModelLoader.setCustomModelResourceLocation(this, 2, new ModelResourceLocation("exnihilocreatio:item_mesh_flint"));
        ModelLoader.setCustomModelResourceLocation(this, 3, new ModelResourceLocation("exnihilocreatio:item_mesh_iron"));
        ModelLoader.setCustomModelResourceLocation(this, 4, new ModelResourceLocation("exnihilocreatio:item_mesh_diamond"));
        ModelLoader.setCustomModelResourceLocation(this, 5, new ModelResourceLocation("exnihilocreatio:item_mesh_bronze"));
        ModelLoader.setCustomModelResourceLocation(this, 6, new ModelResourceLocation("exnihilocreatio:item_mesh_steel"));
        ModelLoader.setCustomModelResourceLocation(this, 7, new ModelResourceLocation("exnihilocreatio:item_mesh_aluminium"));
        ModelLoader.setCustomModelResourceLocation(this, 8, new ModelResourceLocation("exnihilocreatio:item_mesh_stainless"));
        ModelLoader.setCustomModelResourceLocation(this, 9, new ModelResourceLocation("exnihilocreatio:item_mesh_titanium"));
        ModelLoader.setCustomModelResourceLocation(this, 10, new ModelResourceLocation("exnihilocreatio:item_mesh_tungstensteel"));
        ModelLoader.setCustomModelResourceLocation(this, 11, new ModelResourceLocation("exnihilocreatio:item_mesh_naquadah"));
    }
}
