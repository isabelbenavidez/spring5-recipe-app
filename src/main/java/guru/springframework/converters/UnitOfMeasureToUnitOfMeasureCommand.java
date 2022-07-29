package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized//Para evitar que muchos ejecuten el mismo bloque de código, ejemplo Cuenta bancaria, que es consultada por proveedores.
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

        if(unitOfMeasure != null) {
           final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
           unitOfMeasureCommand.setId(unitOfMeasure.getId());
           unitOfMeasureCommand.setDescription(unitOfMeasure.getDescription());
           return unitOfMeasureCommand;
        }

        return null;
    }


}
