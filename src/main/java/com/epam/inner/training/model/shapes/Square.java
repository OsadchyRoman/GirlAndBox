package com.epam.inner.training.model.shapes;

import com.epam.inner.training.model.material.IMaterial;
import com.epam.inner.training.model.shapes.params.IShapeParameters;
import com.epam.inner.training.model.shapes.params.SquareParameters;

public class Square extends AbstractShape {
  public Square(IMaterial material, IShapeParameters parameters) {
    super(material, parameters);
  }

  public Square(AbstractShape shape) {
    super(shape);
  }

  @Override
  protected IShapeParameters convertParameters(IShapeParameters params) {
    return new SquareParameters(params);
  }
}
