package com.epam.inner.training.model.shapes;

import com.epam.inner.training.model.material.IMaterial;
import com.epam.inner.training.model.shapes.params.CircleParameters;
import com.epam.inner.training.model.shapes.params.IShapeParameters;

public class Circle extends AbstractShape {

  public Circle(IMaterial material, IShapeParameters parameters) {
    super(material, parameters);
  }

  public Circle(AbstractShape shape) {
    super(shape);
  }
  @Override
  protected IShapeParameters convertParameters(IShapeParameters params) {
    return new CircleParameters(params);
  }
}
