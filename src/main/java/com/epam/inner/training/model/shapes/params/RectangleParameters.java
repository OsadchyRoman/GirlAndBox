package com.epam.inner.training.model.shapes.params;

public class RectangleParameters extends AbstractShapeParameters {
  private final double width;
  private final double height;

  public RectangleParameters(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public RectangleParameters(IShapeParameters parameters) {
    ParamTransformer transformer = parameters.getTransformer(this);
    width = transformer.next();
    height = transformer.next();
  }

  @Override
  public double getArea() {
    return width*height;
  }

  @Override
  Double[] getArgs() {
    return new Double[]{width > height ? height : width,  width > height ? width : height};
  }
}
