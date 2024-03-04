package iuriineves.neves_capybaras.init;

import iuriineves.neves_capybaras.NevesCapybaras;
import iuriineves.neves_capybaras.block_entity.ThermalSpringBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModBlockEntities {

    Map<FabricBlockEntityTypeBuilder<? extends BlockEntity>, Identifier> BLOCK_ENTITIES = new LinkedHashMap<>();

      FabricBlockEntityTypeBuilder<? extends BlockEntity> THERMAL_SPRING_BLOCK_ENTITY = createBlockEntity("thermal_spring", ModBlocks.THERMAL_SPRING_BLOCK, ThermalSpringBlockEntity::new);

    private static FabricBlockEntityTypeBuilder<? extends BlockEntity> createBlockEntity(String name, Block block, FabricBlockEntityTypeBuilder.Factory<? extends BlockEntity> blockEntity) {
        FabricBlockEntityTypeBuilder<? extends BlockEntity> blockEntityTypeBuilder = FabricBlockEntityTypeBuilder.create(blockEntity, block);
        BLOCK_ENTITIES.put(blockEntityTypeBuilder, new Identifier(NevesCapybaras.MOD_ID, name));
        return blockEntityTypeBuilder;
    }

    static void initialize() {
        BLOCK_ENTITIES.keySet().forEach(blockEntity -> Registry.register(Registries.BLOCK_ENTITY_TYPE, BLOCK_ENTITIES.get(blockEntity), blockEntity.build()));
    }
}
