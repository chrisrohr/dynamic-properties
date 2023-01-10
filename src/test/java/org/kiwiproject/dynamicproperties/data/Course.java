package org.kiwiproject.dynamicproperties.data;

import static org.kiwiproject.base.KiwiStrings.f;

import org.kiwiproject.dynamicproperties.annotation.Choice;
import org.kiwiproject.dynamicproperties.annotation.DynamicField;

import java.util.List;
import java.util.function.Supplier;

public class Course {

    @DynamicField(required = true, choicesSupplier = DepartmentChoicesSupplier.class)
    private Department department;

    @DynamicField(required = true)
    private String number;

    @DynamicField
    private String title;

    public static class DepartmentChoicesSupplier implements Supplier<List<Choice>> {
        @Override
        public List<Choice> get() {
            return Choice.choicesForEnum(
                    Department.class,
                    dept -> f("{} - {}", dept.getCode(), dept.getDescription())
            );
        }
    }
}