package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;


    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());

    }

    private List<Recipe> getRecipes(){

        List<Recipe> recipes = new ArrayList<>(2);

        //Obtener Unidad de medida //get UOM

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Unidad de medida no encontrada");
        }

        Optional<UnitOfMeasure> tableSpoomUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!tableSpoomUomOptional.isPresent()){
            throw new RuntimeException("Unidad de medida no encontrada");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Unidad de medida no enconatrada");
        }

        Optional<UnitOfMeasure> dashUomOpcional = unitOfMeasureRepository.findByDescription("Dash");
        if(!dashUomOpcional.isPresent()){
            throw new RuntimeException("Unidad de medida no encontrada");
        }

        Optional<UnitOfMeasure> pintUomOpcional = unitOfMeasureRepository.findByDescription("Pint");
        if(!pintUomOpcional.isPresent()){
            throw new RuntimeException("Unidad de medida no encontrada");
        }

        Optional<UnitOfMeasure> cupUomOpcional = unitOfMeasureRepository.findByDescription("Cup");
        if(!cupUomOpcional.isPresent()){
            throw new RuntimeException("Unidad de medida no encontrada");
        }

        //get Optionals Unit of measures

        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoomUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOpcional.get();
        UnitOfMeasure pintUom = pintUomOpcional.get();
        UnitOfMeasure cupUom = cupUomOpcional.get();


        //Obtener Unidad de Categoria //get Category

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Categoría no encontrada");
        }

        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");
        if(!italianCategoryOptional.isPresent()){
            throw new RuntimeException("Categoría no encontrada");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Categoría no encontrada");
        }

        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");
        if(!fastFoodCategoryOptional.isPresent()){
            throw new RuntimeException("Categoría no encontrda");
        }

        //get Optionals Categories

        Category americanCategory = americanCategoryOptional.get();
        Category italianCategory = italianCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();
        Category fastFoodCategory = fastFoodCategoryOptional.get();

        //Yuumy Guac

        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(0);
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setDirections(" La receta aquí");

        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Aquí están las notas de la receta de guacamole. Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");

        guacamoleNotes.setRecipe(guacamoleRecipe);
        guacamoleRecipe.setNotes(guacamoleNotes);

        guacamoleRecipe.getIngredients().add(new Ingredient("Ripe avocados", new BigDecimal(2), eachUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("Kosher Salt", new BigDecimal("5"), teaSpoonUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("Fresh lime juice or lemon juice", new BigDecimal(2), tableSpoonUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("Minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("Serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("Cilantro", new BigDecimal(2), tableSpoonUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("Freshy grated black papper", new BigDecimal(2), dashUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("Ripe tomato, seeds and pulp removed, chopped", new BigDecimal("5"), eachUom, guacamoleRecipe));

        guacamoleRecipe.getCategories().add(americanCategory);
        guacamoleRecipe.getCategories().add(mexicanCategory);

        //Add to return list

        recipes.add(guacamoleRecipe);

        return recipes;



    }

}

