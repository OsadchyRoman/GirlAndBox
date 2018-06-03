package com.epam.inner.training.model.shapes.params;

public abstract class AbstractShapeParameters implements IShapeParameters {
  @Override
  public ParamTransformer getTransformer(IShapeParameters to) {
    return ParamTransformer.getTransformer(getClass(), to.getClass(), getArgs());
  }

  abstract Double[] getArgs();
}
