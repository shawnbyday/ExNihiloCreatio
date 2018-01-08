package exnihilocreatio.registries.registries.prefab;

import com.google.gson.Gson;
import exnihilocreatio.recipes.yaml.YamlLoader;
import exnihilocreatio.recipes.yaml.yamlRecipeClasses.ExNihiloRecipes;
import exnihilocreatio.recipes.yaml.yamlRecipeClasses.YamlCrucibleRecipe;
import exnihilocreatio.registries.manager.IDefaultRecipeProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseRegistryMap<K, V> extends BaseRegistry<Map<K, V>> {

    public BaseRegistryMap(Gson gson, List<? extends IDefaultRecipeProvider> defaultRecipeProviders) {
        super(gson, new HashMap<>(), defaultRecipeProviders);
    }

    public void register(K key, V value) {
        registry.put(key, value);
        YamlLoader.registerRecipeToMap(ex -> registerToYaml(ex, key, value));
    }

    public abstract void registerToYaml(ExNihiloRecipes ex, K key, V value);

    @Override
    public void clearRegistry() {
        registry.clear();
    }
}
