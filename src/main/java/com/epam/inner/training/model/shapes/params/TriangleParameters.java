package com.epam.inner.training.model.shapes.params;

public class TriangleParameters extends AbstractShapeParameters {

  private final double party;

  public TriangleParameters(double party) {
    this.party = party;
  }
  public TriangleParameters(IShapeParameters parameters) {
    ParamTransformer transformer = parameters.getTransformer(this);
    this.party = transformer.next();
  }

  @Override
  public double getArea() {
    return party * Math.sqrt(Math.pow(party, 2) - Math.pow(party / 2, 2) / 2);
  }

  @Override
  Double[] getArgs() {
    return new Double[]{party, party};
  }
}
