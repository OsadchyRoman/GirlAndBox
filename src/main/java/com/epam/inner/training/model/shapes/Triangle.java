package com.epam.inner.training.model.shapes;

import com.epam.inner.training.model.material.IMaterial;
import com.epam.inner.training.model.shapes.params.IShapeParameters;
import com.epam.inner.training.model.shapes.params.TriangleParameters;

public class Triangle extends AbstractShape {
  public Triangle(IMaterial material, IShapeParameters parameters) {
    super(material, parameters);
  }

  public Triangle(AbstractShape shape) {
    super(shape);
  }

  @Override
  protected IShapeParameters convertParameters(IShapeParameters params) {
    return new TriangleParameters(params);
  }
}
