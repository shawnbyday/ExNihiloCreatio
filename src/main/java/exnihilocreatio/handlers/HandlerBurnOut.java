package exnihilocreatio.handlers;

import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.registries.types.BlockDropReward;
import net.minecraft.block.BlockFire;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HandlerBurnOut {
    // Store Fire Location and minimum age to be a valid burnout
    private static final Map<BlockPos, Long> fires = new HashMap<>();
    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public void on(BlockEvent.NeighborNotifyEvent event){
        if (event.getWorld().isRemote)
            return;
        final World world = event.getWorld();
        BlockPos posIdx = event.getPos();
        BlockPos pos = event.getPos();
        final long worldTime = world.getTotalWorldTime();
        if(fires.containsKey(posIdx)){
            // Fire Burning Out
            if (world.isAirBlock(pos) &&
                    ExNihiloRegistryManager.BURNOUT_REGISTRY.isRegistered(world.getBlockState(pos.down()).getBlock()) &&
                    worldTime > fires.get(posIdx)){
                List<BlockDropReward> rewards = ExNihiloRegistryManager.BURNOUT_REGISTRY.getRewards(world.getBlockState(pos.down()));
                for(BlockDropReward reward : rewards){
                    if(RANDOM.nextFloat() <= reward.getChance()){
                        double dx = RANDOM.nextFloat() * 0.5F + 0.25D;
                        double dy = RANDOM.nextFloat() * 0.5F + 0.25D;
                        double dz = RANDOM.nextFloat() * 0.5F + 0.25D;
                        EntityItem entityitem = new EntityItem(world, pos.getX() + dx, pos.getY() + dy, pos.getZ() + dz, reward.getStack().copy());
                        entityitem.setDefaultPickupDelay();
                        entityitem.attackEntityFrom(DamageSource.IN_FIRE, -100);
                        entityitem.setFire(10);
                        world.spawnEntity(entityitem);
                    }
                }
            }
            fires.remove(posIdx);
        }
        else if(event.getState().getBlock() instanceof BlockFire){
            // Fire Being Lit
            if(ExNihiloRegistryManager.BURNOUT_REGISTRY.isRegistered(world.getBlockState(pos.down()).getBlock()))
                fires.put(posIdx, worldTime + 260);
        }
    }
}
