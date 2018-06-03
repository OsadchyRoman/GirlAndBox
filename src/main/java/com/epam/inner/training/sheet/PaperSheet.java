package com.epam.inner.training.sheet;

import com.epam.inner.training.model.material.IMaterial;
import com.epam.inner.training.model.material.PaperMaterial;

public class PaperSheet extends AbstractSheet {
  private final IMaterial material;

  public PaperSheet() {
    material = new PaperMaterial();
  }

  @Override
  protected IMaterial getMaterial() {
    return material;
  }
}
