package com.epam.inner.training.model.material;

public class PaperMaterial implements IMaterial {
  @Override
  public boolean isPainted() {
    return true;
  }

  @Override
  public String toString() {
    return "Paper material";
  }
}
