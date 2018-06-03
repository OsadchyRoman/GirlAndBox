package com.epam.inner.training.model.shapes.params;

public class CircleParameters extends AbstractShapeParameters{

  private final double radius;

  public CircleParameters(double radius) {
    this.radius = radius;
  }
  public CircleParameters(IShapeParameters parameters) {
    ParamTransformer transformer = parameters.getTransformer(this);
    this.radius = transformer.next();
  }

  @Override
  public double getArea() {
    return Math.PI*radius*radius;
  }

  @Override
  Double[] getArgs() {
    return new Double[]{radius, radius};
  }
}
