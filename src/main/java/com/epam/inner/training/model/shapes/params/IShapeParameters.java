package com.epam.inner.training.model.shapes.params;

public interface IShapeParameters {
  double getArea();
  ParamTransformer getTransformer(IShapeParameters to);
}
