package com.epam.inner.training.model.shapes;

import com.epam.inner.training.model.color.Color;
import com.epam.inner.training.model.material.IMaterial;
import com.epam.inner.training.model.shapes.params.IShapeParameters;

public abstract class AbstractShape implements IColoredShape {

  private final IMaterial material;
  private boolean hasColor;
  private Color color;

  private final IShapeParameters parameters;

  public AbstractShape(IMaterial material, IShapeParameters parameters) {
    this.material = material;
    this.parameters = parameters;
    hasColor = false;
  }
  public AbstractShape(AbstractShape shape) {
    this.material = shape.material;
    this.hasColor = shape.hasColor;
    this.color = shape.color;
    this.parameters = this.convertParameters(shape.parameters);
  }


  @Override
  public void paint(Color color) {
    if (canBePainted()) {
      hasColor = true;
      this.color = color;
    } else {
      throw new RuntimeException("The shape can't be pained");
    }
  }
  @Override
  public Color getColor(){
    return color;
  }

  @Override
  public boolean canBePainted() {
    return !hasColor && material.isPainted();
  }

  @Override
  public IMaterial getMaterial() {
    return material;
  }
  @Override
  public IShapeParameters getParameters() {
    return parameters;
  }

  @Override
  public double getArea() {
    return parameters.getArea();
  }
  protected abstract IShapeParameters convertParameters(IShapeParameters params);

}
