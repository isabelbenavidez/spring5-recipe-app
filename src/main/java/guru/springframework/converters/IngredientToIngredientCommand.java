package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import org.springframework.core.convert.converter.Converter;
import guru.springframework.domain.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;


    public IngredientToIngredientCommand(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    public IngredientCommand convert(Ingredient ingredient){
        if(ingredient== null){
            return null;
        }

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setDescription(ingredient.getDescription());
        //ingredientCommand.setUom(uomConverter.convert(ingredient.getUom()));
        return ingredientCommand;


    }
}

