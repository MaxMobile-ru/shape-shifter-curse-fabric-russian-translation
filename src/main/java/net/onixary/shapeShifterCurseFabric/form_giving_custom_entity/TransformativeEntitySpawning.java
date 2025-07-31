package net.onixary.shapeShifterCurseFabric.form_giving_custom_entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.onixary.shapeShifterCurseFabric.ShapeShifterCurseFabric;
import net.onixary.shapeShifterCurseFabric.form_giving_custom_entity.axolotl.TransformativeAxolotlEntity;
import net.onixary.shapeShifterCurseFabric.form_giving_custom_entity.bat.TransformativeBatEntity;
import net.onixary.shapeShifterCurseFabric.form_giving_custom_entity.ocelot.TransformativeOcelotEntity;

public class TransformativeEntitySpawning {
    public static void addEntitySpawns() {
        // original weights located at data/minecraft/worldgen/biome/...

        // T_OCELOT
        SpawnRestriction.register(
                ShapeShifterCurseFabric.T_OCELOT,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING,
                TransformativeOcelotEntity::canCustomSpawn
        );
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.JUNGLE)
                        .or(BiomeSelectors.includeByKey(BiomeKeys.BAMBOO_JUNGLE)),
                SpawnGroup.MONSTER,
                ShapeShifterCurseFabric.T_OCELOT,
                10,
                1,
                3
        );
        // T_AXOLOTL
        SpawnRestriction.register(
                ShapeShifterCurseFabric.T_AXOLOTL,
                SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                TransformativeAxolotlEntity::canSpawn
        );
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES),
                SpawnGroup.AXOLOTLS,
                ShapeShifterCurseFabric.T_AXOLOTL,
                8,
                4,
                6
        );
        // T_BAT
        SpawnRestriction.register(
                ShapeShifterCurseFabric.T_BAT,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                TransformativeBatEntity::canCustomSpawn
        );
        BiomeModifications.addSpawn(
                BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                SpawnGroup.AMBIENT,
                ShapeShifterCurseFabric.T_BAT,
                8,
                1,
                3
        );
    }
}
