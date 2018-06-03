package com.epam.inner.training.sheet;

import com.epam.inner.training.model.material.IMaterial;
import com.epam.inner.training.model.material.TapeMaterial;

public class TapeSheet extends AbstractSheet {
  private final IMaterial material;

  public TapeSheet() {
    this.material = new TapeMaterial();
  }

  @Override
  protected IMaterial getMaterial() {
    return material;
  }
}
