package com.epam.inner.training.model.shapes.params;

public class SquareParameters extends AbstractShapeParameters {
  private final double party;

  public SquareParameters(double party) {
    this.party = party;
  }
  public SquareParameters(IShapeParameters parameters) {
    ParamTransformer transformer = parameters.getTransformer(this);
    this.party = transformer.next();
  }

  @Override
  public double getArea() {
    return party*party;
  }


  @Override
  Double[] getArgs() {
    return new Double[]{party, party};
  }
}
