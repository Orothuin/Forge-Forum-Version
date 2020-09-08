package elementalalchemie;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class DispenseBehaviors {
	
	 public static final IDispenseItemBehavior LIQUIED_BUCKED_BEHAVIOR = new DefaultDispenseItemBehavior() {
         private final DefaultDispenseItemBehavior field_218405_b = new DefaultDispenseItemBehavior();

         /**
          * Dispense the specified stack, play the dispense sound and spawn particles.
          */
         public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
            BucketItem bucketitem = (BucketItem)stack.getItem();
            BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
            World world = source.getWorld();
            if (bucketitem.tryPlaceContainedLiquid((PlayerEntity)null, world, blockpos, (BlockRayTraceResult)null)) {
               bucketitem.onLiquidPlaced(world, stack, blockpos);
               return new ItemStack(Items.BUCKET);
            } else {
               return this.field_218405_b.dispense(source, stack);
            }
         }
      };
      
      public static final DefaultDispenseItemBehavior SPAWN_EGG_BEHAVIOR = new DefaultDispenseItemBehavior() {
          /**
           * Dispense the specified stack, play the dispense sound and spawn particles.
           */
    	  @Override
          public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
             Direction direction = source.getBlockState().get(DispenserBlock.FACING);
             EntityType<?> entitytype = ((SpawnEggItem)stack.getItem()).getType(stack.getTag());
             entitytype.spawn(source.getWorld(), stack, (PlayerEntity)null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
             stack.shrink(1);
             return stack;
          }
       };
}
