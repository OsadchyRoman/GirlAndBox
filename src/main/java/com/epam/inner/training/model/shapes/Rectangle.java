package com.epam.inner.training.model.shapes;

import com.epam.inner.training.model.material.IMaterial;
import com.epam.inner.training.model.shapes.params.IShapeParameters;
import com.epam.inner.training.model.shapes.params.RectangleParameters;

public class Rectangle extends AbstractShape {
  public Rectangle(IMaterial material, IShapeParameters parameters) {
    super(material, parameters);
  }

  public Rectangle(AbstractShape shape) {
    super(shape);
  }

  @Override
  protected IShapeParameters convertParameters(IShapeParameters params) {
    return new RectangleParameters(params);
  }
}
