package net.mreskimo.gam.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mreskimo.gam.GAM;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = GAM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new GAMRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), GAMLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new GAMBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new GAMItemModelProvider(packOutput, existingFileHelper));

        GAMBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new GAMBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new GAMItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));


        generator.addProvider(event.includeServer(), new GAMWorldgenProvider(packOutput, lookupProvider));
    }
}