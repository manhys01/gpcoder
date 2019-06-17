package com.gpcoder.patterns.creational.abstractfactory;

public class FurnitureFactory {

    private FurnitureFactory(){}
    // Returns a concrete factory object that is an instance of the
    // concrete factory class appropriate for the given architecture.
    public static FurnitureAbstractFactory getFactory(MaterialType materialType) {
        switch (materialType) {
            case WOOD:
                return new WoodFactory();
            case PLASTIC:
                return new PlasticFactory();
            default:
                throw new IllegalArgumentException("This material type is unsupported");
        }
    }

}
