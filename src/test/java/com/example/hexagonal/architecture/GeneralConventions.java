package com.example.hexagonal.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;

import static com.tngtech.archunit.lang.conditions.ArchConditions.not;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.GeneralCodingRules.THROW_GENERIC_EXCEPTIONS;

@AnalyzeClasses(packages = "com.example.hexagonal", importOptions = ImportOption.DoNotIncludeTests.class)
@SuppressWarnings("unused")
public class GeneralConventions {
    @ArchTest
    public static final ArchRule applicationArchitecture = layeredArchitecture()
            .layer("Ports").definedBy("com.example.hexagonal.ports..")
            .layer("Adapters").definedBy("com.example.hexagonal.adapters..")
            .layer("DomainModel").definedBy("com.example.hexagonal.domain.model..")
            .layer("DomainServices").definedBy("com.example.hexagonal.domain.services..")
            .whereLayer("Ports").mayOnlyBeAccessedByLayers("Adapters", "DomainServices")
            .whereLayer("Adapters").mayNotBeAccessedByAnyLayer()
            .whereLayer("DomainModel").mayOnlyBeAccessedByLayers("Ports", "Adapters", "DomainServices")
            .whereLayer("DomainServices").mayNotBeAccessedByAnyLayer()
            .because("The application must follow the Hexagonal architecture pattern.\n" +
                    "See also:\n" +
                    " * Original article https://alistair.cockburn.us/hexagonal-architecture/\n" +
                    " * Good video and article https://www.youtube.com/watch?v=cPH5AiqLQTo / https://reflectoring.io/spring-hexagonal/\n" +
                    " * Also https://blog.octo.com/en/hexagonal-architecture-three-principles-and-an-implementation-example/#runtime\n");

    @ArchTest
    public static final ArchRule noFieldInjectionAllowed = GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    @ArchTest
    public static final ArchRule noGenericExceptionsAreAllowed = classes()
            .that().resideOutsideOfPackage("..generated..")
            .should(not(THROW_GENERIC_EXCEPTIONS));
}